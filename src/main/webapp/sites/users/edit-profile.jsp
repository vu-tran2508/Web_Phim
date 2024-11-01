<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-8 offset-2">
	<form action="EditProfile" method="post">
		<div class="card">
			<div class="card-header">
				<b>Edit Profile</b>
			</div>
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
					
						<div class="form-group">
							<label for="username">Username</label> 
							<input type="text"
								class="form-control" name="username" id="username" value="${ user.username }"
								aria-describedby="usernameHid" placeholder="Username"> <small
								id="usernameHid" class="form-text text-muted"> Username
								is requied</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> 
							<input type="text"
								class="form-control" name="fullname" id="fullname" value="${ user.fullname }"
								aria-describedby="fullnameHid" placeholder="Fullname"> <small
								id="fullnameHid" class="form-text text-muted"> Fullname
								is requied</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								placeholder="Password">
						</div>
						<div class="form-group">
							<label for="email">Email Address</label> <input type="text"
								class="form-control" name="email" id="email" placeholder="Email Address" value="${ user.email }"
								required> <small id="emailHid"
								class="form-text text-muted"> Email is requied</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Update</button>
			</div>
		</div>
	</form>
</div>