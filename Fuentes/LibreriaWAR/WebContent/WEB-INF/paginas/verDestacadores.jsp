<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<section class="hero is-light is-fullheight">
  <div class="hero-body">
<main class="container">
	<div class="columns is-centered">
		<div class="column is-9">
			<c:if test="${destacadores.isEmpty()}">
				<div class="notification is-info">
					<p>No existen destacadores registrados</p>
					<p>
						<a href="IngresarDestacadoresController.do">Registrar
							Destacador</a>
					</p>
				</div>
			</c:if>
			<form method="GET" action="VerDestacadoresController.do">
				<div class= "columns is-centered">
                <div class="field">
                    <div class="control">
                        <div class="select">
                            <select name="filtro-txt">
                                <option value="">Todos</option>
                               
                                    <option >Stabilo</option>
                                    <option >Faber Castell</option>
                                    <option >Lavoro</option>
                                    <option >Staedtler</option>
                            </select>
                        </div>
                         <button type="submit" class="button is-success">Filtrar</button>
                    </div>
                   
                </div>
               </div>
            </form>
			<c:if test="${!destacadores.isEmpty()}">
				<table class="table is-bordered is-hovered is-fullwidth mt-5">
					<thead class="has-background-info has-text-white">
						<tr>
							<th class="has-text-centered">ID del Destacador</th>
							<th class="has-text-centered">Nombre del Destacador</th>
							<th class="has-text-centered">Marca del Destacador</th>
							<th class="has-text-centered">Cantidad del Destacador</th>	
							<th class="has-text-centered">Gama de color</th>
							<th class="has-text-centered">Precio Destacador</th>
							<th class="has-text-centered">Borrar</th>
							<th class="has-text-centered">Actualizar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${destacadores}" var="destacador">
							<tr>
								<td class="has-text-centered">${destacador.idDestacador}</td>
								<td class="has-text-centered">${destacador.nombre}</td>
								<td class="has-text-centered">${destacador.marca}</td>
								<td class="has-text-centered">${destacador.cantidad}</td>								
								<td class="has-text-centered">${destacador.gama}</td>
								<td class="has-text-centered"><span
									class="icon is-small is-left"> <i
									class="fas fa-dollar-sign"></i>
								</span>${destacador.precio}</td>
								<td><a class=" fas fa-trash-alt ml-4" href="VerDestacadoresController.do?idEliminar=${destacador.idDestacador}"></a></td>
							
							<td><a class="fas fa-edit ml-5" href="ActualizarDestacadorController.do?idDestacador=${destacador.idDestacador}"></a>
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