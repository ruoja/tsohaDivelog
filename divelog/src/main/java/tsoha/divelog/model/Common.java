package tsoha.divelog.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jani
 */
public class Common extends HttpServlet {

    public void showPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/" + page + ".jsp").forward(request, response);
    }

    public boolean isLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("loggedInDiver") != null) {
            return true;
        } else {
            request.setAttribute("errorMessage", "Kirjaudu tai rekisteröidy käyttääksesi palvelua!");
            showPage(request, response, "login");
            return false;
        }
    }
}
