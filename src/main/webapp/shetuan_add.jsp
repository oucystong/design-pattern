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
		<TITLE>添加社团</TITLE>
	    

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
	document.location.href="shetuan_add.jsp?id=<%=id%>";
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
			<form action="addShetuan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加社团</td>
						</tr>
						<tr ><td width="200">社团编号：</td><td><input name='shetuanbianhao' type='text' id='shetuanbianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='hsgcheck()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelshetuanmingcheng' /></td></tr>
		<tr ><td width="200">类别：</td><td><select name='leibie' id='leibie' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("leibiexinxi","leibie")%></select></td></tr>
		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('tupian')" style='border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">点击率：</td><td><input name='dianjilv' type='text' id='dianjilv' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeldianjilv' /></td></tr>
		<tr ><td width="200">社长：</td><td><input name='shechang' type='text' id='shechang' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		<tr ><td width="200">社长姓名：</td><td><input name='shechangxingming' type='text' id='shechangxingming' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">社团介绍：</td><td><textarea name='shetuanjieshao' cols='50' rows='5' id='shetuanjieshao' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>




<script language=javascript >  
function hsgcheck() {
		var shetuanmingcheng = $("#shetuanmingcheng").val();
		if(shetuanmingcheng==""||(shetuanmingcheng.length<6||shetuanmingcheng.length>12)){
			 $("#clabelshetuanmingcheng").html("<font color=red>社团名称不能为空且长度在3～12位之间！</font>");
			 $("input[id=shetuanmingcheng]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelshetuanmingcheng").html("");
			$.ajax({
				url : "quchongShetuan.do",
				type : "post",
				data : "shetuanmingcheng=" + shetuanmingcheng,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelshetuanmingcheng").html("<font color=red>社团名称已存在，请更换！</font>");
					$("input[id=shetuanmingcheng]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelshetuanmingcheng").html("系统异常，请检查错误！");
					$("input[id=shetuanmingcheng]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var shetuanmingchengobj = document.getElementById("shetuanmingcheng"); if(shetuanmingchengobj.value==""){document.getElementById("clabelshetuanmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入社团名称</font>";return false;}else{document.getElementById("clabelshetuanmingcheng").innerHTML="  "; } 
	var dianjilvobj = document.getElementById("dianjilv"); if(dianjilvobj.value==""){document.getElementById("clabeldianjilv").innerHTML="&nbsp;&nbsp;<font color=red>请输入点击率</font>";return false;}else{document.getElementById("clabeldianjilv").innerHTML="  "; } 
	var dianjilvobj = document.getElementById("dianjilv"); if(dianjilvobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(dianjilvobj.value)){document.getElementById("clabeldianjilv").innerHTML=""; }else{document.getElementById("clabeldianjilv").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    


return true;   
}   
popheight=450;
</script>  
