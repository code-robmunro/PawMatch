package pawmatch.servlet;

import pawmatch.dal.*;
import pawmatch.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


@WebServlet("/commonapplicationupdate")
public class CommonApplicationUpdate extends HttpServlet {
	
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

        // Retrieve user and validate.
        String userId = req.getParameter("userid");
        if (userId == null || userId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid user ID.");
        } else {
        	try {
        		CommonApplications commonApplication = commonApplicationsDao.getcommonAppByUserId(Integer.parseInt(userId));
        		if(commonApplication == null) {
        			messages.put("success", "CommonApplication for that user does not exist.");
        		}
        		req.setAttribute("CommonApplication", commonApplication);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/CommonApplicationUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String userId = req.getParameter("userid");
        if (userId == null || userId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid User ID.");
        } else {
        	try {
        		CommonApplications commonApplication = commonApplicationsDao.getcommonAppByUserId(Integer.parseInt(userId));
        		if(commonApplication == null) {
        			messages.put("success", "Common application does not exist. No update to perform.");
        		} else {
        			String newBody = req.getParameter("newbody");
        			if (newBody == null || newBody.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid body text for the application.");
        	        } else {
        	        	commonApplication = commonApplicationsDao.updateApplication(commonApplication, newBody);
        	        	messages.put("success", "Successfully updated " + userId);
        	        }
        		}
        		req.setAttribute("commonApplication", commonApplication);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/CommonApplicationUpdate.jsp").forward(req, resp);
    }
}
