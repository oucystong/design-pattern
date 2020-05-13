<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.ouc.util.db"/>
<html>
  <head>
    <title>会员详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  会员详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>社团编号：</td><td width='39%'>${huiyuan.shetuanbianhao}</td>
     <td width='11%'>社团名称：</td><td width='39%'>${huiyuan.shetuanmingcheng}</td></tr><tr>
     <td width='11%'>类别：</td><td width='39%'>${huiyuan.leibie}</td>
     <td width='11%'>社长：</td><td width='39%'>${huiyuan.shechang}</td></tr><tr>
     <td width='11%'>社长姓名：</td><td width='39%'>${huiyuan.shechangxingming}</td>
     <td width='11%'>用户名：</td><td width='39%'>${huiyuan.yonghuming}</td></tr><tr>
     <td width='11%'>姓名：</td><td width='39%'>${huiyuan.xingming}</td>
     <td width='11%'>电话：</td><td width='39%'>${huiyuan.dianhua}</td></tr><tr>
     <td width='11%'>学院：</td><td width='39%'>${huiyuan.xueyuan}</td>
     <td width='11%'>专业：</td><td width='39%'>${huiyuan.zhuanye}</td></tr><tr>
     <td width='11%'>备注：</td><td width='39%'>${huiyuan.beizhu}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

