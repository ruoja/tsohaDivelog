package tsoha.divelog.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tsoha.divelog.model.Diver;

/**
 *
 * @author jani
 */
public class BaseServlet extends HttpServlet {

    public void showPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/" + page + ".jsp").forward(request, response);
    }

    public boolean isLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("loggedInDiver") != null) {
            return true;
        } else {
            return false;
        }
    }

    public void kickOutNotLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorMessage", "Kirjaudu tai rekisteröidy käyttääksesi palvelua!");
        showPage(request, response, "login");
    }

    public void showError(HttpServletRequest request, HttpServletResponse response, String page, String message) throws ServletException, IOException {
        request.setAttribute("errorMessage", message);
        showPage(request, response, page);
    }

    public void acceptLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("loggedInDiver", new Diver().setDiverId(1).setDiverFirstName("Erkki").setDiverLastName("Esimerkki").setDiverClass("CMAS P3").setDiverPhone("555-123456").setDiverEmail("erkki@internez.net"));
        response.sendRedirect("divestats");
    }
}
