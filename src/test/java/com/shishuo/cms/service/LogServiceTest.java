package com.shishuo.cms.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shishuo.cms.constant.LogConstant;
import com.shishuo.cms.entity.Log;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.util.JacksonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class LogServiceTest {

	@Autowired
	private LogService logService;

	 @Test
	 public void testAddLog() {
		 logService.addLog(LogConstant.Level.DEBUG ,"sdef");
	 //assertEquals("sdef", logService.addLog(LogConstant.Level.DEBUG ,"sdef").getDescription());
	 }

	@Test
	public void testGetLogPage() {
		assertEquals(2, logService.getLogPage(1).getList().size());
	}
	@Test
	public void testGetLogList() {
		List<Log>  page=logService.getLogList(0, 200);
		System.err.println(JacksonUtil.bean2Json(page));
	}

}
