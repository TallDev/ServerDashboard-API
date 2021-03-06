package de.tallerik.mcweb.Servlet.Ram;

import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RamUsedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setStatus(HttpStatus.OK_200);
        resp.getWriter().println(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory());
    }
}
