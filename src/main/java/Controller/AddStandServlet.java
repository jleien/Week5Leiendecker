package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Stand;

/**
 * Servlet implementation class AddStandServlet
 */
@WebServlet("/addStandServlet")
public class AddStandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddStandServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String startcash = request.getParameter("startcash");
		String status = request.getParameter("status");
		double startCash = Double.parseDouble(startcash);
		
		Stand s = new Stand(name, type, startCash, status);
		StandHelper dbo = new StandHelper();
		dbo.insertStand(s);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
