package cl.inacap.libreria.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.libreriaModel.dao.PortaminasDAOLocal;
import cl.inacap.libreriaModel.dto.Portamina;

/**
 * Servlet implementation class VerPortaminasController
 */
@WebServlet("/VerPortaminasController.do")
public class VerPortaminasController extends HttpServlet {
	@Inject
	private PortaminasDAOLocal portaminasDAO;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerPortaminasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idEliminar") != null) {
			int nombre = Integer.parseInt(request.getParameter("idEliminar"));					
			Portamina portaminaEliminado = portaminasDAO.find(nombre);			
			portaminasDAO.remove(portaminaEliminado);
		}
		
		List<Portamina> portaminas = this.portaminasDAO.getAll();
		String filtro = request.getParameter("filtro-txt");
        if(filtro != null && !filtro.isEmpty()) {
            portaminas = this.portaminasDAO.findByMarca(filtro);
        } else {
            portaminas = this.portaminasDAO.getAll();
        }
		request.setAttribute("portaminas", portaminas);
		request.getRequestDispatcher("WEB-INF/paginas/verPortaminas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
