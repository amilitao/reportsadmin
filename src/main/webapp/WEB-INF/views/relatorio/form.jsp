<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<tags:pageTemplate  titulo="Cadastro de Relatorio">

	<div class="w3-container ">

		<div class="w3-panel w3-bar w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
			<i class="fa fa-file-pdf-o"></i><b> Cadastro de Relatório</b>
			</h4>
		</div>

		<div class="w3-panel w3-padding-large">

			<form:form action="${spring:mvcUrl('RC#save').build()}" method="post"
				commandName="relatorio">

				<div class="w3-row-padding" style="margin: 0 -16px;">
				
					<form:hidden path="id"/>
				
					<div class="w3-col" style="width:15%">
						<p>
							<label for="nome"><b>Nome</b></label>
							<form:input path="nome" class="w3-input w3-border" />
							<form:errors path="nome" />
						</p>
					</div>	
					<div class="w3-col" style="width:20%">
						<p>
							<label for="servidor"><b>Número do Servidor</b></label>
							<form:select class="w3-select" path="servidor.id" >	
								<form:option value="-1" label="--- Selecione ---" />						
								<form:options items="${servidores}" itemValue="id"
									itemLabel="numero" />
							</form:select>							
							<form:errors path="servidor" />
						</p>
					</div>	
					<div class="w3-col" style="width:45%">
						<p>
							<label for="descricao"><b>Descrição</b></label>
							<form:input path="descricao" class="w3-input w3-border" />
							<form:errors path="descricao" />
						</p>
					</div>
					
					<div class="w3-col" style="width:15%">
						<p>
							<label for="tipoRelatorio"><b>Tipo</b></label>
							<form:select class="w3-select" path="tipoRelatorio" >	
								<form:option value="-1" label="--- Selecione ---" />						
								<form:options items="${tipos}" />
							</form:select>							
							<form:errors path="tipoRelatorio" />
						</p>
					</div>	
																												
				</div>	
				
							
				<br>				
				<button class="w3-btn w3-dark-grey w3-left-align w3-hover-red">Salvar</button>				
			</form:form>
		</div>
	</div>

</tags:pageTemplate>