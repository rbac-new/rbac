<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/img/favicon.ico">

    <title>首页</title>
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style type="text/css">
        body {
            min-height: 75rem;
            padding-top: 4.5rem;
        }
    </style>
</head>

<body>

<%@include file="/jsp/nav.jsp" %>

<div class="container">
    <div class="jumbotron">
        <h1>首页</h1>
        <p class="lead">一个基于角色的权限管理.
        </p>
        <p>
            1.模块整体主要使用了RBAC的思想；
        </p>
        <p>
            2.用户表，角色表，权限表，它们之间都是多对多关系,用中间表体现多对多关系；
        </p>
        <p>
            3.分层实现控制层、业务逻辑层、数据访问层，每一层之间，通过接口来调用, 来降低层与层耦合度；
        </p>
        <p>
            4.其中查询权限方法，页面上需要以多级结构展示权限, 需要如何建立多级权限之间的关系；
        </p>
        <p>
            5.维护中间表 - 修改用户角色, 先删除旧的，再插入新的，为了保证原子性，需要用事务控制；
        </p>
        <p>
            6.项目中用到的框架、技术 springmvc-spring-mybatis
        </p>


    </div>
</div>


<!-- Bootstrap core JavaScript
 ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/js/jquery-3.2.1.slim.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug
<script src="../../../../assets/js/ie10-viewport-bug-workaround.js"></script>
-->
</body>
</html>