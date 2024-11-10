package br.com.fiap.fintech.Servlets;

import br.com.fiap.fintech.DAO.UsuarioDAO;
import br.com.fiap.fintech.Entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/updateUser")
public class UpdateUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailAntigo = request.getParameter("emailAntigo");
        String novoEmail = request.getParameter("novoEmail");
        String novaSenha = request.getParameter("novaSenha");

        Usuario usuarioAtualizado = new Usuario(novoEmail, novaSenha);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        boolean isUpdated = usuarioDAO.atualizarUsuario(emailAntigo, usuarioAtualizado);

        if (isUpdated) {
            response.sendRedirect("updateSuccess.jsp");
        } else {
            request.setAttribute("error", "Failed to update user information. Please try again.");
            request.getRequestDispatcher("updateUser.jsp").forward(request, response);
        }
    }
}
