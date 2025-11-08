import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {

    Connection con;
    PreparedStatement pstAll, pstSearch;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company", "root", "password");

            pstAll = con.prepareStatement("SELECT * FROM employee");
            pstSearch = con.prepareStatement("SELECT * FROM employee WHERE EmpID=?");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String empID = req.getParameter("empid");

        try {
            ResultSet rs;

            if (empID != null && !empID.equals("")) {
                pstSearch.setInt(1, Integer.parseInt(empID));
                rs = pstSearch.executeQuery();
                out.println("<h2>Search Result</h2>");
            } else {
                rs = pstAll.executeQuery();
                out.println("<h2>All Employees</h2>");
            }

            out.println("<table border='1' cellpadding='5'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Salary</th></tr>");

            boolean found = false;

            while (rs.next()) {
                found = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("EmpID") + "</td>");
                out.println("<td>" + rs.getString("Name") + "</td>");
                out.println("<td>" + rs.getInt("Salary") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            if (!found) {
                out.println("<p>No employee found!</p>");
            }

            out.println("<br><a href='index.html'>Back</a>");

        } catch (Exception e) {
            out.println("Error: " + e);
        }
    }

    public void destroy() {
        try {
            con.close();
        } catch (Exception e) { }
    }
}
