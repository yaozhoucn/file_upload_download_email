
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>上传文件</title>
  </head>
  <body>
  <%--通过表单上传文件--%>
  <%--get 上传文件大小有限制--%>
  <%--post 上传文件大小没有限制--%>
  <%--${pageContext.request.contextPath}--%>
  --%>
  <form action="upload.do" enctype="multipart/form-data"  method="post">
    上传用户：<input type="text" name="username"><br/>
    <P><input type="file" name="file1"></P>
    <P><input type="file" name="file1"></P>
    <P><input type="submit" value="提交"> | <input type="reset"></P>
  </form>

  </body>
</html>
