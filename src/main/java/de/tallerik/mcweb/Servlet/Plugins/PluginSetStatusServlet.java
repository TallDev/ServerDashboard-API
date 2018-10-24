package de.tallerik.mcweb.Servlet.Plugins;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PluginSetStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setStatus(HttpStatus.OK_200);
        if(req.getHeader("plugin") != null && req.getHeader("state") != null) {
            Plugin p = Bukkit.getPluginManager().getPlugin(req.getHeader("plugin"));
            if(p != null) {
                if(req.getHeader("state").equalsIgnoreCase("enable")) {
                    Bukkit.getPluginManager().enablePlugin(p);
                    resp.getWriter().println(p.getName() + " Enabled!");
                } else if(req.getHeader("state").equalsIgnoreCase("disable")) {
                    Bukkit.getPluginManager().disablePlugin(p);
                    resp.getWriter().println(p.getName() + " Disabled!");
                } else {
                    resp.getWriter().println("'state' must be 'enable' or 'disable'!");
                }
            }else {
                resp.getWriter().println("Plugin not found!");
            }
        } else {
            resp.getWriter().println("Need to give a 'plugin' and 'state' header!");
        }
    }
}
