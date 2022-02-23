/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 22, 2022
**/
package Controller;

import java.io.IOException;

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
@WebServlet("/eventNavigationServlet")
public class EventNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventNavigationServlet() {
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
		// TODO Auto-generated method stub
		EventHelper dao = new EventHelper();
		String act = request.getParameter("doThisToEvent");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllEventsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Event eventToDelete = dao.searchForEventById(tempId);
				dao.deleteEvent(eventToDelete);

			} catch (NumberFormatException e) {
				System.out.println("You forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllEventsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Event eventToEdit = dao.searchForEventById(tempId);
				request.setAttribute("eventToEdit", eventToEdit);
				request.setAttribute("month", eventToEdit.getEventDate().getMonthValue());
				request.setAttribute("date", eventToEdit.getEventDate().getDayOfMonth());
				request.setAttribute("year", eventToEdit.getEventDate().getYear());
				StandHelper daoForItems = new StandHelper();
				
				request.setAttribute("allItems", daoForItems.showAllStands());
							
				if(daoForItems.showAllStands().isEmpty()){
						request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/edit-event.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllEventsServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-event.jsp").forward(request, response);
		}
		
		
		
	}

}
