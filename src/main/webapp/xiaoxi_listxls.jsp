<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiaoxihsgb" scope="page" class="com.bean.XiaoxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiaoxi.xls");
%>
<html>
  <head>
    <title>消息</title>
  </head>

  <body >
 <%
			String sql="select * from xiaoxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>社团编号</td>    <td align='center'>社团名称</td>    <td align='center'>类别</td>    <td align='center'>通知名称</td>    <td  width='65' align='center'>日期</td>    <td align='center'>登记人</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xiaoxihsgb.getAllXiaoxi(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shetuanbianhao}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.leibie}</td>    <td>${u.tongzhimingcheng}</td>    <td>${u.riqi}</td>    <td>${u.dengjiren}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

