package com.xlf.goods;

import java.util.List;

import com.xlf.entity.GoodsType;

public interface GoodTypeService {

	public GoodsType findById(String id);

	public List<GoodsType> findByNameString(String name);

	public int addType(GoodsType id);

	public int remove(String id);

}
