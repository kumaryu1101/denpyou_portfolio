package model.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import model.dto.SlipsDatedto;

class SlipsDatedtoTest {

	//インスタンス化できる
		@Test
		void instiateTest() {
			SlipsDatedto slipsDate = new SlipsDatedto();
			assertNull(slipsDate);
			
			Date date = new Date();
			SlipsDatedto slips = new SlipsDatedto("ID",date);
			assertEquals("ID",slips.getId());
			assertEquals(date,slips.getDate());
		}
		
		//getterが正しく動作しているか確認
		@Test
		 void testSettersAndGetters() {
			SlipsDatedto slipsDate = new SlipsDatedto();
	        String id = "id";
	        Date date = new Date();

	        slipsDate.setId(id);
	        slipsDate.setDate(date);

	        assertEquals(id, slipsDate.getId());
	        assertEquals(date, slipsDate.getDate());

	    }

}
