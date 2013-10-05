package tsoha.divelog.control;

import tsoha.divelog.model.Diver;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tsoha.divelog.database.DatabaseQuery;
import tsoha.divelog.model.Dive;

/**
 *
 * @author jani
 */
public class DiveStatsServlet extends BaseServlet {

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
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        if (!isLogged(request, response)) {
            kickOutNotLogged(request, response);
            return;
        }
        Diver diver = LoginServlet.getLoggedDiver();
        request.setAttribute("diver", diver);
        request.setAttribute("totalDives", diver.getDiveList().size());
        request.setAttribute("lastDive", getLastDiveDate(diver));
        request.setAttribute("longestDive", getLongestDive(diver));
        request.setAttribute("totalDivetime", getTotalDivetime(diver));
        request.setAttribute("maxDepth", getMaxDepth(diver));
        request.setAttribute("nitroxDives", getDivesByType(diver, "nitrox"));
        request.setAttribute("airDives", getDivesByType(diver, "air"));
        showPage(request, response, "divestats");
    }

    private Date getLastDiveDate(Diver diver) {
        List<Dive> diveList = diver.getDiveList();
        int dives = diveList.size() - 1;
        Date lastDive = diveList.get(dives).getDivedate();
        return lastDive;
    }

    private int getLongestDive(Diver diver) throws SQLException, Exception {
        int id = diver.getDiverId();
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT MAX(divetime) FROM dive WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
    }

    private int getTotalDivetime(Diver diver) throws SQLException, Exception {
        int id = diver.getDiverId();
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT SUM(divetime) FROM dive WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
    }

    //TODO: toteuta tämä!
    private String getFavoriteSpot(Diver diver) throws SQLException, Exception {
        int id = diver.getDiverId();
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT spot_id, COUNT(*) AS timesdived FROM dive"
                + "GROUP BY spot_id ORDER BY COUNT(*) DESC WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getString(1);
        }
        return null;
    }

    private int getMaxDepth(Diver diver) throws SQLException, Exception {
        int id = diver.getDiverId();
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT MAX(maxdepth) FROM dive WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
    }

    private int getDivesByType(Diver diver, String gastype) throws SQLException, Exception {
        int id = diver.getDiverId();
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT COUNT(gastype) FROM dive WHERE diver_id=? AND gastype=?");
        statement.setInt(1, id);
        statement.setString(2, gastype);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DiveStatsServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DiveStatsServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DiveStatsServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DiveStatsServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
