package servletJDBCconnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("insert into studentregistration values(?, ?, ?, ?, ?, ?)");
			st.setInt(1, Integer.valueOf(request.getParameter("id")));
			st.setString(2, request.getParameter("name"));
			st.setInt(3, Integer.valueOf(request.getParameter("grade")));
			st.setString(4,request.getParameter("address"));
			st.setString(5, request.getParameter("subject"));
			st.setInt(6, Integer.valueOf(request.getParameter("gpa")));
			
			st.executeUpdate();
			st.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Inserted</b>"+
					"<table>"
					+ "<th><tr>id><tr>"
					+ ""
					+ ""
					+ ""
					+ "</table>"
					
                   
                    + "</body></html>");
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}

