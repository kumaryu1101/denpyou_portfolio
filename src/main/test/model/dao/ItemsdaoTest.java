package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.dto.Itemsdto;

class ItemsdaoTest {

	//商品をインサートできてるか確認するテスト
	@Test
	void insertItemTest() {
		Itemsdao itemsdao = Itemsdao.getInstance();
		Itemsdto item = new Itemsdto("商品名555",55555);//これをインサートする
		
		boolean result = itemsdao.insertItem(item);
		assertTrue(result);
		
	}
	//商品があるか確認するテスト
	@Test
	void selectAllItemTest() {
		Itemsdao itemsdao = Itemsdao.getInstance();
		assertNotNull(itemsdao.selectAllItem(), "商品リストがnullではありません");
		assertTrue(itemsdao.selectAllItem().size() > 0, "商品リストにアイテムが存在します");
	}

}
