<%--
  Created by IntelliJ IDEA.
  User: kone
  Date: 2017-08-06
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link href="<%=request.getContextPath()%>/js/sweetalert/sweetalert.css" rel="stylesheet">

    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/animate.css" rel="stylesheet">
</head>
<body style="background-color: #F8F8F8">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12" style="margin-top:10px;">
                <!-- TABLE HOVER -->
                <div class="panel">
                    <div class="panel-heading">
                        <h3 class="panel-title"></h3>
                    </div>
                    <div class="panel-body">
                        欢迎！
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 全局js -->
    <script src="<%=request.getContextPath() %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=request.getContextPath()%>/js/sweetalert/sweetalert.min.js"></script>

</body>
</html>
