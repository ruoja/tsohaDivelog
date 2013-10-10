package tsoha.divelog.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tsoha.divelog.model.Dive;
import tsoha.divelog.model.Diver;

/**
 *
 * @author jani
 */
public class RegisterServlet extends BaseServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        showPage(request, response, "register");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Diver diver = new Diver();
            String firstname = request.getParameter("inputEtunimi");
            String lastname = request.getParameter("inputSukunimi");
            String classification = request.getParameter("inputLuokitus");
            String phonenumber = request.getParameter("inputPuhelin");
            String email = request.getParameter("inputEmail");
            String password = request.getParameter("inputSalasana");
            String passwordConfirm = request.getParameter("inputVahvistaSalasana");
            List<Dive> diveList = new ArrayList<Dive>();
            diver.setDiverFirstName(firstname);
            diver.setDiverLastName(lastname);
            diver.setDiverClass(classification);
            diver.setDiverPhone(phonenumber);
            diver.setDiverEmail(email);
            diver.setDiverPswd(password);
            diver.setDiveList(diveList);

            if (!password.equals(passwordConfirm)) {
                showError(request, response, "register", "Vahvista salasana kirjoittamalla sama salasana uudelleen!");
            } else if (diver.getDiverByLogin(email, password) == true) {
                showError(request, response, "register", "Olet jo rekisteröitynyt. Kirjaudu tunnuksillasi.");
            } else {
                try {
                    diver.insertInDatabase();
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInDiver", diver);
                    showPage(request, response, "divestats");
                } catch (Exception ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
