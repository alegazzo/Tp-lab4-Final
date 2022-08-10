<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="Dominio.Docente" %>
    <%@page import ="Dominio.Pais" %>
    <%@page import ="Dominio.Provincia" %>
    <%@page import ="Dominio.Localidad" %>
    <%@page import ="java.util.ArrayList" %>
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
      
        <li class="nav-item">
           <a class="nav-link active" aria-current="page" href="servletHome">Home</a>
        </li>
    
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
      
    </div>
  </div>
  
</nav>


<h1 class="table-title">Agregar profesor</h1>



 <%    
         ArrayList<Pais> listaPaises = new ArrayList<Pais>();
         if(request.getAttribute("paises")!=null)
         {
        	 listaPaises = (ArrayList<Pais>)request.getAttribute("paises"); 
        	 
         }
         
         ArrayList<Provincia> listaProvincias = new ArrayList<Provincia>();
         if(request.getAttribute("provincias")!=null)
         {
        	 listaProvincias = (ArrayList<Provincia>)request.getAttribute("provincias"); 
        	 
         }
         
         ArrayList<Localidad> listaLocalidades = new ArrayList<Localidad>();
         if(request.getAttribute("localidades")!=null)
         {
        	 listaLocalidades = (ArrayList<Localidad>)request.getAttribute("localidades"); 
        	 
         }
   
   
   %>








<div class="row">

<div class="full-width flex-column">

	<div class="flex-center-container flex-column max-width-container">
	
<div class="form__container full-width flex-center-container">
  <div class="form__container__heading">


  <form class="form max-width-container" method="Post" action="servletAgregarProfesor">
  
  	<div class="form__input-container">
      <label for="firstname">Legajo</label>
      <input required type="text" maxlength="10" name="legajo" >
    </div>
    
    	<div class="form__input-container">
      <label for="firstname">DNI</label>
      <input required type="text" name="dni" maxlength="10">
    </div>
  

    <div class="form__input-container">
      <label for="firstname">Nombre</label>
      <input required type="text" name="nombre" maxlength="15">
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Apellido</label>
      <input required type="text" name="apellido" maxlength="15">
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Email</label>
      <input required type="email" name="email" maxlength="50">
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Fecha Nacimiento</label>
      <input required type="date" name="fecha" maxlength="20">
    </div>
    
    
    <div class="form__input-container">
      <label for="lastname">Telefono</label>
      <input required type="phone" name="telefono" maxlength="20">
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Direccion</label>
      <input required type="text" name="direccion" maxlength="20">
    </div>
    
    
    
    <div class="form__input-container">
      <label for="document_type">País</label>
      <select name="paises">
    <%
            
         for(Pais pais : listaPaises)
         {
        	 %>
        	    <option value=<%=pais.getIdPais()%>><%=pais.getNombrePais()%></option>
        	 <%
         }
     
     
     %>   
          </select>
    </div>

    <div class="form__input-container">
      <label for="document_type">Provincia</label>
      <select name="provincias">
    <%
            
         for(Provincia prov : listaProvincias)
         {
        	 %>
        	    <option value=<%=prov.getIdProvincia()%>><%=prov.getNombreProvincia()%></option>
        	 <%
         }
     
     
     %>   
          </select>
    </div>
    
    <div class="form__input-container">
      <label for="document_type">Localidad</label>
      <select name="localidades">
    <%
            
         for(Localidad loc : listaLocalidades)
         {
        	 %>
	        	    <option value=<%=loc.getIdLocalidad()%>><%=loc.getNombre()%></option>
        	 <%
         }
     
     
     %>   
      </select>
    </div>
	<div class="form__input-container"></div>
	<div class="form__input-container" style=" width: 100%"></div>
    <button class="form__btn-sumbit accent" type="submit">Agregar</button>
  
  </form>
</div>
</div>
	
	</div>

</div>
</div>

</main>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</html>