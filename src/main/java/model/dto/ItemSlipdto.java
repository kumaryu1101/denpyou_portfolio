package model.dto;

import java.util.Date;

//引数で使う用
public class ItemSlipdto {
    private String slipid;	//伝票番号
    private int itemid ;//商品ID 
    private String itemname;//商品名
    private int price;		//単価
    private int number;		//個数
    private Date date;		//日付
    
    
    //コンストラクタ
	public ItemSlipdto() {}
    public ItemSlipdto(String slipId, int itemId, String itemName, int price, int number, Date date) {
        this.slipid = slipId;
        this.itemid = itemId;
        this.itemname = itemName;
        this.price = price;
        this.number = number;
        this.date = date;
    }
    
    
    
    //getter setter
    public String getSlipid() { return slipid; }
    public void setSlipid(String slipId) {
    	this.slipid = slipId;
    }
    
    public int getItemid() { return itemid; }
    public void setItemid(int itemId) {
		this.itemid = itemId;
	}
    
    public String getItemname() { return itemname; }
    public void setItemname(String itemName) {
    	this.itemname = itemName;
    }
    
    public int getPrice() { return price; }
    public void setPrice(int price) {
		this.price = price;
	}
    
    public int getNumber() { return number; }
    public void setNumber(int number) {
    	this.number = number;
    }
    
    public Date getDate() { return date; }
    public void setDate(Date date) {
		this.date = date;
	}
}