import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {

    Connection con;
    PreparedStatement pst;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/school", "root", "password");

            pst = con.prepareStatement("INSERT INTO attendance VALUES (?, ?, ?)");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String sid = req.getParameter("sid");
        String date = req.getParameter("date");
        String status = req.getParameter("status");

        try {
            pst.setInt(1, Integer.parseInt(sid));
            pst.setString(2, date);
            pst.setString(3, status);

            int result = pst.executeUpdate();

            if (result > 0) {
                out.println("<h2>Attendance Saved Successfully!</h2>");
                out.println("<a href='attendance.jsp'>Mark Another</a>");
            } else {
                out.println("<h2>Failed to Save Attendance!</h2>");
            }

        } catch (Exception e) {
            out.println("Error: " + e);
        }
    }

    public void destroy() {
        try { con.close(); } catch (Exception e) {}
    }
}
