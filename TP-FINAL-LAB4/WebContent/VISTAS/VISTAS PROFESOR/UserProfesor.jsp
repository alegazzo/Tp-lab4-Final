<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import ="Dominio.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="Styles/Styles.css" />
<link rel="stylesheet" href="Styles/mini-lib.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profesores</title>
</head>
<body>

<main class="main-container">

 <nav class="navbar navbar-expand-lg navbar-dark full-width flex-center-container"> 
  
  <div class="container-fluid max-width-container">
  
    <a class="navbar-brand flex-center-container" href="#">
    	<img src="./Assets/logo.png" />
    </a>
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      </ul>
      
      
        <%

   Usuario usuario = (Usuario)session.getAttribute("usuario");

%>
      
      <form class="flex-evenly-container align-items-center" method ="Post" action="servletCerrarSession">
        <h5 class="user-name"><%=usuario.getUser_Name() %></h5>
        <input class="btn accent" type="submit" value="Cerrar sesión"/>
      </form>
      
    </div>
  </div>
  
</nav>

<!-- Modal -->
<%
  if(request.getAttribute("errorUserName")==null){
	  
	  %>
	  
	  
		  <div class="modal fade show mt-5" id="modal" style="display:block;" tabindex="1" aria-labelledby="exampleModalLabel" aria-hidden="false">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" style="color:green" id="exampleModalLabel">Success!</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body" style="color:black">
	         <%=request.getAttribute("action") %>
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="btnCerrar" class="btn btn-warning" data-bs-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	 
	  <% 
  }

  else{
	  
	  %><h1 style ="color:red"> USER NAME NO DISPONIBLE </h1><%
  }

%>

<% int referencia = Integer.parseInt(request.getAttribute("idGenerado").toString()); %>

 <div class="container">
            <h1 class="table-title">Nuevo Usuario</h1>
            <div class="row justify-content-center mb-3">
                <div class="col-md-4 mt-4" style="text-align: center;">
                    <h3>Profesor :  <span style="color: #F5B7B1"> <%=request.getAttribute("nuevoUser") %> </span></h3>
                </div>
            </div>

             <br/>
             <br/>
            <div class="login-form-container max-width-container full-height flex-center-container flex-column align-center-container">
            <form class="flex-column" method="Post" action="servletUserProfesor">
            
                <input type="hidden" name="referencia" value="<%=referencia %>">
				
				<label>Usuario</label>
				<input type="text" name ="usuario" id="usuario" required>
				  <br/>
				<label>Contraseña</label>
				<input type="password" name ="pass" id="pass" required>
				
				<input type="submit" value="Asignar" class="btn accent text-white mt-4">
			</form>
			 </div>
           
            
          </div>








</main>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</html>
<script>

$('#btnCerrar').click(function(){ 
   $('#modal').hide();
});

</script>