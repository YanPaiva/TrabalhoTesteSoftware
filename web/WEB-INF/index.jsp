<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="jspf/cabecalho.jspf" %>

<form method="POST" action="notaSalva.jsp">
    <div class="row justify-content-center align-items-center" style="padding-top:30px;">
        <div class="col-2">Grupo</div>
        <div class="col-10">
          <select name="cbGrupo" class="custom-select">         
            <option>Selecionar</option>
            <c:forEach var="grupo" items="${todosGrupos}">
                <option value="${grupo.getIdGrupoServidor()}">${grupo.getNome()}</option>
            </c:forEach>
          </select>
        </div>
    </div>
    <div class="row justify-content-center align-items-center" style="padding-top:5px;">
        <div class="col-2">Nota</div>
        <div class="col-10">
            <input class="form-control" type="number" step="0.01" name="txtNota" value="" size="20" min="0" max="100"/>
        </div>
    </div>
    <div class="row" style="padding-top:15px;">
        <div class="col-10"></div>
        <div class="col-2">
            <input class="btn btn-primary" type="submit" name="btnSalvar" value="Salvar" />
        </div>
    </div>
</form>

<%@include file="jspf/rodape.jspf" %>

