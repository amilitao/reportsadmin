 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="w3-sidebar w3-collapse"
	style="z-index: 3; width: 300px; background: #d8dddf" id="mySidebar">
	<br>
	<div class="w3-container">
		<h5>Menu</h5>
	</div>
	<div class="w3-bar-block">


		<a href="<c:url value="/dashboard/" />"
			class="w3-bar-item w3-button w3-padding w3-hover-red"> <i
			class="fa fa-dashboard"></i> Dashboard
		</a> <a href="<c:url value="/envio-de-relatorio/" />"
			class="w3-bar-item w3-button w3-padding w3-hover-red">
			 <i class="fa fa-envelope-o"></i> Envio de relatórios
		</a>	
		 <a href="<c:url value="/agendamento/" />"
			class="w3-bar-item w3-button w3-padding w3-hover-red"> <i
			class="fa fa-calendar"></i> Agenda de envio de relatórios
		</a>
		
		<a href="<c:url value="/relatorio/" />"
			class="w3-bar-item w3-button w3-padding w3-hover-red"> <i
			class="fa fa-file-pdf-o"></i> Relatorios
		</a>
		
		 <a href="<c:url value="/funcionario/" />"
			class="w3-bar-item w3-button w3-padding w3-hover-red"> <i
			class="fa fa-user"></i> Funcionários
		</a>
		
		
		<button class="w3-button w3-block w3-left-align w3-hover-red" onclick="myGruposFunc()">
		<i class="fa fa-object-group"></i> Grupos <i class="fa fa-caret-down"></i>
		</button>
		<div id="grupos" class="w3-hide w3-white w3-card">
			<a href="<c:url value="/grupos/" />" class="w3-bar-item w3-button"> Grupos</a> 
			<a href="<c:url value="/funcionario-grupos/" />" class="w3-bar-item w3-button"> Funcionário - Grupos</a>
			<a href="<c:url value="/relatorio-grupos/" />" class="w3-bar-item w3-button"> Relatório - Grupos</a>			
		</div>

		<a href="<c:url value="/departamento/" />"
			class="w3-bar-item w3-button w3-padding w3-hover-red"> <i
			class="fa fa-sitemap"></i> Departamentos
		</a> <a href="<c:url value="/servidor/" />"
			class="w3-bar-item w3-button w3-padding w3-hover-red"> <i
			class="fa fa-server"></i> Servidores
		</a>
		
		</div>
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity"
	onclick="w3_close()" style="cursor: pointer" title="close side menu"
	id="myOverlay"></div>


<script>
	// Get the Sidebar
	var mySidebar = document.getElementById("mySidebar");

	// Get the DIV with overlay effect
	var overlayBg = document.getElementById("myOverlay");

	// Toggle between showing and hiding the sidebar, and add overlay effect
	function w3_open() {
		if (mySidebar.style.display === 'block') {
			mySidebar.style.display = 'none';
			overlayBg.style.display = "none";
		} else {
			mySidebar.style.display = 'block';
			overlayBg.style.display = "block";
		}
	}

	// Close the sidebar with the close button
	function w3_close() {
		mySidebar.style.display = "none";
		overlayBg.style.display = "none";
	}
	


	function myGruposFunc() {
	  var x = document.getElementById("grupos");
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	    x.previousElementSibling.className += " w3-red";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
	    x.previousElementSibling.className = 
	    x.previousElementSibling.className.replace(" w3-red", "");
	  }
	}

	function myConfFunc() {
		  var x = document.getElementById("conf");
		  if (x.className.indexOf("w3-show") == -1) {
		    x.className += " w3-show";
		    x.previousElementSibling.className += " w3-red";
		  } else { 
		    x.className = x.className.replace(" w3-show", "");
		    x.previousElementSibling.className = 
		    x.previousElementSibling.className.replace(" w3-red", "");
		  }
		}	
	

</script>