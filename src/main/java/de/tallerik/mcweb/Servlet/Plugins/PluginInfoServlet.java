package de.tallerik.mcweb.Servlet.Plugins;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PluginInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setStatus(HttpStatus.OK_200);

        if(req.getHeader("plugin") != null) {
            Plugin p = Bukkit.getPluginManager().getPlugin(req.getHeader("plugin"));
            if(p != null) {
                resp.getWriter().println(p.getDescription().getDescription());
            } else {
                resp.getWriter().println("Plugin not found");
            }
        } else {
            resp.getWriter().println("Need Header: 'plugin'");
        }



    }
}
