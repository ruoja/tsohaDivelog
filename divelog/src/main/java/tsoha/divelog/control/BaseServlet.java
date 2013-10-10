package tsoha.divelog.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jani
 */
public class BaseServlet extends HttpServlet {

    public void showPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/" + page + ".jsp").forward(request, response);
    }

    public boolean isLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("loggedInDiver") != null) {
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

    public void showWarning(HttpServletRequest request, HttpServletResponse response, String page, String message) throws ServletException, IOException {
        request.setAttribute("warningMessage", message);
        showPage(request, response, page);
    }

    public void showMessage(HttpServletRequest request, HttpServletResponse response, String page, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        showPage(request, response, page);
    }
}
