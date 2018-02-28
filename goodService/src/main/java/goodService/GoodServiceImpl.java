package goodService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xlf.entity.Goods;
import com.xlf.goods.GoodService;

@Service("demoService")
public class GoodServiceImpl implements GoodService {
	public Goods showGoodsByDes() {
		// TODO Auto-generated method stub
		return new Goods();
	}

	public List<Goods> showHotGoods() {
		// TODO Auto-generated method stub
		return null;
	}

}
