package goodService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.sun.xml.internal.ws.developer.Serialization;
import com.xlf.entity.GoodsType;
import com.xlf.goods.GoodTypeService;

import comment.MyBeanUtis;

@Service("demoService")
public class GoodTypeServiceImpl implements GoodTypeService {

	@Autowired
	MongoTemplate mongoTemplate;

	public GoodsType findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GoodsType> findByNameString(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addType(GoodsType id) {
		return mongoTemplate.execute(new DbCallback<Integer>() {
			public Integer doInDB(DB arg0) throws MongoException, DataAccessException {
				DBObject student = new BasicDBObject();
				try {
					arg0.getCollection("table").insert(MyBeanUtis.bean2DBObject(student));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				return 1;
			}
		});
	}

	public int remove(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
