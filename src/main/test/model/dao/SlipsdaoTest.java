package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.dto.ItemSlipdto;

class SlipsdaoTest {

	//伝票を日付で取得できるかのテスト
	@Test
	void selectByDateTest() {
		Slipsdao slipsdao = Slipsdao.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		
		try {
			Date endDate = sdf2.parse("2025-01-01-00-55");
			Date startDate = sdf.parse("2023-01-01-10-20");
			assertNotNull(slipsdao.selectByDate(startDate, endDate, 1), "伝票リストがnullではありません");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	//伝票をIDで取得できるかテスト
	@Test
	void selectByIdSlipTest() {
		Slipsdao slipsdao = Slipsdao.getInstance();
		String id = "T001"; // 取得したい伝票IDを指定
		List<ItemSlipdto> itemslipdtolist = slipsdao.selectBySlipId(id);
		for (ItemSlipdto itemSlipdto : itemslipdtolist) {
			System.out.println(itemSlipdto.getItemid() + ": " + itemSlipdto.getItemname() + "/ " + itemSlipdto.getPrice() + "/ " + itemSlipdto.getNumber() + "/ " + itemSlipdto.getDate());
		}
		assertNotNull(itemslipdtolist);
		
	}

}
