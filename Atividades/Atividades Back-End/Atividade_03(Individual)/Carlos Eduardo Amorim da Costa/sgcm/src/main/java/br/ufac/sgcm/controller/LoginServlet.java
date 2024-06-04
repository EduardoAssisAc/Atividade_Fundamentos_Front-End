package br.ufac.sgcm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verificação simples (substitua isso por uma lógica de autenticação real)
        if("admin".equals(username) && "admin".equals(password)) {
            response.sendRedirect("success.jsp");
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}