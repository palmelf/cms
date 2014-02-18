<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>武汉恒达智慧城市交通研发有限公司</title>

    <!-- Bootstrap core CSS -->
    <link href="${TEMPLATE_PATH}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${TEMPLATE_PATH}/css/theme.css" rel="stylesheet">
    <link href="${TEMPLATE_PATH}/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${TEMPLATE_PATH}/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" href="${TEMPLATE_PATH}/css/flexslider.css"/>
    <link href="${TEMPLATE_PATH}/assets/bxslider/jquery.bxslider.css" rel="stylesheet" />
    <link href="${TEMPLATE_PATH}/assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
    <script src="${TEMPLATE_PATH}/js/jquery.js"></script>    

    <link rel="stylesheet" href="${TEMPLATE_PATH}/assets/revolution_slider/css/rs-style.css" media="screen">
    <link rel="stylesheet" href="${TEMPLATE_PATH}/assets/revolution_slider/rs-plugin/css/settings.css" media="screen">

    <!-- Custom styles for this template -->
    <link href="${TEMPLATE_PATH}/css/style.css" rel="stylesheet">
    <link href="${TEMPLATE_PATH}/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="${TEMPLATE_PATH}/js/html5shiv.js"></script>
      <script src="${TEMPLATE_PATH}/js/respond.min.js"></script>
    <![endif]-->
    <style>
    .breadcrumb > li + li:before {
	    color: #CCCCCC;
	    content: "/ ";
	    padding: 0 5px;
	}
    </style>
  </head>
  <body>
  	<header class="header-frontend">
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="${basePath}/index.htm" class="navbar-brand"><img src="${TEMPLATE_PATH}/img/logo.png" style="width:188px;"></a>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                    	<li><a href="${basePath}/index.htm">首页</a></li>
                    	<#--头部页面tag显示-->
	                    <@shishuocms_folder_list fatherId=0 >
						<#list tag_folder_list as folder>
	                        <@shishuocms_folder folderId="${folder.folderId}">
								<li class="dropdown mega-menu-item">
	                    			<a class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false" href="${basePath}/${tag_folder.ename}/index.htm">
	                        			${tag_folder.name?upper_case}
	                            		<i class="fa fa-angle-down"></i>
	                        		</a>
	                        	<ul class="dropdown-menu">
	                        		<#list tag_folder.folderList as secondFolder>
	                        		<li><a href="${basePath}/${tag_folder.ename}/${secondFolder.ename}/index.htm">${secondFolder.name}</a></li>
	                        		</#list>
	                        	
	                        	</ul>
	                    	</li>
							</@shishuocms_folder>
						</#list>
						</@shishuocms_folder_list>
                    </ul>
                </div>
            </div>
        </div>
    </header>