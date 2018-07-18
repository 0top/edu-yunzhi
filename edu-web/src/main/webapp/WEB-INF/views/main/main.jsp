<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
<%  
    if (session.getAttribute("admin") == null) {
        System.out.println("session haven't admin");
        response.sendRedirect("/edu/error.jsp");
        return; 
    }
 %>
--%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%>
<c:set value="${pageContext.request.contextPath }" var="yunzhi" />
<head>
<meta name="viewport" content="width=device-width" />
<title>云智教育</title>

<!-- 下面是easyui的环境 -->
<link id="easyuiTheme" href="${yunzhi }/theme/ui-dark-hive/easyui.css" rel="stylesheet" />
<!--  
<link id="easyuiTheme" href="${yunzhi }/easyui/themes/metro/easyui.css"
	rel="stylesheet" />
	-->
<link rel="stylesheet" href="${yunzhi }/easyui/themes/icon.css"
	type="text/css"></link>
<link href="${yunzhi }/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css"></link>
<link href="${yunzhi }/easyui/themes/color.css" rel="stylesheet" />
<link href="${yunzhi }/easyui/demo/demo.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="${yunzhi }/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${yunzhi }/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${yunzhi }/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body class="easyui-layout" id="cc">
	
	<!-- 头部状态栏 -->
	<jsp:include page="header.jsp" />

    <!-- 导航栏 -->
	<jsp:include page="navigation-hide.jsp" />
	<!-- 
    <jsp:include page="navigation.jsp" />
     -->

    <!-- 中心数据展示区 -->
	<jsp:include page="center.jsp" />

    <!-- 右侧栏 -->	
	<jsp:include page="right.jsp" />

    <!-- 底部信息 -->
    <div data-options="region:'south',border:false"
        style="height: 20px; background:#712369;">底部</div>

	@*主题*@
	<div id="mm1" style="width:150px;">
		<div onclick="changeTheme('metro');">metro</div>
		<div onclick="changeTheme('metro-blue');">metro-blue</div>
		<div onclick="changeTheme('metro-gray');">metro-gray</div>
		<div onclick="changeTheme('metro-green');">metro-green</div>
		<div onclick="changeTheme('metro-orange');">metro-orange</div>
		<div onclick="changeTheme('metro-red');">metro-red</div>
		<div class="menu-sep"></div>
		<div onclick="changeTheme('black');">black</div>
		<div onclick="changeTheme('bootstrap');">bootstrap</div>
		<div onclick="changeTheme('default');">default</div>
		<div onclick="changeTheme('gray');">gray</div>
		<div onclick="changeTheme('material');">material</div>
		<div class="menu-sep"></div>
		<div onclick="changeTheme('ui-cupertino');">ui-cupertino</div>
		<div onclick="changeTheme('ui-dark-hive');">ui-dark-hive</div>
		<div onclick="changeTheme('ui-pepper-grinder');">ui-pepper-grinder</div>
		<div onclick="changeTheme('ui-sunny');">ui-sunny</div>
	</div>

	<script type="text/javascript">  
        $(function () {  
            //读取easyuiThemeName Cookie  
            var ThreadCookie = getCookie("themeName");  
            if (ThreadCookie != "") { changeTheme(ThreadCookie) };//LoadThread  
        });  
  
        //提示框  
        function topCenter(val,time) {  
            $.messager.show({  
                title: '友情提示！',  
                msg: val,  
                timeout: time,  
                showType: 'slide',  
                style: {  
                    right: '',  
                    bottom: '',  
                    top: 80  
                }  
            });  
        };  
  
        //加载开始  
        function ajaxLoading() {  
            $("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: "100%", height: $(window).height() }).appendTo("body");  
            $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({ display: "block", left: ($(document.body).outerWidth(true) - 190) / 2, top: ($(window).height() - 45) / 2 });  
        };  
  
        //加载结束  
        function ajaxLoadEnd() {  
            $(".datagrid-mask").remove();  
            $(".datagrid-mask-msg").remove();  
        };  
  
        //添加选项卡  
        function AddTab(subtitle, url) {  
            if (!$('#tabs').tabs('exists', subtitle)) {  
                $('#tabs').tabs('add', {  
                    title: subtitle,  
                    href: url,  
                    closable: true,  
                    width: $('#mainPanle').width() - 10,  
                    height: $('#mainPanle').height() - 10  
                });  
            } else {  
                $('#tabs').tabs('select', subtitle);  
            }  
            TabClose();  
        }  
  
        function TabClose() {  
            $(".tab-inner").dblclick(function () {  
                var subtitle = $(this).children("span").text();  
                $('#tabs').tabs('close', subtitle)  
            })  
        }  
  
        //切换主题  
        changeTheme = function (themeName) {  
            var $easyuiTheme = $('#easyuiTheme');  
            var url = $easyuiTheme.attr('href');  
            var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';  
            $easyuiTheme.attr('href', href);  
            var $iframe = $('iframe');  
            if ($iframe.length > 0) {  
                for (var i = 0; i < $iframe.length; i++) {  
                    var ifr = $iframe[i];  
                    $(ifr).contents().find('#easyuiTheme').attr('href', href);  
                }  
            }  
            setCookie("themeName", themeName, 7)  
            //友情提示  
            topCenter("当前主题：" + themeName, 1000);  
        };  
  
        //设置cookie  
        function setCookie(cname, cvalue, exdays) {  
            var d = new Date();  
            d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));  
            var expires = "expires=" + d.toUTCString();  
            document.cookie = cname + "=" + cvalue + "; " + expires;  
        }  
  
        //获取cookie  
        function getCookie(cname) {  
            var name = cname + "=";  
            var ca = document.cookie.split(';');  
            for (var i = 0; i < ca.length; i++) {  
                var c = ca[i];  
                while (c.charAt(0) == ' ') c = c.substring(1);  
                if (c.indexOf(name) != -1) return c.substring(name.length, c.length);  
            }  
            return "";  
        }  
    </script>
</body>
