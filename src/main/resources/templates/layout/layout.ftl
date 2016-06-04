<#macro mainLayout urlLink urlGroup hasSideBar=true progressBar="" >
    <#import "/layout/sidebar.ftl" as sidebar/>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js"><!--<![endif]-->
<head>
    <meta charset="utf-8">



<#--Styles-->

<#--Styles-->
    <!--Bootstrap-->
    <link rel="stylesheet" href="/css/lib/bootstrap.min.css">
    <link rel="stylesheet" href="/css/lib/vendor/bootstrap-select/bootstrap-select.min.css">
    <!-- Theme -->
    <link rel="stylesheet" href="/css/lib/plugins.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/lib/main.css">
<#--Jquery UI-->
    <link rel="stylesheet" href="/js/lib/vendor/jquery-ui/jquery-ui.css">
<#--<link rel="stylesheet" href="/js/vendor/jquery-ui/jquery-ui.theme.css">-->
    <!-- Site wide custom CSS-->
    <link rel="stylesheet" href="/css/lib/custom.css">
    <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
    <link rel="stylesheet" href="/css/lib/themes/spring.css">
    <link rel="stylesheet" href="/css/lib/themes.css">
    <link rel="stylesheet" href="/css/lib/font-awesome-4.6.3/css/font-awesome.min.css">
    <!-- Modernizr (browser feature detection library) & Respond.js (Enable responsive CSS code on browsers that don't support it, eg IE8) -->
    <script type="text/javascript" src="/js/lib/vendor/modernizr-respond.min.js"></script>
<#--End styles-->


    <!--Bootstrap-->
    <#--<link rel="stylesheet" href="/css/lib/bootstrap.css">-->
    <#--<link rel="stylesheet" href="/css/lib/bootstrap-responsive.css">-->
    <link rel="stylesheet" href="/css/main.css">

    <#--<script type="text/javascript" src="/js/jquery.js"></script>-->
    <#--<script type="text/javascript" src="/js/lib/bootstrap.js"></script>-->

    <!-- Modernizr (browser feature detection library) & Respond.js (Enable responsive CSS code on browsers that don't support it, eg IE8) -->
    <script type="text/javascript" src="/js/lib/vendor/modernizr-respond.min.js"></script>
<#--End styles-->

<#--Required Scripts-->
    <!--JQuery-->
    <script type="text/javascript" src="/js/lib/vendor/jquery-1.12.3.min.js"></script>

<#--JQuery UI-->
    <script type="text/javascript" src="/js/lib/vendor/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/js/lib/vendor/jquery.validate.min.js"></script>
    <!-- Bootstrap JS-->
    <script type="text/javascript" src="/js/lib/vendor/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/lib/vendor/bootstrap-select/bootstrap-select.js"></script>

    <title>${pageTitle!"?"}</title>

</head>
<body>

    <#if hasSideBar>
    <div id="page-container" class="header-fixed-top  sidebar-visible-lg">
        <@sidebar.sidebar urlLink urlGroup></@sidebar.sidebar>
    <#else>
    <div id="page-container" class="">
    </#if>
<div id="main-container">

    <header class="navbar navbar-default navbar-fixed-top">

        <h1 class="pull-left">${pageTitle!"?"}</h1>
        <div class="pull-right">

            <#--<a href="/" class="btn btn-info">Home</a>-->

<#--<a href="/flowErrors" class="btn btn-info">ERRORS</a>-->
            <span id="appStartStopBtn" class="btn btn-success"><#if isOn?? && isOn == true>PAUSE<#else>START</#if></span>
<a href="/system?kill" id="appKillBtn" class="btn btn-warning">KILL</a>
<span id="resetSystem" class="btn btn-danger">RESET</span>
</div>
        </header>
<#--Content wrapped in this layout-->
<div id="page-content" class="block full">
    <#if messageType?? && messageType == "success">
        <#global messageType = "success" />
    </#if>
    <#if messageType?? && messageType ==  "info">
        <#global messageType = "info" />
    </#if>
    <#if messageType?? && messageType ==  "warning">
        <#global messageType = "warning" />
    </#if>
    <#if messageType?? && messageType ==  "error">
        <#global messageType = "danger" />
    </#if>
    <#if message??>
        <div class="row">
            <div class="col-md-12">
                <div class="alert alert-${messageType} alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                ${message}
                </div>
            </div>
        </div>
    </#if>
    <#nested/>

    </div>

    <footer>
        <#if xmpContent??>
            <#else>

<div class="row">
<xmp id="messageLog" class="terminal">${xmpContent!""}</xmp>
</div>
            </#if>
        </footer>
    </div>
    </div>
<!-- Scroll to top link, initialized in js/app.js - scrollToTop() -->
<a href="#" id="to-top"><i class="fa fa-angle-double-up"></i></a>

<#--Addiational Scripts-->
<script type="text/javascript" src="/js/lib/vendor/sock.js"></script>
<script type="text/javascript" src="/js/lib/vendor/stomp.js"></script>
<!--Theme JS-->
<script type="text/javascript" src="/js/lib/theme/plugins.js"></script>
<script type="text/javascript" src="/js/lib/theme/app.js"></script>
<#--Site wide custom JS-->
<script lang="text/javascript" src="/js/custom.js"></script>
<#--End additional scripts-->



<script>


</script>

</body>
</html>
</#macro>