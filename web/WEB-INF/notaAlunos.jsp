<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>Bem vindo</p>
<form method="POST" action="notaSalva.html">
    <table border="1">
        <tbody>
            <tr>
                <td><h4>Nota dos Alunos</h4></td>
            </tr>


            <c:forEach var="user" items="${grupo}">
                <tr>
                    <td>${user.getNome()}</td>
                    <td> <input type="number" min="0" max="<%=request.getAttribute("nota")%>"
                               name="txtNota" value="<%=request.getAttribute("nota")%>" size="20" />
               
                    </td>
                </tr>
            </c:forEach>


            <tr>
                <td><input type="submit" value="Salvar"/></td>
            </tr>
        </tbody>
    </table>
</form>


