<#include "header.ftl">
<style type="text/css">
.tab-style-1 .tab-content {
    background: none repeat scroll 0 0 #FFFFFF;
    padding: 20px 15px;
}
#bx-pager a.active img{
	border: 2px solid #0DA3E2;
}
</style>
<div class="page-container">
	<!-- BEGIN BREADCRUMBS -->   
	<#include "topbar.ftl">
    <!-- END BREADCRUMBS -->
    <div class="container min-hight">
		<!-- BEGIN BLOG -->
		<div class="row">
		<#include "sidebar.ftl">
				<!-- BEGIN LEFT SIDEBAR -->  
				<div class="col-xs-9">
					<div class="panel panel-default">   
	                  	<div class="panel-heading"><h3 class="panel-title">${folder.name}<#if isAdmin><a target="_blank" style="color:red;" href="${basePath}/admin/article/update.htm?articleId=${article.articleId}">[编辑]</a></#if></h3></div>
	                    <div class="panel-body">				
					<div class="row">
							<div class="col-md-5 col-sm-5" style="height:300px;width:330px;">
			                    <ul class="products-photo" style="display: block;">
			                      <#list article.attachmentList as attachment>
			                      <#if attachment.type == "photo" && attachment.status == "display">
								  <li><img style="height: 300px; width: 300px;"  src="${basePath}${attachment.path}" /></li>
								  </#if>
								  </#list>
								</ul>
							</div>
		                    <div class="col-md-7 col-sm-7" id="bx-pager">
		                   		<h2 style="color: #0DA3E2;">${article.name}</h2>
		                   		<h4 style="height:80px;">${article.title}</h4>
		                   		<#assign i = 0>
		                   		<#list article.attachmentList as attachment>
			                    <#if attachment.type == "photo">
			                    <a data-slide-index="${i}" href="javascript:void(0);"><img style="height: 150px; width:150px;" src="${basePath}${attachment.path}" /></a>
			                    <#assign i = i +1>
								</#if>
								</#list>
							</div>					
					</div>
            		<div class="tab-style-1" style="margin-top: 20px;">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#tab-1">产品内容</a></li>
							<li><a data-toggle="tab" href="#tab-2">产品描述</a></li>
							<li><a data-toggle="tab" href="#tab-3">资料下载</a></li>
						</ul>
						<div class="tab-content">
							<div id="tab-1" class="tab-pane row-fluid fade in active">
								<p>${article.content}</p>
							</div>						
							<div id="tab-2" class="tab-pane fade">
								<p>${article.description}</p>
							</div>
							<div id="tab-3" class="tab-pane fade">
								<ul>
								<#list article.attachmentList as attachment>
								<#if attachment.type == "file" && attachment.status == "display">
									<li><a target="_blank" href="${basePath}${attachment.path}">${attachment.name}</a></li>
								</#if>
								</#list>
								</ul>
							</div>
						</div>
					</div>
					<!-- 本目录产品 -->
					<div class="row">
						<div class="col-md-12 col-sm-12" style="height:150px;">
						<ul class="folder-products"  style="display: block;">
						<@shishuocms_article_page folderId="${article.folderId}" p="${p}" rows="12">
						<#list tag_article_page.list as article>
							<#list article.attachmentList as attachment>
								<#if attachment.type == "photo" && attachment.status="display">
								<li>
									<a href="${basePath}/<#list article.folderPathList as folder>${folder.ename}/</#list>${article.articleId}.htm">
										<img style="height: 150px; width:150px;" alt="" src="${basePath}${attachment.path}">
									</a>
								</li>
								<#break>
								</#if>
							</#list>
						</#list>
						</@shishuocms_article_page>
						</ul>
						</div>
					</div>
				</div>
				</div>
						</div>
				<!-- END LEFT SIDEBAR -->		
			</div>
		</div>
</div>
<script type="text/javascript">
$(function(){
	$('.products-photo').bxSlider({
        moveSlides: 1,
        responsive: true,
        controls:false,
        auto: true,
		pagerCustom: '#bx-pager'
	});
	$('.folder-products').bxSlider({
       minSlides: 6,
       maxSlides: 6,
       slideWidth: 1100,
       slideMargin: 2,
       moveSlides: 1,
       responsive: true,
       auto: true,
       pager:false
	});
});
</script>
<#include "footer.ftl">