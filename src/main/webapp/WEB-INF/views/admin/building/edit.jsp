<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/09/2024
  Time: 1:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Thêm Tòa Nhà</title>
</head>
<body>
<div class="main-content" id="main-container">

    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">


                <div class="page-header">
                    <h1>
                        Danh Sách Tòa Nhà
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>
                </div><!-- /.page-header -->

                <div class = "row">
                    <div class ="col-xs-12">

                    </div>
                </div>

                <!-- Bảng Danh Sách -->
                <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                    <form:form modelAttribute="buildingEdit" id="listForm" method="GET">
                        <div class ="col-xs-12">
                            <form class="form-horizontal" role = "form">
                                <di class="form-group">
                                    <label class="col-sm-3">Tên Tòa Nhà</label>
                                    <div class="col-sm-9">
                                        <form:input class="form-control" path="name" />
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class = "col-sm-3"> Quận </label>
                                    <div class="col-sm-2">
<%--                                        <label class = "name"> Quận </label>--%>
                                        <form:select class ="form-control" path="district">
                                            <form:option value="">Chọn Quận</form:option>
                                            <form:options items="${districts}"></form:options>
                                        </form:select>
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Phường</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="ward" id="ward" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Đường</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="street" id="street" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Kết Cấu</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="structure" id="structure" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Số Tầng Hầm</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="numberofbasement" id="numberofbasement" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Diện Tích Sàn</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="floorarea" id="floorarea" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Hướng</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="direction" id="direction" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Hạng</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="level" id="level" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Diện Tích Thuê</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="rentarea" id="rentarea" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Giá Thuê</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="rentprice" id="rentprice" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Mô Tả Giá</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="rentpricedescription" id="rentpricedescription" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Phí Dịch Vụ</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="servicefee" id="servicefee" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Phí Ô Tô</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="carfee" id="carfee" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Phi Mô Tô</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="motorbikefee" id="motorbikefee" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Phí Ngoài Giờ</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="overtimefee" id="overtimefee" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Tiền Điện</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="electricityfee" id="electricityfee" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Đặt Cọc</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="deposit" id="deposit" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Thanh Toán</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="payment" id="payment" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Thời Hạn Thuê</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="renttime" id="renttime" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Thời Gian Trang Trí</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="decorationtime" id="decorationtime" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Tên Quản Lý</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="managername" id="managername" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">SĐT Quản Lý</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="managerphonenumber" id="managerphonenumber" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Phí Môi Giới</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="number" name="brokeragefee" id="brokeragefee" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Loại Tòa Nhà</label>
                                    <div class="col-sm-9">
                                        <form:checkboxes path="buildingtypecode" items="${typeCodes}" />
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3">Ghi Chú</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" name="note" id="note" value="">
                                    </div>
                                </di>
                                <di class="form-group">
                                    <label class="col-sm-3"></label>
                                    <div class="col-sm-9">
                                        <c:if test="${not empty buildingEdit.id}">
                                        <button class="btn btn-primary" id = "btnAddOrUpdateBuilding">Cập Nhật Tòa Nhà</button>
                                        <button class="btn btn-primary" id="btnCancel" >Hủy Thao Tác</button>
                                        </c:if>
                                        <c:if test="${empty buildingEdit.id}">
                                            <button class="btn btn-primary" id = "btnAddOrUpdateBuilding" >Thêm Mới</button>
                                            <button class="btn btn-primary" id="btnCancel" >Hủy Thao Tác</button>
                                        </c:if>
                                    </div>
                                </di>
                                <form:hidden path="id" id="buildingId" />
                            </form>
                        </div>
                    </form:form>
                </div>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
</div><!-- /.main-container -->

<script>
    $('#btnAddOrUpdateBuilding').click(function(e)
    {
        var data = {} ;
        var typeCode = [] ;
        var formData = $('#listForm').serializeArray() ;
        $.each(formData, function(i, v)
        {
            if(v.name != 'buildingtypecode')
            {
                data["" + v.name + ""] = v.value ;
            }
            else
            {
                typeCode.push(v.value) ;
            }
        });
        data['buildingtypecode'] = typeCode ;
        if(typeCode.length > 0) {
            addOrUpdateBuilding(data) ;
        }
        else
        {
            e.preventDefault();
            window.location.href = "/admin/building-edit?typeCode=required" ;
        }
    });
    function addOrUpdateBuilding(data)
    {
        $.ajax({
            type: "POST",
            url: "/api/building",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "JSON",
            success: function(respond)
            {
                console.log("success") ;
            },
            error: function(respind)
            {
                console.log("fail") ;
                console.log("respond") ;
            }
        }) ;
    }
    $('#btnCancel').click(function(e)
    {
        e.preventDefault();
        window.location.href = "/admin/building-list" ;
    });


</script>

</body>
</html>
