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

import pawmatch.dal.PetProfilesDao;
import pawmatch.model.PetProfiles;


/**
 * CommonApplication is the primary entry point into the application.
 */
@WebServlet("/pets")
public class PetsServlet extends HttpServlet {

  /**
   *
   */
  private static final long serialVersionUID = -3947916779464848110L;
  protected PetProfilesDao petsDao;

  @Override
  public void init() throws ServletException {
    petsDao = PetProfilesDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    PetProfiles pet = null;

    String petId = req.getParameter("petprofileid");
    if (petId == null || petId.trim().isEmpty()) {
      messages.put("success", "Please enter a valid pet ID.");
    } else {
      try {
        pet = petsDao.getPetById(Integer.parseInt(petId));
      } catch (SQLException e) {
        e.printStackTrace();
      }
      messages.put("success", "Displaying results for pet ID " + petId);
      // Save the previous search term, so it can be used as the default
      // in the input box when rendering FindPetProfiles.jsp.
      messages.put("previous pet ID", petId.toString());
    }
    req.setAttribute("pet", pet);

    req.getRequestDispatcher("/Pets.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    PetProfiles pet = null;

    String petId = req.getParameter("petid");
    if (petId == null || petId.trim().isEmpty()) {
      messages.put("success", "Please enter a valid pet ID.");
    } else {
      try {
        pet = petsDao.getPetById(Integer.parseInt(petId));
      } catch (SQLException e) {
        e.printStackTrace();
      }
      messages.put("success", "Displaying results for pet ID: " + petId);
      // Save the previous search term, so it can be used as the default
      // in the input box when rendering FindPetProfiles.jsp.
      messages.put("previous pet ID", petId.toString());
    }
    req.setAttribute("pet", pet);

    req.getRequestDispatcher("/Pets.jsp").forward(req, resp);
  }
}
