package de.tallerik.mcweb.Servlet.Whitelist;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WhitelistListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setStatus(HttpStatus.OK_200);
        for (OfflinePlayer p : Bukkit.getWhitelistedPlayers()) {
            resp.getWriter().println(p.getName());
        }

    }
}
