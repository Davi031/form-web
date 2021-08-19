<%@page import="org.senai.dao.PessoaDao"%>
<%@page import="org.senai.model.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/estilo.css">

    <style>
        .bloco-inline label,
        .bloco-inline input,
        .bloco-inline * {
            display: inline;
        }
    </style>
</head>
<body>

	<%
	Pessoa p = new Pessoa();
	try {
		int id = Integer.parseInt(request.getParameter("id"));
		PessoaDao dao = new PessoaDao();
		p = dao.getPessoa(id);
	} catch (Exception e) {
	}
	//out.print(id);
	%>
    <form action="cadastro">
    <input type="hidden" name="id" value="<%=p.getId()%>">
        <fieldset>
            <legend>CADASTRO</legend>
            <img id="img-java" src="img/java.png" alt="imagem java">
            <label for="nome">Nome Completo:</label>
            <input class="larguraTexto" type="text" id="nome" name="nome"
                placeholder="Digite seu nome completo" value="<%=p.getNomeCompleto()%>">
                
            <label for="telefone">Telefone:</label>
            <input class="larguraTexto" type="text" placeholder="(61)9.9999-9999"
            	 id="tel" name="tel" value="<%=p.getTelefone()%>">
            	 
            <label for="dtNascimento">Data de Nascimento:</label>
            <input class="larguraTexto" type="date" 
            	 id="nasc" name="nasc" value="<%=p.getDtNascimento()%>"> 
            
            <label for="email">E-mail:</label>
            <input class="larguraTexto" type="email" id="email"
            	name="email" value="<%=p.getEmail()%>">
            
            <label for="sexo">Sexo:</label>
            <div class="bloco-inline">
                <input type="radio" id="masc" name="sexo" value="m"> <label for="masc"> Masculino</label>
                <input type="radio" id="fem" name="sexo" value="f"> <label for="fem"> Feminino</label>
            </div>
            
            <label for="">Tecnologias:</label>
            <div class="bloco-inline">
                <input type="checkbox" id="html" name="tecnologia" value="html"> <label for="html"> HTML</label>
                <input type="checkbox" id="css" name="tecnologia" value="css"><label for="css"> CSS</label>
                <input type="checkbox" id="java" name="tecnologia" value="java"><label for="java"> Java</label>
                <input type="checkbox" id="php" name="tecnologia" value="php"><label for="php"> PHP</label>
            </div>
            
            <label for="">Escolaridade:</label>
            <select name="escolaridade" id="escolaridade">
                <option value="">Selecione</option>
                <option value="Fundamental">Fundamental</option>
                <option value="Ensino M�dio">Ensino M�dio</option>
                <option value="Superior">Superior</option>
            </select>
            
            <input type="submit" class="bt" value="Enviar">
            <input type="reset" class="bt" value="Limpar">
        </fieldset>
    </form>
    <script type="text/javascript">
		var lsSexo = document.getElementsByName("sexo");
		for (i in lsSexo) {
			if (lsSexo[i].value == '<%=p.getSexo()%>') {
				lsSexo[i].setAttribute('checked', 'checked');
			}
		}
		
		document.getElementById("escolaridade").value = "<%=p.getEscolaridade()%>";
	<%
	for (String t : p.getTecnologia()) {
	out.println("document.getElementById('" + t + "').setAttribute('checked', 'checked')");
	}
	%>
		
	</script>
	<br>
	<a href="index.jsp" class="bt3" style="float: right;">Index</a>
</body>
</html>