<#include "header.ftl">
<div class="page-container">
	<!-- BEGIN BREADCRUMBS -->
	<#include "topbar.ftl">
	<!-- END BREADCRUMBS -->
	<!-- BEGIN CONTAINER -->
	<div class="container min-hight">
		<!-- BEGIN BLOG -->
		<div class="row">
			<#include "sidebar.ftl">
			<!-- BEGIN LEFT SIDEBAR -->
			<div class="col-md-9 col-sm-9 blog-posts margin-bottom-40">
					<div class="panel panel-default">   
	                  	<div class="panel-heading"><h4 class="panel-title">${folder.name}<#if isAdmin><a target="_blank" style="color:red;" href="${basePath}/admin/article/add.htm?folderId=${folder.folderId}">[增加文章]</a></#if></h4></div>
	                    <div class="panel-body">
	                    <ul>
							<@shishuocms_article_page folderId="${folder.folderId}" p="${p}"
								rows="12">
	                    	<#list tag_article_page.list as article>
							<li>
			                    <div class="col-lg-12">
		                        	<div class="full-width-media-text">
		                            	<h4><a href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm">${article.name}</a><span>(${article.updateTime?date}) </span></h4>
											  <!-- 		${article.content}-->
		                        	</div>
                    		</div>
                    	</li>
                    	</#list>
                    	</@shishuocms_article_page>
                    </ul>
						</div>
					</div>
				</div>
			<!-- END LEFT SIDEBAR -->
		</div>
		<!-- END BEGIN BLOG -->
	</div>
	<!-- END CONTAINER -->
</div>
<#include "footer.ftl">