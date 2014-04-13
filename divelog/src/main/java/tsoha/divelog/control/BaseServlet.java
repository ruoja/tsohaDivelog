package tsoha.divelog.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        if (request.getSession().getAttribute("loggedInDiver") != null) {
            return true;
        } else {
            return false;
        }
    }

    public Diver getDiver(HttpServletRequest request, HttpServletResponse response) {
        return (Diver) request.getSession().getAttribute("loggedInDiver");
    }

    public void kickOutNotLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorMessage", "Kirjaudu tai rekisteröidy käyttääksesi palvelua!");
        showPage(request, response, "login");
    }

    public void showError(HttpServletRequest request, HttpServletResponse response, String page, String message) throws ServletException, IOException {
        request.setAttribute("errorMessage", "VIRHE: " + message);
        showPage(request, response, page);
    }

    public void showWarning(HttpServletRequest request, HttpServletResponse response, String page, String message) throws ServletException, IOException {
        request.setAttribute("warningMessage", "VAROITUS: " + message);
        showPage(request, response, page);
    }

    public void showMessage(HttpServletRequest request, HttpServletResponse response, String page, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        showPage(request, response, page);
    }
}
