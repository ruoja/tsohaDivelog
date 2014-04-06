package tsoha.divelog.control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tsoha.divelog.model.Spot;

/**
 *
 * @author jani
 */
public class RemoveSpotServlet extends BaseServlet {

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
        List allSpots = Spot.getAllSpots();

        try {
            int id = Integer.parseInt(request.getParameter("spotSelection"));
            Spot.deleteSpotById(id);
            if (allSpots.isEmpty()) {
                showMessage(request, response, "spotlist", "Ei näytettäviä kohteita.");
            } else if (Spot.hasDive(id)) {
                request.setAttribute("allSpots", allSpots);
                showError(request, response, "spotlist", "Et voi poistaa kohdetta joka on liitetty sukellukseen!");
            } else {
                request.setAttribute("allSpots", Spot.getAllSpots());
                showMessage(request, response, "spotlist", "Kohteen poisto onnistui!");
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("allSpots", allSpots);
            showError(request, response, "spotlist", "Et ole valinnut poistettavaa kohdetta!");
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
