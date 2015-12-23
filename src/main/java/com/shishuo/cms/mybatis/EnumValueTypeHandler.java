package com.shishuo.cms.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.shishuo.cms.constant.TypeMappping;

/**
 * 通过 getValue 来取得枚举对应需要存进数据库的值
 * @see com.shishuo.cms.constant.TypeMappping#getValue 
 * @author Jacarri
 *
 * @param <E>
 */
public class EnumValueTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {
	static Log log=LogFactory.getLog(EnumValueTypeHandler.class);
	  private Class<E> type;
	  private final E[] enums;
	  
	public EnumValueTypeHandler(Class<E> type) {
	    if (type == null) throw new IllegalArgumentException("Type argument cannot be null");
	    this.type = type;
	    this.enums = type.getEnumConstants();
	    if (this.enums == null) throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
		if (!TypeMappping.class.isAssignableFrom(type)){
			String errorMsg=type.getCanonicalName()+" Type argument must implements " + TypeMappping.class.getCanonicalName();
			log.error(errorMsg);
			throw new IllegalArgumentException(errorMsg);
		}
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		short actualVal=((TypeMappping)parameter).getValue();
		ps.setInt(i, actualVal);
	}
	
	@Override
	public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
	    int i = rs.getInt(columnName);
	    if (rs.wasNull()) {
	      return null;
	    } else {
	      try {
	        return getEnumByValue((short) i);
	      } catch (Exception ex) {
	        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
	      }
	    }
	  }

	  @Override
	  public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
	    int i = rs.getInt(columnIndex);
	    if (rs.wasNull()) {
	      return null;
	    } else {
	      try {
	        return getEnumByValue((short) i);
	      } catch (Exception ex) {
	        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
	      }
	    }
	  }

	  @Override
	  public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
	    int i = cs.getInt(columnIndex);
	    if (cs.wasNull()) {
	      return null;
	    } else {
	      try {
	        return getEnumByValue((short) i);
	      } catch (Exception ex) {
	        throw new IllegalArgumentException("Cannot convert " + i + " to " + type.getSimpleName() + " by ordinal value.", ex);
	      }
	    }
	  }
	  
	  private E getEnumByValue(short val){
		  E e=null;
			for (Object enumUnit : enums) {
				TypeMappping tm=(TypeMappping) enumUnit;
				if(tm.getValue()==val){
					e=(E) tm;
					break;
				}
			}
			return e;
	  }
}
