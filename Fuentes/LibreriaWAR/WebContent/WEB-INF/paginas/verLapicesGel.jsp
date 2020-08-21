<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<section class="hero is-light is-fullheight">
  <div class="hero-body">
<main class="container">
	<div class="columns is-centered">
		<div class="column is-9">
			<c:if test="${lapicesGel.isEmpty()}">
				<div class="notification is-info">
					<p>No existen lapices gel registrados</p>
					<p>
						<a href="IngresarLapicesGelController.do">Registrar
							Lapiz Gel</a>
					</p>
				</div>
			</c:if>
			<form method="GET" action="VerLapicesGelController.do">
				<div class= "columns is-centered">
                <div class="field">
                    <div class="control">
                        <div class="select">
                            <select name="filtro-txt">
                                <option value="">Todos</option>                              
                                    <option >Zebra</option>
                                    <option >Pilot</option>
                                    <option >Muji</option>
                                    <option >Pentel</option>
                            </select>
                        </div>
                         <button type="submit" class="button is-success">Filtrar</button>
                    </div>
                   
                </div>
               </div>
            </form>
			<c:if test="${!lapicesGel.isEmpty()}">
				<table class="table is-bordered is-hovered is-fullwidth mt-5">
					<thead class="has-background-info">
						<tr>
							<th class="has-text-centered">ID del Lapiz Gel</th>
							<th class="has-text-centered">Nombre del Lapiz Gel</th>
							<th class="has-text-centered">Marca del Lapiz Gel</th>
							<th class="has-text-centered">Cantidad de Lapices Gel</th>							
							<th class="has-text-centered">Gama de color</th>
							<th class="has-text-centered">Precio Lapiz Gel</th>
							<th class="has-text-centered">Borrar</th>
							<th class="has-text-centered">Actualizar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lapicesGel}" var="lapicesGel">
							<tr>
								<td class="has-text-centered">${lapicesGel.idLapizGel}</td>
								<td class="has-text-centered">${lapicesGel.nombre}</td>
								<td class="has-text-centered">${lapicesGel.marca}</td>
								<td class="has-text-centered">${lapicesGel.cantidad}</td>							
								<td class="has-text-centered">${lapicesGel.gama}</td>
								<td class="has-text-centered"><span
									class="icon is-small is-left"> <i
									class="fas fa-dollar-sign"></i>
								</span>${lapicesGel.precio}</td>
								
							<td><a class=" fas fa-trash-alt ml-4" href="VerLapicesGelController.do?idEliminar=${lapicesGel.idLapizGel}"></a></td>
							<td><a class="fas fa-edit ml-5" href="ActualizarLapicesGelController.do?idLapizGel=${lapicesGel.idLapizGel}"></a>
							
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</div>
</main>
</div>
	</section>
	<jsp:include page="../templates/footer.jsp"></jsp:include>
</body>
</html>