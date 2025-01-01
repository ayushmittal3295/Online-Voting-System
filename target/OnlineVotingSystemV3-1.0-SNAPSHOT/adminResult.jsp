<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Results</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<jsp:include page="adminHeader.jsp"></jsp:include>

<%
    String s1 = (String) session.getAttribute("adminName");
    if (s1 == null) {
        response.sendRedirect("adminPanel.jsp");
        return;
    }

    HashMap<String, String> count = new HashMap<String, String>();
    HashMap<String, Integer> countInt = new HashMap<String, Integer>();

    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting", "root", "root");

        String sql = "select * from partytable";
        PreparedStatement statement = con.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery("select voter, count(voter) as c from voter group by voter");

        while (resultSet.next()) {
            count.put(resultSet.getString("voter"), resultSet.getString("c"));
            countInt.put(resultSet.getString("voter"), Integer.parseInt(resultSet.getString("c")));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>

<div class="limiter">
    <div class="container">
        <h1>Voting Results</h1>
        <table border="1">
            <tr>
                <th>Voter</th>
                <th>Count</th>
            </tr>
            <%
                for (Map.Entry<String, Integer> entry : countInt.entrySet()) {
                    out.println("<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
                }
            %>
        </table>
    </div>
</div>

<jsp:include page="adminFooter.jsp"></jsp:include>
</body>
</html>