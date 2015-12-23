/*
 * 
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	 
 *		http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.shishuo.cms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shishuo.cms.constant.LogConstant;
import com.shishuo.cms.constant.TransResultEnum;
import com.shishuo.cms.dao.LogDao;
import com.shishuo.cms.entity.Log;
import com.shishuo.cms.entity.vo.PageVo;

/**
 * @author Zhangjiale
 * 
 */
@Service
public class LogService {

	@Autowired
	private LogDao logDao;

	// ///////////////////////////////
	// ///// 增加 ////////
	// ///////////////////////////////

	/**
	 * 增加日志
	 * 
	 * @param description
	 * @return log
	 */
	public Log addLog(LogConstant.Level level, String description) {
		Log log = new Log();
		log.setLevel(level);
		//log.setContent(content);
		log.setDescription(description);
		log.setCreateTime(new Date());
		log.setTransType(TransResultEnum.TRANS_RESULT_FAIL);
		logDao.addLog(log);
		return log;
	}

	// ///////////////////////////////
	// ///// 查詢 ////////
	// ///////////////////////////////

	/**
	 * 日志分页
	 * 
	 * @return pageVo
	 */
	public PageVo<Log> getLogPage(int pageNum) {
		PageVo<Log> pageVo = new PageVo<Log>(pageNum);
		List<Log> list = this.getLogList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		pageVo.setCount(this.getLogListCount());
		return pageVo;
	}

	/**
	 * 所有日志
	 * 
	 * @param offset
	 * @param rows
	 * @return list<Log>
	 */
	public List<Log> getLogList(long offset, long rows) {
		return logDao.getLogList(offset, rows);
	}

	/**
	 * 所有日志的数量
	 * 
	 * @return Integer
	 */
	public int getLogListCount() {
		return logDao.getLogListCount();
	}
}
