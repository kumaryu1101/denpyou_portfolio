package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.Itemsdto;

public final class Itemsdao extends Connection_lesson_db {

	//シングルトンパターン
	//finalを記述することで一度だけしかインスタンス化されない
	private final static Itemsdao itemsdao = new Itemsdao();

	private Itemsdao() {
	}

	//インスタンス化するメソッド
	public static Itemsdao getInstance() {
		return itemsdao;
	}

	//close
	public void close() {
		super.closeConnection();
	}
	/**
	 * ここまでシングルトンパターン
	 */

	
	
	
	/**
	 * 商品ID、商品名、単価を表示するメソッド
	 */
	public List<Itemsdto> selectAllItem() {
		List<Itemsdto> itemlist = new ArrayList<>();

		String sql = """
				SELECT * FROM items;
				""";

		try {
			Connection con = super.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("itemid");
				String name = rs.getString("itemname");
				int price = rs.getInt("price");
				Itemsdto item = new Itemsdto(id, name, price);
				itemlist.add(item);//itemリストにid,name,priceを格納
			}
		   }catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		   }
		return itemlist;
	}

	
	/**
	 * 商品を登録するメソッド
	 */
	public boolean insertItem(Itemsdto itemsdto) {
		
		boolean result = false;
		
		try {
			Connection conn = super.getConnection();
			//最初に商品(items)sql文
			String sqlitem = null;
				sqlitem = """
						INSERT INTO items ( itemName, price)
						VALUES (?, ?);
						""";
				//自動で生成された商品IDを取得するため、第二引数にreturnを追加
				PreparedStatement pstmt = conn.prepareStatement(sqlitem, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1 ,itemsdto.getItemname());//商品名
				pstmt.setInt(2 ,itemsdto.getPrice());//単価
				
				int insertNumber = pstmt.executeUpdate();//インサートされた件数が帰ってくる
				
				if (insertNumber > 0) {
					System.out.println("itemsにインサートが成功しました");
					result=true;
					}	
			}catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
			return result;
	}

			
}
