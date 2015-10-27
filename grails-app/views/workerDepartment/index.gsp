<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="layout" content="public">
    <title>Document</title>
  </head>
  <body>
    <h1>Extenciones</h1>
    <table class="table table-bordered table-hover">
      <colgroup>
        <col style="width: 10%">
        <col style="width: 20%">
        <col style="width: 20%">
        <col style="width: 50%">
      </colgroup>
      <thead>
        <tr>
          <th>Extencion</th>
          <th>Departamento</th>
          <th>Responsable</th>
          <th>Colaboradores</th>
        </tr>
      </thead>
      <tbody>
        <g:each in="${data}" var="d">
          <g:if test="${d.meta.size() == 1}">
            <tr>
              <td>${d.ext}</td>
              <td>${d.meta.department}</td>
              <td>${d.meta.manager}</td>
              <td>${d.meta.collaborators}</td>
            </tr>
          </g:if>
          <g:else>
            <g:each in="${d.meta}" var="m" status="i">
              <tr>
                <g:if test="${i == 0}">
                  <td rowspan="${d.meta.size()}">${d.ext}</td>
                </g:if>
                <td>${m.department}</td>
                <td>${m.manager}</td>
                <td>${m.collaborators}</td>
              </tr>
            </g:each>
          </g:else>
        </g:each>
      </tbody>
    </table>

    <g:link action="printExtencionsList" class="btn btn-primary">
      <span class="glyphicon glyphicon-print" aria-hidden="true"></span> Imprimir
    </g:link>
  </body>
</html>