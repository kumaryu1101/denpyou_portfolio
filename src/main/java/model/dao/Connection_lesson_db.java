package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public sealed class Connection_lesson_db permits Slipsdao , Itemsdao{
	private static final String URL = "jdbc:postgresql://localhost:5432/lesson";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	
	//リターン用のConnection
	protected Connection conn = null;
	
	
	protected Connection getConnection() {
		if(this.conn == null) {
			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("①jdbc読み込みOK");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("JDBCを読み込ませんでした");
			}
			//データベースに接続する
			try {
				this.conn = DriverManager.getConnection(URL,USER,PASS);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return this.conn;
}
	
	/**
	 * コネクションをcloseする
	 */
	protected void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
