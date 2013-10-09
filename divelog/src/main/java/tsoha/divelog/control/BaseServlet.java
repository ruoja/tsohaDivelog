package tsoha.divelog.control;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tsoha.divelog.database.DatabaseQuery;
import tsoha.divelog.model.Diver;

/**
 *
 * @author jani
 */
public class BaseServlet extends HttpServlet {

    private static Diver diver = new Diver();

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

    public static void setDiver(Diver diver) {
        BaseServlet.diver = diver;
    }

    public static Diver getDiver() {
        return BaseServlet.diver;
    }

    public void insertNewDiverInDatabase(Diver diver) throws SQLException, Exception {
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("INSERT INTO diver(firstname,lastname,classification,phonenumber,email,pswd) VALUES(?,?,?,?,?,?)");
        statement.setString(1, diver.getDiverFirstName());
        statement.setString(2, diver.getDiverLastName());
        statement.setString(3, diver.getDiverClass());
        statement.setString(4, diver.getDiverPhone());
        statement.setString(5, diver.getDiverEmail());
        statement.setString(6, diver.getDiverPswd());
        statement.executeUpdate();
    }
}
