<%@ page language="java" pageEncoding="UTF-8"%>

<div
    data-options="region:'west',split:true,collapsed:false,  
                hideExpandTool: false,  
                expandMode: null,  
                hideCollapsedContent: false,  
                collapsedSize: 120,  
                collapsedContent: function(){  
                    return $('#titlebar');  
                }  
                "
    title="导航栏" style="width: 150px;">
    <a href="javascript:void(0)" style="width:150px;"  class="easyui-linkbutton"
                onclick="topCenter('ok')">教务管理</a>
    <a href="javascript:void(0)" style="width:150px;"  class="easyui-linkbutton"
                onclick="AddTab('网站信息', 'http:localhost:8088/edu/admin/list.do')">平台管理</a>
    <a href="javascript:void(0)" style="width:150px;"  class="easyui-linkbutton"
                onclick="AddTab('平台', '')">网站管理</a>
                
   <!-- 
    <div class="easyui-accordion" style="width:150px;height:200px;">
        <div class="easyui-linkbutton"  title="站点管理" data-options="iconCls:'icon-ok'"
            style="overflow:auto;padding:10px;height:60px;">
            <a href="javascript:void(0)" style="width: 150px;" class="easyui-linkbutton"
                onclick="topCenter('ok')">站点管理</a>
                <a href="javascript:void(0)" style="width: 150px;" class="easyui-linkbutton"
                onclick="topCenter('ok')">功能配置</a>
            
            <ul style="padding: 0px; margin: 0px;">
                <li style=" margin:4px 12px;">
                    <a href="#"  style="list-style:none;text-decoration:none;"
                       onclick="javascript: AddTab('站点配置', '/SiteInfo/Index')">站点配置</a>
                </li>
                <li style=" margin:4px 12px;">
                    <a href="#" style="list-style:none;text-decoration:none;"
                       onclick="javascript: AddTab('功能配置', '/UrlInfo/Index' )">功能配置</a>
                 </li>
            </ul>
            
        </div>
        <div title="部门管理" data-options="iconCls:'icon-help'"
            style="padding:40px;">
            <ul style="padding: 0px; margin: 0px;">
                <li style=" margin:4px 12px;">
                <a href="#" style="list-style:none;text-decoration:none;"
                    onclick="javascript: AddTab('部门配置', '/Department/Index')">部门配置</a></li>
            </ul>
        </div>
        <div title="职位管理" data-options="iconCls:'icon-search'"
            style="padding:40px;"></div>
        <div title="用户管理" data-options="iconCls:'icon-search'"
            style="padding:40px;"></div>
        <div title="权限管理" data-options="iconCls:'icon-search'"
            style="padding:40px;"></div>
        -->
    </div>
</div>