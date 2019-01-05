<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<!--[if IE 8]> <html class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <title>我的商城 | 商品管理</title>
    <%@ include file="../includes/head.jsp" %>
</head>
<!-- END HEAD -->

<body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo">
<%@ include file="../includes/header.jsp" %>
<link href="/static/assets/global/plugins/dropzone/dropzone.min.css" rel="stylesheet" type="text/css" />
<link href="/static/assets/global/plugins/dropzone/basic.min.css" rel="stylesheet" type="text/css" />
<link href="https://cdn.bootcss.com/zTree.v3/3.5.32/css/metroStyle/metroStyle.min.css" rel="stylesheet" />
<link href="https://cdn.bootcss.com/wangEditor/10.0.13/wangEditor.min.css" rel="stylesheet">

<div class="page-container">
    <%@ include file="../includes/menu.jsp" %>

    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-head">
                <div class="page-title">
                    <sys:message />
                    <h1>商品管理</h1>
                </div>
            </div>

            <ul class="page-breadcrumb breadcrumb"></ul>

            <div class="row">
                <div class="col-md-12">
                    <div class="portlet light bordered">
                        <div class="portlet-title">
                            <div class="caption">
                                <span class="caption-subject font-blue bold uppercase">${item.id == null ? '新增' : '编辑'}用户</span>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form id="inputForm" action="/item/save" method="post" class="form-horizontal">
                                <input type="hidden" name="id" value="${item.id}" />

                                <div class="form-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">所属分类</label>
                                                <div class="col-md-9">
                                                    <input id="cid" name="cid" value="${item.cid}" type="hidden" />
                                                    <input id="cname" type="text" class="form-control required" placeholder="所属分类" data-toggle="modal" href="#treeModal" value="${item.cname}" readonly style="cursor: pointer;" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">标题</label>
                                                <div class="col-md-9">
                                                    <input name="title" type="text" class="form-control required " placeholder="标题" value="${item.title}">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">卖点</label>
                                                <div class="col-md-9">
                                                    <input name="sellPoint" type="text" class="form-control required " placeholder="卖点" value="${item.sellPoint}">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">价格</label>
                                                <div class="col-md-9">
                                                    <input name="price"  class="form-control required" value="${item.price}" placeholder="价格">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label col-md-3">库存</label>
                                            <div class="col-md-9">
                                                <input name="num" type="text" class="form-control required digits" placeholder="库存" value="${item.num}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label col-md-3">条形码</label>
                                            <div class="col-md-9">
                                                <input name="barcode" type="text" class="form-control" placeholder="条形码" value="${item.barcode}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label col-md-3">图片</label>
                                            <div class="col-md-9">
                                                <input id="image" name="image" type="text" class="form-control" placeholder="图片" value="${item.image}">
                                                <div  class="dropzone dropzone-file-area" id="my-dropzone" >
                                                    <h3 class="sbold">点击这里上传文件或拖拽上传</h3>
                                                    <p>文件上传</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label col-md-3">状态</label>
                                            <div class="col-md-9">
                                                <input name="status" type="text" class="form-control required" placeholder="状态" value="${item.status}">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-9">
                                        <div class="form-group">
                                            <label class="control-label col-md-2">详情</label>
                                            <div class="col-md-10">
                                                <input type="hidden" id="itemDesc" name="itemDesc.itemDesc" />
                                                <div id="editor">
                                                    ${item.itemDesc.itemDesc}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-actions">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="row">
                                                <div class="col-md-offset-3 col-md-9">
                                                    <button type="submit" class="btn blue">提交</button>
                                                    <button type="button" class="btn default" onclick="history.go(-1);">返回</button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6"> </div>
                                    </div>
                                </div>
                            </form>
                            <!-- END FORM-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../includes/footer.jsp" %>
<script src="/static/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-validation/js/localization/messages_zh.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/dropzone/dropzone.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/zTree.v3/3.5.33/js/jquery.ztree.core.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/wangEditor/3.1.1/wangEditor.min.js"></script>
<script src="/static/assets/apps/modal/validation.js" type="text/javascript"></script>
<script src="/static/assets/apps/modal/ztree.js" type="text/javascript"></script>
<script src="/static/assets/apps/modal/wangeditor.js" type="text/javascript"></script>
<script>
    $(function () {
        ZTree.initzTRee("/item/cat/tree", function (event, treeId, treeNode, clickFlag) {
            $("#cid").val(treeNode.id);
            $("#cname").val(treeNode.name);

        });
        wangEditor.initWangEditor("editor","itemDesc");
    });

    Dropzone.options.myDropzone = {
        url: "/upload",
        dictDefaultMessage: "",
        paramName: "imgfile",
        autoProcessQueue:true,//自动上传
        maxFilesize: 2,
        init: function() {
            this.on("success", function (file, data) {
                $("#image").val(data.filePath);
                console.log(data.filePath);
            });
        }
    };

</script>
</body>
</html>