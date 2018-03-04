package com.xlf.goods;
import java.util.List;

import  com.xlf.entity.Goods;
/**
 * 物品服务项
 * @author lingfeng
 *
 */

public interface GoodService {
	
	public List<Goods> showHotGoods();
		
	public Goods showGoodsByDes();
	
	public int addGoods(Goods goods);
	
	
	public int deleteGoods(String Id);
	
	
	public int deleteGoodsByName(String name);
	
	
	
	

}
