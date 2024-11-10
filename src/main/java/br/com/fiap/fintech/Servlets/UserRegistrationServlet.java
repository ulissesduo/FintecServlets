package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.UsuarioDAO;
import br.com.fiap.fintech.Entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registerUser")
public class UserRegistrationServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Usuario usuario = new Usuario(email, password);

        try {
            boolean userExists = usuarioDAO.validarUsuario(usuario);

            if (userExists) {
                request.setAttribute("error", "User already exists!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                usuarioDAO.inserirUsuario(usuario);
                response.sendRedirect("success.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while registering. Please try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
