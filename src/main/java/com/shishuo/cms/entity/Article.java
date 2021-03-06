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

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

import com.shishuo.cms.constant.ArticleConstant;

/**
 * 文件实体
 * 
 * @author zsy
 * 
 */
//@Data
public class Article {

	/**
	 * 文件Id
	 */
	private long articleId;

	/**
	 * 所属目录的第一级Id
	 */
	private long firstFolderId;

	/**
	 * 所属目录的第二级Id
	 */
	private long secondFolderId;

	/**
	 * 所属目录的第三级Id
	 */
	private long thirdFolderId;

	/**
	 * 所属目录的第四级Id
	 */
	private long fourthFolderId;

	/**
	 * 管理员Id
	 */
	private long adminId;

	/**
	 * 英文名称
	 */
	private String ename;

	/**
	 * 文件名称
	 */
	private String name;

	/**
	 * 文件简介
	 */
	private String title;

	/**
	 * 文件内容
	 */
	private String content;

	/**
	 * 文件描述
	 */
	private String description;

	/**
	 * 报价
	 */
	private BigDecimal price;

	/**
	 * 实际价格
	 */
	private BigDecimal realPrice;

	/**
	 * 文件被copy的次数，相当于是商品的库存
	 */
	private int copyCount;

	/**
	 * 浏览人数
	 */
	private int viewCount;

	/**
	 * 评论人数
	 */
	private int commentCount;

	/**
	 * 文件状态
	 */
	private ArticleConstant.Status status;

	/**
	 * 
	 */
	private ArticleConstant.Owner owner;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 过期时间
	 */
	private Date expireTime;

	public long getFourthFolderId() {
		return fourthFolderId;
	}

	public void setFourthFolderId(long fourthFolderId) {
		this.fourthFolderId = fourthFolderId;
	}

	public ArticleConstant.Owner getOwner() {
		return owner;
	}

	public void setOwner(ArticleConstant.Owner owner) {
		this.owner = owner;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public long getFirstFolderId() {
		return firstFolderId;
	}

	public void setFirstFolderId(long firstFolderId) {
		this.firstFolderId = firstFolderId;
	}

	public long getSecondFolderId() {
		return secondFolderId;
	}

	public void setSecondFolderId(long secondFolderId) {
		this.secondFolderId = secondFolderId;
	}

	public long getThirdFolderId() {
		return thirdFolderId;
	}

	public void setThirdFolderId(long thirdFolderId) {
		this.thirdFolderId = thirdFolderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArticleConstant.Status getStatus() {
		return status;
	}

	public void setStatus(ArticleConstant.Status status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}

	public int getCopyCount() {
		return copyCount;
	}

	public void setCopyCount(int copyCount) {
		this.copyCount = copyCount;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	private String adminName;

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", firstFolderId="
				+ firstFolderId + ", secondFolderId=" + secondFolderId
				+ ", thirdFolderId=" + thirdFolderId + ", fourthFolderId="
				+ fourthFolderId + ", adminId=" + adminId + ", ename=" + ename
				+ ", name=" + name + ", title=" + title + ", content="
				+ content + ", description=" + description + ", price=" + price
				+ ", realPrice=" + realPrice + ", copyCount=" + copyCount
				+ ", viewCount=" + viewCount + ", commentCount=" + commentCount
				+ ", status=" + status + ", owner=" + owner + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", expireTime="
				+ expireTime + ", adminName=" + adminName + "]";
	}
	
	
}
