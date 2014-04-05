package tsoha.divelog.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tsoha.divelog.model.Spot;

/**
 *
 * @author jani
 */
public class UpdateSpotlistServlet extends BaseServlet {

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
        response.sendRedirect("spotlist");
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
        Spot spot = new Spot();
        String spot_id = request.getParameter("spotSelection");
        String name = request.getParameter("inputName");
        String location = request.getParameter("inputLocation");
        String spottype = request.getParameter("inputSpottype");
        String mindepth = request.getParameter("inputMindepth");
        String description = request.getParameter("inputDescription");

        if (!spot_id.isEmpty()) {
            int id = Integer.parseInt(spot_id);
            spot.setSpot_id(id);
            spot.setName(name);
            spot.setLocation(location);
            spot.setSpottype(spottype);
            spot.setMindepth(mindepth);
            spot.setDescription(description);
            spot.updateSpotById(id);
            response.sendRedirect("spotlist");
        } else {
            spot.setName(name);
            spot.setLocation(location);
            spot.setSpottype(spottype);
            spot.setMindepth(mindepth);
            spot.setDescription(description);
            spot.insertInDatabase();
            response.sendRedirect("spotlist");
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
