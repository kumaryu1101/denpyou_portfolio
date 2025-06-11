package model.dto;

public class Slipsdto {
	
	private String id;			//伝票番号
	private Itemsdto itemsdto; 	//itemIDをゲット
	private int number;			//数量
	
	
	//コンストラクタ
	public Slipsdto() {}
	public Slipsdto(String id, Itemsdto itemsdto, int number) {
		this.id = id;
		this.itemsdto = itemsdto;
		this.number = number;
	}
	
	//getter setter
	public String getId() {return this.id;}
	public void setId(String id) {
		this.id = id;
	}//idを変更できてよいのか？
	
	public Itemsdto getItemsdto() {return this.itemsdto;}
	public void setItemsdto(Itemsdto itemsdto) {
		this.itemsdto = itemsdto;
	}
	
	public int getNumber() {return this.number;}
	public void setNumber(int Number) {
		this.number = number;
	}
	

}
