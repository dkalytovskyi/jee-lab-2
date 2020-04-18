import dao.DataBaseManager;
import dao.DataBaseProperties;
import models.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        String title = request.getParameter("title");
        String director = request.getParameter("director");
        int year = Integer.parseInt(request.getParameter("year"));
        double imdbRate = Double.parseDouble(request.getParameter("imdb_rate"));

        DataBaseManager dataBaseManager = new DataBaseManager();
        dataBaseManager.addDbDriver(DataBaseProperties.DRIVER);
        dataBaseManager.connectAtUrl(DataBaseProperties.URL, DataBaseProperties.LOGIN, DataBaseProperties.PASS);

        Movie movieToInsert = new Movie(title, director, year, imdbRate);

        pw.println("<h1>");
        if (dataBaseManager.insert(movieToInsert) != 0){
            pw.println("The movie \"" + movieToInsert.getTitle() + "\" was successfully added to the list!");
        } else {
            pw.println("Sorry, but the movie \"" + movieToInsert.getTitle() + "\" was not added to the list!");
        }
        pw.println("</h1>");

        dataBaseManager.disconnectFromDb();
        pw.close();
    }
}
