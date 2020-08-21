<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<section class="hero is-light is-fullheight">
  <div class="hero-body">
<main class="container">

	<div class="columns is-centered is-multiline mt-5">
		<c:if test="${errores != null}">
			<div class="notification column is-7 is-warning">
				<ul>
					<c:forEach items="${ errores}" var="errores">
						<li>${error}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<div class="column is-7">
			<form method="POST" action="ActualizarPortaminasController.do">
				<div class="card">
					<div class="card-header has-background-info-light">
						<span class="card-header-title">Ingresar Portaminas</span>
						</div>
							<c items="${portaminasEditado}" var="portaminasEditado">
								<div class="card-content">
								
								<div class="field">
							<label class="label" for="idTxt">Id</label>
							
							<div class="control">
							 
								<input type="text" name=idTxt class="input" value="${portaminasEditado.idPortamina}" readonly/>
								
							</div>
							
						</div>
						
						
						<div class="field">
							<label class="label" for="nombreTxt">Nombre</label>
							
							<div class="control">
							 
								<input type="text" name=nombreTxt class="input" required value="${portaminasEditado.nombre}"/>
								
							</div>
							
						</div>
						<div class="field">
							<label class="label" for="marcaSelect">Marca</label>
							<div class="control">
								<div class="select">
									<select name="marcaSelect">
										<option>Zebra</option>
										<option>Pilot</option>
										<option>Muji</option>
										<option>Pentel</option>
									</select>
								</div>
							</div>
						</div>
						<div class="field">
							<label class="label" for="precioTxt">Precio</label>
							<p>
							<div class="control has-icons-left">

								<input type="number" min="100" name=precioTxt class="input" required value="${portaminasEditado.precio}" /> 
								<span
									class="icon is-small is-left"> <i
									class="fas fa-dollar-sign"></i>
								</span>
							</div>
						</div>
						<div class="field">
							<label class="label" for="cantidadTxt">Cantidad</label>
							<div class="control">
								<input type="number" min="1" name=cantidadTxt class="input" required value="${portaminasEditado.cantidad}" />
							</div>
						</div>
						<label class="label" for="punta">Punta</label>
					<div class="control">
						<label class="radio"> 
							<input type="radio" name=punta checked value="0.3mm"> 0.3mm
							<input type="radio" name=punta value="0.4mm"> 0.4mm
							<input type="radio" name=punta value="0.5mm"> 0.5mm
							<input type="radio" name=punta value="0.7mm"> 0.7mm
							<input type="radio" name=punta value="0.1mm"> 1mm
						</label>
					</div>
					</div>
					</c>
						<div class="columns is-centered">
						<div class="column is-4 is-centered">
							<button class="button is-info" type="submit">Actualizar</button>
						</div>
					</div>
					</div>
			</form>
		</div>
	</div>

	
</main>
</div>
</section>
<jsp:include page="../templates/footer.jsp"></jsp:include>
</body>
</html>