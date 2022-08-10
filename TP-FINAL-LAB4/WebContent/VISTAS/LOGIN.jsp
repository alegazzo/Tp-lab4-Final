<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TMT | Login</title>
</head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="../Styles/Styles.css" />
<link rel="stylesheet" href="../Styles/mini-lib.css" />

<body>


	<div class="full-width-height flex-center-container">
		
		<div class="login-form-container max-width-container full-height flex-center-container flex-column align-center-container">
		
			<form class="login-form flex-column" method="Post" action="../servletLogin">
				
				<img class="login-img" src="../Assets/login-comune.png" />
				
				<label>Usuario</label>
				<input type="text" name="user">
				
				<label>Contraseña</label>
				<input type="password" name="pass">
				
				<input type="submit" class="btn accent text-white mt-4" value="Ingresar"> 
			   
			</form>
		
		</div>
	
	</div>



</body>
</html>