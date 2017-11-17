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


/**
 * CommonApplication is the primary entry point into the application.
 */
@WebServlet("/commonapps")
public class CommonApps extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3947916779464848110L;
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

        CommonApplications commonApp = null;
        
        String userId = req.getParameter("userid");
        if (userId == null || userId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid user ID.");
        } else {
        	try {
        		commonApp = commonApplicationsDao.getcommonAppByUserId(Integer.parseInt(userId));
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for user ID " + userId);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previous user ID", userId.toString());
        }
        req.setAttribute("commonApp", commonApp);
        
        req.getRequestDispatcher("/CommonApps.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        CommonApplications commonApp = null;
        
        String userId = req.getParameter("userid");
        if (userId == null || userId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid user ID.");
        } else {
        	try {
        		commonApp = commonApplicationsDao.getcommonAppByUserId(Integer.parseInt(userId));
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for user ID: " + userId);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previous user ID", userId.toString());
        }
        req.setAttribute("commonApp", commonApp);
        
        req.getRequestDispatcher("/CommonApps.jsp").forward(req, resp);
	}
}
