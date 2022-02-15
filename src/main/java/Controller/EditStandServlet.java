package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Stand;

/**
 * Servlet implementation class editStandServlet
 */
@WebServlet("/editStandServlet")
public class EditStandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStandServlet() {
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
		StandHelper dbo = new StandHelper();
		
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String startcash = request.getParameter("startcash");
		String status = request.getParameter("status");
		double startCash = Double.parseDouble(startcash);
		Integer tempId = Integer.parseInt(request.getParameter("ID"));
		
		Stand standToUpdate = dbo.searchForStandById(tempId);
		standToUpdate.setName(name);
		standToUpdate.setType(type);
		standToUpdate.setStartCash(startCash);
		standToUpdate.setOpen(status);
		
		dbo.updateStand(standToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllStandsServlet").forward(request, response);
	}

}
