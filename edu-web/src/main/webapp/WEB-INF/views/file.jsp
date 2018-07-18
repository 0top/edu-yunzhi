<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
%>

<!DOCTYPE c:set PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>upload</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/easyui/jquery.min.js"></script>
<script type="text/javascript"
    src="${yunzhi }/easyui/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
    function upload(){
        $('#upform').form({
            success:function(data){
                $.messager.alert('info',data,'info');
            }
        });
    }
</script>

<body>
    <h2>Hello World!</h2>

    <form id="upform" action="upload.do" method="post"
        enctype="multipart/form-data">
        <input type="file" name="file" size="50"> 
        <input type="submit" value="upload" onclick="upload">
    </form>
    
</body>

</html>