package model.dto;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.dto.Itemsdto;

class ItemsdtoTest {

	
	//インスタンス化できる
	@Test
	void instiateTest() {
		Itemsdto itemsdto = new Itemsdto();
		assertNull(itemsdto);
		
		Itemsdto itemsdto2 = new Itemsdto("商品名",100);
		assertEquals("商品名",itemsdto2.getItemname());
		assertEquals(100,itemsdto2.getPrice());
	}
	
	
	
	//getterが正しく動作しているか確認
	@Test
	 void testSettersAndGetters() {
        Itemsdto items = new Itemsdto();
        String itemName = "商品名";
        int price = 100;
        int id = 1;

        items.setItemname(itemName);
        items.setPrice(price);
        items.setItemid(id);

        assertEquals(itemName, items.getItemname());
        assertEquals(price, items.getPrice());
        assertEquals(id, items.getItemid());
    }

}
