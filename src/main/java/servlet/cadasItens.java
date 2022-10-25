package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;


@WebServlet("/cadasItens")
public class cadasItens extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public cadasItens() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection conn = null;
		Statement st1 = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			int coditem = Integer.parseInt(request.getParameter("coditem"));
			String nomitem =request.getParameter("nomitem");
			String marcitem =request.getParameter("marcitem");
			float valoritem = Float.parseFloat(request.getParameter("valoritem"));
			
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"Insert into tbitens (coditem, nomitem, marcitem, valoritem) values (?,?,?,?)"
					);
			st.setInt(1, coditem);
			st.setString(2, nomitem);
			st.setString(3, marcitem);
			st.setFloat(4, valoritem);
			
			st.executeUpdate();
						
		}catch(SQLException e){
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
		};
	
	
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta charset=\"utf-8\">");
	    out.println("<title>Teste</title>");
	    out.println("<style>");
	    out.println("body {margin: 0; backgroud-color: #fed73f; background-image: url('fundote.jpg');}");   
	    out.println("div {");   
	    out.println("text-align:center;");
	    out.println("border-radius:0px 0px 20px 20px;");
	    out.println("background-color: #fed73f;");
	    out.println("border: 1px solid black;");
	    out.println("}");
	    out.println("input{margin-bottom:20px;}");
	    out.println(".btn{height: 2rem; font-size: 1.1rem; border-radius: 5px; border: none; margin-top: 3px; background-color: #354270; color: white; display: inline-block;}");

	    out.println("</style>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<div>");
	    out.println("<H1>ITEM ADICIONADO!</H1>");
	    out.println("<form action='index.jsp'><br>	<input class='btn' type='submit' value='VOLTAR'> </form>");
	    out.println("</div>");
	    out.println("</body>");
	    out.println("</html>");	


	}

}