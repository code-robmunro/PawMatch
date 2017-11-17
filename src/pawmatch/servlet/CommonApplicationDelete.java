package pawmatch.servlet;

import pawmatch.dal.*;
import pawmatch.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/commonapplicationdelete")
public class CommonApplicationDelete extends HttpServlet {
	
	protected CommonApplicationsDao commonApplicationsDao;
	
	@Override
	public void init() throws ServletException {
		commonApplicationsDao = CommonApplicationsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete Common Application");        
        req.getRequestDispatcher("/CommonApplicationDelete.jsp").forward(req, resp);
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
        	// Delete the CommonApplication.
	        CommonApplications commonApplication = null;
			try {
				commonApplication = commonApplicationsDao.getcommonAppByUserId(Integer.parseInt(userId));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
	        	commonApplication = commonApplicationsDao.delete(commonApplication);
	        	// Update the message.
		        if (commonApplication == null) {
		            messages.put("title", "Successfully deleted user " + userId + "'s common application");
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete user " + userId + "'s common application");
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/CommonApplicationDelete.jsp").forward(req, resp);
    }
}
