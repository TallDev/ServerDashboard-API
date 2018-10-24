package de.tallerik.mcweb.Servlet.Console;

import de.tallerik.mcweb.Main;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class ReadConsoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(HttpStatus.OK_200);
        try {

            File folder = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile();


            folder = new File(folder.getPath() + "/logs/latest.log");
            if (folder.exists()) {
                resp.getWriter().println(readFile(folder));
            } else {
                resp.getWriter().println("file Not found: " + folder.getPath());
            }


        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

        private String readFile(File file) throws IOException {


        StringBuilder fileContents = new StringBuilder((int)file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }

}
