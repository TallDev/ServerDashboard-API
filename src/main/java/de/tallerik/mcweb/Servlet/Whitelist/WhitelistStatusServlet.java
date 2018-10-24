package de.tallerik.mcweb.Servlet.Whitelist;

import org.bukkit.Bukkit;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WhitelistStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setStatus(HttpStatus.OK_200);
        if(Bukkit.hasWhitelist()) {
            resp.getWriter().println("on");
        } else {
            resp.getWriter().println("off");
        }

    }
}
