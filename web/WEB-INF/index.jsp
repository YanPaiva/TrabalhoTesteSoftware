<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="jspf/cabecalho.jspf" %>

<form method="POST" action="index.jsp" id="formNota">
    <div class="row justify-content-center align-items-center" style="padding-top:30px;">
        <div class="col-2">Grupo</div>
        <div class="col-10">
            <select name="cbGrupo" class="custom-select" required >         
                <option></option>
                <c:forEach var="grupo" items="${todosGrupos}">
                    <option ${grupo.getIdGrupoServidor() == idGrupo ? 'selected="selected"' : ''} value="${grupo.getIdGrupoServidor()}">${grupo.getNome()}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row justify-content-center align-items-center" style="padding-top:5px;">
        <div class="col-2">Nota</div>
        <div class="col-10">
            <input class="form-control" required type="number" step="0.01" name="txtNota" value="${nota}" size="20" min="0" max="100"/>
        </div>
    </div>
    <div class="row" style="padding-top:15px;">
        <div class="col-10"></div>
        <div class="col-2">
            <input class="btn btn-primary" type="submit" name="btnSalvar" value="Salvar" />
        </div>
    </div>
</form>

<script>
    $('select').on('change', function() {
        document.getElementById("formNota").submit();
    });
</script>

<%@include file="jspf/rodape.jspf" %>

