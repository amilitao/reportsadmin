<%@taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<tags:pageTemplate titulo="Lista de Agendamento">

	<div class="w3-container">

		<div class="w3-panel w3-bar w3-leftbar w3-text-dark-grey w3-border-red w3-pale-red">
			<h4 class="w3-bar-item">
				<i class="fa fa-calendar"></i><b> Agenda de envio de relatórios</b>
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
					<th class="w3-border">Email</th>
					<th class="w3-border">Departamento</th>
					<th class="w3-center">Agenda</th>
				</tr>
				<c:forEach items="${funcionarios}" var="funcionario">
					<tr class="item">
						<td class="w3-border">${funcionario.id}</td>
						<td class="w3-border">${funcionario.nome}</td>
						<td class="w3-border">${funcionario.email}</td>
						<td class="w3-border">${funcionario.departamento}</td>
						<td class="w3-center">
						<a href="${spring:mvcUrl('AC#show').arg(0,funcionario.id).build()}">
						<i class="fa fa-calendar" style="font-size:24px"></i> </a>						
						</td>
					</tr>
				</c:forEach>

			</table>
			</div>
		</div>

</tags:pageTemplate>
