package de.tallerik.mcweb.Servlet.Console;

import de.tallerik.mcweb.Main;
import org.bukkit.Bukkit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendConsoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getHeader("cmd") != null) {
            System.out.println("[MCWeb] Command Executed: /" + req.getHeader("cmd"));
            Main.getInstance().getServer().dispatchCommand(Bukkit.getConsoleSender(), req.getHeader("cmd"));

        } else {
            resp.getWriter().println("Need to give a 'cmd' header!");
        }
    }

}
