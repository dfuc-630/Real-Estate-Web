<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/09/2024
  Time: 12:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Danh Sách Tòa Nhà</title>
</head>
<body>
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
                    <div class="col-xs-12 col-sm-12 widget-container-col ui-sortable">
                        <div class="widget-box">
                            <div class="widget-header">
                                <h5 class="widget-title">Tìm Kiếm</h5>

                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>

                            <div class="widget-body" style="font-family: 'Times New Roman', Times, serif;">
                                <div class="widget-main" >
                                    <form:form id="listForm" modelAttribute="modelSearch" action="/admin/building-list" method="GET">
                                        <div class = "row">
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-6">
                                                        <label class = "name"> Tên Tòa Nhà </label>
<%--                                                        <input type="text" class ="form-control" name="name" value="">--%>
                                                        <form:input class="form-control" path="name"/>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <label class = "name"> Diện Tích Sàn </label>
<%--                                                        <input type="number" class ="form-control" name="floorarea" value="">--%>
                                                        <form:input class="form-control" path="floorarea"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-2">
                                                        <label class = "name"> Quận </label>
                                                        <form:select class ="form-control" path="district">
                                                            <form:option value="">Chọn Quận</form:option>
                                                            <form:options items="${districts}"></form:options>
                                                        </form:select>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label class = "name"> Phường </label>
<%--                                                        <input type="text" class ="form-control" name="ward" value="">--%>
                                                        <form:input class="form-control" path="ward"/>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label class = "name"> Đường </label>
<%--                                                        <input type="text" class ="form-control" name="street" value="">--%>
                                                        <form:input class="form-control" path="street"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-4">
                                                        <label class = "name"> Số Tầng Hầm </label>
<%--                                                        <input type="number" class ="form-control" name="numberofbasement" value="">--%>
                                                        <form:input class="form-control" path="numberofbasement"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label class = "name"> Hướng </label>
<%--                                                        <input type="text" class ="form-control" name="direction" value="">--%>
                                                        <form:input class="form-control" path="direction"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <label class = "name"> Hạng </label>
<%--                                                        <input type="number" class ="form-control" name="level" value="">--%>
                                                        <form:input class="form-control" path="level"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-3">
                                                        <label class = "name"> Diện Tích Từ </label>
<%--                                                        <input type="number" class ="form-control" name="areamin" value="">--%>
                                                        <form:input class="form-control" path="areamin"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label class = "name"> Diện Tích Đến </label>
<%--                                                        <input type="number" class ="form-control" name="areamax" value="">--%>
                                                        <form:input class="form-control" path="areamax"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label class = "name"> Giá Thuê Từ </label>
<%--                                                        <input type="number" class ="form-control" name="rentpricemin" value="">--%>
                                                        <form:input class="form-control" path="rentpricemin"/>
                                                    </div>
                                                    <div class="col-xs-3">
                                                        <label class = "name"> Giá Thuê Đến </label>
<%--                                                        <input type="number" class ="form-control" name="rentpricemax" value="">--%>
                                                        <form:input class="form-control" path="rentpricemax"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class="col-xs-5">
                                                        <label class = "name"> Tên Quản Lý </label>
<%--                                                        <input type="text" class ="form-control" name="managername" value="">--%>
                                                        <form:input class="form-control" path="managername"/>
                                                    </div>
                                                    <div class="col-xs-5">
                                                        <label class = "name"> Điện Thoại Quản Lý </label>
<%--                                                        <input type="text" class ="form-control" name="managerphonenumber" value="">--%>
                                                        <form:input class="form-control" path="managerphone"/>
                                                    </div>
                                                    <div class="col-xs-2">
                                                        <label class = "name"> Chọn Nhân Viên Phụ Trách </label>
                                                        <form:select class ="form-control" path="staffid">
                                                            <form:option value="">Chọn Nhân Viên</form:option>
                                                            <form:options items="${listStaffs}"/>

                                                        </form:select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-xs-12">
                                                    <div class ="col-xs-6">
                                                        <form:checkboxes path="buildingtypecode" items="${typeCodes}" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class = "col-xs-12">
                                                <div class="col-xs-6">
                                                    <button type="button" class="btn btn-xs btn-danger" id ="btnSearchBuilding">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"></path>
                                                        </svg>
                                                        Tìm Kiếm
                                                    </button>

                                                </div>
                                            </div>

                                    </form:form>

                                </div>

                            </div>
                </div>
                            <div class = "pull-right">
                            <a href="/admin/building-edit">
                                <button class = "btn btn-info" title="Thêm Tòa Nhà">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-add" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                        <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    </svg>
                                </button>
                            </a>

                            <button class = "btn btn-danger" title="Xóa Tòa Nhà" id="btnDeleteBuilding">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </div>

                <!-- Bảng Danh Sách -->
                <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                    <div class="col-xs-12" >
                        <table id="tableList" style="margin: 3em 0 1.5cm;" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" name="checkList" value="" class="ace">
                                        <span class="lbl"></span>
                                    </label>
                                </th>
                                <th>Tên Tòa Nhà</th>
                                <th>Địa Chỉ</th>
                                <th>Số Tầng Hầm</th>
                                <th>Tên Quản Lý</th>
                                <th>Số Điện Thoại</th>
                                <th>D.T Sàn</th>
                                <th>D.T Trống</th>
                                <th>D.T Thuê</th>
                                <th>Giá Thuê</th>
                                <th>Phí Môi Giới</th>
                                <th>Phí Dịch Vụ</th>
                                <th>Thao Tác</th>

                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="item" items="${buildingList}">
                                <tr>
                                    <td class="center">
                                        <label class="pos-rel">
                                            <input type="checkbox" class="ace" value="${item.id}" >
                                            <span class="lbl"></span>
                                        </label>
                                    </td>

                                    <td>
                                            ${item.name}
                                    </td>
                                    <td>${item.address}</td>
                                    <td>${item.numberofbasement}</td>
                                    <td>${item.managername}</td>
                                    <td>${item.managerphone}</td>
                                    <td>${item.floorarea}</td>
                                    <td>${item.emptyarea}</td>
                                    <td>${item.rentarea}</td>

                                    <td>${item.rentprice}</td>
                                    <td>${item.brokeragefee}</td>
                                    <td>${item.servicefee}</td>

                                    <td>
                                        <div class=" btn-group">
                                            <button class="btn btn-xs btn-success" title="Giao Tòa Nhà" onclick ="assignmentBuilding(${item.id})">
                                                <i class="ace-icon glyphicon glyphicon-list"></i>
                                            </button>

                                            <a class="btn btn-xs btn-info" title="Sửa Tòa Nhà" href ="/admin/building-edit-${item.id}">
                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                            </a>

                                            <button class="btn btn-xs btn-danger" title="Xóa Tòa Nhà" onclick="deleteBuilding(${item.id})">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                            </button>

                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>

                            

                            </tbody>
                        </table>
                    </div><!-- /.span -->
                </div>
                        </div> </div> </div>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->


    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
<!-- Modal -->
                <div class="modal fade" id="assignmentBuildingModal" role="dialog" style="font-family: 'Times New Roman', Times, serif;">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Danh Sách Nhân Viên</h4>
                            </div>
                            <div class="modal-body">
                                <table id = "staffList" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th class="center"> Chọn </th>
                                        <th class="center">Tên Nhân Viên</th>
                                    </tr>
                                    </thead>

                                    <tbody>


                                    </tbody>
                                </table>
                                <input type = "hidden" id = "buildingId" name = "buildingId" value = "">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" id = "btnAssignmentBuilding">Giao Tòa Nhà</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                            </div>
                        </div>

                    </div>
                </div>
                <script>
                    function assignmentBuilding(buildingId)
                    {
                        $('#assignmentBuildingModal').modal() ;
                        loadStaff(buildingId) ;
                        $('#buildingId').val(buildingId) ;

                    }

                    function loadStaff(buildingId)
                    {
                        $.ajax({
                            type: "GET",
                            url: "/api/building/" + buildingId + '/staffs',
                            // data: JSON.stringify(data),
                            // contentType: "application/json",
                            dataType: "JSON",
                            success: function(response)
                            {
                                var row = '' ;
                                $.each(response.data, function(index, item){
                                    row += '<tr>' ;
                                    row += '<td class="text-center"><input type="checkbox" value=' + item.staffId + ' id="checkbox_' + item.staffid + '" class = "check-box-element"' + item.checked + '/></td>' ;
                                    row += '<td class="text-center">' + item.fullName + '</td>' ;
                                    row += '</tr>';
                                });
                                $('#staffList tbody').html(row) ;
                                console.log("success") ;
                            },
                            error: function(response)
                            {
                                console.log("fail") ;
                                window.location.href = "/admin/building-list?message=error" ;
                                console.log(response) ;
                            }
                        }) ;
                    }

                    $('#btnAssignmentBuilding').click(function(e){
                        e.preventDefault() ;
                        var data = {} ;
                        data['buildingId'] = $('#buildingId').val() ;
                        var staffs = $('#staffList').find('tbody input[type = checkbox]:checked').map(function(){
                            return $(this).val();
                        }).get();
                        data['staffs'] = staffs;
                        if(data['staffs'] != '')
                        {
                            assignment(data) ;
                        }
                        console.log("OK") ;
                    });
                    function assignment(data)
                    {
                        $.ajax({
                            type: "POST",
                            url: "/api/building/" + 'assignment',
                            data: JSON.stringify(data),
                            contentType: "application/json",
                            dataType: "JSON",
                            success: function(response)
                            {
                                console.log("success") ;
                            },
                            error: function(response)
                            {
                                console.info("Giao Khong Thanh Cong") ;
                                window.location.href = "/admin/building-list?message=errorAssignment" ;
                                console.log(response) ;
                            }
                        }) ;
                    }
                    $('#btnSearchBuilding').click(function(e){
                        e.preventDefault() ;
                        $('#listForm').submit() ;
                    });

                    function deleteBuilding(data)
                    {
                        var buildingId = [data] ;
                        deleteBuildings(buildingId) ;
                    }
                    $('#btnDeleteBuilding').click(function(e){
                        e.preventDefault() ;
                        var buildingIds = $('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
                            return $(this).val();
                        }).get();
                        deleteBuildings(buildingIds) ;

                    });
                    function deleteBuildings(data)
                    {
                        $.ajax({
                            type: "Delete",
                            url: "/api/building/" + data,
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
                </script>
</body>
</html>
