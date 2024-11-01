<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-sm-9">
	<h2 class="header-list-index">
		<span class="title-list-index">Phim Chiếu Rạp</span>
	</h2>
	<hr>
	<div class="row p-2">
	<c:forEach var="item" items="${ videos }">
		<div class="col-3">
			<div class="card text-left"
				style="background-color: rgb(25, 24, 24);">
				<div class="block-wrapper" style="padding: 2px;">
					<img class="img-fluid" src="${ empty item.poster ? 'images/doraemon1.jpg': item.poster }" alt=""
						width="250" height="250">
					<div class="movie-meta" style="margin: 5px;">
						<div class="movie-title-1">${item.title }</div>
						<span class="movie-title-2" style="color: aliceblue; size: 3cm;">Trailer
							HD Vietsub</span>
					</div>
				</div>
				<div class="buz-footer">
					<a href="LikeVideo?videoId=${item.videoId }" class="buz1 btn buz-success btn-success">Like</a> 
					<a href="ShareVideo?videoId=${item.videoId }" class="buz2 btn buz-info btn-info">Share</a>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
<div class="col-3">
	<div style="margin-top: 60px;">
		<h5 class="right-box star-icon">
			<span class="right-box-header">Top Phim Hot Trong Tuần</span>
		</h5>
		<div style="background-color: rgb(14, 13, 13);">
			<div class="card">
				<ul class="list-group list-group-flush"
					style="background-color: rgb(34, 33, 33);">
					<li class="list-group-item"
						style="overflow: hidden; margin: 0 0 5px; background-color: black;">
						<a href=""> <img class="avatar" src="images/doraemon1.jpg"
							alt="" width="70" height="70">
					</a>
						<div style="margin: 0; padding: 0;">
							<p style="font-size: 13; margin-bottom: 5px;">
								<a href=""
									style="color: white; font-size: 8px; font-weight: bold;">NOBITA
									VÀ HÒN ĐẢO KỲ TÍCH</a>
							</p>
							<p class="real-name"
								style="color: rgb(228, 224, 224); font-size: 15px;">2023</p>
						</div>
						<p>
							<img src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt="">
						</p>
					</li>
					<li class="list-group-item"
						style="overflow: hidden; margin: 0 0 5px; background-color: black;">
						<a href=""> <img class="avatar" src="images/doraemon1.jpg"
							alt="" width="70" height="70">
					</a>
						<div style="margin: 0; padding: 0;">
							<p style="font-size: 13; margin-bottom: 5px;">
								<a href=""
									style="color: white; font-size: 8px; font-weight: bold;">NOBITA
									VÀ HÒN ĐẢO KỲ TÍCH</a>
							</p>
							<p class="real-name"
								style="color: rgb(228, 224, 224); font-size: 15px;">2023</p>
						</div>
						<p>
							<img src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt="">
						</p>
					</li>
					<li class="list-group-item"
						style="overflow: hidden; margin: 0 0 5px; background-color: black;">
						<a href=""> <img class="avatar" src="images/doraemon1.jpg"
							alt="" width="70" height="70">
					</a>
						<div style="margin: 0; padding: 0;">
							<p style="font-size: 13; margin-bottom: 5px;">
								<a href=""
									style="color: white; font-size: 8px; font-weight: bold;">NOBITA
									VÀ HÒN ĐẢO KỲ TÍCH</a>
							</p>
							<p class="real-name"
								style="color: rgb(228, 224, 224); font-size: 15px;">2023</p>
						</div>
						<p>
							<img src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt="">
						</p>
					</li>
					<li class="list-group-item"
						style="overflow: hidden; margin: 0 0 5px; background-color: black;">
						<a href=""> <img class="avatar" src="images/doraemon1.jpg"
							alt="" width="70" height="70">
					</a>
						<div style="margin: 0; padding: 0;">
							<p style="font-size: 13; margin-bottom: 5px;">
								<a href=""
									style="color: white; font-size: 8px; font-weight: bold;">NOBITA
									VÀ HÒN ĐẢO KỲ TÍCH</a>
							</p>
							<p class="real-name"
								style="color: rgb(228, 224, 224); font-size: 15px;">2023</p>
						</div>
						<p>
							<img src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt="">
						</p>
					</li>
					<li class="list-group-item"
						style="overflow: hidden; margin: 0 0 5px; background-color: black;">
						<a href=""> <img class="avatar" src="images/doraemon1.jpg"
							alt="" width="70" height="70">
					</a>
						<div style="margin: 0; padding: 0;">
							<p style="font-size: 13; margin-bottom: 5px;">
								<a href=""
									style="color: white; font-size: 8px; font-weight: bold;">NOBITA
									VÀ HÒN ĐẢO KỲ TÍCH</a>
							</p>
							<p class="real-name"
								style="color: rgb(228, 224, 224); font-size: 15px;">2023</p>
						</div>
						<p>
							<img src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt="">
						</p>
					</li>
					<li class="list-group-item"
						style="overflow: hidden; margin: 0 0 5px; background-color: black;">
						<a href=""> <img class="avatar" src="images/doraemon1.jpg"
							alt="" width="70" height="70">
					</a>
						<div style="margin: 0; padding: 0;">
							<p style="font-size: 13; margin-bottom: 5px;">
								<a href=""
									style="color: white; font-size: 8px; font-weight: bold;">NOBITA
									VÀ HÒN ĐẢO KỲ TÍCH</a>
							</p>
							<p class="real-name"
								style="color: rgb(228, 224, 224); font-size: 15px;">2023</p>
						</div>
						<p>
							<img src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt=""> <img
								src="images/star-on.png" alt="">
						</p>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>