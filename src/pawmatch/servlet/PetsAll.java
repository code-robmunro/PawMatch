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
import pawmatch.model.PetProfiles;


/**
 * CommonApplication is the primary entry point into the application.
 */
@WebServlet("/petsall")
public class PetsAll extends HttpServlet {

  /**
   *
   */
  protected PetProfilesDao petProfilesDao;
  protected PicturesDao picturesDao;

  @Override
  public void init() throws ServletException {
    petProfilesDao = PetProfilesDao.getInstance();
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

    try {
      profiles = petProfilesDao.getAllPets();
      for (PetProfiles pet : profiles) {
        thumbs.add(picturesDao.getPictureById(pet.getPetProfileId()).getThumbnailImageUrl());
        full.add(picturesDao.getPictureById(pet.getPetProfileId()).getFullImageUrl());
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
    messages.put("success", "Displaying...");


    req.setAttribute("thumbs_img", thumbs);
    req.setAttribute("full_img", full);
    req.setAttribute("profiles", profiles);

    req.getRequestDispatcher("/PetsAll.jsp").forward(req, resp);
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

    try {
      profiles = petProfilesDao.getAllPets();
      for (PetProfiles pet : profiles) {
        thumbs.add(picturesDao.getPictureById(pet.getPetProfileId()).getThumbnailImageUrl());
        full.add(picturesDao.getPictureById(pet.getPetProfileId()).getFullImageUrl());
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
    messages.put("success", "Displaying...");

    req.setAttribute("thumbs_img", thumbs);
    req.setAttribute("full_img", full);
    req.setAttribute("profiles", profiles);

    req.getRequestDispatcher("/PetsAll.jsp").forward(req, resp);
  }
}
