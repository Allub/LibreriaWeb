<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="vendor/bulma-0.9.0/css/bulma.min.css" rel="stylesheet" />
<link href="vendor/fontawesome-free-5.13.0-web/css/all.min.css"	rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
</head>
<body>
	<header class="has-background-danger has-text-white">
		<nav class="navbar has-background-info-light" role="navigation"
			aria-label="main navigation">
			<div class="navbar-brand">
				<a class="navbar-item" href="HomeController.do"> <img
					src="img/logo.PNG" width="112" height="28">
				</a> <a role="button" class="navbar-burger burger" aria-label="menu"
					aria-expanded="false" data-target="navbarBasicExample"> <span
					aria-hidden="true"></span> <span aria-hidden="true"></span> <span
					aria-hidden="true"></span>
				</a>
			</div>
			<div class="navbar-item has-dropdown is-hoverable">
				<a class="navbar-link"> Destacador </a>

				<div class="navbar-dropdown">
					<a class="navbar-item" href="IngresarDestacadoresController.do"> 
					Ingresar nuevo </a> 
					<a class="navbar-item" href="VerDestacadoresController.do">
					Mostrar/Modificar/Eliminar </a>
				</div>
			</div>
			<div class="navbar-item has-dropdown is-hoverable">
				<a class="navbar-link"> Lápiz Gel </a>

				<div class="navbar-dropdown">
					<a class="navbar-item" href="IngresarLapicesGelController.do"> Ingresar nuevo </a>
					 <a class="navbar-item" href="VerLapicesGelController.do"> Mostrar/Modificar/Eliminar </a>
				</div>
			</div>
			<div class="navbar-item has-dropdown is-hoverable">
				<a class="navbar-link"> Portaminas </a>

				<div class="navbar-dropdown">
					<a class="navbar-item" href="IngresarPortaminasController.do"> Ingresar nuevo </a> 
					<a class="navbar-item" href="VerPortaminasController.do">Mostrar/Modificar/Eliminar </a>
				</div>
			</div>

			<div class="navbar-end">
				<div class="navbar-item">
					<div class="field is-grouped">
						<p class="control">
							<a class="button has-background-info"
								href="https://twitter.com/Allub_"> <span class="icon">
									<i class="fab fa-twitter has-text-white" aria-hidden="true"></i>
							</span>

							</a>
						</p>
						<p class="control">
							<a class="button has-background-danger"
								href="https://www.instagram.com/l.o.r.e.t.o._"> <span
								class="icon"> <i class="fab fa-instagram has-text-white"
									aria-hidden="true"></i>
							</span>
							</a>
						</p>
					</div>
				</div>
			</div>
		</nav>
		
	</header>