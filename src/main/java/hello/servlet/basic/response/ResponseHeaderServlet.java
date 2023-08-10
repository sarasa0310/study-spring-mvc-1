package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);

//        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        cookie(resp);

        redirect(resp);

        resp.getWriter().write("안녕");
    }

    private static void redirect(HttpServletResponse resp) throws IOException {
//        resp.setStatus(HttpServletResponse.SC_FOUND);
        resp.sendRedirect("/basic/hello-form.html");
    }

    private static void cookie(HttpServletResponse resp) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

}
