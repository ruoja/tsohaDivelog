package tsoha.divelog.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tsoha.divelog.model.Diver;

/**
 *
 * @author jani
 */
public class DiverServlet extends BaseServlet {

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
        if (!isLogged(request, response)) {
            kickOutNotLogged(request, response);
            return;
        }
        Diver diver = (Diver) request.getSession().getAttribute("loggedInDiver");
        request.setAttribute("firstName", diver.getDiverFirstName());
        request.setAttribute("lastName", diver.getDiverLastName());
        request.setAttribute("classification", diver.getDiverClass());
        request.setAttribute("phonenumber", diver.getDiverPhone());
        request.setAttribute("email", diver.getDiverEmail());

        showPage(request, response, "diver");
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
        if (!isLogged(request, response)) {
            kickOutNotLogged(request, response);
            return;
        }
        HttpSession session = request.getSession();
        Diver diver = (Diver) session.getAttribute("loggedInDiver");
        int diver_id = diver.getDiverId();
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String classification = request.getParameter("classification");
        String phonenumber = request.getParameter("phonenumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String newPasswordAgain = request.getParameter("newPasswordAgain");

        if (password.isEmpty()) {
            request.setAttribute("errorMessage", "VIRHE! Kirjoita salasana!");
            processRequest(request, response);
        } else if (!newPassword.equals(newPasswordAgain)) {
            request.setAttribute("errorMessage", "VIRHE! Salasanat eivät täsmää!");
            processRequest(request, response);
        } else if (!newPassword.isEmpty() && newPassword.equals(newPasswordAgain)) {
            diver.changePswd(diver_id, newPassword);
            request.setAttribute("message", "Salasana vaihdettu!");
            session.setAttribute("loggedInDiver", diver);
            processRequest(request, response);
        } else {
            diver.setDiverFirstName(firstname);
            diver.setDiverLastName(lastname);
            diver.setDiverClass(classification);
            diver.setDiverPhone(phonenumber);
            diver.setDiverEmail(email);
            diver.setDiverPswd(password);
            diver.updateDiver(diver_id);
            request.setAttribute("message", "Tietojen muokkaus onnistui!");
            session.setAttribute("loggedInDiver", diver);
            processRequest(request, response);
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
