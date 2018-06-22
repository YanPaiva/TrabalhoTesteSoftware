<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>Bem vindo</p>
<form method="POST" action="notaSalva.html">
    <table border="1">
        <tbody>
            <tr>
                <td><h4>Coloque a nota do Grupo: </h4></td>
                <td><input type="number" min="0" max="100" name="nomta" value="" size="20" /></td>
            </tr>
            <tr>
                <td><input type="submit" name="btnSalvar" value="Salvar" /></td>
                <td><input type="submit" name="btnEditarNota" value="Editar Nota Individual" /></td>
            </tr>
        </tbody>
    </table>
</form>


