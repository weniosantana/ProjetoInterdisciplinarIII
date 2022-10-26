package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import servlet.consultItens;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadXML")
public class downloadXML extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public downloadXML() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int i;
		consultItens ms = new consultItens();
		PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    String filename = ms.gerarXML(); 
		  response.setContentType("APPLICATION/OCTET-STREAM");   
		  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
		  java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filename);
		  while (( i=fileInputStream.read()) != -1) {  
		  out.write(i);   
		  }   
		 fileInputStream.close();
	}
}
