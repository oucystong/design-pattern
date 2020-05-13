<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.ouc.util.db"/>
<html>
  <head>
    <title>制度详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  制度详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>社团编号：</td><td width='39%'>${zhidu.shetuanbianhao}</td>
     <td width='11%'>社团名称：</td><td width='39%'>${zhidu.shetuanmingcheng}</td></tr><tr>
     <td width='11%'>类别：</td><td width='39%'>${zhidu.leibie}</td>
     <td width='11%'>章节：</td><td width='39%'>${zhidu.zhangjie}</td></tr><tr>
     <td width='11%'>制度名称：</td><td width='39%'>${zhidu.zhidumingcheng}</td>
     <td width='11%'>制度内容：</td><td width='39%'>${zhidu.zhiduneirong}</td></tr><tr>
     <td width='11%'>登记人：</td><td width='39%'>${zhidu.dengjiren}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

