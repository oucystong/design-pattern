<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.ouc.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改制度</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="zhidu_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateZhidu.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改制度<input type="hidden" name="id" value="${zhidu.id}" /></td>
						</tr>
						<tr ><td width="200">社团编号：</td><td><input name='shetuanbianhao' type='text' id='shetuanbianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">类别：</td><td><input name='leibie' type='text' id='leibie' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">章节：</td><td><input name='zhangjie' type='text' id='zhangjie' value='' onblur='checkform()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelzhangjie' /></td></tr>
		<tr ><td width="200">制度名称：</td><td><input name='zhidumingcheng' type='text' id='zhidumingcheng' value='' onblur='checkform()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelzhidumingcheng' /></td></tr>
		<tr ><td width="200">制度内容：</td><td><textarea name='zhiduneirong' cols='50' rows='5' id='zhiduneirong' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		<tr ><td width="200">登记人：</td><td><input name='dengjiren' type='text' id='dengjiren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shetuanbianhao.value='${zhidu.shetuanbianhao}';</script>
	<script language="javascript">document.form1.shetuanmingcheng.value='${zhidu.shetuanmingcheng}';</script>
	<script language="javascript">document.form1.leibie.value='${zhidu.leibie}';</script>
	<script language="javascript">document.form1.zhangjie.value='${zhidu.zhangjie}';</script>
	<script language="javascript">document.form1.zhidumingcheng.value='${zhidu.zhidumingcheng}';</script>
	<script language="javascript">document.form1.zhiduneirong.value='${zhidu.zhiduneirong}';</script>
	<script language="javascript">document.form1.dengjiren.value='${zhidu.dengjiren}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var zhangjieobj = document.getElementById("zhangjie"); if(zhangjieobj.value==""){document.getElementById("clabelzhangjie").innerHTML="&nbsp;&nbsp;<font color=red>请输入章节</font>";return false;}else{document.getElementById("clabelzhangjie").innerHTML="  "; } 
	var zhidumingchengobj = document.getElementById("zhidumingcheng"); if(zhidumingchengobj.value==""){document.getElementById("clabelzhidumingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入制度名称</font>";return false;}else{document.getElementById("clabelzhidumingcheng").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
