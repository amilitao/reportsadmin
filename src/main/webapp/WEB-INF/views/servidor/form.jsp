<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<tags:pageTemplate titulo="Cadastro de servidor">

	<div class="w3-container ">

		<div class="w3-panel w3-bar w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
			<i class="fa fa-server"></i><b> Cadastro de servidor</b>
			</h4>
		</div>

		<div class="w3-panel w3-padding-large">
			<form:form class= "w3-container" action="${spring:mvcUrl('SC#save').build()}" method="post"
				commandName="servidor">

				<div class="w3-row-padding" style="margin: 0 -16px;">
				
				<form:hidden path="id"/>
				
					<div class="w3-col m3">
						<p>
							<label for="numero"><b>Numero</b></label>
							<form:input path="numero" class="w3-input w3-border" />
							<form:errors path="numero" />
						</p>
					</div>
					<div class="w3-col m3">
						<p>
							<label for="host"><b>Host</b></label>
							<form:input path="host" class="w3-input w3-border" />
							<form:errors path="host" />
						</p>
					</div>
					<div class="w3-col m3">
						<p>
							<label for="caminhoBk"><b>Caminho do diretório BK</b></label>
							<form:input path="caminhoBk" class="w3-input w3-border" />
							<form:errors path="caminhoBk" />
						</p>
					</div>									
				</div>				
				<hr>	
				<button class="w3-btn w3-dark-grey w3-left-align w3-hover-red">Salvar</button>
												
			</form:form>
		</div>
	</div>

</tags:pageTemplate>