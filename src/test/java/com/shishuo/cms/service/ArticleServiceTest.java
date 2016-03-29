package com.shishuo.cms.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.shishuo.cms.entity.vo.ArticleVo;
import com.shishuo.cms.entity.vo.PageVo;
import com.shishuo.cms.exception.FolderNotFoundException;

@ContextConfiguration(locations={"/applicationContext.xml"})
public class ArticleServiceTest  extends AbstractJUnit4SpringContextTests{
	@Autowired
	private ArticleService articleService;
	
	@Test
	public void testGetArticlePageByFolderId() throws FolderNotFoundException{
		PageVo<ArticleVo> articleVoList = articleService.getArticlePageByFolderId(4, 1, 3);
		for (ArticleVo articleVo : articleVoList.getList()) {
			System.out.println(articleVo.getTitle());
		}
	}

}
