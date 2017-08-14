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
                        <h3 class="panel-title">查看项目</h3>
                        <h4>
                            <span data-toggle="modal" data-target="#myModal" style="float:right;color:#23B7E5">
                                <a href="javascript:void(0)"> 增加项目</a>
                            </span>
                        </h4>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <tr>
                                <td>编号</td>
                                <td>项目名称</td>
                                <td>项目说明</td>
                                <td>项目所属人</td>
                                <td>项目电话</td>
                                <td width="90px">项目创建时间</td>

                                <td >查看原材料</td>
                                <td >查看成品</td>
                                <td >操作</td>
                            </tr>
                            <c:forEach items="${projects }" var="items">
                                <tr>
                                    <td>${items.id}</td>
                                    <td>${items.projectName}</td>
                                    <td>${items.projectContent}</td>
                                    <td>${items.name}</td>
                                    <td>${items.tel}</td>
                                    <td>${items.createTime}</td>

                                    <td>
                                        <a href="<%=request.getContextPath()%>/controller/goods/viewMaterial.do?projectId=${items.id}">查看原材料</a>
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/controller/goods/viewProduct.do?projectId=${items.id}">查看成品</a>
                                    </td>
                                    <td>
                                        <a href="javascript:void(0)" onclick="deleteItem(${items.id})">
                                            <button type="button" class="btn btn-default btn-xs btn-danger">
                                                <span class="glyphicon glyphicon-trash"></span> 删除
                                            </button>
                                        </a>

                                        <a href="javascript:void(0)" data-toggle="modal" data-target="#myModal2" onclick="updateItem(${items.id})">
                                            <button type="button" class="btn btn-default btn-xs btn-default">
                                                <span class="glyphicon glyphicon-pencil"></span> 更新
                                            </button>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>

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
                            增加项目
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form id="form">
                            <input type="text" class="form-control" name="projectName" placeholder="项目名称"/>
                            <br>
                            <input type="text" class="form-control" name="projectContent" placeholder="项目说明"/>
                            <br>
                            <input type="text" class="form-control" name="name" placeholder="给谁做的项目"/>
                            <br>
                            <input type="text" class="form-control" name="tel" placeholder="项目的手机号"/>
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
    </div>

    <!-- 模态框（更新项目） -->
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel2">
                        增加项目
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="form2">
                        <input type="hidden" class="form-control" name="id" id="id"/>
                        <input type="hidden" class="form-control" name="createTime" id="createTime"/>
                        <input type="hidden" class="form-control" name="yn" id="yn"/>
                        <input type="text" class="form-control" name="projectName" id="projectName" placeholder="项目名称"/>
                        <br>
                        <input type="text" class="form-control" name="projectContent" id="projectContent" placeholder="项目说明"/>
                        <br>
                        <input type="text" class="form-control" name="name" id="name" placeholder="给谁做的项目"/>
                        <br>
                        <input type="text" class="form-control" name="tel" id="tel" placeholder="项目的手机号"/>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" id="update" class="btn btn-primary">
                        更新
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    </div>
    <!-- 全局js -->
    <script src="<%=request.getContextPath() %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=request.getContextPath()%>/js/sweetalert/sweetalert.min.js"></script>

    <script>
        $("#save").click(function(){
            var form = new FormData(document.getElementById("form"));
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath() %>/controller/goods/addProject.do",
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

        function deleteItem(id){
            swal({
                    title: "确认删除？",
                    text: "",
                    type: "warning",
                    showCancelButton: true,
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true,
                },
                function(){
                    $.ajax({
                        type:"post",
                        url:"<%=request.getContextPath() %>/controller/goods/deleteProject.do",
                        data:{"projectId":id},
                        dataType:"json",
                        success:function(data){
                            if(data==1){
                                swal("成功!", "", "success");
                                window.setTimeout("location.reload()",700);
                            }else{
                                swal("失败！", "请重试！", "error");
                            }
                        },
                        error:function(msg){
                            swal("失败！", "请重试！", "error");
                        }
                    })
                });
        }

        function updateItem(id) {
            $("#id").val(id);
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath() %>/controller/goods/getProjectOne.do",
                data:{"projectId":id},
                dataType:"json",
                success:function(data){
                    $("#projectName").val(data.projectName);
                    $("#projectContent").val(data.projectContent);
                    $("#name").val(data.name);
                    $("#tel").val(data.tel);
                    $("#yn").val(data.yn);
                    $("#createTime").val(data.createTime);

                },
                error:function(msg){
                    swal("失败！", "请重试！", "error");
                }
            })
        }

        $("#update").click(function(){
            var form = new FormData(document.getElementById("form2"));
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath() %>/controller/goods/updateProject.do",
                data:form,
                dataType:"json",
                processData:false,
                contentType:false,
                success:function(data){
                    if(data==1){
                        swal("成功!", "", "success");
                        window.setTimeout("location.reload()",700);
                    }else{
                        swal("失败！", "请重试！", "error");
                    }
                },
                error:function(msg){
                    swal("失败！", "请重试！", "error");
                }
            })
        })
    </script>
</body>
</html>
