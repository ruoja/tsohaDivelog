package tsoha.divelog.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tsoha.divelog.model.Diver;

/**
 *
 * @author jani
 */
public class RegisterServlet extends BaseServlet {

    String firstname;
    String lastname;
    String classification;
    String phonenumber;
    String email;
    String password;

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

        firstname = request.getParameter("inputEtunimi");
        lastname = request.getParameter("inputSukunimi");
        classification = request.getParameter("inputLuokitus");
        phonenumber = request.getParameter("inputPuhelin");
        email = request.getParameter("inputEmail");
        password = request.getParameter("inputSalasana");
        String passwordConfirm = request.getParameter("inputVahvistaSalasana");

        if (!password.equals(passwordConfirm)) {
            showError(request, response, "register", "Vahvista salasana kirjoittamalla sama salasana uudelleen!");
        } else if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            showError(request, response, "register", "Täytä kaikki pakolliset kentät!");
        } else {
            try {
                Diver diver = register();
                HttpSession session = request.getSession();
                session.setAttribute("loggedInDiver", diver);
                setDiver(diver);
                response.sendRedirect("divestats");
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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

    private Diver register() throws SQLException, Exception {
        Diver diver = new Diver();
        diver.setDiverFirstName(firstname);
        diver.setDiverLastName(lastname);
        diver.setDiverClass(classification);
        diver.setDiverPhone(phonenumber);
        diver.setDiverEmail(email);
        diver.setDiverPswd(password);
        diver.insertNewDiverInDatabase();
        return diver;
    }
}
