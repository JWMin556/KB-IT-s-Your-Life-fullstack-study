package org.scoula.ex04.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_save")
public class CartSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        //입력 파라미터 얻기
        String product = req.getParameter("product");

        HttpSession session = req.getSession();
        ArrayList<String> list =(ArrayList<String>) session.getAttribute("product");

        if (list == null) {
            list = new ArrayList<String>();
            session.setAttribute("product", list);
        }

        list.add(product);  // null도 리스트에 추가되어버림

        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>"); // jsp경로
        out.print("<a href='cart_view'>장바구니 보기</a>");  // servlet 담당 url
        out.print("</body></html>");
    }
}
