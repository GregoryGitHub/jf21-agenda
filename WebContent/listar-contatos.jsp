<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<%@ page import="
		java.util.*,
		br.com.caelum.modelo.dao.*,
		br.com.caelum.modelo.* ,
		java.text.*"
	%>

    <body>
        <table>
        		<thead>
	        		<th>NOME</th>
	        		<th>E-MAIL</th>
	        		<th>ENDEREÇO</th>
	        		<th>DATA NASCIMENTO</th>
        		</thead>
        		<tbody>
            <%
            ContatoDao dao = new ContatoDao();
            List<Contato> contatos = dao.getAll();

            for (Contato contato : contatos ) {
            		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
            		String data = sdf.format(contato.getDataNascimento().getTime());
            %>
                <tr>
                    <td><%=contato.getNome() %></td> 
                    <td><%=contato.getEmail() %></td>
                    <td><%=contato.getEndereco() %></td>
                    <td><%=data %></td>
                </tr>
            <%
            }
            %>
            </tbody>
        </table>
    </body>
</html>