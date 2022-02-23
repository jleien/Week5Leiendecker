/**
*Jake Leiendecker - 900930049
*CIS175 23970 - Java II
*Feb 22, 2022
**/
package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Event;
import Model.Stand;
import Model.StandManager;

/**
 * @author jake
 *
 */
@WebServlet("/editEventServlet")
public class EditEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEventServlet() {
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
		StandHelper lih = new StandHelper();
		StandManagerHelper sh = new StandManagerHelper();
		
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Event eventToUpdate = dao.searchForEventById(tempId);

		String newEventType = request.getParameter("eventType");

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String standManagerName = request.getParameter("managerName");
		StandManager newManager = sh.findStandManager(standManagerName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			String[] selectedItems = request.getParameterValues("allStandsToAdd");
			List<Stand> selectedItemsInList = new ArrayList<Stand>();

			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Stand s = lih.searchForStandById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(s);

			}
			eventToUpdate.setListOfStands(selectedItemsInList);
		} catch (NullPointerException ex) {
			List<Stand> selectedItemsInList = new ArrayList<Stand>();
			eventToUpdate.setListOfStands(selectedItemsInList);
		}

		eventToUpdate.setEventType(newEventType);
		eventToUpdate.setEventDate(ld);
		eventToUpdate.setStandManager(newManager);

		dao.updateEvent(eventToUpdate);

		getServletContext().getRequestDispatcher("/viewAllEventsServlet").forward(request, response);
	}

}
