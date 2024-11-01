<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">

<head>
<title>${page.title }</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/PolyAss/">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="../fontawesome-free-6.3.0-web/css/all.css">
</head>
<style>
body {
	background-color: rgba(52, 52, 52, 0.85);
}

.header-list-index .title-list-index {
	color: #dacb46;
	text-shadow: 1px 1px 1px #1a1a1a;
	display: inline-block;
	text-transform: uppercase;
}

.movie-item .movie-meta .movie-title-1 {
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 100%;
	color: #44e2ff;
	text-transform: uppercase;
	font-size: 12px;
	font-weight: 700;
	text-decoration: none;
}

.header-list-index {
	background: bottom repeat-x;
	margin-bottom: 5px;
	margin-top: 10px;
}

.right-box .right-box-header {
	color: #dacb46;
	height: 32px;
	padding-left: 15px;
}

.movie-item .movie-meta .movie-title-1 {
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 100%;
	color: #44e2ff;
	text-transform: uppercase;
	font-size: 12px;
	font-weight: 700;
	text-decoration: none;
}

.movie-title-1 {
	display: block;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 100%;
	color: #44e2ff;
	text-transform: uppercase;
	font-size: 12px;
	font-weight: 700;
	text-decoration: none;
}

ul, span, p, div {
	margin: 0;
	padding: 0;
	padding-top: 0px;
	padding-right: 0px;
	padding-bottom: 0px;
	padding-left: 0px;
}

img.avatar {
	object-fit: cover;
	width: 75px;
	height: 87px;
	float: left;
	margin: 3px 10px 0 0;
	border: 1px solid #efefef;
}

.text-left {
	margin-top: 10px;
}
 .buz1{
        padding-left: 0.75rem;
        padding-top: 0.1rem;
        padding-right: 1.4rem;
        padding-bottom: 0.1rem;
        border-top-left-radius: 0.5rem;
        border-top-right-radius: 0.5rem;
        border-bottom-left-radius: 0.5rem;
        border-bottom-right-radius: 0.5rem;
    }
    .buz-info{
        color: #fff;
        background-color: #17a2b8;
    }
    .buz-success{
        color: #fff;
        background-color: #28a745;
    }
    .buz2{
        padding-left: 0.75rem;
        padding-top: 0.1rem;
        padding-right: 0.75rem;
        padding-bottom: 0.1rem;
        border-top-left-radius: 0.5rem;
        border-top-right-radius: 0.5rem;
        border-bottom-left-radius: 0.5rem;
        border-bottom-right-radius: 0.5rem;
    }
    .buz-footer{ 
        padding-bottom: 0.5rem; 
        padding-left: 1.4rem;
    }
</style>

<body>
	<header style="background-color: #333;">
		<div class="header">
			<div class="container">
				<div class="top">
					<div class="left" style="float: left;">
						<h1 style="color: white;">AnimeWibu</h1>
					</div>

					<div class="right-box">
						<div class="text-right">
							<img src="images/logo-fpt.png" alt="" width="200" height="75">
						</div>
						<nav class="col navbar navbar-expand-sm navbar-light "
							style="float: right; background-color: rgba(79, 79, 79, 0.85);">
							<a class="navbar-brand" href="#" style="color: whitesmoke;">Online
								Entertainment</a>

							<button class="navbar-toggler d-lg-none" type="button"
								data-toggle="collapse" data-target="#collapsibleNavId"
								aria-controls="collapsibleNavId" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>

							<div class="collapse navbar-collapse" id="collapsibleNavId">
								<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
									<li class="nav-item active"><a class="nav-link"
										href="Homepage" style="color: whitesmoke;"><i
											class="fa fa-home" aria-hidden="true"
											style="color: whitesmoke;"></i> Home</a></li>

								</ul>
								<ul class="navbar-nav">
									<li class="nav-item dropdown"><a
										class="nav-link dropdown-toggle" href="#" id="dropdownId"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false" style="color: whitesmoke;"> <i
											class="fa fa-user" aria-hidden="true"></i> My Account
									</a>
										<div class="dropdown-menu" aria-labelledby="dropdownId">

											<c:if test="${ ! isLogin }">
												<a class="dropdown-item" href="Login">login</a>
												<a class="dropdown-item" href="ForgotPassword">Forgot Passowrd</a>
												<a class="dropdown-item" href="Registration">Registration</a>
											</c:if>
											<c:if test="${isLogin }">
												<a class="dropdown-item" href="Logoff">Logoff</a>
												<a class="dropdown-item" href="ChangePassword">Change Passowrd</a>
												<a class="dropdown-item" href="EditProfile">Edit Profile</a>
											</c:if>
										</div>
									</li>
								</ul>
							</div>
							
						</nav>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div class="container">
		<div class="row">
			<jsp:include page="${page.contentUrl }"></jsp:include>
		</div>
	</div>



	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

	<c:if test="${not empty page.scriptUrl }">
		<jsp:include page="${page.scriptUrl }"></jsp:include>
	</c:if>
</body>

</html>