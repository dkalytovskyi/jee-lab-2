import dao.DataBaseManager;
import dao.DataBaseProperties;
import models.Movie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MovieListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        DataBaseManager dataBaseManager = new DataBaseManager();
        dataBaseManager.addDbDriver(DataBaseProperties.DRIVER);
        dataBaseManager.connectAtUrl(DataBaseProperties.URL, DataBaseProperties.LOGIN, DataBaseProperties.PASS);

        ArrayList<Movie> movies = dataBaseManager.getAllRows();

        pw.println("<h1>Movie List</h1>");
        pw.println("<table>");
        for(Movie movie : movies) {
            pw.println("<tr>");

            pw.println("<td>" + movie.getTitle() + "</td>");
            pw.println("<td>" + movie.getDirector() + "</td>");
            pw.println("<td>" + movie.getYear() + "</td>");
            pw.println("<td>" + movie.getImdbRate() + "</td>");

            pw.println("</tr>");
        }
        pw.println("</table>");

        dataBaseManager.disconnectFromDb();
        pw.close();
    }
}
