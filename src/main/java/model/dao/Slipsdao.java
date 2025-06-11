package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dto.ItemSlipdto;
import model.dto.SlipInsertdto;

public final class Slipsdao extends Connection_lesson_db {
	//シングルトンパターン
	//finalにすれば、変更インスタンスが変更されない
	private final static Slipsdao slipsdao = new Slipsdao();//自身のクラスをフィールドに持つ

	private Slipsdao() {}

	public static Slipsdao getInstance() {
		return slipsdao;
	}

	//close
	public void close() {
		super.closeConnection();
	}

	/**
	 * ここまでシングルトンパターン
	 */
	
	//検索するメソッド
	//商品番号、商品名、単価、個数、伝票番号、日付
	public List<ItemSlipdto> selectAll(Date statDate, Date endDate) {
		List<ItemSlipdto> itemSlipList = new ArrayList<ItemSlipdto>();

		try {
			Connection conn = super.getConnection();

			String sql = """
					    SELECT slips.id, items.itemId, items.itemName, items.price, slips.number, slips_date.date
					    FROM slips
					    JOIN items ON slips.itemId = items.itemId
					    JOIN slips_date ON slips.id = slips_date.id
					    WHERE slips_date.date between ? and ?
					    ORDER BY slips_date.date DESC, slips.id DESC;
					""";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			Timestamp timestamp = new Timestamp(statDate.getTime());
			Timestamp timestamp2 = new Timestamp(endDate.getTime());
			pstmt.setTimestamp(1, timestamp);
			pstmt.setTimestamp(2, timestamp2);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ItemSlipdto dto = new ItemSlipdto(
						rs.getString("id"),
						rs.getInt("itemId"),
						rs.getString("itemName"),
						rs.getInt("price"),
						rs.getInt("number"),
						rs.getTimestamp("date"));
				itemSlipList.add(dto);
			}
			rs.close();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return itemSlipList;
	}
	
	
	
	
	/**
	 * 伝票を保存するメソッド Slips , Slips_date両方格納してる
	 * //すべての情報が保存できたらtrue
	 */

	public boolean insertAllSlip(SlipInsertdto slipinsertdto) {
		
		boolean result = false;
		try {
			Connection conn = super.getConnection();
			//伝票(slips)外部キーで、itemIdを参照しているから
			String sql = """
					INSERT INTO slips (id, itemId, number)
					VALUES (?, ?, ?)
					""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, slipinsertdto.getSlipId());
			pstmt.setInt(2, slipinsertdto.getItemId());
			pstmt.setInt(3, slipinsertdto.getNumber());
			
			int insertNumberSlip = pstmt.executeUpdate();
			if (insertNumberSlip > 0) {
				System.out.println("slipsにインサートが成功しました");
				result = true;
			}
			
			
			//次に日付伝票(Slips_date)
			String sqlDate = """
					INSERT INTO slips_date (id, date)
					VALUES (?, ?)
					""";
			PreparedStatement pstmtDate = conn.prepareStatement(sqlDate);
			pstmtDate.setString(1, slipinsertdto.getSlipId());
			pstmtDate.setTimestamp(2, new Timestamp(slipinsertdto.getDate().getTime()));
			
			int insertNumber = pstmtDate.executeUpdate();
			if (insertNumber > 0) {
				System.out.println("slips_dateにインサートが成功しました");
				result = true;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 指定した日付の商品がすべて表示されるメソッド
	 */
	
	public List<ItemSlipdto> selectByDate(Date statdate, Date endDate, int itemId) {
		List<ItemSlipdto> itemSlipList = new ArrayList<ItemSlipdto>();

		try {
			Connection conn = super.getConnection();
			//日付、商品ID順で表示する
			String sql = """
					SELECT slips.id, items.itemId, items.itemName, items.price, slips.number, slips_date.date
					FROM slips
					JOIN items ON slips.itemId = items.itemId
					JOIN slips_date ON slips.id = slips_date.id
					WHERE slips_date.date between ? and ? AND items.itemId = ?
					ORDER BY slips_date. date DESC, slips.id DESC;
					""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			Timestamp timestamp = new Timestamp(statdate.getTime());//dateをtimestampに変換
			Timestamp timestamp2 = new Timestamp(endDate.getTime());
			pstmt.setTimestamp(1, timestamp);
			pstmt.setTimestamp(2, timestamp2);
			pstmt.setInt(3,itemId);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ItemSlipdto dto = new ItemSlipdto(
						rs.getString("id"),
						rs.getInt("itemId"),
						rs.getString("itemName"),
						rs.getInt("price"),
						rs.getInt("number"),
						rs.getTimestamp("date"));
				itemSlipList.add(dto);
			}
			if(itemSlipList != null) {
				System.out.println("表示が完了しました");
			}
		}catch(SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return itemSlipList;			  
	}
	
	/**
	 * 
	 * 指定された伝票IDを表示する
	 */
	
	public List<ItemSlipdto> selectBySlipId(String slipId) {
		List<ItemSlipdto> itemsliplist = new ArrayList<>();
		
		try {
			Connection con = super.getConnection();
			String sql = """
					SELECT 
					    slips.id, 
					    items.itemid, 
					    items.itemName, 
					    items.price, 
					    slips.number, 
					    slips_date.date
					FROM 
					    slips
					    JOIN items ON slips.itemid = items.itemid
					    JOIN slips_date ON slips.id = slips_date.id
					WHERE 
					    slips.id = ?;
					""";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, slipId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ItemSlipdto dto = new ItemSlipdto();//伝票すべての情報を格納するインスタンス
				dto.setSlipid(rs.getString("id"));			//伝票ID
				dto.setItemid(rs.getInt("itemid"));			//商品ID
				dto.setItemname(rs.getString("itemName"));	//商品名
				dto.setPrice(rs.getInt("price"));			//単価
				dto.setNumber(rs.getInt("number"));			//個数
				dto.setDate(rs.getTimestamp("date"));		//日付
				itemsliplist.add(dto);
			}
			if (itemsliplist != null) {//もし代入されていたら、成功
				System.out.println("指定された伝票IDの表示が完了しました");
			}
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		return itemsliplist;
	}

}
