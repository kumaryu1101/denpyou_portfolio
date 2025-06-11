package model.dto;

import java.util.Date;

public class SlipsDatedto {
	private String id;			//伝票番号
	private Date date;			//日付
	
	//コンストラクタ
	public SlipsDatedto() {}
	public SlipsDatedto(String id, Date date) {
		this.id = id;
		this.date = date;
	}
	
	//getter setter 
	public String getId() {return this.id;}
	public void setId(String id) {
		this.id = id;
	}//idを変更できてよいのか？
	
	public Date getDate() {return this.date;}
	public void setDate(Date date) {
		this.date = date;
	}

}
