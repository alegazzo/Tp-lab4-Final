<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import ="Dominio.Alumno" %>
    <%@page import ="Dominio.Pais" %>
    <%@page import ="Dominio.Provincia" %>
    <%@page import ="Dominio.Localidad" %>
    <%@page import ="Dominio.Usuario" %>
    <%@page import ="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<%
     Alumno alumno = new Alumno();
     alumno = (Alumno)request.getAttribute("AlumnoEliminar"); 


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

<h1 class="table-title">Eliminar alumno</h1>
<div class="row">
<div class="full-width flex-column">

	<div class="flex-center-container flex-column max-width-container">
	
<section class="form__container full-width flex-center-container">
  <div class="form__container__heading">


   <form class="form max-width-container" method="Post" action="servletEliminarAlumno">

	<input required type="hidden" name="idAlumno" id="id" value="<%=alumno.getIdAlumno()%>" >

    <div class="form__input-container">
      <label for="firstname">Nombre</label>
      <input required type="text" name="nombre" id="nombre" maxlength="15" value="<%=alumno.getNombre()%>" disabled>
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Apellido</label>
      <input required type="text" name="apellido" id="apellido" maxlength="15" value="<%=alumno.getApellido()%>" disabled>
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Email</label>
      <input required type="email"  id="email" name="email" maxlength="50" value="<%=alumno.getEmail()%>" disabled>
    </div>
    
    
    <div class="form__input-container">
      <label for="lastname">Telefono</label>
      <input required type="phone"  name="telefono" id="telefono" maxlength="20" value="<%=alumno.getTelefono()%>" disabled>
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Nacimiento</label>
      <input required type="date"  name="fecha" id="fecha" value="<%=alumno.getFecha_Nacimiento()%>" disabled>
    </div>
    
    <div class="form__input-container">
      <label for="lastname">Direccion</label>
      <input required type="text" name="direccion" id="direccion" maxlength="20" value="<%=alumno.getAdress()%>" disabled>
    </div>
    
    
    
    <div class="form__input-container">
      <label for="document_type">Pais</label>
       <select name="paises" disabled>
    <%
            
         for(Pais pais : listaPaises)
         {
             %>
                <option value=<%=pais.getIdPais()%>
                
                <%if(alumno.getPais().getIdPais()==pais.getIdPais()){%> selected <%} %>
                
                >
                <%=pais.getNombrePais()%></option>
             <%
         }
     
     
     %>   
          </select>
      
    </div>

    <div class="form__input-container">
      <label for="document_type">Provincia</label>
      
      <select name="provincias" disabled>
    <%
            
         for(Provincia prov : listaProvincias)
         {
             %>
                <option value=<%=prov.getIdProvincia()%>
                
                <%if(alumno.getProvincia().getIdProvincia()==prov.getIdProvincia()){%> selected <%} %>
                
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
                    
                    <%if(alumno.getLocalidad().getIdLocalidad()==loc.getIdLocalidad()){%> selected <%} %>
                
                ><%=loc.getNombre()%></option>
             <%
         }
     
     
     %>   
      </select>
      
    </div>
     <button class="form__btn-sumbit accent" type="submit">Eliminar</button>
  </form>

</section>
	
	</div>

</div>

	</div>





</main>

</body>
</html>