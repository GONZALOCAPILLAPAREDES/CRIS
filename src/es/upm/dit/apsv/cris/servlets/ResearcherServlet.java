package es.upm.dit.apsv.cris.servlets;

import java.io.IOException;

import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.cris.dao.ResearcherDAO;
import es.upm.dit.apsv.cris.dao.ResearcherDAOImplementation;
import es.upm.dit.apsv.cris.model.Publication;
import es.upm.dit.apsv.cris.model.Researcher;

/**
 * Servlet implementation class ResearcherServlet
 */
@WebServlet("/ResearcherServlet")
public class ResearcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResearcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResearcherDAO dao = ResearcherDAOImplementation.getInstance();
		String id = (String) request.getParameter("id");
		Researcher researcher = dao.read(id);
		Set<Publication> publications = researcher.getPublications();
		request.setAttribute ("ri",researcher);
		request.setAttribute("publications", publications);
		getServletContext().getRequestDispatcher("/ResearcherView.jsp")
		     .forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
