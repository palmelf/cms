package org.apache.ibatis.executor.resultset;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.ReflectionUtils;

@Intercepts({ @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class DiclectResultSetHandlerInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object result = invocation.proceed();
		return result;
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof DefaultResultSetHandler) {
			ResultSetHandler rsh = (DefaultResultSetHandler) target;
			rsh = changeResultSetHandler(rsh);
			target = rsh;
		}
		return Plugin.wrap(target, this);
	}

	private ResultSetHandler changeResultSetHandler(ResultSetHandler rsh) {
		DefaultResultSetHandler drsh = (DefaultResultSetHandler) rsh;
		Field executorField = ReflectionUtils.findField(drsh.getClass(), "executor");
		executorField.setAccessible(true);
		Field mappedStatementField = ReflectionUtils.findField(drsh.getClass(), "mappedStatement");
		mappedStatementField.setAccessible(true);
		Field parameterHandlerField = ReflectionUtils.findField(drsh.getClass(), "parameterHandler");
		parameterHandlerField.setAccessible(true);
		Field resultHandlerField = ReflectionUtils.findField(drsh.getClass(), "resultHandler");
		resultHandlerField.setAccessible(true);
		Field boundSqlField = ReflectionUtils.findField(drsh.getClass(), "boundSql");
		boundSqlField.setAccessible(true);
		Field rowBoundsField = ReflectionUtils.findField(drsh.getClass(), "rowBounds");
		rowBoundsField.setAccessible(true);
		Executor executor = (Executor) ReflectionUtils.getField(executorField, drsh);
		MappedStatement mappedStatement = (MappedStatement) ReflectionUtils.getField(mappedStatementField, drsh);
		ParameterHandler parameterHandler = (ParameterHandler) ReflectionUtils.getField(parameterHandlerField, drsh);
		ResultHandler resultHandler = (ResultHandler) ReflectionUtils.getField(resultHandlerField, drsh);
		BoundSql boundSql = (BoundSql) ReflectionUtils.getField(boundSqlField, drsh);
		RowBounds rowBounds = (RowBounds) ReflectionUtils.getField(rowBoundsField, drsh);
		ResultSetHandler newhandler = new DefaultWrapperUnmappPropertyResultSetHandler(executor, mappedStatement,
				parameterHandler, resultHandler, boundSql, rowBounds);
		return newhandler;
	}

	@Override
	public void setProperties(Properties properties) {

	}
}
