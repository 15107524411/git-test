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
    <title>我的商城 | 商品分类管理</title>
    <%@ include file="../../includes/head.jsp" %>



</head>
<!-- END HEAD -->

<body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo">
<%@ include file="../../includes/header.jsp" %>

<div class="page-container">
    <%@ include file="../../includes/menu.jsp" %>

    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-head">
                <div class="page-title">
                    <h1>商品分类管理</h1>
                </div>
            </div>

            <ul class="page-breadcrumb breadcrumb"></ul>

            <sys:message />

            <div class="row">
                <div class="col-md-12">
                    <div class="portlet light bordered">
                        <div class="portlet-title">
                            <div class="caption">
                                <span class="caption-subject font-blue bold uppercase">${itemCat.id == null ? '新增' : '编辑'}商品分类</span>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                            <form id="inputForm" action="/item/cat/save" method="post" class="form-horizontal">
                                <input type="hidden" name="id" value="${itemCat.id}" />
                                <input type="hidden" name="status" value="${itemCat.status}" />

                                <div class="form-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">父级分类</label>
                                                <div class="col-md-9">
                                                    <input id="parentId" name="parentId" value="${itemCat.parentId}" type="hidden" />
                                                    <input id="parentName" type="text" class="form-control" placeholder="父级分类" data-toggle="modal" href="#treeModal" value="${itemCat.parentName}" readonly style="cursor: pointer;" />
                                                    <span class="help-block"> 如果是根目录，请留空 </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">名称</label>
                                                <div class="col-md-9">
                                                    <input name="name" type="text" class="form-control required" placeholder="名称" value="${itemCat.name}" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="control-label col-md-3">排序</label>
                                                <div class="col-md-9">
                                                    <input name="sortOrder" type="text" class="form-control required digits" placeholder="排序" value="${itemCat.sortOrder}" />
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

<%@ include file="../../includes/footer.jsp" %>
<script src="/static/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-validation/js/localization/messages_zh.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
<script src="https://cdn.bootcss.com/zTree.v3/3.5.33/js/jquery.ztree.core.min.js" type="text/javascript"></script>
<script src="/static/assets/apps/modal/validation.js" type="text/javascript"></script>
<script src="/static/assets/apps/modal/ztree.js" type="text/javascript"></script>
<script>
    $(function () {
        ZTree.initZTree("/item/cat/tree", function (event, treeId, treeNode, clickFlag) {
            $("#parentId").val(treeNode.id);
            $("#parentName").val(treeNode.name);
        });
    });
</script>
</body>
</html>