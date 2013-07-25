package com.eriad;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Diu extends HttpServlet {

    public static String buildHTMLContent(String recipient, String sender) {
        return "<h1>Diu Lei, " + recipient + ".</h1><p><em>- " + sender + "</em></p>";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getHeader("Accept");

        String content = "";
        String args = req.getRequestURI().replaceFirst("/diu/", "");
        if (args != null) {
            String[] names = args.split("/");
            if (names.length == 2) {
                content = buildHTMLContent(names[0], names[1]);
            }
        }

        StringBuilder response = new StringBuilder()
                .append(Structure.PART_A)
                .append(content)
                .append(Structure.PART_B);

        resp.getWriter().write(response.toString());
    }
}
