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
				<div class="col-xs-9 blog-posts margin-bottom-40">
					<div class="panel panel-default">   
	                  	<div class="panel-heading"><h3 class="panel-title">${folder.name}<#if isAdmin><a target="_blank" style="color:red;" href="${basePath}/admin/folder/update.htm?folderId=${folder.folderId}">[编辑]</a></#if></h3></div>
	                    <div class="panel-body">

							<ul class="list-unstyled">
								<@shishuocms_article_page folderId="${folder.folderId}" p="${p}"
								rows="12"> <#list tag_article_page.list as article>
								<li class="col-xs-3 space-mobile widfg"
									style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 120px; margin-bottom: 30px;">
									<div class="thumbnail" style="border-right: 1px dashed #DDDDDD">
										<#list article.attachmentList as attachment> <#if
										attachment.type == "photo" && attachment.status="display"> <a
											href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm">
											<img style="width: 150px; height: 150px;" alt=""
											src="${basePath}${attachment.path}">
										</a> <#break> </#if> </#list>
										<h3>
											<a
												href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm"
												style="white-space: nowrap;">${article.name}</a> <small>${article.title}</small>
										</h3>
										<div>
											<a class="btn btn-primary"
												href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li> <#if (article_index+1)%3==0>
								<div class="clearfix"></div>
								</#if> </#list>
								<div class="text-center">${tag_article_page.pageNumHtml}</div>
								</@shishuocms_article_page>
							</ul>
						</div>
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