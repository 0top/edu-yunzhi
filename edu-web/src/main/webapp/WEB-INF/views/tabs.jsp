<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div title="平台" data-options="iconCls:'icon-ok',closable:true"
	style="padding:10px">
	<p>中心数据展示</p>

	<a href="/edu/druid/index.html" target="_blank">druid监控登录界面</a>

	<form action="" enctype="application/x-www-form-urlencoded"></form>
</div>

<div hidden="hidden" title="网站信息"
	data-options="iconCls:'icon-ok',closable:true" style="padding:10px">
	<p>云智教育后端管理</p>
	
	<c:forEach items="${requestScope.sd}" var="u">
        <div class="technology_list1">
                <input id="id" value="${u.orgCode }" type="hidden" style="border-style:none">
                <div class="col-md-2 images_1_of_4 bg1">
                    <span class="bg"><i class="fa fa-laptop"></i> </span>
                </div>
                ${u.authorization }
                <div class="clearfix"></div>
                <div class="read_more">
                <!-- class="fa-btn btn-1 btn-1e" -->
                    <input id="delete" type="submit" value="修改 /删除"></a>
                </div>
        </div>
    </c:forEach>

	<a href="/edu/druid/index.html" target="_blank">druid监控登录界面</a>

	<form action="" enctype="application/x-www-form-urlencoded"></form>
</div>