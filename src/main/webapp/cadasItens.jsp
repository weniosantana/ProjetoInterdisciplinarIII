<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CADASTRAR ITENS</title>
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
	  background-color: #b5915c;
	  color: black;
	}

	.textarea{
		border-radius: 0.4rem;
	    position: relative;
	  	background-color: #fcffff; 
	  	border: black 0.1rem solid;
	  	width: 20rem;
	  	height: 2rem;
	  	padding: 0rem 1rem;
	  	font-size: 1.4rem;
		margin-top:5px;
		margin-bottom:5px;	 	  
	
	}
	label{
		
	
	}
	.btn{
	  height: 2rem;
	  font-size: 1.1rem;
	  border-radius: 5px;
	  border: none;
	  background-color: #354270;
	  color: white;
	  display: inline-block;
	  
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
	<form action="/ProjetoWeb/cadasItens">
		<label>Codigo do Item:</label><br>
		<input class="textarea" type="text" name="coditem"><br>
		<label>Nome do Item:</label><br>
		<input class="textarea" type="text" name="nomitem"><br>
		<label>Marca do Item:</label><br>
		<input  class="textarea" type="text" name="marcitem"><br>
		<label>Valor do Item:</label><br>
		<input  class="textarea"  type="text" name="valoritem"><br>
		<input class="btn" type="submit" value="CADASTRAR">
	</form>
	
	<form action='index.jsp'>	
	<input class='btn' type='submit' value='VOLTAR'> 
	</form>
	
	</div>
</body>
</html>