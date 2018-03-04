package goodService;

import java.util.List;

import org.bson.Document;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.xlf.entity.Goods;
import com.xlf.goods.GoodService;

import comment.MyBeanUtis;

@Service("demoService")
public class GoodServiceImpl implements GoodService {

	@Autowired
	MongoTemplate mongoTemplate;

	public Goods showGoodsByDes() {
		// TODO Auto-generated method stub
		return new Goods();
	}

	public List<Goods> showHotGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addGoods(Goods goods) {
		return mongoTemplate.execute(new DbCallback<Integer>() {
			@Override
			public Integer doInDB(DB arg0) throws MongoException, DataAccessException {
				DBObject student = new BasicDBObject();
				try {
					arg0.getCollection("table").insert(MyBeanUtis.bean2DBObject(student));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
				return 1;
			}
		});
	}

	@Override
	public int deleteGoods(String Id) {
		return mongoTemplate.execute(new DbCallback<Integer>() {
			@Override
			public Integer doInDB(DB arg0) throws MongoException, DataAccessException {
				DBObject student = new BasicDBObject();
				student.put("id", Id);
				arg0.getCollection("table").findAndRemove(student);
				return 1;
			}
		});
	}

	@Override
	public int deleteGoodsByName(String name) {
		return mongoTemplate.execute(new DbCallback<Integer>() {
			@Override
			public Integer doInDB(DB arg0) throws MongoException, DataAccessException {
				DBObject student = new BasicDBObject();
				student.put("name", name);
				arg0.getCollection("table").findAndRemove(student);
				return 1;
			}
		});
	}
}
