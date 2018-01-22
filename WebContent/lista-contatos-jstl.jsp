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

	<c:import url="cabecalho.jsp" />
    <body>
        <table border="0">
        		<thead>
	        		<th>NOME</th>
	        		<th>E-MAIL</th>
	        		<th>ENDEREÇO</th>
	        		<th>DATA NASCIMENTO</th>
	        		<th>AÇÃO</th>
        		</thead>
        		<tbody>
			<!--Percorre todos os elementos da lista -->
			<c:forEach var="contato" items="${dao.all}" varStatus="id" >
                <tr bgcolor="#${id.count % 2 == 0 ? 'DDD' : 'FFFFFF' }"> 
                    <td>${ contato.nome }</td> 
                    
                    <c:choose>
                    		<c:when test="${ not empty contato.email }">
                    			<td><a href="mailto: ${ contato.email } " >${ contato.email }</a></td>
                    		</c:when>
                    		<c:otherwise>
                    			<td>E-Mail não informado.</td>
                    		</c:otherwise>
                    </c:choose>
                    
                    <td>${ contato.endereco }</td>
                    <td>
                    		<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
        				</td>
        				<td>
                    		<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
        				</td>
                </tr>
			</c:forEach>
            </tbody>
        </table>
        <c:import url="rodape.jsp" />
    </body>
</html>