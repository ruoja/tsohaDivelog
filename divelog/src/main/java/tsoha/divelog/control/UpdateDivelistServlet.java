package tsoha.divelog.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tsoha.divelog.model.Dive;
import tsoha.divelog.model.Diver;
import tsoha.divelog.model.Spot;

/**
 *
 * @author jani
 */
public class UpdateDivelistServlet extends BaseServlet {

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
        response.sendRedirect("divelist");
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
        try {
            Dive dive = new Dive();
            Diver diver = (Diver) request.getSession().getAttribute("loggedInDiver");
            String spotname = request.getParameter("spotname");
            int diver_id = diver.getDiverId();
            int spot_id = Spot.getSpotIdByName(spotname);
            String divenumber = request.getParameter("divenumber");
            String divedate = request.getParameter("divedate");
            String divetime = request.getParameter("divetime");
            String bottomtime = request.getParameter("bottomtime");
            String maxdepth = request.getParameter("maxdepth");
            String visibility = request.getParameter("visibility");
            String airtemp = request.getParameter("airtemp");
            String watertemp = request.getParameter("watertemp");
            String suittype = request.getParameter("suitOptions");
            String tanksize = request.getParameter("tanksize");
            String startpressure = request.getParameter("startpressure");
            String endpressure = request.getParameter("endpressure");
            String gastype = request.getParameter("gasOptions");
            String oxygenPercentage = request.getParameter("oxygenPercentage");
            String description = request.getParameter("description");

            dive.setDiver_id(diver_id);
            dive.setSpot_id(spot_id);
            dive.setDiveNumber(divenumber);
            dive.setDivedate(divedate);
            dive.setDivetimeInMinutes(divetime);
            dive.setBottomtimeInMinutes(bottomtime);
            dive.setMaxdepth(maxdepth);
            dive.setVisibility(visibility);
            dive.setAirtemp(airtemp);
            dive.setWatertemp(watertemp);
            dive.setSuittype(suittype);
            dive.setTanksize(tanksize);
            dive.setStartpressure(startpressure);
            dive.setEndpressure(endpressure);
            dive.setGastype(gastype);
            dive.setOxygenPercentage(oxygenPercentage);
            dive.setDescription(description);

            dive.insertInDatabase();
            response.sendRedirect("divelist"); //ei talleta, ei virheilmoitusta????
        } catch (Exception ex) {
            Logger.getLogger(DiveServlet.class.getName()).log(Level.SEVERE, null, ex);
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
