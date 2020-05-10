<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<tags:pageTemplate titulo="Agendamento de envio de email">

	<jsp:attribute name="extraScripts">
		 <script>
				$(function() {
					$("#mensagem").dialog({
						resizable: false,
					    height: "auto",
					    width: "auto",
					    modal: true,
						buttons : {
							Ok : function() {
								$(this).dialog("close");
							}
						}
					});
				});
			</script>
	</jsp:attribute>


	<jsp:body>

	<c:if test="${not empty falha}">
			<div id="mensagem" title="Mensagem">
				<p>
					<i class="fa fa-exclamation-triangle"></i> ${falha}
				</p>
			</div>
		</c:if>
		<c:if test="${not empty sucesso}">
			<div id="mensagem" title="Mensagem">
				<p>
					<i class="fa fa-check-circle w3-text-green"></i> ${sucesso}
				</p>
			</div>
		</c:if>		

	<div class="w3-container">

		<div
				class="w3-panel w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4>
				<i class="fa fa-sitemap"></i><b> Agendamento de envio de relatórios</b>
			</h4>
		</div>

		<form:form servletRelativeAction="salvar-agendamento" >	
		
			<div class="w3-panel w3-padding-large w3-white">			

				<div class="w3-col s3 w3-padding">
							<input type="hidden" name="id" value="${funcionario.id}" />							
							<p>
								<label><b>Nome: </b></label>
								${funcionario.nome}								
							</p>
						</div>
						<div class="w3-col s4 w3-padding">
							<p>
								<label><b>Email: </b></label>
								${funcionario.email}												
							</p>
						</div>
						<div class="w3-col s3 w3-padding">
							<p>
								<label><b>Departamento: </b></label>						
								${funcionario.departamento.nome}									
							</p>	
						</div>
						<div class="w3-col s2 w3-padding">							
								<button class="w3-button w3-red">Salvar</button>							
						</div>	
				</div>		
				<br>
				<div class="w3-responsive" style="height:450px; overflow: auto;">
					<table class="w3-table-all w3-border">
						<tr>
							<th class="w3-border"></th>
							<th class="w3-border">Relatório</th>
							<th class="w3-border">Descrição</th>
							<th class="w3-border">Estabelecimento</th>
							<th class="w3-border">Tipo de Relatório</th>						
						</tr>

						<c:forEach var="relatorio" items="${permitidos}">

							<tr>
								<td class="w3-border" style="width:70px"><input type="checkbox" class="w3-check"
									name="selecionados" value="${relatorio.id}" 						
									<c:if test="${funcionario.relatorios.contains(relatorio)}">checked</c:if>></td>
								<td class="w3-border">${relatorio.nome}</td>
								<td class="w3-border">${relatorio.descricao}</td>
								<td class="w3-border">${relatorio.servidor}</td>
								<td class="w3-border">${relatorio.tipoRelatorio}</td>								
							</tr>

						</c:forEach>

					</table>
				</div>	
			</form:form>				
		</div>
		
	

	</jsp:body>

</tags:pageTemplate>