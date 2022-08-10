<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">Ç
<%@page import ="java.util.ArrayList" %>
<%@page import ="Dominio.Usuario" %>
<%@page import ="Dominio.Calificaciones" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="Styles/Styles.css" />
<link rel="stylesheet" href="Styles/mini-lib.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Editar Calificaciones Curso</title>
</head>
<body>


<%

   Usuario usuario = (Usuario)session.getAttribute("usuario");

%>




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
           <a class="nav-link active" aria-current="page" href="servletHome">Home</a>
        </li>
      
      </ul>
      
      <form class="flex-evenly-container align-items-center" method ="Post" action="servletCerrarSession">
        <h5 class="user-name"><%=usuario.getUser_Name() %></h5>
        <input class="btn accent" type="submit" value="Cerrar sesión"/>
      </form>
      
    </div>
  </div>
  
</nav>
<!-- Fin navbar -->

<% 

ArrayList<Calificaciones> listaCalificaciones = new ArrayList<Calificaciones>(); 

listaCalificaciones = (ArrayList<Calificaciones>)request.getAttribute("listaCalificaciones");

%>
	<div class="full-width flex-center-container">
		
		<div class="table-container max-width-container flex-column">
			
			<h1 class="table-title">Calificaciones Curso</h1>
			<h1 class="table-title">Curso 1</h1>
			
				<form id="formu" method="Post" action="servletEditarCalificaciones">
			<table id="table-1" class="display table table-light table-hover">
	                    <thead class="table-dark">
	                        <tr>
	                            <th>Legajo</th>
	                            <th scope="col">Nombre</th>                        
	                            <th>Apellido</th>
	                            <th>Primer parcial</th>
	                            <th>Segundo parcial</th>
	                            <th>Primer Recuperatorio</th>
	                            <th>Segundo Recuperatorio</th>
	                            <th>Estado</th>
	                        </tr>
	                   </thead>
	                   <tbody>
	                   
	                   <%for(Calificaciones cal : listaCalificaciones) 
	                   {
	                	   
	                	   
	                	  %>
	                	  
	                	  <tr>
	                	  		<input type="Hidden" name="idCurso" value="<%= cal.getIdCurso() %>" >
	                	  		<input type="Hidden" class="idAlumno calificaciones" name="idAlumno" value="<%= cal.getAlumno().getIdAlumno() %>" >
								<th><%= cal.getAlumno().getLegajo() %></th>
	                            <th><%= cal.getAlumno().getNombre() %></th>                        
	                            <th><%= cal.getAlumno().getApellido() %></th>
	                            <th> 
	                             <input type="text" class="parcial1 calificaciones" name="primerParcial" value="<%= cal.getParcial1() %>"/>
	                            </th>
	                            <th> 
	                             <input type="text" class="parcial2 calificaciones" name="segundoParcial" value="<%= cal.getParcial2() %>"/>
	                            </th>
	                            <th> 
	                             <input type="text" class="recuperatorio1 calificaciones" name="primerRecuperatorio" value="<%= cal.getRecuperatorio1() %>"/>
	                            </th>
	                            <th> 
	                             <input type="text" class="recuperatorio2 calificaciones" name="segundoRecuperatorio" value="<%= cal.getRecuperatorio2() %>"/>
	                            </th>
	                            
	                            <th>
	                            <select class="estado calificaciones" name="estado" id="document_type">
	                            <% 
	                               if(cal.getEstadoAcademico()){
	                            	   %>
	                            	      <option value="1" selected >Regular</option> 
                                          <option value="0">Libre</option>  
	                            	   <% 
	                               } 
	                               else{
	                            	   
	                            	   %>
	                            	      <option value="1" selected >Regular</option> 
                                           <option value="0" selected>Libre</option>  
	                            	   <% 
	                               }
	                           
	                            
	                            %>
	                               
                                </select>
	                            </th>
							</tr>
	                	  
	                	  
	                	  
	                	  <%
	                	 
	                   }
	                   
	                   %>
	                   
	                   
							
	                   </tbody>
	       </table>
		 	<input id="arrayidAlumno" type ="hidden" name ="arrayidAlumno">
			<input id="arrayparcial1" type ="hidden" name ="arrayparcial1">	
			<input id="arrayparcial2" type ="hidden" name ="arrayparcial2">
			<input id="arrayrecuperatorio1" type ="hidden" name ="arrayrecuperatorio1">
			<input id="arrayrecuperatorio2" type ="hidden" name ="arrayrecuperatorio2">
			<input id="arrayestado" type ="hidden" name ="arrayestado">
			
			<input class="btn" type="submit" value="Guardar">
			
		</form>
		</div>
	
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
    
    
    
 var arrayCalificaciones = []
    
    $(document).on('change', '.calificaciones', function(e){
    	var idAlumnobuscar = e.target.closest('tr').querySelector('[name=idAlumno]')
    	var parcial1 = e.target.closest('tr').querySelector('[name=primerParcial]')
    	var parcial2 = e.target.closest('tr').querySelector('[name=segundoParcial]')
    	var recuperatorio1 = e.target.closest('tr').querySelector('[name=primerRecuperatorio]')
    	var recuperatorio2 = e.target.closest('tr').querySelector('[name=segundoRecuperatorio]')
    	var estado = e.target.closest('tr').querySelector('[name=estado]')
    	
    	
    	
    	var repetido =  arrayCalificaciones.findIndex(x => x.idAlumno === $(idAlumnobuscar).val())
    	if(repetido!=-1) arrayCalificaciones.splice(repetido, 1)
    		
    	var calificaciones = {
    			idAlumno: $(idAlumnobuscar).val(),
    			parcial1: $(parcial1).val(),
    			parcial2: $(parcial2).val(),
    			recuperatorio1:$(recuperatorio1).val(),
    			recuperatorio2: $(recuperatorio2).val(),
    			estado: $(estado).val()	
    	}
    	
    	arrayCalificaciones.push(calificaciones)
    	 console.log(arrayCalificaciones)   
    	 
    	cargarElementos(arrayCalificaciones)
    	
    })
    
    
    function cargarElementos(arrayCalificaciones){
	 
	 $('#arrayidAlumno').val("")
	 $('#arrayparcial1').val("")
	 $('#arrayparcial2').val("")
	 $('#arrayrecuperatorio1').val("")
	 $('#arrayrecuperatorio2').val("")
	 $('#arrayestado').val("")
	 
	 var idAlumnoArray = []
	 var parcial1Array  = []
	 var parcial2Array  = []
	 var recuperatorio1Array  = []
	 var recuperatorio2Array  = []
	 var estadoArray  = []
	 
	 $.each(arrayCalificaciones, function(index, item) {
		 idAlumnoArray.push(item.idAlumno)
		 parcial1Array.push(item.parcial1)
		 parcial2Array.push(item.parcial2)
		 recuperatorio1Array.push(item.recuperatorio1)
		 recuperatorio2Array.push(item.recuperatorio2)
		 estadoArray.push(item.estado)
	 });
	 
	 
	 $('#arrayidAlumno').val(idAlumnoArray)
	 $('#arrayparcial1').val(parcial1Array)
	 $('#arrayparcial2').val(parcial2Array)
	 $('#arrayrecuperatorio1').val(recuperatorio1Array)
	 $('#arrayrecuperatorio2').val(recuperatorio2Array)
	 $('#arrayestado').val(estadoArray)
 }
         
    </script>   
</html>