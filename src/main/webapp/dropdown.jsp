<%@ page import="br.com.fiap.fintech.Factory.ConnectionFactory" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <label for="tipoInvestimento">Investment Type:</label>
        <select id="tipoInvestimento" name="tipoInvestimento" required>
            <option>Select</option>
            <%
                try{
                    Connection con = ConnectionFactory.getConnection();
                    Statement stmt = con.createStatement();
                    String query = "select * from tipos_investimentos";
                    ResultSet rs = stmt.executeQuery(query);
                    while(rs.next()){
                    %>
                        <option value="<%=rs.getInt("ID") %>"> <%=rs.getString("Description") %> </option>

                    <%
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();  // Optional: to print the error to the server logs
                }

                %>
        </select>

</body>
</html>
