<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="jspf/cabecalho.jspf" %>

<form method="POST" action="notaSalva.jsp">
    <div class="row justify-content-center align-items-center" style="padding-top:30px;">
        <div class="col-6">Grupo</div>
        <div class="col-6">
          <select name="cbGrupo" class="custom-select">         
            <option>Selecionar</option>
            <c:forEach var="numeroDoGrupo" items="${todosGrupos}">
                <option>${numeroDoGrupo.getNome()}</option>
            </c:forEach>
          </select>
        </div>
    </div>
    <div class="row justify-content-center align-items-center" style="padding-top:5px;">
        <div class="col-6">Nota</div>
        <div class="col-6">
            <input class="form-control" type="number" step="0.01" name="txtNota" value="" size="20" />
        </div>
    </div>
    <div class="row" style="padding-top:15px;">
        <div class="col-9" style="background-color:pink"></div>
        <div class="col-3" style="background-color:red">
            <input class="btn btn-primary" type="submit" name="btnSalvar" value="Salvar" />
        </div>
    </div>
    
</form>

<%@include file="jspf/rodape.jspf" %>

