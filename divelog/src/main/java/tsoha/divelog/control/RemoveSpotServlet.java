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
        try {
            int id = Integer.parseInt(request.getParameter("spotSelection"));
            Spot.deleteSpotById(id);
            List allSpots = Spot.getAllSpots();
            if (allSpots.isEmpty()) {
                showMessage(request, response, "spotlist", "Ei näytettäviä kohteita.");
            } else {
                request.setAttribute("allSpots", allSpots);
                showMessage(request, response, "spotlist", "Kohteen poisto onnistui!");
            }
        } catch (SQLException ex) {
            try {
                request.setAttribute("allSpots", Spot.getAllSpots());
                showError(request, response, "spotlist", "Kohde on liitetty sukellukseen!");
            } catch (SQLException ex1) {
                showError(request, response, "spotlist", "Kohdelistan nouto epäonnistui!");
            } catch (Exception ex1) {
                showError(request, response, "spotlist", "Kohdelistan nouto epäonnistui");
            }
        } catch (Exception ex) {
            showError(request, response, "spotlist", "Kohdelistan nouto epäonnistui");

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
