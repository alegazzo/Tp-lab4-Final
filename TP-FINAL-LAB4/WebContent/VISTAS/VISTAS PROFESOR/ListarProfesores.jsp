<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="java.util.ArrayList" %>
<%@page import ="Dominio.Docente" %>
  <%@page import ="Dominio.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="Styles/Styles.css" />
<link rel="stylesheet" href="Styles/mini-lib.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" />


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
     
</nav>
<!-- Fin navbar -->

<!-- Modal -->


<%
  if(request.getAttribute("action")!=null){
	  
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

%>



<% 
ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
if(request.getAttribute("listaDocentes")!=null)
{
listaDocentes = (ArrayList<Docente>)request.getAttribute("listaDocentes");
}
%>

	<div class="full-width flex-center-container">
		
		<div class="table-container max-width-container flex-column">
			
			<h1 class="table-title">Profesores</h1>
			
			<table id="table-1" class="display table table-light table-hover">	                                    
	                    <thead class="table-dark">
	                        <tr>
	                            <th>DNI</th>
	                            <th>Legajo</th>
	                            <th scope="col">Nombre</th>                        
	                            <th>Apellido</th>
	                            <th>Fecha de nacimiento</th>
	                            <th>Dirección</th>
	                            <th>País</th>
	                            <th>Provincia</th>
	                            <th>Localidad</th>
	                            <th>Mail</th>
	                            <th>Teléfono</th>
	                            <th> </th>
	                            <th> </th>
	                        </tr>
	                   </thead>
	                   <tbody>
	                   <% for (Docente docente : listaDocentes){
	                	   %>
							<tr>
							
								<th><%=docente.getDni() %></th>
	                            <th><%=docente.getLegajo() %></th>                        
	                            <th><%=docente.getNombre() %></th>
	                            <th><%=docente.getApellido() %></th>
	                            <th><%=docente.getFecha_Nacimiento() %></th>
	                           	<th><%=docente.getAdress() %></th>
	                            <th><%=docente.getPais().getNombrePais() %></th>
	                            <th><%=docente.getProvincia().getNombreProvincia() %></th>
	                            <th><%=docente.getLocalidad().getNombre() %></th>
	                            <th><%=docente.getEmail() %></th>
	                            <th><%=docente.getTelefono() %></th>	                         
	                             <th> <a href="servletModificarProfesor?id=<%=docente.getIdDocente()%>"> <i class="fas fa-edit"></i> </a>  </th>
	                            <th> <a href="servletEliminarProfesor?id=<%=docente.getIdDocente()%>" ><i class="fas fa-trash-alt"></i></a> </th>
	
							</tr>
						<%	
	                    }
						%>
	                   </tbody>
	       </table>
		
		<form>
			<!-- <input class="btn" type="submit" value="Agregar">  -->
			  <a class="form__btn-sumbit accent" type="submit" href="servletAgregarProfesor">Agregar</a>
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
    </script>
    
 <script>

$('#btnCerrar').click(function(){ 
   $('#modal').hide();
});

</script>
 
 
 
 
</html>