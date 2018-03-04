package com.xlf.test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.xlf.goods.GoodService;

public class Tess {
	public static void main(String[] args) {
		// com.alibaba.dubbo.container.Main.main(args);

		ClassPathXmlApplicationContext clz = new ClassPathXmlApplicationContext("applicationContext.xml");
		com.xlf.goods.GoodService ser = (GoodService) clz.getBean("goodServer");
		//Goods g = new Goods(name, money, count, id, typeId);
		
		
		
		
		

	}
}
