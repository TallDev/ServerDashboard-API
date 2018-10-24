package de.tallerik.mcweb.Servlet.Plugins;

import de.tallerik.mcweb.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class PluginUninstallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setStatus(HttpStatus.OK_200);
        /*if(req.getHeader("plugin") != null) {
            Plugin p = Bukkit.getPluginManager().getPlugin(req.getHeader("plugin"));
            if(p != null) {

                try {
                    File loc = new File(p.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
                    System.out.println(loc.getPath());
                    if (loc.delete()) {
                        resp.getWriter().println("Success!");
                        Main.getInstance().getServer().dispatchCommand(Bukkit.getConsoleSender(), "reload");
                    } else {
                        resp.getWriter().println("An Error occured!");
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }else {
                resp.getWriter().println("Plugin not found!");
            }
        } else {
            resp.getWriter().println("Need to give a 'plugin' header!");
        }*/
        resp.getWriter().println("Function disabled!");
    }

}
