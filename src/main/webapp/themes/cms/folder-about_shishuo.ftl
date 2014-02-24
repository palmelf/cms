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
								<@shishuocms_article_page folderId="${folder.folderId}" p="${p}"	rows="12">
								<#list tag_article_page.list as article>
										${article.content}
								</#list>
								</@shishuocms_article_page>
						</div>
							${tag_article_page.pageNumHtml}
					</div>
				</div>
				<!-- END LEFT SIDEBAR -->
			</div>
			<!-- END BEGIN BLOG -->
		</div>
		<!-- END CONTAINER -->		
</div>
<#include "footer.ftl">