<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<tags:pageTemplate titulo="Lista de servidores">

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
			<div id="mensagem" title="Mensagem" >
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

		<div
			class="w3-panel w3-bar w3-leftbar  w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
				<i class="fa fa-server"></i><b> Servidores</b>
			</h4>
		</div>
		<div class="w3-container w3-center">
			<p>
				<a href= "<c:url value="/servidor/form" />" class="w3-button w3-red">Novo servidor</a>
			</p>
		</div>
		<div class="w3-responsive" style="height:500px; overflow: auto;">

			<table class="w3-table-all w3-striped w3-hoverable">
				<tr class="w3-dark-gray">
					<th class="w3-border">Id</th>
					<th class="w3-border">Numero</th>
					<th class="w3-border">Host</th>
					<th class="w3-border">Caminho do diretório BK</th>
					<th class="w3-border w3-center">Gerenciar</th>	
										
				</tr>
				<c:forEach items="${servidores}" var="servidor">
					<tr>
						<td class="w3-border">${servidor.id}</td>
						<td class="w3-border">${servidor.numero}</td>
						<td class="w3-border">${servidor.host}</td>
						<td class="w3-border">${servidor.caminhoBk}</td>	
						<td class="w3-center">
							<div class="w3-bar">
								<%-- <a href="${spring:mvcUrl('SC#remove').arg(0,servidor.id).build()}" class="w3-bar-item w3-button w3-tiny w3-padding-small" title="remover"><i class="fa fa-remove" style="font-size: 18px"></i></a> --%>
								 <a href="${spring:mvcUrl('SC#update').arg(0,servidor.id).build()}" class="w3-bar-item w3-button w3-tiny w3-padding-small" title="editar"><i class="fa fa-edit" style="font-size: 18px"></i></a>								 
							</div>
						</td>	
						
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>

</jsp:body>

</tags:pageTemplate>