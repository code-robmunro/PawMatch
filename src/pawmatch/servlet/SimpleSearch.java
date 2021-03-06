package pawmatch.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pawmatch.dal.PetProfilesDao;
import pawmatch.dal.PicturesDao;
import pawmatch.dal.UsersDao;
import pawmatch.model.PetProfiles;


@WebServlet("/simplesearch")
public class SimpleSearch extends HttpServlet {

	protected PetProfilesDao petProfilesDao;
	protected UsersDao usersDao;
	protected PicturesDao picturesDao;

	@Override
	public void init() throws ServletException {
		petProfilesDao = PetProfilesDao.getInstance();
		usersDao = UsersDao.getInstance();
		picturesDao = PicturesDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<PetProfiles> profiles = null;
		List<String> thumbs = new ArrayList<>();
		List<String> full = new ArrayList<>();

		String userId = req.getParameter("userid");
		if (userId == null || userId.trim().isEmpty()) {
			messages.put("success", "Please enter a valid user ID.");
		} else {
			try {
				profiles = petProfilesDao.matchPetsToSimplePrefs(usersDao.getUserById(Integer.parseInt(userId)));
				for (PetProfiles pet : profiles) {
					thumbs.add(picturesDao.getPictureById(pet.getPetProfileId()).getThumbnailImageUrl());
					full.add(picturesDao.getPictureById(pet.getPetProfileId()).getFullImageUrl());
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success", "Displaying results for user ID " + userId);
			// Save the previous search term, so it can be used as the default
			// in the input box when rendering FindUsers.jsp.
			messages.put("previous user ID", userId.toString());
		}
		req.setAttribute("thumbs_img", thumbs);
		req.setAttribute("full_img", full);
		req.setAttribute("profiles", profiles);

		req.getRequestDispatcher("/SimpleSearch.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<PetProfiles> profiles = null;
		List<String> thumbs = new ArrayList<>();
		List<String> full = new ArrayList<>();

		String userId = req.getParameter("userid");
		if (userId == null || userId.trim().isEmpty()) {
			messages.put("success", "Please enter a valid user ID.");
		} else {
			try {
				profiles = petProfilesDao.matchPetsToSimplePrefs(usersDao.getUserById(Integer.parseInt(userId)));
				for (PetProfiles pet : profiles) {
					thumbs.add(picturesDao.getPictureById(pet.getPetProfileId()).getThumbnailImageUrl());
					full.add(picturesDao.getPictureById(pet.getPetProfileId()).getFullImageUrl());
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			messages.put("success", "Displaying results for user ID: " + userId);
			// Save the previous search term, so it can be used as the default
			// in the input box when rendering FindUsers.jsp.
			messages.put("previous user ID", userId.toString());
		}
		req.setAttribute("thumbs_img", thumbs);
		req.setAttribute("full_img", full);
		req.setAttribute("profiles", profiles);

		req.getRequestDispatcher("/SimpleSearch.jsp").forward(req, resp);
	}

}
