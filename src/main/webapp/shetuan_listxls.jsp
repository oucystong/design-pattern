<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shetuanhsgb" scope="page" class="com.bean.ShetuanBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shetuan.xls");
%>
<html>
  <head>
    <title>社团</title>
  </head>

  <body >
 <%
			String sql="select * from shetuan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>社团编号</td>    <td align='center'>社团名称</td>    <td align='center'>类别</td>    <td  width='90' align='center'>图片</td>    <td align='center'>点击率</td>    <td align='center'>社长</td>    <td align='center'>社长姓名</td>        <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shetuanhsgb.getAllShetuan(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shetuanbianhao}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.leibie}</td>    <td width='90' align='center'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>    <td>${u.dianjilv}</td>    <td>${u.shechang}</td>    <td>${u.shechangxingming}</td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shetuan'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

