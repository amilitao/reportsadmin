<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<tags:pageTemplate titulo="Relatorio - Grupos">

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
					<i class="fa fa-exclamation-triangle w3-text-red"></i> ${falha}
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

		<div class="w3-panel w3-bar w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
				<i class="fa fa-object-group"></i><b> Relat�rio - Grupos</b>
			</h4>
			<p>
				<input oninput="w3.filterHTML('#id01', '.item', this.value)"
					class="w3-input w3-bar-item w3-right" placeholder="Pesquisar ..." style="width:30%">
			</p>
		</div>			
		<br>
		<div class="w3-responsive" style="height:500px; overflow: auto;">

				<table id="id01" class="w3-table-all w3-striped w3-hoverable">
					<tr class="w3-dark-gray">
						<th class="w3-border">Id</th>
						<th class="w3-border">Nome</th>
						<th class="w3-border">Descri��o</th>
						<th class="w3-border">Tipo</th>
						<th class="w3-border">Servidor</th>
						<th class="w3-border">Grupos</th>
						<th class="w3-border w3-center">Gerenciar</th>
					</tr>
					<c:forEach items="${relatorios}" var="relatorio">					
						<tr class="item">								
							<td class="w3-border">${relatorio.id}</td>
							<td class="w3-border">${relatorio.nome}</td>
							<td class="w3-border">${relatorio.descricao}</td>
							<td class="w3-border">${relatorio.tipoRelatorio}</td>
							<td class="w3-border">${relatorio.servidor}</td>
							<td class="w3-border">${relatorio.grupos}</td>
							<td class="w3-border w3-center">
							<a href="${spring:mvcUrl('show-relatorio-grupos').arg(0,relatorio.id).build()}">
								<i class="fa fa-edit" style="font-size:24px"></i>
							</a>							
							</td>
						
						</tr>
					
					</c:forEach>
				</table>
			</div>
		</div>
	
	</jsp:body>	

</tags:pageTemplate>