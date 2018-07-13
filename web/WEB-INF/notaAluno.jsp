
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>


<form method="POST" action="notaAluno.jsp" id="formNota">
    <div class="row">
        <div class="col-12">${grupo.getNome()}</div>
    </div>
    <div style="padding-top:30px;">Aluno</div>
    <div class="row" >
        <div class="col-12">
            <select name="alunos" class="custom-select" required >         
                <option></option>
                <c:forEach var="aluno" items="${alunos}">
                    <option ${aluno.getIdAlunoServidor() == idAluno ? 'selected="selected"' : ''} value="${aluno.getIdAlunoServidor()}">${aluno.getNome()}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div style="padding-top:10px;">Nota</div>
    <div class="row">
        <div class="col-12">
            <input class="form-control" required type="number" step="0.01" name="txtNota" value="${nota}" size="20" min="0" max="100"/>
        </div>
    </div>
    <div class="row" style="padding-top:15px;padding-bottom:10px">
        <div class="col-10"></div>
        <div class="col-2">
            <input type="hidden" name="cbGrupo" value="${grupo.getIdGrupoServidor()}"/>
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

