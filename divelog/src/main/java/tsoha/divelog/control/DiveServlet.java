package tsoha.divelog.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tsoha.divelog.model.Dive;

/**
 *
 * @author jani
 */
public class DiveServlet extends BaseServlet {

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
        showPage(request, response, "dive");
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

        Dive dive = new Dive();
        
        String divenumber = request.getParameter("inputDivenumber");
        String divedate = request.getParameter("inputDivedate");
        String divetime = request.getParameter("inputDivetime");
        String bottomtime = request.getParameter("inputBottomtime");
        String maxdepth = request.getParameter("inputMaxdepth");
        String visibility = request.getParameter("inputVisibility");
        String airtemp = request.getParameter("inputWatertemp");
        String watertemp = request.getParameter("inputWatertemp");
        String suittype = request.getParameter("inputSuittype");
        String tanksize = request.getParameter("inputTanksize");
        String startpressure = request.getParameter("inputStartpressure");
        String endpressure = request.getParameter("inputEndpressure");
        String gastype = request.getParameter("inputGastype");
        String oxygenPercentage = request.getParameter("inputOxygenPercentage");
        String description = request.getParameter("inputDescription");
        
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
