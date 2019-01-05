<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link href="/static/assets/apps/pluags/treetable/themes/vsStyle/treeTable.min.css" rel="stylesheet" type="text/css" />
    <link href="/static/assets/apps/pluags/ztree/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
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
                    <!-- BEGIN SAMPLE TABLE PORTLET-->
                    <div class="portlet light bordered">
                        <div class="portlet-title">
                            <div class="caption">
                                <span class="caption-subject font-blue bold uppercase">商品分类列表</span>
                            </div>
                            <div class="actions">
                                    <i class="icon-cloud-upload"></i>
                                </a>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-scrollable">
                                <table id="treeTable" class="table table-striped table-hover table-bordered">
                                    <thead>
                                    <tr>
                                        <th> ID </th>
                                        <th> 名称 </th>
                                        <th> 状态 </th>
                                        <th> 排序 </th>
                                        <th> 更新时间 </th>
                                        <th> 操作 </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="itemCat" items="${list}">
                                        <tr id="${itemCat.id}" pId="${itemCat.parentId}">
                                            <td>${itemCat.id}</td>
                                            <td>${itemCat.name}</td>
                                            <td>${itemCat.status}</td>
                                            <td>${itemCat.sortOrder}</td>
                                            <td><fmt:formatDate value="${itemCat.updated}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
                                            <td>
                                                <a href="/item/cat/form?id=${itemCat.id}" class="btn default green-stripe"> 编辑 </a>&nbsp;&nbsp;
                                                <button class="btn default red-stripe mt-sweetalert"
                                                        data-title="确定删除当前数据项吗？"
                                                        data-type="warning"
                                                        data-show-confirm-button="true"
                                                        data-confirm-button-class="btn-danger"
                                                        data-show-cancel-button="true"
                                                        data-cancel-button-class="btn-default"
                                                        data-close-on-confirm="false"
                                                        data-close-on-cancel="false"
                                                        data-confirm-button-text="确定"
                                                        data-cancel-button-text="取消"
                                                        data-popup-title-success="已删除"
                                                        data-popup-title-cancel="已取消"
                                                        data-url="/item/cat/delete?id=${itemCat.id}">删除</button>&nbsp;&nbsp;
                                                <a href="/item/cat/form?parentId=${itemCat.id}" class="btn default purple-stripe"> 添加下级菜单 </a>&nbsp;&nbsp;
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- END SAMPLE TABLE PORTLET-->
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>
<script src="/static/assets/apps/modal/sweetalert.js" type="text/javascript"></script>
<script src="/static/assets/apps/pluags/treetable/jquery.treeTable.min.js" type="text/javascript"></script>
<%--<script src="/static/assets/apps/pluags/ztree/zTree_v3/js/jquery-1.4.4.min.js" type="text/javascript"></script>--%>
<%--<script src="/static/assets/apps/pluags/ztree/zTree_v3/js/jquery.ztree.all.min.js.js" type="text/javascript"></script>--%>
<%--<script src="/static/assets/apps/pluags/ztree/zTree_v3/js/jquery.ztree.core.min.js" type="text/javascript"></script>--%>
<%--<script src="/static/assets/apps/pluags/ztree/zTree_v3/js/jquery.ztree.excheck.min.js" type="text/javascript"></script>--%>
<%--<script src="/static/assets/apps/pluags/ztree/zTree_v3/js/jquery.ztree.exhide.min.jsn " type="text/javascript"></script>--%>
<script>
    $(function () {
        $("#treeTable").treeTable({
            "column": 1,
            "expandLevel": 1
        });
        var setting = {
            view:{
                //禁止多选
                selectedMulti: false,

                showIcon: false

            }
        }
    });
</script>
</body>
</html>