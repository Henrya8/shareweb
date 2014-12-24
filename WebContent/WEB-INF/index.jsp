<%@ page language="java" import="java.util.*,com.ymxtc.duapp.dao.vo.*,com.ymxtc.duapp.service.impl.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
a{
TEXT-DECORATION:none
}
.clazz{
    padding: 1px 0 0;
    text-overflow: ellipsis;
    width: 57px;
    font-weight:700;
}

img{
 width:16;
 heigth:16;
}

</style>
<script  type="text/javascript"  src="js/mainpage.js" >
</script>




<title>我的网站导航</title>
</head>
<body>
<div id="top_inf">
  <span id="user_msg" style="position:absolute;left:3%">
   <c:if test="${user!=null}">
	  <a  href="userMsg.do" >${user.username}</a>
	  <a id="login_or_logout" href="javascript:logout()">注销</a>
	</c:if>
	<c:if test="${user==null }">
	    <span>游客</span>
	    <a id="login_or_logout" href="javascript:showLogin()">登陆</a>
	</c:if>
  </span>
   <span id="login_space" style="position:absolute;left:20%;display:none" >
    <table>
    <tr>
    <td>用户名:<input id="username" type="text"  name="username" /> </td>
     <td>密码:<input id="pwd" type="password"  name="pwd"></td>
     <td><input type="submit" value="提交"  onclick="login()"> </td>
    </tr>
    
    </table>
    </span>

  <span style="position:absolute;right:3%">其他信息</span></div>

<br/>
<div id="center_search"  style="margin:50px">   

<form action="http://www.baidu.com/baidu" target="_blank">
<table bgcolor="#FFFFFF"  align="center"><tr><td>
<input name=tn type=hidden value=baidu>
<a href="http://www.baidu.com/"><img src="http://img.baidu.com/img/logo-80px.gif" alt="Baidu" align="bottom" border="0"></a>
<input type=text name=word size=30>
<input type="submit" value="百度搜索">
</td></tr></table>
</form>

</div>

<div  id ="web_navigation">

<div id="title" align="center" >
       <span>我的网站导航</span><span style="position:absolute;right:20%"><a href="javascript:showEditcache()">添加</a> <a  href="javascript:showEditField()">编辑</a></span>
</div>

<div  id="editcache"  style="display:none">
   <div  id="edit"    style="position:relative;left:20%">
   
          <input type="text"   value="请输入名字"  name="name" />
          <input type="text"   value="请输入网址"  name="address" />
          <select  name="clazz"  onchange="change(this)" >
            <option  selected="selected" value="default">请选择分类</option>
            <option value="addClass" >添加分类</option>
          </select>
          <input type="button"  value="确认"  onclick="addweb()"/>
   </div>
   <div id="cache" style="position:relative;left:20%">
   
   </div>
   
</div>



<c:if test="${webCatalogs.size()>0}">
<div  id="showwebdiv"   style="display:inline">


   <input  type="hidden"  name="userid"/> 
   <table  align="center" width="60%">
  <c:forEach var="webCatalog"  items="${webCatalogs}" >
  <tr >
    <td  class="clazz" width="10%">${webCatalog.clazz}</td>
       <c:forEach var="i" begin="0"  end="4">
      
          <c:if test="${webCatalog.webs.size()>i}">
           <td>
            <img  width="16" height="16" src="http://${webCatalog.webs[i].webUrl}/favicon.ico" /><a href="http://${webCatalog.webs[i].webUrl}" target="blank">${webCatalog.webs[i].webname}</a>
            </td>
         </c:if>
         <c:if test="${webCatalog.webs.size()<=i}">
        	   <td width="17%"><a></a></td>
         </c:if>
      </c:forEach>
       <td width="5%"></td>
     
  </tr>
   </c:forEach>
  </table>

 </div> 
</c:if>
</div>

</body>
</html> 