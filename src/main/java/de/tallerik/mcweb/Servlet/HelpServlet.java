package de.tallerik.mcweb.Servlet;

import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        resp.setStatus(HttpStatus.OK_200);
        resp.getWriter().println("<h1>Serverdashboard API</h1>");
        resp.getWriter().println("<h2>Metrics</h2>");

        resp.getWriter().println("<h3>Players API</h3>");
        resp.getWriter().println("<p>");
        resp.getWriter().println("/players/online -> Online count <br>");
        resp.getWriter().println("/players/max -> Max Players count <br>");
        resp.getWriter().println("/players/list -> Online Players list <br>");
        resp.getWriter().println("</p><br>");

        resp.getWriter().println("<h3>Whitelist API</h3>");
        resp.getWriter().println("<p>");
        resp.getWriter().println("/whitelist/status -> 'on' or 'off' <br>");
        resp.getWriter().println("/whitelist/list -> List whitelisted Players <br>");
        resp.getWriter().println("</p><br>");

        resp.getWriter().println("<h3>Ram API</h3>");
        resp.getWriter().println("<p>");
        resp.getWriter().println("/ram/used -> Get used Ram <br>");
        resp.getWriter().println("/ram/max -> Get Max Ram <br>");
        resp.getWriter().println("</p><br>");

        resp.getWriter().println("<h3>CPU API</h3>");
        resp.getWriter().println("<p>");
        resp.getWriter().println("/cpu/load -> Get CPU load <br>");
        resp.getWriter().println("</p><br>");

        resp.getWriter().println("<h3>Plugins API</h3>");
        resp.getWriter().println("<p>");
        resp.getWriter().println("/plugins/list -> Get plugins list <br>");
        resp.getWriter().println("/plugins/info -> Get plugin description. Need header 'plugin: pluginname'! <br>");
        resp.getWriter().println("/plugins/status -> Set the Plugin status. Need header 'plugin: pluginname' and 'state: enable/disable'! <br>");
        resp.getWriter().println("/plugins/uninstall -> Uninstall an plugin. Need header 'plugin: pluginname'! <br>");
        resp.getWriter().println("</p><br>");

        resp.getWriter().println("<h3>Console API</h3>");
        resp.getWriter().println("<p>");
        resp.getWriter().println("/console -> Get the console <br>");
        resp.getWriter().println("/console/sendCMD -> Send header 'cmd' to console <br>");
        resp.getWriter().println("</p><br>");

        resp.getWriter().println("<h3>Server API</h3>");
        resp.getWriter().println("<p>");
        resp.getWriter().println("/server/port -> Gets the Serverport <br>");
        resp.getWriter().println("</p><br>");

    }
}
