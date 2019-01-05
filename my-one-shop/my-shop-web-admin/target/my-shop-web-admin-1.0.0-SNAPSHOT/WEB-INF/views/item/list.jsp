<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<!--[if IE 8]> <html class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
    <title>我的商城 | 购物车管理</title>
    <%@ include file="../includes/head.jsp" %>
    <link href="/static/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
    <link href="/static/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />

</head>
<!-- END HEAD -->

<body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo">
<%@ include file="../includes/header.jsp" %>

<div class="page-container">
    <%@ include file="../includes/menu.jsp" %>

    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-head">
                <div class="page-title">
                    <h1>商品管理</h1>
                </div>
            </div>
            <sys:message />

            <div class="row search-area" style="display: none;">
            </div>

             <div class="row">
            <div class="col-md-12">
                <!-- BEGIN SAMPLE TABLE PORTLET-->
                <div class="portlet light bordered">
                    <div class="portlet-title">
                        <div class="caption">
                            <span class="caption-subject font-blue bold uppercase">商品列表</span>
                        </div>
                        <div class="actions">
                            <a class="btn btn-circle btn-icon-only btn-default" href="javascript:;" title="搜索" onclick="$('.search-area').toggle('fast');">
                                <i class="icon-magnifier"></i>
                            </a>
                            <a class="btn btn-circle btn-icon-only btn-default" href="/item/form" title="新增">
                                <i class="icon-cloud-upload"></i>
                            </a>
                        </div>
                    </div>
                    <div class="portlet-body">
                        <table id="dataTable" class="table table-striped table-hover table-bordered">
                            <thead>
                            <tr>
                                <th>所属分类</th>
                                <th> 标题 </th>
                                <th> 卖点 </th>
                                <th> 价格 </th>
                                <th> 库存 </th>
                                <th> 更新时间 </th>
                                <th > 操作 </th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- END SAMPLE TABLE PORTLET-->
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp" %>
<script src="/static/assets/global/scripts/datatable.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
<script src="/static/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
<script src="/static/assets/apps/modal/datatables.js" type="text/javascript"></script>
<script src="/static/assets/apps/modal/dateutils.js" type="text/javascript"></script>
<script src="/static/assets/apps/modal/sweetalert.js" type="text/javascript"></script>


<script>
    var _grid;
    $(function () {
        _grid = DataTables.initDataTable("/item/page", [
            {"data":"cname"},
            {"data": "title"},
            {"data": "sellPoint"},
            {"data": "price"},
            {"data": "num"},
            {
                "data": function (row, type, set, meta) {
                    return DateUtils.format(row.updated, 'yyyy-MM-dd HH:mm:ss');
                }
            },
            {
                "data": function (row, type, set, meta) {
                    return'<a href="/item/form?id=' + row.id + '" class="btn default green-stripe"> 编辑 </a>&nbsp;&nbsp;' +
                       ' <button  class="btn default red-stripe mt-sweetalert" ' +
                     ' data-title="你确定要删除此项数据么?" \n' +
                     ' data-type="info" \n' +
                     ' data-show-confirm-button="true" \n' +
                     ' data-confirm-button-class="btn-success" \n'+
                     ' data-show-cancel-button="true" \n'+
                     ' data-cancel-button-class="btn-default" \n' +
                     ' data-close-on-confirm="false" \n' +
                     ' data-close-on-cancel="false" \n' +
                     ' data-confirm-button-text="确定" \n' +
                     ' data-cancel-button-text="取消" \n'+
                     ' data-popup-title-success="已删除" \n' +
                     ' data-popup-title-cancel="已取消" \n' +
                     ' data-url="/item/delete?id='+row.id+'" \n' +
                     '   >删除</button>';

                }
            }
        ]);


    });
    function search() {
        // 清理传递的参数
        _grid.clearAjaxParams();

        var username = $("#username").val();
        var phone = $("#phone").val();
        var email = $("#email").val();

        if (username.length != 0) {
            _grid.setAjaxParam("username", username);
        }

        if (phone.length != 0) {
            _grid.setAjaxParam("phone", phone);
        }

        if (email.length != 0) {
            _grid.setAjaxParam("email", email);
        }

        // 重新加载 Ajax 数据

        _grid.getDataTable().ajax.reload();


    }


</script>
</body>
</html>