<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="huiyuanhsgb" scope="page" class="com.bean.HuiyuanBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=huiyuan.xls");
%>
<html>
  <head>
    <title>会员</title>
  </head>

  <body >
 <%
			String sql="select * from huiyuan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>社团编号</td>    <td align='center'>社团名称</td>    <td align='center'>类别</td>    <td align='center'>社长</td>    <td align='center'>社长姓名</td>    <td align='center'>用户名</td>    <td align='center'>姓名</td>    <td align='center'>电话</td>    <td align='center'>学院</td>    <td align='center'>专业</td>        <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=huiyuanhsgb.getAllHuiyuan(14);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shetuanbianhao}</td>    <td>${u.shetuanmingcheng}</td>    <td>${u.leibie}</td>    <td>${u.shechang}</td>    <td>${u.shechangxingming}</td>    <td>${u.yonghuming}</td>    <td>${u.xingming}</td>    <td>${u.dianhua}</td>    <td>${u.xueyuan}</td>    <td>${u.zhuanye}</td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=huiyuan'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

