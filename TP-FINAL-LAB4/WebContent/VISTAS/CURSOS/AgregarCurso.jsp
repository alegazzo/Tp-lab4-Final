<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import ="java.util.ArrayList" %>
<%@page import ="Dominio.Alumno" %>
<%@page import ="Dominio.Materia" %>
<%@page import ="Dominio.Docente" %>
  <%@page import ="Dominio.Usuario" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>

<link rel="stylesheet" href="Styles/Styles.css" />
<link rel="stylesheet" href="Styles/mini-lib.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" />

<body>

<main class="main-container">

   <nav class="navbar navbar-expand-lg navbar-dark full-width flex-center-container"> 
  
  <div class="container-fluid max-width-container">
  
    <a class="navbar-brand flex-center-container" href="#">
    	<img src="Assets/logo.png" />
    </a>
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="servletHome" >Home</a>
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
<!-- Fin navbar -->

<% 
// LISTA DOCENTES
ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
if(request.getAttribute("listaDocentes")!=null)
{
listaDocentes = (ArrayList<Docente>)request.getAttribute("listaDocentes");
}
// LISTA ALUMNO
ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
if(request.getAttribute("listaAlumnos")!=null)
{
listaAlumnos = (ArrayList<Alumno>)request.getAttribute("listaAlumnos");
}
// LISTA MATERIAS
ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
if(request.getAttribute("listaMaterias")!=null)
{
listaMaterias = (ArrayList<Materia>)request.getAttribute("listaMaterias");
}
%>

 <div class="container">
 
 <div class="row justify-content-center mb-3">
            <div class="col-md-4 mt-3"  style="text-align:center; border-radius: 20px;">
                <h1 class="h1">Agregar Curso</h1>
            </div>
        </div>
 
<form method = "Post" action = "servletAgregarCurso">
    <div class="row justify-content-center mt-5">
      <div class="col-md-4">
        			
        			<label for="lastname" class="px-3" style="font-size: 2rem">Nombre : </label>
        			<input type = "text" name ="nombreCurso"> </input>
        			<label for="lastname" class="px-3" style="font-size: 2rem">Semestre : </label>
        			<input type = "text" name ="semestreCurso"> </input>
        			<label for="lastname" class="px-3" style="font-size: 2rem">Año : </label>
        			<input type = "text" name ="anioCurso"> </input>
        			<label for="lastname" class="px-3" style="font-size: 2rem">Profesor : </label>
       
       				<select name="Profesor" id="document_type">
       							<% for (Docente Docente : listaDocentes){ %>
	                            <option value="<%= Docente.getIdDocente() %>"><%= Docente.getNombre() %>   <%= Docente.getApellido() %></option>
	                            <%
		                        }
		                        %>
	                               
                    </select>
      
      </div>
       
    </div>
    
    <div class="row justify-content-center mt-5">
      <div class="col-md-4">
        
        			<label for="lastname" class="px-3" style="font-size: 2rem">Materia : </label>
       
       				<select name="Materia" id="document_type">
	                            <% for (Materia materia : listaMaterias){ %>
	                            <option value="<%= materia.getIdMateria() %>"><%= materia.getNombreMateria() %>  </option>
	                            <%
		                        }
		                        %>
                    </select>
 
      </div>
       
    </div>
    
    
    <div class="row justify-content-center mt-5">
            <div class="col-md-4 mt-3"  style="text-align:center; border-radius: 20px;">
                <h3 class="h3">Listado de Alumnos</h3>
            </div>
        </div>
    
    <div class="row">
      <table id="table-1" class="display table table-light table-hover">
	                    <thead class="table-dark">
	                        <tr> 
	                        	<th>ID</th>
	                            <th>Legajo</th>
	                            <th>Nombre</th>                        
	                            <th>Apellido</th>
	                            <th>Seleccionado</th>
	                            
	                        </tr>
	                   </thead>
	                   <tbody>
							 <% for (Alumno alumno : listaAlumnos){ 
								 
                             %>
                            <tr> 
                               <th> <%=alumno.getIdAlumno() %></th>
                                <th><%=alumno.getLegajo() %></th>
                                <th><%=alumno.getNombre() %></th>
                                <th><%=alumno.getApellido() %></th>
                                <th> <input class="check" type ="checkbox" name ="seleccionado" value ="<%=alumno.getIdAlumno()%>"></input>
                                
                                     
                                 </th>
                            </tr>
                        <%
                        
                        }
							 
                        %>
                        
	                   </tbody>
	       </table>
	       
	        <input id="arrayid" type ="hidden" name ="arrayid">
    
    </div>
    
 
        <input   class="btn accent" type="submit" value ="Guardar"></input>
        
      
    
    </form>
    
    
 </div>

	
	
</main>

</body>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
 <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <script>
    $(document).ready(function() {
        $('#table-1').DataTable({
            "language": {
                search:"Buscar"
            }
        });
    } );
    
    var arr = []
    
    $(document).on('change', '.check', function(e){
    	 var check = e.target.closest('.check')
    	 
    	 if($(check).is(':checked')){
    		 arr.push($(check).val())
    		console.log(arr)
    	 }
    	 else{
    		var eliminar=  arr.findIndex(x=>x===$(check).val())
    		arr.splice(eliminar, 1)
    		
    	 }
    	 
    	 $('#arrayid').val("")
         $('#arrayid').val(arr)
    })
    
    
    
    
    
    </script>
    
    
    
    
</html>