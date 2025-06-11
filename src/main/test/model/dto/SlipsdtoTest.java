package model.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.dto.Itemsdto;
import model.dto.Slipsdto;

class SlipsdtoTest {

	//インスタンス化できる
	@Test
	void instiateTest() {
		Slipsdto slips = new Slipsdto();
		assertNull(slips);

		Itemsdto item = new Itemsdto();
		Slipsdto slip = new Slipsdto("ID",item,1 );
		assertEquals("ID", slip.getId());
		assertEquals(item, slip.getItemsdto());
		assertEquals(1, slip.getNumber());
		
	}

	//getterが正しく動作しているか確認
	@Test
	void testSettersAndGetters() {
		Slipsdto slip = new Slipsdto();
		String id = "id";
		Itemsdto item = new Itemsdto();
		int number = 1;

		slip.setId(id);
		slip.setItemsdto(item);
		slip.setNumber(number);

		assertEquals(id, slip.getId());
		assertEquals(item, slip.getItemsdto());
		assertEquals(number, slip.getNumber());

	}

}
