<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listando com JSTL</title>
</head>
	<!-- 	Importando as Taglibraries -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<!--    Criando o DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.modelo.dao.ContatoDao"/>
	<c:import url="cabecalho.jsp" />
    <body>
        <% request.setAttribute( "test", new br.com.caelum.modelo.dao.ContatoDao().getAll() ); %>

		<display:table name="test" >
			<display:column property="Nome" />
		    <display:column property="email" />
		    <display:column property="endereço" />
		    <display:column property="data Nascimento" />
		</display:table>
        <c:import url="rodape.jsp" />
    </body>
</html>