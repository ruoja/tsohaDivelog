package tsoha.divelog.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tsoha.divelog.model.Dive;
import tsoha.divelog.model.Diver;
import tsoha.divelog.model.Spot;

/**
 *
 * @author jani
 */
public class RemoveDiveServlet extends BaseServlet {

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

        if (!isLogged(request, response)) {
            kickOutNotLogged(request, response);
            return;
        }
        Diver diver = (Diver) request.getSession().getAttribute("loggedInDiver");
        int diver_id = diver.getDiverId();
        List diveList = diver.getDiveList();

        try {
            int dive_id = Integer.parseInt(request.getParameter("diveSelection"));
            diveList = diver.deleteDiveById(dive_id, diver_id);
            if (diveList.isEmpty()) {
                showMessage(request, response, "divelist", "Ei sukelluksia.");
            } else {
                request.setAttribute("diveList", diveList);
                //request.getSession().setAttribute("loggedInDiver", diver);
                showMessage(request, response, "divelist", "Sukelluksen poisto onnistui!");
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("diveList", diveList);
            showError(request, response, "divelist", "Et ole valinnut poistettavaa sukellusta!");
        } catch (Exception ex) {
            Logger.getLogger(RemoveDiveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        processRequest(request, response);
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
