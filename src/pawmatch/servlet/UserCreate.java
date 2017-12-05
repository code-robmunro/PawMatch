package pawmatch.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pawmatch.dal.CommonApplicationsDao;
import pawmatch.dal.UsersDao;
import pawmatch.model.CommonApplications;
import pawmatch.model.Users;


@WebServlet("/usercreate")
public class UserCreate extends HttpServlet {
	
	protected UsersDao usersDao;
	
	@Override
	public void init() throws ServletException {
		usersDao = usersDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);


        // Create the User.
        String userName = req.getParameter("username");
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String notifications = req.getParameter("notifications");
        String foster = req.getParameter("foster");
        String userId = req.getParameter("userid");

	    try {
	        // Exercise: parse the input for StatusLevel.
	        Users user = new Users(Integer.parseInt(userId), userName, firstName, lastName, email,
							password, null, null, Boolean.parseBoolean(notifications),
							Boolean.parseBoolean(foster));
	        user = usersDao.create(user);
	        messages.put("success", "Successfully created user (" + userName + ", UserID: " + userId);
	    } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
	    }

        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
    }
}
