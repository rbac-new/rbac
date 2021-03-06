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

    <title>订单查询管理</title>

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
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/index.jsp">首页</a></li>
            <li class="breadcrumb-item">订单管理</li>
            <li class="breadcrumb-item active">查询订单</li>
        </ol>
      <div class="jumbotron">
        <h1>订单查询管理</h1>
        

      </div>
      
      <c:if test="${error!=null}">
      <hr/>
      <div class="alert alert-warning" role="alert">
		<h5 class="alert-heading">错误!</h5>
		<p>${error}</p>
	  </div>
	  </c:if>
      
      <c:if test="${list!=null}">
      <table class="table">
	  <thead>
	    <tr>
	      <th>订单编号</th>
	      <th>顾客编号</th>
	      <th>门店编号</th>
	      <th>总金额</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${list}" var="o">
	    <tr>
	      <th scope="row">${o.id}</th>
	      <td>${o.customerId}</td>
	      <td>${o.orgId}</td>
	      <td>${o.total}</td>
	    </tr>
	    </c:forEach>	    
	  </tbody>
	  </table>
	  </c:if>
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
    <script type="text/javascript">
      $("#findBy").click(function(e){
    	  e.preventDefault();
    	  window.location.href=this.href+"?customerId="+$("input[name=customerId]").val();    	  
      });
    </script>
  </body>
</html>