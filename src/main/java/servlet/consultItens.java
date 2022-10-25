package servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import db.DB;

@WebServlet("/consultItens")
public class consultItens extends HttpServlet {
	
	

	private static final long serialVersionUID = 1L;
 
    public consultItens() {
        super();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> sele = new ArrayList<>();
		Connection conn = null;
		Statement st1 = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int i;
		try {
			String cod =request.getParameter("coditemMos");
			String tes = request.getParameter("tes");
			conn = DB.getConnection();
			
			
			FileWriter writeFile = null;
			JSONObject objetoJson = new JSONObject();
			if(tes == null) {st = conn.prepareStatement("SELECT * FROM proj_inter.tbitens WHERE (`coditem` = ?)");
			st.setString(1, cod);
			rs = st.executeQuery();
		 
				while(rs.next()) {
					
					sele.add(rs.getString("coditem"));
					sele.add(rs.getString("nomitem"));
					sele.add(rs.getString("marcitem"));
					sele.add(Float.toString(rs.getFloat("valoritem")));
					objetoJson.put("Codigo do item", rs.getString("coditem"));
					objetoJson.put("Nome do item", rs.getString("nomitem"));
					objetoJson.put("Marca do item", rs.getString("marcitem"));
					objetoJson.put("Valor do item", Float.toString(rs.getFloat("valoritem")));
					writeFile = new FileWriter("C:\\Users\\valdi\\OneDrive\\Documentos\\Nova pasta\\dados.json");
					writeFile.write(objetoJson.toString());
					writeFile.close();
					

				}
			}
			else if(tes != null) {
				st = conn.prepareStatement("SELECT * FROM proj_inter.tbitens");
				rs = st.executeQuery();
			 
					while(rs.next()) {
						
						sele.add(rs.getString("coditem"));
						sele.add(rs.getString("nomitem"));
						sele.add(rs.getString("marcitem"));
						sele.add(Float.toString(rs.getFloat("valoritem")));
						objetoJson.put("Codigo do item", rs.getString("coditem"));
						objetoJson.put("Nome do item", rs.getString("nomitem"));
						objetoJson.put("Marca do item", rs.getString("marcitem"));
						objetoJson.put("Valor do item", Float.toString(rs.getFloat("valoritem")));
						writeFile = new FileWriter("C:\\Users\\valdi\\OneDrive\\Documentos\\Nova pasta\\dados.json");
						writeFile.write(objetoJson.toString());
						writeFile.close();
						

					}
			}
				PrintWriter out = response.getWriter();
			    response.setContentType("text/html");

			    out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<meta charset=\"utf-8\">");
			    out.println("<title>CONSULTA DOS ITENS</title>");
			    out.println("<style>");
			    out.println("body {margin: 0; backgroud-color: #fed73f; background-image: url('fundote.jpg');}");   
			    out.println("div {");   
			    out.println("text-align:center;");
			    out.println("border-radius:0px 0px 20px 20px;");
			    out.println("background-color: #fed73f;");
			    out.println("border: 1px solid black;");
			    out.println("}");
			    out.println("form{display:inline-block;}");
			    out.println("input{margin-bottom:20px;}");
			    out.println(".btn{height: 2rem; font-size: 1.1rem; border-radius: 5px; border: none; margin-top: 3px; background-color: #354270; color: white; display: inline-block;}");
			    out.println("</style>");
			    out.println("</head>");
			    out.println("<body>");
			    out.println("<div>");
			    if(sele.size() != 0){
			    	
			    	out.print("<h1>Dado(s) do(s) Itens</h1>");
			    	for (i = 0; i <= sele.size() - 1; i++) {
						   out.println(sele.get(i)+ "<br>"); 
						}
			    	
				out.println("<form action='/ProjetoWeb/downloadJson'><input class='btn' type='submit' value='GERAR JSON'> </form>");
			    out.println("<form action='consultItens.jsp'><br>	<input class='btn' type='submit' value='VOLTAR'> </form>");

			    }else{
			    	out.println("O item não existe! ");
				    out.println("<form action='consultItens.jsp'><br>	<input class='btn' type='submit' value='VOLTAR'> </form>");

			    }
			    out.println("</div>");
			    out.println("</body>");
			    out.println("</html>");
		}catch(SQLException e){
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		 	
	
	
	}

	
	public String gerar() {
		
		String gerar = "dados.json";
		
		return gerar;
	};
}
