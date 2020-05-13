<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <TITLE>管理员账号查询</TITLE>
    <style type="text/css">
        <!--
        body, td, th {
            font-size: 12px;
        }

        -->
    </style>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr valign="top">
        <td>
            <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
                <tr align="left" bgcolor="#F2FDFF">
                    <td colspan="17" background="images/table_header.gif">管理员账户列表</td>
                </tr>
            </table>
        </td>
    </tr>

    <tr valign="top">
        <td bgcolor="#FFFFFF">
            <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
                <tr align="right" bgcolor="#ebf0f7">
                    <td colspan="21">
                        <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1">
                            <tr align="left">
                                <td colspan="17">
                                    <form action="allusersList.do" name="myform" method="post">
                                        查询 用户名：<input name="username" type="text" id="username"
                                                      style='border:solid 1px #000000; color:#666666' size="12"/>
                                        <input type="submit" value="查询"/>
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr align="center">
                    <td style="padding-left:0px; padding-right:0px;">
                        <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                            <tr>
                                <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                                <td align="center">账号</td>
                                <td align="center">密码</td>
                                <td align="center">权限</td>

                                <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间</td>
                                <td align="center" bgcolor="#ebf0f7" width="150px"> 操作</td>
                            </tr>
                            <%
                                int i = 0;
                            %>
                            <c:forEach items="${list }" var="u">
                                <%
                                    i++;
                                %>
                                <tr align="center" bgcolor="#FFFFFF">
                                    <td align="center"><%=i%>
                                    </td>
                                    <td>${u.username}</td>
                                    <td>${u.pwd}</td>
                                    <td>${u.cx}</td>

                                    <td align="center"> ${u.addtime } </td>
                                    <td align="center"><a href="doUpdateAllusers.do?id=${u.id }">编辑</a> | <a
                                            href="deleteAllusers.do?id=${u.id }"
                                            onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </table>


        </td>
    </tr>
</table>
<p align="center"><c:if test="${sessionScope.p==1 }">
    <c:if test="${page.page>1}">
        <a href="allusersList.do?page=1">首页</a>
        <a href="allusersList.do?page=${page.page-1 }"> 上一页</a> </c:if>
    <c:if test="${page.page<page.totalPage}">
        <a href="allusersList.do?page=${page.page+1 }">下一页</a>
        <a href="allusersList.do?page=${page.totalPage }">末页</a> </c:if>
</c:if>
</p>


</body>
</html>
