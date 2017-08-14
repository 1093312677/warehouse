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
                        <h3 class="panel-title">查看成品</h3>
                        <h4>
                            <span data-toggle="modal" data-target="#myModal" style="float:right;color:#23B7E5">
                                <a href="javascript:void(0)"> 增加成品类型</a>
                            </span>
                        </h4>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td>编号</td>
                                <td>成品名称</td>
                                <td>数量</td>
                                <td>查看</td>
                                <td>出库</td>
                            </tr>
                            <c:forEach items="${products }" var="items">
                                <tr>
                                    <td>${items.id}</td>
                                    <td>${items.productName}</td>
                                    <td>${items.number}</td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/controller/goods/viewProductRecord.do?productId=${items.id}">查看记录</a>
                                    </td>
                                    <td>
                                        <a href="javascript:void(0)" data-toggle="modal" data-target="#myModal2" onclick="addWare(${items.id})" >增加成品</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        增加成品类型
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="form">
                        <input type="hidden" value="${projectId}" name="projectId"/>
                        <input type="text" class="form-control" name="productName" placeholder="成品名称"/>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="save" class="btn btn-primary">
                        保存
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>


    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel1">
                        增加成品
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="form2">
                        <input type="hidden" value="" id="productId" name="productId"/>
                        <input type="number" class="form-control" name="inNum" placeholder="成品数量"/>
                        <br>
                        <input type="text" class="form-control" name="remark" placeholder="备注"/>
                        <br>
                        <div class="row" id="contar">
                            <div class="col-sm-6">
                                <div class="input-group">
                                    <span class="input-group-addon">选择材料</span>
                                    <select name="materialName" class="form-control" >
                                        <option>1</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="input-group">
                                    <span class="input-group-addon">使用的材料质量</span>
                                    <input type="number" class="form-control" name="materialNum" value="0" placeholder="使用的材料质量"/>
                                    <span class="input-group-addon">KG</span>
                                </div>
                            </div>
                            <br>
                            <br>
                        </div>
                        <br>
                        <button type="button" class="btn btn-default" id="addMater">增加材料</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="add" class="btn btn-primary">
                        入库
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <!-- 全局js -->
    <script src="<%=request.getContextPath() %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js?v=3.3.6"></script>

    <script>
        $("#save").click(function(){
            var form = new FormData(document.getElementById("form"));
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath() %>/controller/goods/addProduct.do",
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

        var content = "";

        function addWare(id) {
            $("#productId").val(id);
            var projectId = ${projectId}
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath() %>/controller/goods/selectMaterial.do",
                data:{"projectId":projectId},
                dataType:"json",
                success:function(data){
                   content = '<div class="col-sm-6">'
                       +'<div class="input-group">'
                       +'<span class="input-group-addon">选择材料</span>'
                       +'<select name="materialName" class="form-control" >'
                       +'<option value="0">--选择材料--</option>';
                   for(var i=0;i<data.length;i++) {
                       content += '<option value='+data[i].id+'>'+data[i].materialName+'</option>';
                   }
                   content += '</select>'
                       +'</div>'
                       +'</div>'
                       +'<div class="col-sm-6">'
                       +'<div class="input-group">'
                       +'<span class="input-group-addon">使用的材料质量</span>'
                       +'<input type="number" class="form-control" name="materialNum" value="0" placeholder="使用的材料质量"/>'
                       +'<span class="input-group-addon">KG</span>'
                       +'</div>'
                       +'</div>'
                       +'<br><br>';
                   $("#contar").html(content);
                },
                error:function(msg){
                }
            })
        }
        $("#add").click(function(){
            var form = new FormData(document.getElementById("form2"));
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath() %>/controller/goods/addProductRecord.do",
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

        $("#addMater").click(function(){
            $("#contar").append(content);
//            $("#contar").append('<div class="col-sm-6">'
//                +'<div class="input-group">'
//                    +'<span class="input-group-addon">选择材料</span>'
//                    +'<select name="materialName" class="form-control" >'
//                    +'<option>1</option>'
//                    +'</select>'
//                +'</div>'
//                +'</div>'
//                    +'<div class="col-sm-6">'
//                        +'<div class="input-group">'
//                        +'<span class="input-group-addon">使用的材料质量</span>'
//                        +'<input type="number" class="form-control" name="materialNum" value="0" placeholder="使用的材料质量"/>'
//                        +'<span class="input-group-addon">KG</span>'
//                +'</div>'
//                +'</div>'
//                +'<br><br>');
        })
    </script>
</body>
</html>
