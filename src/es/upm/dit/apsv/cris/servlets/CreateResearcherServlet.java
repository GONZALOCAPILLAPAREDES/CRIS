package es.upm.dit.apsv.cris.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.apsv.cris.dao.ResearcherDAO;
import es.upm.dit.apsv.cris.dao.ResearcherDAOImplementation;
import es.upm.dit.apsv.cris.model.Researcher;

/**
 * Servlet implementation class CreateResearcherServlet
 */
@WebServlet("/CreateResearcherServlet")
public class CreateResearcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateResearcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("user");
		
		if(user.equals("root")){
			String id =request.getParameter("id");
			String name =request.getParameter("name");
			String lastname =request.getParameter("lastname");
			String email =request.getParameter("email");
			String password =request.getParameter("password");
			
			ResearcherDAO dao = ResearcherDAOImplementation.getInstance();
			Researcher researcher_existente = dao.read(id);
			
			if(researcher_existente == null) {
				Researcher researcher_nuevo = new Researcher();
				researcher_nuevo.setId(id);
				researcher_nuevo.setName(name);
				researcher_nuevo.setLastname(lastname);
				researcher_nuevo.setEmail(email);
				researcher_nuevo.setPassword(password);
				
				dao.create(researcher_nuevo);
				
				response.sendRedirect(request.getContextPath() + "/AdminServlet");
			}
			
			
		}else {
			getServletContext().getRequestDispatcher("/LoginView.jsp").forward(request, response);
		}
	}

}
