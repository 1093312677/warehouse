<%--
  Created by IntelliJ IDEA.
  User: kone
  Date: 2017-08-06
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title> 厂库管理</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=request.getContextPath()%>/js/sweetalert/sweetalert.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/sweetalert/sweetalert-dev.js"></script>
    <link href="<%=request.getContextPath() %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/animate.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">厂库管理</strong>
                                    </span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">厂库管理
                    </div>
                </li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">产品管理</span>
                </li>
                <li>
                    <a class="J_menuItem" href="https://www.baidu.com/">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa fa-bar-chart-o"></i>
                        <span class="nav-label">管理产品</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=request.getContextPath()%>/controller/goods/viewProject.do">查看项目</a>
                        </li>
                    </ul>
                </li>

                <!--
                <li>
                    <a href="#"><i class="fa fa-edit"></i> <span class="nav-label">表单</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="form_basic.html">基本表单</a>
                        </li>
                        <li><a class="J_menuItem" href="form_wizard.html">表单向导</a>
                        </li>
                        <li>
                            <a href="#">文件上传 <span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li><a class="J_menuItem" href="form_webuploader.html">百度WebUploader</a>
                                </li>
                                <li><a class="J_menuItem" href="form_file_upload.html">DropzoneJS</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="J_menuItem" href="layerdate.html">日期选择器layerDate</a>
                        </li>
                    </ul>
                </li>
                -->
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">帐号</span>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa fa-edit"></i>
                        <span class="nav-label">帐号管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="" href="javascript:void(0)" data-toggle="modal" data-target="#myModal">修改密码</a>
                        </li>
                        <li>
                            <a class="" href="<%=request.getContextPath()%>/controller/account/loginout.do">退出系统</a>
                        </li>
                    </ul>

                </li>
            </ul>
        </div>
    </nav>

    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                </div>

            </nav>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%" src="<%=request.getContextPath()%>/welcome.jsp" frameborder="0" data-id="index_v1.html" seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
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
                    修改密码
                </h4>
            </div>
            <div class="modal-body">
                <form id="form">
                    <input type="password" id="oldPassword" class="form-control" name="oldPassword" placeholder="旧密码"/>
                    <br>
                    <input type="password" id="newPassword" class="form-control" name="newPassword" placeholder="新密码"/>
                    <br>
                    <input type="password"id="newPasswordConfirm" class="form-control" name="newPasswordConfirm" placeholder="确认新密码"/>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" id="save" class="btn btn-primary">
                    修改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 全局js -->
<script src="<%=request.getContextPath() %>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=request.getContextPath() %>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=request.getContextPath() %>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=request.getContextPath() %>/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="<%=request.getContextPath() %>/js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/index.js"></script>

<!-- 第三方插件 -->
<script src="<%=request.getContextPath() %>/js/plugins/pace/pace.min.js"></script>

<script>
    $("#save").click(function(){
        var newPassword = $("#newPassword").val();
        var newPasswordConfirm = $("#newPasswordConfirm").val();
        if(newPasswordConfirm != newPassword) {
            swal("两次密码不一致！", "请重试！", "info");
            return false;
        }
        var form = new FormData(document.getElementById("form"));
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath() %>/controller/account/changePW.do",
            data:form,
            dataType:"json",
            processData:false,
            contentType:false,
            success:function(data){
                if(data==1){
                    swal("成功!", "", "success");
                    window.setTimeout("location.reload()",700);
                }else{
                    swal("原始密码不正确！", "请重试！", "error");
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
