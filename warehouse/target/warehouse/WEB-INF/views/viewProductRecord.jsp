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
    <script src="<%=request.getContextPath()%>/js/sweetalert/sweetalert-dev.js"></script>

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
                        <h3 class="panel-title">查看成品入库记录</h3>
                        <br>
                        <form action="<%=request.getContextPath() %>/controller/goods/viewProductRecord.do" method="post">
                            <input type="hidden" name="productId" value="${productId}"/>
                            <div class="row">
                                <div class="col-sm-3">
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">开始时间</span>
                                        <input type="date" class="form-control" name="startTime" value="${startTime}">
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="input-group input-group-sm">
                                        <span class="input-group-addon">结束时间</span>
                                        <input type="date" class="form-control" name="endTime" value="${endTime}">
                                    </div>
                                </div>

                                <div class="col-sm-3">
                                    <input type="submit" class="btn btn-default" value="查找"/>
                                </div>
                            </div>


                        </form>
                        <p>总共数量：${sum}</p>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td>编号</td>
                                <td>入库数量</td>
                                <td>使用材料</td>
                                <td>入库时间</td>
                                <td>备注</td>
                            </tr>
                            <c:forEach items="${pagination.data }" var="items">
                                <tr>
                                    <td>${items.id}</td>
                                    <td>${items.inNum}</td>
                                    <td>
                                        <c:forEach items="${items.productRecordMaterialList}" var="prm">
                                            ${prm.material.materialName}(${prm.number}KG)
                                            <br>
                                        </c:forEach>
                                    </td>
                                    <td>${items.time}</td>
                                    <td>${items.remark}</td>
                                </tr>
                            </c:forEach>
                        </table>

                        <ul class="pagination" style="margin-left:15px;">
                            <c:if test="${pagination.currentPage gt 1 }">
                                <li><a href="<%=request.getContextPath() %>/controller/goods/viewProductRecord.do?startTime=${startTime}&endTime=${endTime}&productId=${productId}&num=${pagination.currentPage-1}">&laquo;</a></li>
                            </c:if>
                            <c:if test="${pagination.currentPage eq 1 }">
                                <li class="disabled"><a href="#">&laquo;</a></li>
                            </c:if>
                            <c:set var="pageNum" value="${(pagination.total%pagination.pageSize == 0) ? (pagination.total/pagination.pageSize) :  ((pagination.total/pagination.pageSize)  + 1 ) }"></c:set>
                            <c:set var="start" value="${ (pagination.currentPage -3) < 0 ?0 :(pagination.currentPage -3)  }"></c:set>
                            <c:set var="end" value="${  pagination.currentPage + 3 }"></c:set>
                            <c:choose>
                                <c:when test="${end gt start }">
                                    <c:forEach var="i" begin="${start}" end="${end}">
                                        <c:if test="${i >0 && i<= pageNum}">
                                            <c:if test="${i ==  pagination.currentPage}"  >
                                                <li class="active"><a href="javascript:void(0)">${pagination.currentPage }</a></li>
                                            </c:if>
                                            <c:if test="${i != pagination.currentPage}"  >
                                                <li><a href="<%=request.getContextPath() %>/controller/goods/viewProductRecord.do?startTime=${startTime}&endTime=${endTime}&productId=${productId}&num=${i}">${i}</a></li>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <li class="active"><a href="javascript:void(0)">${pagination.currentPage }</a></li>
                                </c:otherwise>
                            </c:choose>

                                <c:if test="${pagination.currentPage lt pagination.total/pagination.pageSize }">
                                <li><a href="<%=request.getContextPath() %>/controller/goods/viewProductRecord.do?startTime=${startTime}&endTime=${endTime}&productId=${productId}&num=${pagination.currentPage+1}">&raquo;</a></li>
                            </c:if>
                            <c:if test="${pagination.currentPage ge pagination.total/pagination.pageSize }">
                                <li class="disabled"><a href="#">&raquo;</a></li>
                            </c:if>
                        </ul>
                        <p style="padding-top:15px;margin-left:15px;">共 ${pagination.total } 条记录</p>

                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- 全局js -->
    <script src="<%=request.getContextPath() %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js?v=3.3.6"></script>

    <script>
        $("#save").click(function(){
            var form = new FormData(document.getElementById("form"));
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath() %>/controller/goods/addMaterial.do",
                data:form,
                dataType:"json",
                processData:false,
                contentType:false,
                success:function(data){
                    if(data==1){
                        swal("提交成功!", "", "success");
                        window.setTimeout("location.reload()",700);
                    }else{
                        swal("提交失败！", "请重试！", "error");
                    }
                },
                error:function(msg){
                    swal("提交失败！", "请重试！", "error");
                }
            })
        })

    </script>
</body>
</html>
