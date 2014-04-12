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
            Spot spot = new Spot();
            Diver diver = (Diver) request.getSession().getAttribute("loggedInDiver");
            int diver_id = diver.getDiverId();
            String divenumber = request.getParameter("divenumber");
            String divedate = request.getParameter("divedate");
            String name = request.getParameter("name");
            String location = request.getParameter("location");
            String spottype = request.getParameter("spottype");
            String mindepth = request.getParameter("mindepth");
            String spotDescription = request.getParameter("spotDescription");
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
            String diveDescription = request.getParameter("diveDescription");

            spot.setName(name);
            spot.setLocation(location);
            spot.setSpottype(spottype);
            spot.setMindepth(mindepth);
            spot.setDescription(spotDescription); //talleta tässä?

            dive.setDiver_id(diver_id);
            dive.setSpot_id(spot.insertInDatabase());
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
            dive.setDescription(diveDescription);

            dive.insertInDatabase();
            response.sendRedirect("divelist"); //ei talleta, ei virheilmoitusta????
        } catch (Exception ex) {
            Logger.getLogger(DiveServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*protected int newSpot(HttpServletRequest request) {

     Spot spot = new Spot();
     String name = request.getParameter("name");
     String location = request.getParameter("location");
     String spottype = request.getParameter("spottype");
     String mindepth = request.getParameter("mindepth");
     String description = request.getParameter("spotDescription");

     spot.setName(name);
     spot.setLocation(location);
     spot.setSpottype(spottype);
     spot.setMindepth(mindepth);
     spot.setDescription(description);
     return spot.insertInDatabase();
     }*/
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
