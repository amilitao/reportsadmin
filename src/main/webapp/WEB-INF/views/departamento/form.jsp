<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<tags:pageTemplate titulo="Cadastro de Departamento">

	<div class="w3-container">

		<div class="w3-panel w3-bar w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
				<i class="fa fa-sitemap"></i><b> Cadastro de Departamento</b>
			</h4>
		</div>

	<form:form class="w3-container" action="${spring:mvcUrl('DC#save').build()}"
				commandName="departamento" method="post">

		<div class="w3-panel w3-padding-large">		

				<div class="w3-row-padding" style="margin: 0 -16px;">
				
					<form:hidden path="id"/>

					<div class="w3-col m3">
						<p>
							<label><b>Nome</b></label>
							<form:input class="w3-input w3-border"
								path="nome" style="width: 400px" />
						</p>
					</div>					
				</div>
				<hr>
				<button class="w3-btn w3-dark-grey w3-hover-red">Salvar</button>
			</div>
		</form:form>		
	</div>
</tags:pageTemplate>