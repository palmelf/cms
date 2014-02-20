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
package com.shishuo.cms.action.admin;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.stereotype.Controller;

import com.shishuo.cms.constant.SystemConstant;
import com.shishuo.cms.entity.Admin;
import com.shishuo.cms.entity.vo.JsonVo;
import com.shishuo.cms.exception.ValidateException;
import com.shishuo.cms.service.AdminService;
import com.shishuo.cms.service.AttachmentService;
import com.shishuo.cms.service.CacheService;
import com.shishuo.cms.service.CommentService;
import com.shishuo.cms.service.ConfigService;
import com.shishuo.cms.service.ArticleService;
import com.shishuo.cms.service.FolderService;
import com.shishuo.cms.service.LogService;
import com.shishuo.cms.service.UserService;
import com.shishuo.cms.util.UpdatePictureUtils;

/**
 * @author 所有action的父类
 * 
 */
@Controller
public class AdminBaseAction {

	protected final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected ConfigService configSevice;

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected ArticleService articleService;

	@Autowired
	protected LogService logService;

	@Autowired
	protected AttachmentService attachmentService;

	@Autowired
	protected UserService userService;
	@Autowired
	protected AdminService adminService;
	@Autowired
	protected CommentService commentService;
	@Autowired
	protected UpdatePictureUtils updatePictureConsTant;
	@Autowired
	protected CacheService cacheService;
	/**
	 * 参数校验
	 * 
	 * @param json
	 *            json数据Bean
	 * @throws ValidateException
	 */
	protected <T> void validate(JsonVo<T> json) throws ValidateException {
		if (json.getErrors().size() > 0) {
			json.setResult(false);
			throw new ValidateException("有错误发生");
		} else {
			json.setResult(true);
		}
	}

	/**
	 * 从session中获得管理员的信息
	 * 
	 * @param request
	 * @return
	 */
	protected Admin getAdmin(HttpServletRequest request) {
		Admin admin = (Admin) request.getSession().getAttribute(
				SystemConstant.SESSION_ADMIN);
		return admin;
	}
	
}
