<%@ page language="java" pageEncoding="UTF-8"%> 


<div data-options="region:'center',title:'展示区'">
	<div class="easyui-tabs" style="width:100%;height:100%" id="tabs">
		<div title="主页" style="padding:10px">
			<p>中心数据展示</p>
			
			<a href="/edu/druid/index.html" target="_blank" >druid监控登录界面</a>
			<br>
			@*<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="topCenter('ok')">TopCenter</a>*@
				
		     <form action="" enctype="application/x-www-form-urlencoded">
		          
		     </form>
		</div>
		<div title="平台信息" data-options="iconCls:'icon-ok',closable:true" style="padding:10px">
            <p>中心数据展示</p>
            
            <a href="/edu/druid/index.html" target="_blank" >druid监控登录界面</a>
                
             <form action="" enctype="application/x-www-form-urlencoded">
               
             </form>
        </div>
        
        <div id="wangzhanjiankong" hidden="hidden" title="网站管理" data-options="iconCls:'icon-ok',closable:true" style="padding:10px">
            <p>中心数据展示</p>
            
            <a href="/edu/druid/index.html" target="_blank" >druid监控登录界面</a>
                
             <form action="" enctype="application/x-www-form-urlencoded">
               
             </form>
        </div>
        
        <jsp:include page="../tabs.jsp" />
	</div>
	
</div>