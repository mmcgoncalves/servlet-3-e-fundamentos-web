<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>
<c:if test="${not empty usuarioLogado}">
    Você está logado como ${usuarioLogado.email}<br/>
</c:if>
<form action="fazTudo?tarefa=NovaEmpresa" method="post">
    Nome: <input type="text" name="nome" /><br/>
    <input type="submit" value="Enviar" />
</form>
<form action="login" method="post">
    Email: <input type="text" name="email" /><br/>
    Senha: <input type="password" name="senha" /><br/>
    <input type="submit" value="Login" />
</form>

<form action="executa" method="post">
    <input type="hidden" name="tarefa" value="logout" />
    <input type="submit" value="logout" />
</form>

</body>
</html>