package com.shishuo.cms.service;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shishuo.cms.entity.Article;
import com.shishuo.cms.util.JacksonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class ArticlServiceTest {

	@Autowired
	private ArticleService articleService;

	@Test
	public void testFindListPageByQuery() {
		List<Article> list = articleService.findListPageByQuery();
		Article article1 = null;
		for (Article article : list) {
			article1 = article;
			String json = JacksonUtil.bean2Json(article);
			System.out.println(article.getClass() + "---" + json);
		}
		if (null != article1) {
			Method[] ms = article1.getClass().getMethods();
			for (Method method : ms) {
				System.out.println(method.getName());
			}
		}
	}
}