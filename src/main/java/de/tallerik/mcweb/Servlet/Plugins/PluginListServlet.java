package de.tallerik.mcweb.Servlet.Plugins;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PluginListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setStatus(HttpStatus.OK_200);
        for(Plugin p : Bukkit.getPluginManager().getPlugins()) {
            resp.getWriter().println(p.getName());
        }



    }
}
