<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="pinglunhsgb" scope="page" class="com.bean.PinglunBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=pinglun.xls");
%>
<html>
  <head>
    <title>评论</title>
  </head>

  <body >
 <%
			String sql="select * from pinglun  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>新闻ID</td>    <td align='center'>评论内容</td>    <td align='center'>评论人</td>    <td align='center'>评分</td>    <td align='center'>表</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=pinglunhsgb.getAllPinglun(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xinwenID}</td>    <td>${u.pinglunneirong}</td>    <td>${u.pinglunren}</td>    <td>${u.pingfen}</td>    <td>${u.biao}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>
