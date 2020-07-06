<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
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
							<h1 class="m-0 text-dark">Dish</h1>
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
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Add Dish</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
								<s:form method="post" action="adddish" modelAttribute="dishBean">
									<div class="card-body">
										<div class="form-group">
											<label for="exampleInputEmail1">Add Dish</label> 
												<s:input path="dishName" cssClass="form-control"/>
												<s:errors path="dishName"></s:errors>
												<br>
											<label for="exampleInputEmail1">Dish Description</label> 
												<s:input path="dishDescription" cssClass="form-control" />
												<s:errors path="dishDescription"></s:errors>
												<br>
												<label for="exampleInputEmail1">DishIs Active</label>
												<s:checkbox path="dishactive"  />
												<s:errors path="dishactive"></s:errors>
												</div>
												</div>
								<!-- /.card-body -->

								<div class="card-footer">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</s:form>
							</div>
						<!-- /.card -->

					</div>

				</div>
				<!-- /.row (main row) -->
			</div>
			<!-- /.container-fluid --> </section>
			<!-- /.content -->
		</div>


		<jsp:include page="AdminFooter.jsp"></jsp:include>

	</div>