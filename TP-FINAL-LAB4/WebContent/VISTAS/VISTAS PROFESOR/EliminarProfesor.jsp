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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="Styles/Styles.css" />
<link rel="stylesheet" href="Styles/mini-lib.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" />


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
          <a class="nav-link active" aria-current="page" href="VISTAS/HOME.jsp" id="listarProfesores" name="listarProfesores">Home</a>
        </li>
      
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="servletListarProfesor" id="listarProfesores" name="listarProfesores">Profesores</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="servletListarAlumnos">Alumnos</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link"  href="VISTAS/CURSOS/TodosLosCursos.jsp">Cursos</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link" class="nav-link"  href="servletListarUsarios">Usuarios</a>
        </li>
        
      </ul>
      
      <%

   Usuario usuario = (Usuario)session.getAttribute("usuario");

%>
      
      <form class="flex-evenly-container align-items-center" method ="Post" action="servletCerrarSession">
        <h5 class="user-name"><%=usuario.getUser_Name() %></h5>
        <input class="btn accent" type="submit" value="Cerrar sesi�n"/>
      </form>
      
    </div>
  </div>
      
    </div>
  </div>
  
</nav>


<h1 class="table-title">Eliminar profesor</h1>
<div class="row">
<div class="full-width flex-column">

	<div class="flex-center-container flex-column max-width-container">
	
<section class="form__container full-width flex-center-container">
  <div class="form__container__heading">
  
  
  <%
     Docente docente = new Docente();
     docente = (Docente)request.getAttribute("docenteEliminar"); 
  
  
  %>
  
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
  
  <form class="form max-width-container"  method="Post" action="servletEliminarProfesor">
  
  <input required type="hidden" name="idProfesor" id="id" value="<%=docente.getIdDocente()%>">
  
  
  	<div class="form__input-container">
      <label for="firstname">Legajo</label>
      <input disabled type="number" name="firstname" id="firstname" value="<%=docente.getLegajo()%>">
    </div>
  

    <div class="form__input-container">
      <label for="firstname">Nombre</label>
      <input disabled type="text" name="firstname" id="firstname" value="<%=docente.getNombre()%>" >
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Apellido</label>
      <input disabled type="text" name="firstname" id="firstname" value="<%=docente.getApellido()%>" >
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Email</label>
     <input disabled type="text" name="firstname" id="firstname" value="<%=docente.getEmail()%>" >
    </div>
    
    
    <div class="form__input-container">
      <label for="lastname">Telefono</label>
      <input disabled type="text" name="firstname" id="firstname"value="<%=docente.getTelefono()%>" >
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Direccion</label>
     <input disabled type="text" name="firstname" id="firstname" value="<%=docente.getAdress()%>" >
    </div>
    
    
    
    <div class="form__input-container">
      <label for="document_type" >Pa�s</label>
         <select name="paises" disabled>
    <%
            
         for(Pais pais : listaPaises)
         {
        	 %>
        	    <option value=<%=pais.getIdPais()%>
        	    
        	    <%if(docente.getPais().getIdPais()==pais.getIdPais()){%> selected <%} %>
        	    
        	    >
        	    <%=pais.getNombrePais()%></option>
        	 <%
         }
     
     
     %>   
          </select>
    </div>

    <div class="form__input-container">
      <label for="document_type" >Provincia</label>
      	  <select name="provincias" disabled>
    <%
            
         for(Provincia prov : listaProvincias)
         {
        	 %>
        	    <option value=<%=prov.getIdProvincia()%>
        	    
        	    <%if(docente.getProvincia().getIdProvincia()==prov.getIdProvincia()){%> selected <%} %>
        	    
        	    ><%=prov.getNombreProvincia()%></option>
        	 <%
         }
     
     
     %>   
          </select>
      
    </div>
    
    <div class="form__input-container">
      <label for="document_type">Localidad</label>
      	
      	<select name="localidades" disabled>
    <%
            
         for(Localidad loc : listaLocalidades)
         {
        	 %>
	        	    <option value=<%=loc.getIdLocalidad()%>
	        	    
	        	    <%if(docente.getLocalidad().getIdLocalidad()==loc.getIdLocalidad()){%> selected <%} %>
        	    
        	    ><%=loc.getNombre()%></option>
        	 <%
         }
     
     
     %>   
      </select>
         	
    </div>
    <div class="form__input-container"></div>
	<div class="form__input-container" style=" width: 100%"></div>
    <button class="form__btn-sumbit" type="submit">Eliminar</button>
  </form>

</section>
	
	</div>

</div>
</div>





</main>

</body>
</html>