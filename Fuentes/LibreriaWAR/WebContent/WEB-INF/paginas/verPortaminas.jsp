<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<section class="hero is-light is-fullheight">
  <div class="hero-body">
<main class="container">
	<div class="columns is-centered">
		<div class="column is-9">
			<c:if test="${portaminas.isEmpty()}">
				<div class="notification is-info">
					<p>No existen portaminas registrados</p>
					<p>
						<a href="IngresarPortaminasController.do">Registrar
							Portaminas</a>
					</p>
				</div>
			</c:if>
			<form method="GET" action="VerPortaminasController.do">
				<div class= "columns is-centered">
                <div class="field">
                    <div class="control">
                        <div class="select">
                            <select name="filtro-txt">
                                <option value="">Todos</option>
                                    <option >Zebra</option>
                                    <option >Tombow</option>
                                    <option >Kurutoga</option>
                                    <option >Staedtler</option>
                            </select>
                        </div>
                         <button type="submit" class="button is-success">Filtrar</button>
                    </div>
                   
                </div>
               </div>
            </form>
			<c:if test="${!portaminas.isEmpty()}">
				<table class="table is-bordered is-hovered is-fullwidth mt-5">
					<thead class="has-background-info">
						<tr>
							<th class="has-text-centered">ID del Portaminas</th>
							<th class="has-text-centered">Nombre del Portaminas</th>
							<th class="has-text-centered">Marca del Portaminas</th>
							<th class="has-text-centered">Cantidad de Portaminas</th>							
							<th class="has-text-centered">Punta</th>
							<th class="has-text-centered">Precio Portaminas</th>
							<th class="has-text-centered">Borrar</th>
							<th class="has-text-centered">Actualizar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${portaminas}" var="portaminas">
							<tr>
								<td class="has-text-centered">${portaminas.idPortamina}</td>
								<td class="has-text-centered">${portaminas.nombre}</td>
								<td class="has-text-centered">${portaminas.marca}</td>
								<td class="has-text-centered">${portaminas.cantidad}</td>								
								<td class="has-text-centered">${portaminas.punta}</td>
								<td class="has-text-centered"><span
									class="icon is-small is-left"> <i
									class="fas fa-dollar-sign"></i>
								</span>${portaminas.precio}</td>
								<td><a class=" fas fa-trash-alt ml-4" href="VerPortaminasController.do?idEliminar=${portaminas.idPortamina}"></a></td>
								<td><a class="fas fa-edit ml-5" href="ActualizarPortaminasController.do?idPortaminas=${portaminas.idPortamina}"></a>
							</td>
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