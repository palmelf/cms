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
					<div class="panel-heading">
						<h3 class="panel-title" style="color: #0DA3E2;">
							${folder.name} <#if folder.folderList?size gt 0 && folder.level
							== 2> :&nbsp;&nbsp;&nbsp;<small> <#list folder.folderList
								as f> <a
								href="${basePath}/products/${folder.ename}/${f.ename}/index.htm">${f.name}</a>
								| </#list>
							</small> </#if>
						</h3>
					</div>
					<div class="panel-body">
						<div class="row front-team" style="margin: 0;">
							<ul class="list-unstyled">
								<@shishuocms_article_page folderId="${folder.folderId}" p="${p}"	rows="12">
								<#list tag_article_page.list as article>
								<li style="width: 33%; text-align: center; border-bottom: 1px solid #DDDDDD; height: 120px; margin-bottom: 30px;" class="col-xs-3 space-mobile widfg">
									<div style="border-right: 1px dashed #DDDDDD" class="thumbnail">
										    <a  href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm">
											<!--	<#list article.attachmentList as attachment>
												<img src="${basePath}${attachment.path}" alt="" style="width: 150px; height: 150px;">
											</#list>-->
										</a> 
										<h3>
											<a style="white-space: nowrap;" href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm">${article.name}</a> <small></small>
										</h3>
										<div>
											<a href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm"  class="btn btn-primary">Detail
												<i class="fa fa-search"></i>
											</a>
										</div>
									</div>
								</li>
								</#list>
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