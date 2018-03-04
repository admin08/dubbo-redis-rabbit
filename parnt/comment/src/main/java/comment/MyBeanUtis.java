package comment;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public abstract  class MyBeanUtis  {
	
	/** 
	   * ��ʵ��bean����ת����DBObject 
	   * @param bean 
	   * @return 
	   * @throws IllegalArgumentException 
	   * @throws IllegalAccessException 
	   */  
	  public static <T> DBObject bean2DBObject(T bean) throws IllegalArgumentException,  
	      IllegalAccessException {  
	    if (bean == null) {  
	      return null;  
	    }  
	    DBObject dbObject = new BasicDBObject();  
	    // ��ȡ�����Ӧ���е�����������  
	    Field[] fields = bean.getClass().getDeclaredFields();  
	    for (Field field : fields) {  
	      // ��ȡ������  
	      String varName = field.getName();  
	      // �޸ķ��ʿ���Ȩ��  
	      boolean accessFlag = field.isAccessible();  
	      if (!accessFlag) {  
	        field.setAccessible(true);  
	      }  
	      Object param = field.get(bean);  
	      if (param == null) {  
	        continue;  
	      } else if (param instanceof Integer) {//�жϱ���������  
	        int value = ((Integer) param).intValue();  
	        dbObject.put(varName, value);  
	      } else if (param instanceof String) {  
	        String value = (String) param;  
	        dbObject.put(varName, value);  
	      } else if (param instanceof Double) {  
	        double value = ((Double) param).doubleValue();  
	        dbObject.put(varName, value);  
	      } else if (param instanceof Float) {  
	        float value = ((Float) param).floatValue();  
	        dbObject.put(varName, value);  
	      } else if (param instanceof Long) {  
	        long value = ((Long) param).longValue();  
	        dbObject.put(varName, value);  
	      } else if (param instanceof Boolean) {  
	        boolean value = ((Boolean) param).booleanValue();  
	        dbObject.put(varName, value);  
	      } else if (param instanceof Date) {  
	        Date value = (Date) param;  
	        dbObject.put(varName, value);  
	      }  
	      // �ָ����ʿ���Ȩ��  
	      field.setAccessible(accessFlag);  
	    }  
	    return dbObject;  
	  }  
	  
	  /** 
	   * ��DBObjectת����bean���� 
	   * @param dbObject 
	   * @param bean 
	   * @return 
	   * @throws IllegalAccessException 
	   * @throws InvocationTargetException 
	   * @throws NoSuchMethodException 
	   */  
	  public static <T> T dbObject2Bean(DBObject dbObject, T bean) throws IllegalAccessException,  
	      InvocationTargetException, NoSuchMethodException {  
	    if (bean == null) {  
	      return null;  
	    }  
	    Field[] fields = bean.getClass().getDeclaredFields();  
	    for (Field field : fields) {  
	      String varName = field.getName();  
	      Object object = dbObject.get(varName);  
	      if (object != null) {  
	        BeanUtils.setProperty(bean, varName, object);  
	      }  
	    }  
	    return bean;  
	  }  
	
}
