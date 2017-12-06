package pawmatch.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pawmatch.dal.PetProfilesDao;
import pawmatch.dal.UsersDao;
import pawmatch.model.PetProfiles;


@WebServlet("/locationsearch")
public class LocationSearch extends HttpServlet {

	protected PetProfilesDao petProfilesDao;

	@Override
	public void init() throws ServletException {
		petProfilesDao = PetProfilesDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<PetProfiles> profiles = null;

		String zip = req.getParameter("zip");
		if (zip == null || zip.trim().isEmpty()) {
			messages.put("success", "Please enter a valid user ID.");
		} else {
			try {
				profiles = petProfilesDao.searchPetsByLocation(Integer.valueOf(zip));
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success", "Displaying results for pets near " + zip);
			// Save the previous search term, so it can be used as the default
			// in the input box when rendering LocationSearch.jsp.
			messages.put("previous zip", zip.toString());
		}
		req.setAttribute("profiles", profiles);

		req.getRequestDispatcher("/LocationSearch.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<PetProfiles> profiles = null;

		String zip = req.getParameter("zip");
		if (zip == null || zip.trim().isEmpty()) {
			messages.put("success", "Please enter a valid user ID.");
		} else {
			try {
				profiles = petProfilesDao.searchPetsByLocation(Integer.valueOf(zip));
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success", "Displaying results for pets near " + zip);
			// Save the previous search term, so it can be used as the default
			// in the input box when rendering FindUsers.jsp.
			messages.put("previous zip", zip.toString());
		}
		req.setAttribute("profiles", profiles);

		req.getRequestDispatcher("/LocationSearch.jsp").forward(req, resp);
	}

}
