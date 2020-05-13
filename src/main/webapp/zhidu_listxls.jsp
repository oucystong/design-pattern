<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zhiduhsgb" scope="page" class="com.bean.ZhiduBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhidu.xls");
%>
<html>
  <head>
    <title>制度</title>
  </head>

  <body >
 <%
			String sql="select * from zhidu  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>社团编号</td>    <td align='center'>社团名称</td>    <td align='center'>类别</td>    <td align='center'>章节</td>    <td align='center'>制度名称</td>        <td align='center'>登记人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=zhiduhsgb.getAllZhidu(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shetuanbianhao}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.leibie}</td>    <td>${u.zhangjie}</td>    <td>${u.zhidumingcheng}</td>        <td>${u.dengjiren}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

