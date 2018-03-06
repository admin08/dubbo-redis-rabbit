package com.xlf.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xlf.entity.GoodsType;
import com.xlf.goods.GoodService;
import com.xlf.goods.GoodTypeService;

public class Tess {
	public static void main(String[] args) {
		// com.alibaba.dubbo.container.Main.main(args);

		ClassPathXmlApplicationContext clz = new ClassPathXmlApplicationContext("applicationContext.xml");
		// com.xlf.goods.GoodService ser = (GoodService) clz.getBean("goodServer");
		com.xlf.goods.GoodTypeService ser = (GoodTypeService) clz.getBean("goodServerType");
		// Goods g = new Goods(name, money, count, id, typeId);

		List<GoodsType> list = ser.findByNameString("");
		
		for (GoodsType goodsType : list) {
			System.out.println(goodsType.getName());
		}
		
		

	}
}
