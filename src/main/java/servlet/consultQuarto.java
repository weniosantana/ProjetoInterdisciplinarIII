package servlet;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import dados.Dados;
import db.DB;
@WebServlet("/consultQuarto")
public class consultQuarto extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public consultQuarto() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> sele = new ArrayList<>();
		List<Dados> da = new ArrayList();
		XStream xstream = new XStream(new DomDriver());
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String xml = null;
		int i;
		try {
			String cod =request.getParameter("nquartoMos");
			conn = DB.getConnection();
			FileWriter writeFile = null;
			FileWriter writeFile1 = null;
			JSONObject objetoJson = new JSONObject();
			st = conn.prepareStatement("SELECT * FROM proj_inter.tbquartos WHERE (`nquarto` = ?)");
			st.setString(1, cod);
			rs = st.executeQuery();	 
				while(rs.next()) {
					sele.add(rs.getString("nquarto"));
					sele.add(rs.getString("nomequarto"));
					sele.add(rs.getString("tipoquarto"));
					sele.add(Float.toString(rs.getFloat("valorquarto")));
					da.add(new Dados(rs.getString("nquarto"), rs.getString("nomequarto"), rs.getString("tipoquarto"), rs.getFloat("valorquarto")));
					xml = xstream.toXML(da);
					objetoJson.put("Numero do Quarto", rs.getString("nquarto"));
					objetoJson.put("Nome do Quarto", rs.getString("nomequarto"));
					objetoJson.put("Tipo do Quarto", rs.getString("tipoquarto"));
					objetoJson.put("Valor do Quarto", Float.toString(rs.getFloat("valorquarto")));
					writeFile = new FileWriter("dados.json");
					writeFile1 = new FileWriter("dados.xml");
					writeFile.write(objetoJson.toString());
					writeFile1.write(xml);
					writeFile.close();
					writeFile1.close();
				}
				PrintWriter out = response.getWriter();
			    response.setContentType("text/html");
			    out.println("<!DOCTYPE html>");
			    out.println("<html>");
			    out.println("<head>");
			    out.println("<meta charset=\"utf-8\">");
			    out.println("<title>CONSULTA DOS QUARTOS</title>");
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
			    	out.print("<h1>Dado(s) do(s) Quarto(s)</h1>");
			    	for (i = 0; i <= sele.size() - 1; i++) {
						   out.println(sele.get(i)+ "<br>"); 
						}
				out.println("<form action='/ProjetoWeb/downloadXML'><input class='btn' type='submit' value='GERAR XML'> </form>");
				out.println("<form action='/ProjetoWeb/downloadJson'><input class='btn' type='submit' value='GERAR JSON'> </form>");
			    out.println("<form action='consultQuarto.jsp'><br>	<input class='btn' type='submit' value='VOLTAR'> </form>");
			    }else{
			    	out.println("O Quarto n??o existe! ");
				    out.println("<form action='consultQuarto.jsp'><br>	<input class='btn' type='submit' value='VOLTAR'> </form>");

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
	public String gerarJSON() {
		String gerar = "dados.json";
		return gerar;
	};
	public String gerarXML() {
		String gerar = "dados.xml";
		return gerar;
	};
}
