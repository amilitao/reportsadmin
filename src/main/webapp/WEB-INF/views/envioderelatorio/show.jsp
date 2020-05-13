<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<tags:pageTemplate titulo="Envio de Relatorio">

	<jsp:attribute name="extraScripts">
		 <script>
				$(function() {
					$("#mensagem").dialog({
						resizable : false,
						height : "auto",
						width : "auto",
						modal : true,
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
	
				<c:if test="${not empty naoselecionados}">
					<div id="mensagem" title="Mensagem">
						<p>
							<i class="fa fa-exclamation-triangle w3-text-yellow"></i> ${naoselecionados}
						</p>
					</div>
				</c:if>
				<c:if test="${not empty sucesso}">
					<div id="mensagem" title="Mensagem">
						<p>
							<i class="fa fa-check-circle w3-text-green"></i> ${sucesso}							
						</p>
						<ul>
							<c:forEach items="${lista}" var="enviadas">							
								<li>${enviadas}</li>						
							</c:forEach>
						</ul>
					</div>
				</c:if>
				<c:if test="${not empty erro}">
					<div id="mensagem" title="Mensagem">
						<p>
							<i class="fa fa-exclamation-triangle w3-text-red"></i> ${erro}
						</p>
					</div>
				</c:if>
				<c:if test="${not empty excluido}">
					<div id="mensagem" title="Mensagem">
						<p>
							<i class="fa fa-check-circle w3-text-green"></i> ${excluido}
						</p>
					</div>
				</c:if>
				<c:if test="${not empty naoexcluido}">
					<div id="mensagem" title="Mensagem">
						<p>
							<i class="fa fa-check-circle w3-text-green"></i> ${naoexcluido}
						</p>
					</div>
				</c:if>
				<c:if test="${not empty encontrado}">
					<div id="mensagem" title="Mensagem">
						<p>
							<i class="fa fa-check-circle w3-text-green"></i> ${encontrado}
						</p>
					</div>
				</c:if>
				<c:if test="${not empty naoencontrado}">
					<div id="mensagem" title="Mensagem">
						<p>
							<i class="fa fa-exclamation-triangle w3-text-red"></i> ${naoencontrado}
						</p>
					</div>
				</c:if>

	<div class="w3-container">

		<div class="w3-panel w3-bar w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
				<i class="fa fa-envelope-o"></i><b> Envio de relatórios</b>
			</h4>
			<p>
				<input oninput="w3.filterHTML('#id01', '.item', this.value)"
						class="w3-input w3-bar-item w3-right" placeholder="Pesquisar ..."
						style="width: 30%">
			</p>
		</div>

		<form:form servletRelativeAction="enviar">

			<div class="w3-panel w3-padding-large">

				<div class="w3-bar">					
					<div class="w3-bar-item">
						<p><b>DESTINATÁRIO:</b></p>
					</div>	
					
					<input type="hidden" value="${funcionario.id}" name="idFuncionario">
								
					<div class="w3-bar-item">
						<label class="w3-input w3-border w3-white" style="width: 400px">${funcionario.email}</label>
					</div>
					<div class="w3-bar-item">
						<button class="w3-button w3-red">Enviar</button>
					</div>
				
				</div>

			</div>	
			
			 <div id="spin" class="w3-modal">        
     			 <i class="fa fa-refresh fa-spin w3-display-middle" style="font-size:48px;color:white"></i>
 			 </div>			

			<div class="w3-responsive" style="height: 450px; overflow: auto;">
					<table id="id01" class="w3-table-all w3-border">
						<tr class="w3-dark-gray">
							<th class="w3-border"></th>
							<th class="w3-border">Relatório</th>
							<th class="w3-border">Estabelecimento</th>
							<th class="w3-border">Tipo de Relatório</th>
							<th class="w3-border w3-center">Status</th>
							<th class="w3-border w3-center">Atualizado em</th>
							<th class="w3-border w3-center">Atualizar</th>					
							<th class="w3-border w3-center">Visualizar</th>	
										
						</tr>

						<c:forEach var="relatorio" items="${relatoriosPermitidos}">
						
							<c:if test="${relatorio.status == 'INDISPONIVEL'}">
									<c:set var="corDeStatus" value="red" />
									<c:set var="statusCheckBox" value = "disabled" />
								</c:if>	
								<c:if test="${relatorio.status == 'DISPONIVEL'}">
									<c:set var="corDeStatus" value="green" />
									<c:set var="statusCheckBox" value = "enabled" />
								</c:if>	

							<tr class="item">							
								<td class="w3-border" style="width: 70px">
									<input type="checkbox" class="w3-check" name="selecionados"
									value="${relatorio.id}"	${statusCheckBox}>
								</td>							
								<td class="w3-border">${relatorio.nome}</td>
								<td class="w3-border">${relatorio.servidor}</td>
								<td class="w3-border">${relatorio.tipoRelatorio}</td>								
								<td class="w3-border w3-center w3-text-${corDeStatus}" style="text-transform: lowercase;">${relatorio.status}</td>
								<td class="w3-border w3-center"><fmt:formatDate
										pattern="dd/MM/yyyy HH:mm:ss"
										value="${relatorio.dtAtualizacao.getTime()}" /></td>	
								<td class="w3-border w3-center">
									<a href="${spring:mvcUrl('ERC#download').arg(0,funcionario.id).arg(1, relatorio.id).build()}" onclick="document.getElementById('spin').style.display='block'" >
								<i class="fa fa-refresh" style="font-size: 24px"></i>
								</a>
								</td>								
								<td
									class="w3-border w3-center">									
									<a href="${spring:mvcUrl('ERC#viewPDF').arg(0, relatorio.id).arg(1, relatorio.nome).build()}" 
									target="_blank"><i class="fa fa-eye"
										style="font-size: 24px"></i></a> 
								</td>														
							</tr>

						</c:forEach>

					</table>
				</div>	
		</form:form>

	</div>
	
</jsp:body>

</tags:pageTemplate>