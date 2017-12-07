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

import pawmatch.dal.PicturesDao;
import pawmatch.model.Pictures;


/**
 * CommonApplication is the primary entry point into the application.
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

  /**
   *
   */
  private static final long serialVersionUID = -3947916779464848110L;

  @Override
  public void init() throws ServletException {
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // Map for storing messages.
    Map<String, String> messages = new HashMap<String, String>();
    req.setAttribute("messages", messages);

    Pictures one = new Pictures();
    Pictures two = new Pictures();
    Pictures three = new Pictures();

    String url1 = "";
    String url2 = "";
    String url3 = "";

    try {
      one = PicturesDao.getInstance().getRandomFullPicture();
      url1 = one.getFullImageUrl();
      two = PicturesDao.getInstance().getRandomFullPicture();
      url2 = two.getFullImageUrl();
      three = PicturesDao.getInstance().getRandomFullPicture();
      url3 = three.getFullImageUrl();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    req.setAttribute("url1", url1);
    req.setAttribute("url2", url2);
    req.setAttribute("url3", url3);

    req.getRequestDispatcher("/Home.jsp").forward(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

  }
}
