package org.scoula.ex05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vote-submit")
public class VoteSubmitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String snack = req.getParameter("snack");
        req.setAttribute("snack", snack);

        Cookie cookie = new Cookie("lastSnack", snack);
        cookie.setMaxAge(60*60);
        cookie.setPath("/");
        resp.addCookie(cookie);

        req.getRequestDispatcher("vote_result.jsp").forward(req, resp);
    }
}
