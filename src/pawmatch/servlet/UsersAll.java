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

import pawmatch.dal.UsersDao;
import pawmatch.model.Users;


/**
 * CommonApplication is the primary entry point into the application.
 */
@WebServlet("/usersall")
public class UsersAll extends HttpServlet {

  /**
   *
   */
  private static final long serialVersionUID = -3947916779464848110L;
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

    List<Users> allUsers = new ArrayList<Users>();

    try {
      allUsers = usersDao.getAllUsers();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }

    req.setAttribute("allusers", allUsers);

    req.getRequestDispatcher("/UsersAll.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    Users user = null;

    String userId = req.getParameter("userid");
    if (userId == null || userId.trim().isEmpty()) {
      messages.put("success", "Please enter a valid user ID.");
    } else {
      try {
        user = usersDao.getUserById(Integer.parseInt(userId));
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
      messages.put("success", "Displaying results for user ID: " + userId);
      // Save the previous search term, so it can be used as the default
      // in the input box when rendering FindUsers.jsp.
      messages.put("previous user ID", userId.toString());
    }
    req.setAttribute("user", user);

    req.getRequestDispatcher("/Users.jsp").forward(req, resp);
  }
}
