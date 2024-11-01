<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col mt-4">
<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">User Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">User List</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" enctype="multipart/form-data">
				<div class="card">
					<div class="card-body">
	   				 <div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username">Username</label> <input type="text"
										class="form-control" name="username" id="username" value="${user.username}"
										aria-describedby="usernameHid" placeholder="Username">
									<small id="usernameHid" class="form-text text-muted">
										Username is requied</small>
								</div>


								<div class="form-group">
									<label for="fullname">Fullname</label> <input type="text"
										class="form-control" name="fullname" id="fullname" value="${user.fullname}"
										aria-describedby="fullnameHid" placeholder="Fullname">
									<small id="fullnameHid" class="form-text text-muted">
										Fullname is requied</small>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										class="form-control" name="password" id="password" value="${user.password}"
										aria-describedby="passwordHid" placeholder="Password">
									<small id="passwordHid" class="form-text text-muted">Password
										is required</small>
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" name="email" id="email" value="${user.email}"
										placeholder="Email" required> <small id="emailHid"
										class="form-text text-muted"> Email is requied</small>
								</div>
							</div>

						</div>
					</div>
					<div class="card-footer text-muted">
                        <button class="btn btn-primary" formaction="Admin/UserManagement/create">Create</button>
						<button class="btn btn-warning" formaction="Admin/UserManagement/update">Update</button>
						<button class="btn btn-danger" formaction="Admin/UserManagement/delete">Delete</button>
						<button class="btn btn-info" formaction="Admin/UserManagement/resert"> Resert</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-stripe">
				<tr>
					<td>Username</td>
					<td>Fullname</td>
					<td>Email</td>
					<td>Role</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${users }">
				<tr>
					<td>${item.username }</td>
					<td>${item.fullname }</td>
					<td>${item.email }</td>
					<td>user</td>
						<td><a
							href="Admin/UserManagement/edit?username=${item.username }"> <i
								class="fa fa-edit" aria-hidden="true"></i>Edit
						</a> <a href="Admin/UserManagement/delete?username=${item.username }">
								<i class="fa fa-trash" aria-hidden="true"></i>Delete
						</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
