import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int count = 0;

        // Get cookies
        Cookie[] cookies = request.getCookies();

        // Check if cookie exists
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visit")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        count++; // increase count

        // Create cookie
        Cookie ck = new Cookie("visit", String.valueOf(count));
        response.addCookie(ck);

        // Display output
        out.println("<html><body>");
        out.println("<h2>Visit Count: " + count + "</h2>");
        out.println("</body></html>");
    }
}


web.xml

<web-app>
    <servlet>
        <servlet-name>VisitServlet</servlet-name>
        <servlet-class>VisitServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>VisitServlet</servlet-name>
        <url-pattern>/visit</url-pattern>
    </servlet-mapping>
</web-app>
