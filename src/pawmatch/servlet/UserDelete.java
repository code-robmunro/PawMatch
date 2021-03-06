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

import pawmatch.dal.UsersDao;
import pawmatch.model.Users;


@WebServlet("/userdelete")
public class UserDelete extends HttpServlet {
	
	protected UsersDao usersDao;
	
	@Override
	public void init() throws ServletException {
		usersDao = UsersDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Re-enter ID to confirm");
        req.getRequestDispatcher("/UserDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String userId = req.getParameter("userid");
        
        if (userId == null || userId.trim().isEmpty()) {
            messages.put("title", "Invalid UserId");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the User.
	        Users user = null;
			try {
				user = usersDao.getUserById(Integer.parseInt(userId));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
	        	user = usersDao.delete(user);
	        	// Update the message.
		        if (user == null) {
		            messages.put("title", "Successfully deleted user " + userId);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete user " + userId);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }

				getServletContext().getRequestDispatcher("/UsersAll.jsp").forward(req, resp);

    }
}
