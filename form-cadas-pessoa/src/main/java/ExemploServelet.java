import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exemplo")
public class ExemploServelet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		PrintWriter saida = res.getWriter();
		saida.println("<html>");
		saida.println("<body>Ol� Mundo do Servlet "+nome+"</body>");
		saida.println("</html>");
	}
}