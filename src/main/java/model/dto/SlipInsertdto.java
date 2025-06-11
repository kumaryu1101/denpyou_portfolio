package model.dto;

import java.util.Date;

public class SlipInsertdto {
    private String slipId;	//伝票番号
    private int itemId = -1;//商品ID nullの場合もある初期値を-1にするか
    private int number;		//個数
    private Date date;		//日付
    
    
    //コンストラクタ
	public SlipInsertdto() {}
    public SlipInsertdto(String slipId, int itemId, int number, Date date) {
        this.slipId = slipId;
        this.itemId = itemId;
        this.number = number;
        this.date = date;
    }
    
    
    
    //getter setter
    public String getSlipId() { return slipId; }
    public void setSlipId(String slipId) {
    	this.slipId = slipId;
    }
    
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) {
		this.itemId = itemId;
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

