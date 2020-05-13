<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.ouc.util.db"/>
<div class="header">
	<div class="box logo">
      <div class="logopart">
          <a href="index.do">社团管理系统</a>
      </div>
	   <div style="padding-top:50px; position:absolute; padding-left:120px;">
         <div style="font-family:宋体; color:#0c9b25; WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt">
                    <div align="left">社团管理系统</div>
                </div>
      </div>
      <div class="phonepart">
			<div class="toplink">
            	
                <a href="userreg.jsp">用户注册</a>|
                <a href="userlog.jsp">用户登陆</a>
            </div>
            <div class="f_c"></div>
            <div class="dplink">
            	
                <img src="qtimages/phone.png" width="198" height="46"/>
            </div>
      </div>
    </div>
</div>