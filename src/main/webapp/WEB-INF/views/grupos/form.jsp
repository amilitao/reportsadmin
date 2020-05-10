<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<tags:pageTemplate titulo="Cadastro de Grupos">

<div class="w3-container">

		<div
			class="w3-panel w3-bar w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
				<i class="fa fa-sitemap"></i><b> Cadastro de Grupos</b>
			</h4>
		</div>

	<form:form class="w3-container"	action="${spring:mvcUrl('GC#save').build()}"
				commandName="grupos" method="post">

		<div class="w3-panel w3-padding-large">			

				<div class="w3-row-padding" style="margin: 0 -16px;">
				
					<form:hidden path="id"/>

					<div class="w3-col m3">
						<p>
							<form:label path="nome"><b>Nome do grupo</b></form:label>
							<form:input class="w3-input w3-border"
								path="nome" />
							<form:errors path="nome" />
						</p>
					</div>	
					<div class="w3-col m3">
						<p>
							<label for="departamento"><b>Departamento </b></label><br>
							<form:select path="departamento.id" class="w3-select">
								<form:option value="-1" label="--- Selecione ---" />
								<form:options items="${departamentos}" itemValue="id"
									itemLabel="nome" />
							</form:select>
							<form:errors path="departamento" />
						</p>
					</div>				
				</div>
				<hr>
				<button class="w3-btn w3-dark-grey w3-hover-red">Salvar</button>	
			</div>
	</form:form>
</div>


</tags:pageTemplate>