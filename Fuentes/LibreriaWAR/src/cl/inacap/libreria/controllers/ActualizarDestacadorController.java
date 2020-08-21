package cl.inacap.libreria.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cl.inacap.libreriaModel.dao.DestacadoresDAOLocal;
import cl.inacap.libreriaModel.dto.Destacador;


/**
 * Servlet implementation class ActualizarDestacadorController
 */
@WebServlet("/ActualizarDestacadorController.do")
public class ActualizarDestacadorController extends HttpServlet {
	@Inject
	private DestacadoresDAOLocal destacadoresDAO;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarDestacadorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idDestacador") != null) {
			int id = Integer.parseInt(request.getParameter("idDestacador"));
			Destacador destacadorEditado =destacadoresDAO.find(id);
			request.setAttribute("destacadorEditado", destacadorEditado);
			
		}
		
		request.getRequestDispatcher("WEB-INF/paginas/actualizarDestacador.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<String>errores = new ArrayList<String>();
		int id = Integer.parseInt(request.getParameter("idTxt").trim());
		String nombre = request.getParameter("nombreTxt").trim();
		String marcaTxt = request.getParameter("marcaSelect").trim();
		String cantidadTxt = request.getParameter("cantidadTxt").trim();
		String precioTxt = request.getParameter("precioTxt").trim();
		String gama = request.getParameter("gama");
		
		
		
		int cantidad=0;
		int precio=0;
		
		
		if(nombre.isEmpty()) {
			errores.add("Deebe ingresar nombre");
		}		
		if(cantidadTxt.isEmpty()) {
			errores.add("Debe ingresar cantidad");
		}else {
			try {
				cantidad = Integer.parseInt(cantidadTxt);
			}catch(NumberFormatException ex) {
				errores.add("La cantidad debe ser numerico");
			}			
		}
		if(precioTxt.isEmpty()) {
			errores.add("Debe ingresar un precio");
		}else {
			try {
				precio = Integer.parseInt(precioTxt);
			} catch (NumberFormatException ex) {
				errores.add("El precio debe ser numerico");
			}
		}
		if(errores.isEmpty()) {
			Destacador destacador = new Destacador();
			destacador.setIdDestacador(id);
			destacador.setNombre(nombre);
			destacador.setMarca(marcaTxt);
			destacador.setCantidad(cantidad);
			destacador.setPrecio(precio);
			destacador.setGama(gama);
			
			
			destacadoresDAO.update(destacador);
			response.sendRedirect("VerDestacadoresController.do");
		}else {
			request.setAttribute("errores", errores);
			
			doGet(request, response);
		}
	}

}
