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
	                  	<div class="panel-heading"><h3 class="panel-title">${article.name}<#if isAdmin><a target="_blank" style="color:red;" href="${basePath}/admin/article/update.htm?articleId=${article.articleId}">[编辑]</a></#if></h3></div>
	                    <div class="panel-body">
							${article.content}
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