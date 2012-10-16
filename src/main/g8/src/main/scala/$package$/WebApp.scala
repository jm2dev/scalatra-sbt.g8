package $package$

import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHolder}
import org.eclipse.jetty.server.Server

object WebApp {
  def main(args: Array[String]) {
    val port = if (args.isEmpty)
      8080
    else
      args(0).toInt
    val server = new Server(port)
    val context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/")
    context.addServlet(classOf[$servlet_name$], "/*")
    context.addServlet(new ServletHolder(new MyDefaultServlet), "/css/*")
    context.addServlet(new ServletHolder(new MyDefaultServlet), "/images/*")
    context.addServlet(new ServletHolder(new MyDefaultServlet), "/js/*")
    context.addServlet(new ServletHolder(new MyDefaultServlet), "/check.txt")

    server.setHandler(context)

    server.start
    server.join
  }
}
