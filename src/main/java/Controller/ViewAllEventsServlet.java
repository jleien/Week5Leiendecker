/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 22, 2022
**/
package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Event;

/**
 * @author jake
 *
 */
@WebServlet("/viewAllEventsServlet")
public class ViewAllEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEventsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EventHelper ldh = new EventHelper();
		List<Event> abc = ldh.showAllEvents();
		request.setAttribute("allLists", abc);
	
		if(abc.isEmpty()) {
			request.setAttribute("allLists", "");
		}
		
		getServletContext().getRequestDispatcher("/event-list-by-user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

