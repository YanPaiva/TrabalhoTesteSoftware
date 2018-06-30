
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<table border="1">
    <tbody>
        <tr>
            <td><h4>Nota dos Alunos</h4></td>
        </tr>
        <c:forEach var="aluno" items="${grupo}">
            <tr>
                <td>${aluno.getNome()}</td>
            <form method="post" action="notaSalvaAluno.html">
                <td> <input type="number" min="0" max="${aluno.getNota(0)}"
                        name="txtNota" value="${aluno.getNota(0)}" size="20" />       
                </td>
                <input type="hidden" name="idAluno" value="${aluno.getId()}">
                <input type="hidden" name="cbGrupo" value="${cbGrupo}">
                <td><input type="submit" value="Salvar"/></td>

            </tr>
        </c:forEach>
        </tbody>
</table>

<%@include file="jspf/rodape.jspf" %>

