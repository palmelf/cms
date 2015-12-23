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
package com.shishuo.cms.entity;

import java.util.Date;

import com.shishuo.cms.constant.LogConstant;
import com.shishuo.cms.constant.TransResultEnum;

/**
 * 日志实体
 * 
 * @author zsy
 * 
 */

public class Log {

	/**
	 * 日志Id
	 */
	private long logId;

	/**
	 * 描述
	 */
	private String content;
	
	private String description;

	/**
	 * 日志等级：DEBUG INFO WARN ERROR FATAL
	 */
	private LogConstant.Level level;
	/**
	 * 时间
	 */
	private Date createTime;
	private TransResultEnum transType;

	public TransResultEnum getTransType() {
		return transType;
	}

	public void setTransType(TransResultEnum transType) {
		this.transType = transType;
	}

	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LogConstant.Level getLevel() {
		return level;
	}

	public void setLevel(LogConstant.Level level) {
		this.level = level;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
