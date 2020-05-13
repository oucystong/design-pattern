<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class=" nav">
	<div class="box navcontent">
          <div class="navbox">
          <ul>
              <li class="mainlevel"><a href="index.do">网站首页</a></li>
              <li class="mainlevel"><a href="dx_detail.jsp?lb=系统简介">系统简介</a></li>

           <!--   <li class="mainlevel"><a href="xwtzList.do?lb=站内新闻">站内新闻</a></li>-->
            
              <li class="mainlevel"><a href="product.html">网站资讯</a>
                  <ul>
                      <li><a href="xwtzList.do?lb=最新动态">最新动态</a></li>
                      <li><a href="xwtzList.do?lb=通知公告">通知公告</a></li>
                  </ul>
              </li>
              <li class="mainlevel"><a href="stList.do">社团展示</a>              </li>
              <li class="mainlevel"><a href="zdList.do">社团制度</a></li>
			    <li class="mainlevel"><a href="xxList.do">社团消息</a></li>
              <li class="mainlevel"><a>在线留言</a>
                  <ul>
                      <li><a href="lyb.jsp">我要留言</a></li>
                      <li><a href="lybList.do">查看留言</a></li>
                  </ul>
              </li>
			  <li class="mainlevel"><a href="login.jsp">后台管理</a></li>
			  
          </ul>
          </div>
          <div class="searchbox">
          	<form method="post" action="xwtzList.do">
            	<input type="text" id="biaoti" name="biaoti"/>
                <input type="button" id="sbnt"/>
            </form>
          </div>
       </div>
</div>
<script>
	//menu
$(document).ready(function(){
  
  $('li.mainlevel').mousemove(function(){
  $(this).find('ul').slideDown();
  });
  $('li.mainlevel').mouseleave(function(){
  $(this).find('ul').slideUp("fast");
  });
  
});
</script>