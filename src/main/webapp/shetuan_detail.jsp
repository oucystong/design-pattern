<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.ouc.util.db"/>
<html>
  <head>
    <title>社团详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  社团详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>社团编号：</td><td width='39%'>${shetuan.shetuanbianhao}</td>
<td  rowspan=6 align=center><a href=${shetuan.tupian} target=_blank><img src=${shetuan.tupian} width=228 height=215 border=0></a></td></tr><tr>
<td width='11%' height=44>社团名称：</td><td width='39%'>${shetuan.shetuanmingcheng}</td>
</tr><tr>
<td width='11%' height=44>类别：</td><td width='39%'>${shetuan.leibie}</td>
</tr><tr>

<td width='11%' height=44>点击率：</td><td width='39%'>${shetuan.dianjilv}</td>
</tr><tr>
<td width='11%' height=44>社长：</td><td width='39%'>${shetuan.shechang}</td>
</tr><tr>
<td width='11%' height=44>社长姓名：</td><td width='39%'>${shetuan.shechangxingming}</td>
</tr><tr>

<td width='11%' height=100  >社团介绍：</td><td width='39%' colspan=2 height=100 >${shetuan.shetuanjieshao}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

