package goodService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.sun.xml.internal.ws.developer.Serialization;
import com.xlf.entity.GoodsType;
import com.xlf.goods.GoodTypeService;

import comment.MyBeanUtis;

@Service("demoServiceType")
public class GoodTypeServiceImpl implements GoodTypeService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	@Autowired
	RedisTemplate redisTemplate;
	
	public GoodsType findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GoodsType> findByNameString(String name) {
		
		
		/*if(redisTemplate.opsForHash().) {
			
		}*/
		
		return mongoTemplate.execute(new DbCallback<List<GoodsType>>() {
			public List<GoodsType> doInDB(DB arg0) throws MongoException, DataAccessException {
				BasicDBObject dbobj = new BasicDBObject();
				dbobj = dbobj.parse("{name:{$regex:'电'}}");
				List<GoodsType> list = Lists.newArrayList();
				Iterator<DBObject> able = arg0.getCollection("type").find(dbobj).iterator();
				while (able.hasNext()) {
					DBObject ob = able.next();
					try {
						list.add(MyBeanUtis.dbObject2Bean(ob, new GoodsType()));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
				return list;

			}
		});
	}

	public int addType(final GoodsType id) {
		return mongoTemplate.execute(new DbCallback<Integer>() {
			public Integer doInDB(DB arg0) throws MongoException, DataAccessException {

				try {
					arg0.getCollection("Type").insert(MyBeanUtis.bean2DBObject(id));
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
