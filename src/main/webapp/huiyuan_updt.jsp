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
		<TITLE>修改会员</TITLE>
	    
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
	document.location.href="huiyuan_add.jsp?id=<%=id%>";
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
			<form action="updateHuiyuan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改会员<input type="hidden" name="id" value="${huiyuan.id}" /></td>
						</tr>
						<tr ><td width="200">社团编号：</td><td><input name='shetuanbianhao' type='text' id='shetuanbianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">类别：</td><td><input name='leibie' type='text' id='leibie' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">社长：</td><td><input name='shechang' type='text' id='shechang' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">社长姓名：</td><td><input name='shechangxingming' type='text' id='shechangxingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("yonghuzhuce","xingming","yonghuming",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr><script language="javascript">document.form1.dianhua.value='<%=connDbBean.readzd("yonghuzhuce","dianhua","yonghuming",(String)request.getSession().getAttribute("username"))%>';document.form1.dianhua.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">学院：</td><td><input name='xueyuan' type='text' id='xueyuan' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelxueyuan' /></td></tr>
		<tr 0><td width="200">专业：</td><td><input name='zhuanye' type='text' id='zhuanye' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelzhuanye' /></td></tr>
		<tr 1><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shetuanbianhao.value='${huiyuan.shetuanbianhao}';</script>
	<script language="javascript">document.form1.shetuanmingcheng.value='${huiyuan.shetuanmingcheng}';</script>
	<script language="javascript">document.form1.leibie.value='${huiyuan.leibie}';</script>
	<script language="javascript">document.form1.shechang.value='${huiyuan.shechang}';</script>
	<script language="javascript">document.form1.shechangxingming.value='${huiyuan.shechangxingming}';</script>
	<script language="javascript">document.form1.yonghuming.value='${huiyuan.yonghuming}';</script>
	<script language="javascript">document.form1.xingming.value='${huiyuan.xingming}';</script>
	<script language="javascript">document.form1.dianhua.value='${huiyuan.dianhua}';</script>
	<script language="javascript">document.form1.xueyuan.value='${huiyuan.xueyuan}';</script>
	<script language="javascript">document.form1.zhuanye.value='${huiyuan.zhuanye}';</script>
	<script language="javascript">document.form1.beizhu.value='${huiyuan.beizhu}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var xueyuanobj = document.getElementById("xueyuan"); if(xueyuanobj.value==""){document.getElementById("clabelxueyuan").innerHTML="&nbsp;&nbsp;<font color=red>请输入学院</font>";return false;}else{document.getElementById("clabelxueyuan").innerHTML="  "; } 
	var zhuanyeobj = document.getElementById("zhuanye"); if(zhuanyeobj.value==""){document.getElementById("clabelzhuanye").innerHTML="&nbsp;&nbsp;<font color=red>请输入专业</font>";return false;}else{document.getElementById("clabelzhuanye").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
