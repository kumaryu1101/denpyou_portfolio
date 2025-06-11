package model.dto;

public class Itemsdto {
	private int itemid; 		//商品番号
	private String itemname; 	//商品名
	private int price;			//単価
	
	
	//コンストラクタ
	public Itemsdto() {}
	public Itemsdto(String itemName, int price) {
		this.itemname = itemName;
		this.price = price;
	}
	public Itemsdto(int id, String itemName, int price) {
		this.itemid = id;
		this.itemname = itemName;
		this.price = price;
	}
	
	//getter setter
	public int getItemid() {return this.itemid;}
	public void setItemid(int id) {
		this.itemid = id;
	}//IDがセットできてよいのか？
	
	public String getItemname() {return this.itemname;}
	public void setItemname(String itemName) {
			this.itemname = itemName;
		}
	
	public int getPrice() {return this.price;}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
