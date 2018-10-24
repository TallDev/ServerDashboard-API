package de.tallerik.mcweb.Servlet.Players;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlayersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        resp.setStatus(HttpStatus.OK_200);
        for(Player p : Bukkit.getOnlinePlayers()) {
            resp.getWriter().println(p.getName());
        }
    }
}
