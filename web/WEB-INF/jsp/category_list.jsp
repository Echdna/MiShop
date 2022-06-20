<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2022/6/20
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="content-Type" content="text/html; charset=utf-8"/>
    <title>商品分类</title>
    <%--css地址--%>
    <link href="<%=basePath %>admin/css/styLe.css" rel="styLesheet" type="text/css"/>
    <style type="text/css">
        .tablelist th{
            text-align: center;
        }
        .update{
            color: darkred;
        }
    </style>

    <script type="text/javascript" snc="<%=basePath %>js/jquery-3.3.1.js"></script>

    <script type="text/javascript">

    $(document).ready(function(){
        $( ".click" ).click(function(){
        $( ".tip").fadeIn(200);
        });

        $(".tiptop a").click(function(){
        $(".tip").fadeOut(200);
        });

        $( ".sure").click(function(){
        $( ".tip" ).fadeout(100) ;
        });

        $( ".cancel" ).click( function(){
        $( ".tip" ).fadeout(100) ;
        });
    });

    </script>
</head>
<body>
    <div class="place">
        <span>位置:</span>
        <ul class="placeul">
            <li><a href="#">分类管理</a></li>
        </ul>
    </div>
    <div class="rightinfo">
        <div class="tools">
            <ul class="toolbar">
                <li style="cursor: pointer;" onclick="add_category()"><span><img src="<%=basePath %><%--图片地址--%>"/></span>添加类别</li>
                <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="<%=basePath %><%--图片地址--%>"/></span>批量删除</li>
            </ul>
        </div>
        <table class="tablelist">
            <tr>
                <th><input name="" type="checkbox" value=""/></th>
                <%--图片地址--%>
                <th>序号<i class="sort"><img src="<%=basePath %>admin/images/px.gif"/></i></th>
                <th>类别名称</th>
                <th>启用状态</th>
                <th>排序序号</th>
                <th>创建时间</th>
                <th>描述</th>
                <th>操作</th>
            </tr>
            <%--遍历展示--%>
            <c:forEach items="${cates}" var="cate" varStatus="i">
                <tr style="text-align: center;">
                    <td><input class="one" type="checkbox" value="${cate.cid }"/></td>
                    <td>${i.count }</td>
                    <td>${cate.cname }</td>
                    <td>
                        <c:if test="${cate.state == 1 }"><span style="color: green; ">启用</span></c:if>
                        <c:if test="${cate.state == 0 } "><span style="color: red;">未启用</span></c:if>
                    </td>
                    <td>${cate.order_number }</td>
                    <td>
                    <fmt:formatDate value="${cate.create_time }" pattern="yyyy-MN-dd HH:mm:ss"/>
                    </td>
                    <td>${cate.description }</td>
                    <td>
                        <a class="update" href="<%=basePath%>cate?func=findCateById&cid=${cate.cid}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="pagin">
            <div class="message">
                共<i class="blue">${pageTool.totalCount}</i>条记录，
                当前显示第&nbsp;<i class="blue">${pageTool.CurrentPage}&nbsp;</i>页,
                共&nbsp;${pageTool.pageSize }&nbsp;页
            </div>
            <ul class="paginList">
                <li class="paginItem">
                    <a href="<%=basePath %>cate?func=findAllcate&currentPaqe=1">首页</a>
                </li>
                <li class="paginItem">
                    <a href="<%=basePath %>cate?func=findAllcate&currentPaqe=${pageTool.lastPage}">上一页</a>
                </li>
                <li class="paginItem">
                    <a href="<%=basePath %>cate?func=findAllcate&currentPaqe=${pageTool.nextPage}">下一页</a>
                </li>
                <li class="paginItem">
                    <a href="<%=basePath %>cate?func=findAllcate&currentPaqe=${pageTool.pageSize}">尾页</a>
                </li>
            </ul>
        </div>
        <div class="tip">
            <div class="tiptop"><span>提示信息</span><a></a></div>
            <div class="tipinfo">
                <%--图片地址--%>
                <span><img src="images/ticon.png"/></span>
                    <div class="tipright">
                        <p>是否确认对信息的修改﹖</p>
                        <cite>如果是请点击确定按钮，否则请点取消。</cite>
                    </div>
            </div>
            <div class="tipbtn">
                <input name="" type="button" class="sure" value="确定"/> &nbsp;
                <input name="" type="button"class="cancel" value="取消"/>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>
</body>
<script type="text/javascript">
    //点击跳转添加页面
    function add_category(){
        window.location = "admin/category_add.jsp";
    }
    </script>
</html>

