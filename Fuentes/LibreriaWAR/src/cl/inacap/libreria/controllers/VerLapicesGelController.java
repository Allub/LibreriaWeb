package cl.inacap.libreria.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.libreriaModel.dao.LapicesGelDAOLocal;
import cl.inacap.libreriaModel.dto.LapizGel;

/**
 * Servlet implementation class VerLapizGelController
 */
@WebServlet("/VerLapicesGelController.do")
public class VerLapicesGelController extends HttpServlet {
	@Inject
	private LapicesGelDAOLocal lapicesGelDAO;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerLapicesGelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("idEliminar") != null) {
			int nombre = Integer.parseInt(request.getParameter("idEliminar"));
			LapizGel lapizGelEliminado =lapicesGelDAO.find(nombre);
			lapicesGelDAO.remove(lapizGelEliminado);
		}
		
		List<LapizGel> lapicesGel = this.lapicesGelDAO.getAll();
        String filtro = request.getParameter("filtro-txt");
        if(filtro != null && !filtro.isEmpty()) {
            lapicesGel = this.lapicesGelDAO.findByMarca(filtro);
        } else {
            lapicesGel = this.lapicesGelDAO.getAll();
        }
		request.setAttribute("lapicesGel", lapicesGel);
		request.getRequestDispatcher("WEB-INF/paginas/verLapicesGel.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
