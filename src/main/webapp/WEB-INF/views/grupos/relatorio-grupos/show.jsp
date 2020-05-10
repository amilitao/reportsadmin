<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<tags:pageTemplate titulo="Funcionario - Grupos">	

	<div class="w3-container">

		<div class="w3-panel w3-bar w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
				<i class="fa fa-sitemap"></i><b> Relatório - Grupos</b>
			</h4>
		</div>			
		
		<form:form servletRelativeAction="salvar-relatorio-grupos">	
		
			<div class="w3-panel w3-padding-large w3-white">
			
						<div class="w3-col s2 w3-padding">
							<input type="hidden" name="id_relatorio" value="${relatorio.id}" />							
							<p>
								<label><b>Nome: </b></label>
								${relatorio.nome}								
							</p>
						</div>
						<div class="w3-col s5 w3-padding">
							<p>
								<label><b>Descrição: </b></label>
								${relatorio.descricao}												
							</p>
						</div>
						<div class="w3-col s1 w3-padding">
							<p>
								<label><b>Tipo: </b></label>						
								${relatorio.tipoRelatorio}									
							</p>	
						</div>
						<div class="w3-col s2 w3-padding">
							<p>
								<label><b>Nº Servidor: </b></label>						
								${relatorio.servidor.numero}									
							</p>	
						</div>
						<div class="w3-col s2 w3-padding">							
								<button class="w3-button w3-red">Salvar</button>							
						</div>	
		
			</div>
			<div class="w3-panel w3-padding-large" style="width:50%">
				<div class=" w3-responsive" style="height:420px; overflow: auto;">
					<table class="w3-table-all w3-border">
						<tr>
							<th></th>
							<th class="w3-border">Id</th>
							<th class="w3-border">Nome</th>	
							<th class="w3-border">Departamento</th>							
						</tr>

						<c:forEach var="grupo" items="${grupos}">							
							<tr>
								<td class="w3-border" style="width:70px"><input type="checkbox" class="w3-check"
										name="selecionados" value="${grupo.id}"
										<c:if test="${relatorio.grupos.contains(grupo)}">checked</c:if>></td>
								<td class="w3-border">${grupo.id}</td>
								<td class="w3-border">${grupo.nome}</td>
								<td class="w3-border">${grupo.departamento.nome}</td>							
							</tr>

						</c:forEach>

					</table>
				</div>
				</div>
			</form:form>	
		</div>	

</tags:pageTemplate>