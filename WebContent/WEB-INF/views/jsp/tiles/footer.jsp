<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/js/jquery.min.js" var="js1" />
<spring:url value="/resources/js/bootstrap.min.js" var="js2" />
<spring:url value="/resources/js/menumaker.js" var="js3" />
<spring:url value="/resources/js/jquery.sticky.js" var="js4" />
<spring:url value="/resources/js/sticky-header.js" var="js5" />
<spring:url value="/resources/js/owl.carousel.min.js" var="js6" />
<spring:url value="/resources/js/multiple-carousel.js" var="js7" />
<spring:url value="/resources/js/jquery.dataTables.min.js" var="js8" />
<spring:url value="/resources/js/tab.js" var="js9" />

<script src="${js1}"></script>
<script src="${js2}"></script>
<script src="${js3}"></script>
<script src="${js4}"></script>
<script src="${js5}"></script>
<script src="${js6}"></script>
<script src="${js7}"></script>
<script src="${js8}"></script>
<script src="${js9}"></script>


<script type="text/javascript">
	$("#dots").click(function() {
		$(".top-header").toggle("slow", function() {
			// Animation complete.
		});
	});
</script>

<!-- footer -->
<div class="footer">
	<div class="container">
		<div class="row">
			<!-- footer-contact links -->
			<div class=" col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="footer-widget">
					<h3 class="footer-title">Contact Info</h3>
					<div class="contact-info">
						<span class="contact-icon"><i class="fa fa-map-marker"></i></span>
						<span class="contact-text">Rue des Fabriques, 51, 1000, Bruxelles
						</span>
					</div>
					<div class="contact-info">
						<span class="contact-icon"><i class="fa fa-phone"></i></span> <span
							class="contact-text">+32 (0)472 42 01 69</span>
					</div>
					<div class="contact-info">
						<span class="contact-icon"><i class="fa fa-envelope"></i></span> <span
							class="contact-text">grayaamootez@gmail.com</span>
					</div>
					<div class="ft-social">
						<ul>
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
							<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /.footer-useful links -->
			<!-- footer-company-links -->
			<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
				<div class="footer-widget">
					<h3 class="footer-title">Company</h3>
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<ul class="arrow">
								<li><a href="#">Home </a></li>
								<li><a href="#">About</a></li>
								<li><a href="#">Services</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Job List</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- /.footer-services-links -->
			<!-- footer-useful links -->
			<div class=" col-lg-5 col-md-5 col-sm-12 col-xs-12">
				<div class="ft-logo">
					<spring:url value="/resources/images/ft_logo.png" var="img1" />
					<img src="${img1}" alt="">
				</div>
			</div>
			<!-- /.footer-useful links -->
		</div>
	</div>
	<!-- tiny-footer -->
	<div class="tiny-footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<p>
						sample project by Grayaa Mootez
					</p>
				</div>
			</div>
		</div>
		<!-- /. tiny-footer -->
	</div>
</div>
<!-- /.footer -->