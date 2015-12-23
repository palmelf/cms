package com.shishuo.cms.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 
 * @author 
 * 
 */
public  class JacksonUtil {
	
	
	private static final ObjectMapper MAPPER = new ObjectMapper();

	static {
		//MAPPER.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, false);
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);	}


	private static final JsonFactory JSONFACTORY = new JsonFactory();
	

	/**
	 * 把json参数转换成对应Vo
	 * <B>第二个参数请使用  Class ,比如JacksonUtil.json2Bean("{\"name\":\"0000\",\"age\":456}", Car.class);</B>
	 * @param param
	 * @param T
	 * @return
	 */
	public static <T> T json2Bean(String json, TypeReference valueTypeRef) {
		
		T rtn =null;
		try {
			rtn = 	MAPPER.readValue(json, valueTypeRef);
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return rtn;
	}
	public static <T> T json2Bean(String json, Class<T>  cls) {
	    
	    T rtn =null;
	    try {
	        rtn = 	MAPPER.readValue(json, cls);
	    } catch (JsonParseException e) {
	        throw new RuntimeException(e);
	    } catch (JsonMappingException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        throw new RuntimeException(e);
	    }
	    return rtn;
	}

	
	
	/**
	 * 转换vo 为 json
	 */
	public static String bean2Json(Object o) {
	    StringWriter sw = new StringWriter();
	    JsonGenerator jsonGenerator = null;
	    
	    try {
	        jsonGenerator = JSONFACTORY.createJsonGenerator(sw);
	        MAPPER.writeValue(jsonGenerator, o);
	        return sw.toString();
	        
	    } catch (Exception e) {
	        throw new  RuntimeException(e);
	        //return null;
	        
	    } finally {
	        if (jsonGenerator != null) {
	            try {
	                jsonGenerator.close();
	            } catch (Exception e) {
	                throw  new RuntimeException(e);
	            }
	        }
	    }
	}
	/**
	 * 转换vo 为 json,属性为null不被序列化
	 */
	public static String bean2JsonWithoutNull(Object o) {
		StringWriter sw = new StringWriter();
		JsonGenerator jsonGenerator = null;
		ObjectMapper mapper=new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		try {
			jsonGenerator = JSONFACTORY.createJsonGenerator(sw);
            mapper.writeValue(jsonGenerator, o);
			return sw.toString();

		} catch (Exception e) {
			throw new  RuntimeException(e);
			//return null;

		} finally {
			if (jsonGenerator != null) {
				try {
					jsonGenerator.close();
				} catch (Exception e) {
					throw  new RuntimeException(e);
				}
			}
		}
	}
	
	

	/**
	 * 转换Json String 为 HashMap
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> json2Map(String json,
			boolean collToString) {
		try {
			Map<String, Object> map = MAPPER.readValue(json, HashMap.class);
			if (collToString) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if (entry.getValue() instanceof Collection
							|| entry.getValue() instanceof Map) {
						entry.setValue(bean2Json(entry.getValue()));
					}
				}
			}
			return map;
		} catch (Exception e) {
			//return null;
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("serial")
	public static class jsonParseException extends Exception {
		public jsonParseException(String message) {
			super(message);
		} 
	}

	/**
	 * List 转换成json
	 * 
	 * @param list
	 * @return
	 */
	public static String list2Json(List<Map<String, String>> list) {
		JsonGenerator jsonGenerator = null;
		StringWriter sw = new StringWriter();
		try {
			jsonGenerator = JSONFACTORY.createJsonGenerator(sw);
			new ObjectMapper().writeValue(jsonGenerator, list);
			jsonGenerator.flush();
			return sw.toString();
		} catch (Exception e) {
			//return null;
			throw new  RuntimeException(e);
		} finally {
			if (jsonGenerator != null) {
				try {
					jsonGenerator.flush();
					jsonGenerator.close();
				} catch (Exception e) {
					//e.printStackTrace();
					throw new  RuntimeException(e);
				}
			}
		}
	}

	/**
	 * json 转List
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, String>> json2List(String json) {
		try {
			if (json != null && !"".equals(json.trim())) {
				JsonParser jsonParse = JSONFACTORY
						.createJsonParser(new StringReader(json));

				ArrayList<Map<String, String>> arrayList = (ArrayList<Map<String, String>>) new ObjectMapper()
						.readValue(jsonParse, ArrayList.class);
				return arrayList;
			} else {
				return null;
			}
		} catch (Exception e) {
			//return null;
			throw  new RuntimeException(e);
			
		}
	}
	
	
	// 测试方法
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setUsername("张小三");
		user.setAddress("海南");
		user.setPhone("010");

		User user2 = new User();
		user2.setId(2);
		user2.setUsername("李小璐");
		user2.setAddress("天津");
		user2.setPhone("8888888");

		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user2);

		 String str = bean2Json(user);
		 bean2Json(list);
		 System.out.println(str);

		 String json =
		 "{\"address\":\"拾金路\",\"id\":1,\"username\":\"张小宁\",\"phone\":123456789}";
		 User u = (User)json2Bean(json,new TypeReference<User>() {
        });
		 System.out.println(u);
		
	}
	
	
	static class   User {
		 
		 private int id;
		 private String username;
		 private String address;
		 private String phone;
		 public int getId() {
		  return id;
		 }
		 public void setId(int id) {
		  this.id = id;
		 }
		 public String getUsername() {
		  return username;
		 }
		 public void setUsername(String username) {
		  this.username = username;
		 }
		 public String getAddress() {
		  return address;
		 }
		 public void setAddress(String address) {
		  this.address = address;
		 }
		 public String getPhone() {
		  return phone;
		 }
		 public void setPhone(String phone) {
		  this.phone = phone;
		 }
		 
		 @Override
		 public String toString() {
		  return "id: " + id + " username: " + username + " address: " + address + " phone: " + phone;
		 }
		}
	
}
