<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import= "java.sql.Connection"%>
<%@page import=  "java.sql.ResultSet" %>
<%@page import= "java.sql.SQLException" %>
<%@page import= "java.sql.Statement" %>
<%@page import= "db.DB" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INICIO</title>
<style>
	.main{
		margin: 0 auto;
		text-align: center;
		background-color: #fed73f;
		border-radius: 0px 0px 20px 20px;
		padding-top: 10px;
		padding-bottom: 10px;
	}
	.btn{
	  height: 2rem;
	  font-size: 1.1rem;
	  border-radius: 5px;
	  border: none;
	  margin-top: 3px;
	  background-color: #354270;
	  color: white;
	  display: inline-block;
	  
	}
	h1{
	display:inline-block;
	}
	form{
	display:inline-block;
	}
	op{
	
	display:inline-block;
	float:right;
	}
	body{
		margin: 0;
		 background-image: url("fundote.jpg ");
		 background-repeat: repeat;
		 
	}
	
</style>
</head>
<body>
	<div class="main">
	<h1>Projeto Interdisciplinar III</h1>
	<div class="op">
	<form ACTION="cadasItens.jsp">
  	<input class="btn" type="submit" value="CADASTRO DE ITENS">
	</form>
	<form ACTION="consultItens.jsp">
  	<input class="btn" type="submit" value="CONSULTAR E GERAR (JSON/XML) OS ITENS">
	</form>
	</div>
	</div>

</body>
</html>