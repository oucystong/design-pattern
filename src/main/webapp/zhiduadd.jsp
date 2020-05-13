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

<title>制度</title>

<link rel="stylesheet" type="text/css" href="qtimages/css/base.css"/>
<link rel="stylesheet" type="text/css" href="qtimages/css/sonpage.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript" src="qtimages/jquery.js"></script>
<script type="text/javascript" src="qtimages/inc.js"></script>
<link rel="stylesheet" href="qtimages/hsgbanner.css">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 18px;
	font-weight: bold;
	color: #147001;
}
-->
</style>
</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	var zhangjieobj = document.getElementById("zhangjie"); if(zhangjieobj.value==""){document.getElementById("clabelzhangjie").innerHTML="&nbsp;&nbsp;<font color=red>请输入章节</font>";return false;}else{document.getElementById("clabelzhangjie").innerHTML="  "; } 
	var zhidumingchengobj = document.getElementById("zhidumingcheng"); if(zhidumingchengobj.value==""){document.getElementById("clabelzhidumingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入制度名称</font>";return false;}else{document.getElementById("clabelzhidumingcheng").innerHTML="  "; } 
	
}
function gow()
{
	document.location.href="zhiduadd.jsp?id=<%=id%>";
}
</script>


<body>

<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="hsgbanner.jsp"></jsp:include>

<jsp:include page="bht.jsp"></jsp:include>


<div class="center-content">
	<div class="leftbox">
          <div class="c-left">
              <ul><h2>制度/<span>Details</span></h2></ul>
              <!--<ol>
                  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
				  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
				  <li><a href="#">公司新闻</a></li>
                  <li><a href="#">行业动态</a></li>
              </ol>-->
          </div>

          <div class="albaba">
          	<a href="#"><img src="qtimages/alibaba.png" width="250" height="500"/></a>
          </div>
                    <div class="conacts">
                	
					<ul>
                    	<li>公司地址：xxxxxxxxC-xxxxxx室
</li>
                     	<li>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编：xxxx</li>
                        <li>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：xxx-xxxx xxx-xxxxx</li>
                        <li>传&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;真：0871-xxxxx</li>
                        <li>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：xxxxxxx@163.com
</li>                 
                    </ul>
           </div>
    </div>
    <div class="c-right">
    	<div class="tree-nav">
        	<h2>制度</h2>
            <p><a href="index.do">首页</a>/ 制度</p>
        </div>
<div class="news_content">
                                
								<% 




%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addZhidu.do" name="form1" method="post">
						<tr ><td width="200">社团编号：</td><td><input name='shetuanbianhao' type='text' id='shetuanbianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shetuanbianhao.value='<%=connDbBean.readzd("shetuan","shetuanbianhao","id",request.getParameter("id"))%>';document.form1.shetuanbianhao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">社团名称：</td><td><input name='shetuanmingcheng' type='text' id='shetuanmingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shetuanmingcheng.value='<%=connDbBean.readzd("shetuan","shetuanmingcheng","id",request.getParameter("id"))%>';document.form1.shetuanmingcheng.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">类别：</td><td><input name='leibie' type='text' id='leibie' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.leibie.value='<%=connDbBean.readzd("shetuan","leibie","id",request.getParameter("id"))%>';document.form1.leibie.setAttribute("readOnly",'true');</script>
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
						</form>
					 </table>
			
			<script language="javascript">popheight = 450;</script>
					  
      </div>
                            
    </div>
</div>




<jsp:include page="qtdown.jsp"></jsp:include>

</body>
</html>
