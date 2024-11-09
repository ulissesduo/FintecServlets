<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="br.com.fiap.fintech.Factory.ConnectionFactory" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Investment</title>
</head>
<body>
<h1>Edit Investment</h1>
<form action="investimentos" method="POST">
    <!-- Hidden input field to pass the investment ID -->
    <input type="hidden" name="id" value="${investimento.idInvestimento}" />

    <!-- Field for Tipo Investimento -->
    <label for="tipoInvestimento">Tipo Investimento:</label>
    <select id="tipoInvestimento" name="tipoInvestimento" required>
        <option value="">Select</option>
        <%
            try {
                Connection con = ConnectionFactory.getConnection();
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM tipos_investimentos";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String selected = "";
                    // Get the tipoInvestimento ID from the investimento object, ensuring it's not null
                    Long tipoInvestimentoId = (Long) request.getAttribute("investimento.tipoInvestimento");

                    // Check if tipoInvestimentoId is not null before comparison
                    if (tipoInvestimentoId != null && rs.getLong("ID") == tipoInvestimentoId) {
                        selected = "selected";
                    }
        %>
        <option value="<%= rs.getInt("ID") %>" <%= selected %>><%= rs.getString("Description") %></option>
        <%
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace(); // Log error if needed
            }
        %>

    </select><br><br>
    <!-- Field for Valor Investido -->
    <label for="valorInvestido">Valor Investido:</label>
    <input type="text" id="valorInvestido" name="valorInvestido" value="${investimento.valorInvestido}" required /><br><br>

    <!-- Field for Data Início -->
    <label for="dataInicio">Data Início:</label>
    <input type="date" id="dataInicio" name="dataInicio" value="${investimento.dataInicio}" required /><br><br>

    <!-- Field for Data Resgate -->
    <label for="dataResgate">Data Resgate:</label>
    <input type="date" id="dataResgate" name="dataResgate" value="${investimento.dataResgate}" required /><br><br>

    <label for="usuarioIdUsuario">User ID:</label>
    <input type="number" id="usuarioIdUsuario" name="usuarioIdUsuario" value="${investimento.usuarioId}" required /><br><br>

    <!-- Submit Button -->
    <button type="submit">Update</button>
</form>

</body>
</html>
