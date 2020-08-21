package cl.inacap.libreria.controllers;

import java.io.IOException;
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
 * Servlet implementation class VerDestacadoresController
 */
@WebServlet("/VerDestacadoresController.do")
public class VerDestacadoresController extends HttpServlet {
	@Inject
	private DestacadoresDAOLocal destacadoresDAO;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerDestacadoresController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("idEliminar") != null) {
			int nombre = Integer.parseInt(request.getParameter("idEliminar"));					
			Destacador destacadorElinado = destacadoresDAO.find(nombre);			
			destacadoresDAO.remove(destacadorElinado);
		}
		List<Destacador> destacadores = this.destacadoresDAO.getAll();
		String filtro = request.getParameter("filtro-txt");
        if(filtro != null && !filtro.isEmpty()) {
            destacadores = this.destacadoresDAO.findByMarca(filtro);
        } else {
            destacadores = this.destacadoresDAO.getAll();
        }
		request.setAttribute("destacadores", destacadores);
		request.getRequestDispatcher("WEB-INF/paginas/verDestacadores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
