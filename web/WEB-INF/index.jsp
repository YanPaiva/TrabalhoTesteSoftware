<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="jspf/cabecalho.jspf" %>

<form method="POST" action="index.jsp" id="formNota">
    <div style="padding-top:30px;">Grupo</div>
    <div class="row" >
        <div class="col-12">
            <select name="cbGrupo" class="custom-select" required >         
                <option></option>
                <c:forEach var="grupo" items="${todosGrupos}">
                    <option ${grupo.getIdGrupoServidor() == idGrupo ? 'selected="selected"' : ''} value="${grupo.getIdGrupoServidor()}">${grupo.getNome()}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row" style="padding-top:10px;">
        <div class="col-12">
            <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>Aluno</th>
                  </tr>
                </thead>
                <tbody>
                    <c:forEach var="aluno" items="${alunos}">
                        <tr>
                            <td>${aluno.getNome()}</td>
                          </tr>
                    </c:forEach>
                </tbody>
              </table>
        </div>
    </div>
    <div style="padding-top:10px;">Nota</div>
    <div class="row">
        <div class="col-12">
            <input class="form-control" required type="number" step="0.01" name="txtNota" value="${nota}" size="20" min="0" max="100"/>
        </div>
    </div>
    <div class="row" style="padding-top:15px;padding-bottom:10px">
        <div class="col-6"></div>
        <div class="col-6">
            <input class="btn btn-outline-success" type="submit" name="btnEditarNotas" value="Editar Notas Individuais" />
            <input class="btn btn-outline-success" type="submit" name="btnSalvar" value="Salvar" />
        </div>
    </div>
</form>

<script>
    $('select').on('change', function() {
        document.getElementById("formNota").submit();
    });
</script>

<%@include file="jspf/rodape.jspf" %>

