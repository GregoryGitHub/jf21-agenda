<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- comentário em JSP aqui: nossa primeira página JSP --%>

    <%
        String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
    %>
    <% out.println(mensagem); %>

    <br />

    <%
        String desenvolvido = "Desenvolvido por (Henrique Gregorio)";
    %>                
    <%= desenvolvido %>

    <br />

    <%
        System.out.println("Tudo foi executado!");
    %>
</body>

</html>