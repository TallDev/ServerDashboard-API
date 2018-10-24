package de.tallerik.mcweb;

import de.tallerik.mcweb.Servlet.Console.ReadConsoleServlet;
import de.tallerik.mcweb.Servlet.Console.SendConsoleServlet;
import de.tallerik.mcweb.Servlet.HelpServlet;
import de.tallerik.mcweb.Servlet.Players.PlayersListServlet;
import de.tallerik.mcweb.Servlet.Players.PlayersMaxServlet;
import de.tallerik.mcweb.Servlet.Players.PlayersOnlineServlet;
import de.tallerik.mcweb.Servlet.Plugins.PluginInfoServlet;
import de.tallerik.mcweb.Servlet.Plugins.PluginListServlet;
import de.tallerik.mcweb.Servlet.Plugins.PluginSetStatusServlet;
import de.tallerik.mcweb.Servlet.Plugins.PluginUninstallServlet;
import de.tallerik.mcweb.Servlet.Ram.RamUsedServlet;
import de.tallerik.mcweb.Servlet.Server.PortServlet;
import de.tallerik.mcweb.Servlet.Whitelist.WhitelistListServlet;
import de.tallerik.mcweb.Servlet.Whitelist.WhitelistStatusServlet;
import org.bukkit.plugin.java.JavaPlugin;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main extends JavaPlugin {

    Server server = new Server(getConfig().getInt("port"));
    public static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        getConfig().addDefault("port", 8001);
        getConfig().options().copyDefaults(true);

        try {
            server = new Server(getConfig().getInt("port"));
            ServletContextHandler handler = new ServletContextHandler(server, "/");

            handler.addServlet(HelpServlet.class, "/");

            // Ram
            handler.addServlet(RamUsedServlet.class, "/ram/used");
            handler.addServlet(RamUsedServlet.class, "/ram/max");

            // CPU
            handler.addServlet(RamUsedServlet.class, "/cpu/load");

            // Players
            handler.addServlet(PlayersListServlet.class, "/players/list");
            handler.addServlet(PlayersOnlineServlet.class, "/players/online");
            handler.addServlet(PlayersMaxServlet.class, "/players/max");

            // Whitelist
            handler.addServlet(WhitelistStatusServlet.class, "/whitelist/status");
            handler.addServlet(WhitelistListServlet.class, "/whitelist/list");

            // Plugins
            handler.addServlet(PluginListServlet.class, "/plugins/list");
            handler.addServlet(PluginInfoServlet.class, "/plugins/info");
            handler.addServlet(PluginSetStatusServlet.class, "/plugins/status");
            handler.addServlet(PluginUninstallServlet.class, "/plugins/uninstall");

            // Console
            handler.addServlet(ReadConsoleServlet.class, "/console");
            handler.addServlet(SendConsoleServlet.class, "/console/sendCMD");

            // Server
            handler.addServlet(PortServlet.class, "/server/port");

            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        try {
            server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Main getInstance() {
        return instance;
    }
}
