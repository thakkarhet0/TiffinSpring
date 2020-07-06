<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<div class="wrapper">

		<jsp:include page="AdminHeader.jsp"></jsp:include>
		<jsp:include page="AdminSideMenu.jsp"></jsp:include>

		<div class="content-wrapper" style="min-height: 324px;">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Role</h1>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->






			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<!-- Small boxes (Stat box) -->
					<!-- Main row -->
					<div class="row">
						<div class="col-sm-6">


							<!-- ---dynamic  -->


							<div class="card card-info">
								<div class="card-header">
									<h3 class="card-title">Files</h3>

									<div class="card-tools">
										<button type="button" class="btn btn-tool"
											data-card-widget="collapse" data-toggle="tooltip"
											title="Collapse">
											<i class="fas fa-minus"></i>
										</button>
									</div>
								</div>
								<div class="card-body p-0">
									<table class="table">
										<thead>
											<tr>
												<th>RoleId</th>
												<th>RoleName</th>
												<th>Action</th>
											</tr>
											<c:forEach items="${roles}" var="role">
												<tr>
													<td><c:out value="${role.roleId}"></c:out></td>
													<td><c:out value="${role.roleName}"></c:out></td>
													<td class="text-right py-0 align-middle">
														<div class="btn-group btn-group-sm">
															<a href="editrole/${role.roleId }" class="btn btn-info"><i
																class="fas fa-eye"></i></a> <a
																href="deleterole/${role.roleId}" class="btn btn-danger"><i
																class="fas fa-trash"></i></a>
														</div>
												</tr>
											</c:forEach>
									</table>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->



							<!-- -dynamic -->
						</div>

					</div>
					<!-- /.row (main row) -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>


		<jsp:include page="AdminFooter.jsp"></jsp:include>

	</div>



</body>
</html>
