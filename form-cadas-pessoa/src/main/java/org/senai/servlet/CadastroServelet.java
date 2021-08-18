/*package org.senai.servlet;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.senai.db.Conexao;

import com.sun.jdi.connect.spi.Connection;
@WebServlet("/cadastro")
public class CadastroServelet extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		String nome = req.getParameter("nome");
		String tel = req.getParameter("tel");
		String nasc = req.getParameter("nasc");
		
		String email = req.getParameter("email");
		String sexo = req.getParameter("sexo");
		String[] tecnologia = req.getParameterValues("tecnologia");
		String escolaridade = req.getParameter("escolaridade");
		
		PrintWriter saida = res.getWriter() ;
		saida.println("<html>");
		saida.println("<body> Nome: "+nome+" Tel: "
				+tel+ " Nascimento: "+nasc+
				"Email: "+email+" sexo: "+sexo
				+" Escolaridade: "+escolaridade+" Tecnologias: ");
				
				String lsTecnologia = "";
				for(String t: tecnologia) {
					saida.println(t);
					lsTecnologia+=t+", ";
				}
		
		
		
		try {
			
			saida.println("Ok para conex�o");
			
			String sql = "insert into pessoa(nome, tel, nasc, email, sexo, tecnologia, escolaridade) \r\n"
					+ "values('"+nome+"','"+tel+"','"+nasc+"','"+email+"','"+sexo+"','"+lsTecnologia+"','"+escolaridade+"');";
			
			Connection cont = (Connection) Conexao.conectar();
			
			if(cont != null) {
				PreparedStatement pst = ((java.sql.Connection) cont).prepareStatement(sql);
				pst.execute();
				pst.close();
				cont.close();
			
				saida.println("Registro gravado. ");
			}else {
				saida.println("Erro de conex�o. ");
			}
			
		} catch (Exception e) {
			saida.println("Erro de conex�o."+e);
			
		}
		
		saida.println("</body><html>");
		
	}
}*/
package org.senai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.dao.PessoaDao;
import org.senai.model.Pessoa;

@WebServlet("/cadastro")
public class CadastroServelet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Pessoa objP = new Pessoa();
		String acao = req.getParameter("acao");
		
		if (acao != null && acao.equals("apagar")) {
			objP.setId(Integer.parseInt(req.getParameter("id")));
		} else {
			objP.setNomeCompleto(req.getParameter("nome"));
			objP.setTelefone(req.getParameter("tel"));
			objP.setDtNascimento(req.getParameter("nasc"));
			objP.setEmail(req.getParameter("email"));
			objP.setSexo(req.getParameter("sexo"));
			objP.setTecnologia(req.getParameterValues("tecnologia"));
			objP.setEscolaridade(req.getParameter("escolaridade"));
			objP.setId(Integer.parseInt(req.getParameter("id")));
		}

		PessoaDao objDao = new PessoaDao();
		
		boolean validar = false;

		if (objP.getId() > 0) {
			if (acao != null && acao.equals("apagar")) {
				validar = objDao.apagar(objP.getId());
			} else {
				validar = objDao.alterar(objP);
			}
		} else {
			validar = objDao.adicionar(objP);
		}

		if (validar) {
			res.sendRedirect("listaPessoas.jsp");
		} else {
			PrintWriter saida = res.getWriter();
			saida.println("<html>");
			saida.println("Erro ao gravar.");
			saida.println("</html>");
		}


	}

}