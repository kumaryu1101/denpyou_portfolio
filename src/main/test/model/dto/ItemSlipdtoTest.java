package model.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class ItemSlipdtoTest {

	//インスタンス化できるか
	@Test
    void InstiateTest() {
		ItemSlipdto itemSlip = new ItemSlipdto();//引数なしコンストラクタ
		assertNull(itemSlip);
		
		//フルコンストラクタ
		Date date = new Date();
		ItemSlipdto itemSlip2 = new ItemSlipdto("伝票番号",1,"商品名",1000,5,date);
		assertEquals("伝票番号",itemSlip2.getSlipid());
		assertEquals(1,itemSlip2.getItemid());
		assertEquals("商品名",itemSlip2.getItemname());
		assertEquals(1000,itemSlip2.getPrice());
		assertEquals(5,itemSlip2.getNumber());
		assertEquals(date,itemSlip2.getDate());
	}
	
	//getterが正しく動作しているか確認
	@Test
	void testSettersAndGetters() {
		ItemSlipdto itemSlip = new ItemSlipdto();
		String slipId = "伝票番号";
		int itemId = 1;
		String itemName = "商品名";
		int price = 1000;
		int number = 5;
		Date date = new Date();

		itemSlip.setSlipid(slipId);
		itemSlip.setItemid(itemId);
		itemSlip.setItemname(itemName);
		itemSlip.setPrice(price);
		itemSlip.setNumber(number);
		itemSlip.setDate(date);

		assertEquals(slipId, itemSlip.getSlipid());
		assertEquals(itemId, itemSlip.getItemid());
		assertEquals(itemName, itemSlip.getItemname());
		assertEquals(price, itemSlip.getPrice());
		assertEquals(number, itemSlip.getNumber());
		assertEquals(date, itemSlip.getDate());
	}
    
}
