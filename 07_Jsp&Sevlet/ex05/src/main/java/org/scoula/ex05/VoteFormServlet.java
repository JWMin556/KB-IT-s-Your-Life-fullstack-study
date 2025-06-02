package org.scoula.ex05;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/vote-form")
public class VoteFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 방문 시간 세션 저장
        HttpSession session = request.getSession();
        if (session.getAttribute("visitTime") == null) {
            session.setAttribute("visitTime", new Date().toString());
        }

        // 쿠키에서 Lastsnack얻기
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("lastSnack".equals(cookie.getName())) {
                    request.setAttribute("lastSnack", cookie.getValue());
                    break;
                }
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/vote_form.jsp");
        dispatcher.forward(request, response);
    }
}
