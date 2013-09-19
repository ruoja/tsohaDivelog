package tsoha.divelog.divelog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jani
 */
public class Divelog extends HttpServlet {
    
    public void showPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/"+page+".jsp").forward(request, response);
    }
    
}
