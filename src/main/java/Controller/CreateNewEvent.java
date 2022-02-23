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
@WebServlet("/createNewEventServlet")
public class CreateNewEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewEvent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StandHelper lih = new StandHelper();
		String eventType = request.getParameter("eventType");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		String managerName = request.getParameter("managerName");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		String[] selectedItems = request.getParameterValues("allStandsToAdd");
		List<Stand> selectedItemsInList = new ArrayList<Stand>();
		
		if(selectedItems != null && selectedItems.length > 0){
			for(int i = 0; i<selectedItems.length; i++) {
				Stand s = lih.searchForStandById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(s);
			}
		}
		
		StandManager standManager = new StandManager(managerName);
		
		Event sld = new Event(eventType, ld, standManager);
		
		sld.setListOfStands(selectedItemsInList);
		
		EventHelper slh = new EventHelper();
		slh.insertNewEvent(sld);
		
		getServletContext().getRequestDispatcher("/viewAllEventsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
