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


@WebServlet("/commonapplicationcreate")
public class CommonApplicationCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/CommonApplicationCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);


        // Create the CommonApplication.
        String bodyText = req.getParameter("applicationbody");
        String userId = req.getParameter("userid");

	    try {
	        // Exercise: parse the input for StatusLevel.
	        CommonApplications commonApplication = new CommonApplications(bodyText, Integer.parseInt(userId));
	        commonApplication = commonApplicationsDao.create(commonApplication);
	        messages.put("success", "Successfully created application (" + bodyText + ", UserID: " + userId);
	    } catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
	    }

        req.getRequestDispatcher("/CommonApplicationCreate.jsp").forward(req, resp);
    }
}
