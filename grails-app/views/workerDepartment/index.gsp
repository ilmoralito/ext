<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="layout" content="public">
    <title>Extenciones</title>
  </head>
  <body>
    <h1 style="text-align: center;">Extenciones</h1>

    <table class="table table-bordered table-hover">
      <colgroup>
        <col style="width: 10%">
        <col style="width: 20%">
        <col style="width: 20%">
        <col style="width: 50%">
      </colgroup>
      <thead>
        <tr>
          <th style="text-align: center;">Extencion</th>
          <th>Departamento</th>
          <th>Responsable</th>
          <th>Colaboradores</th>
        </tr>
      </thead>
      <tbody>
        <g:each in="${data}" var="d">
          <g:if test="${d.meta.size() == 1}">
            <tr>
              <td style="text-align: center;">
                ${d.ext}
              </td>
              <td>${d.meta[0].department}</td>
              <td>${d.meta[0].manager}</td>
              <td>${d.meta[0].collaborators.join(", ")}</td>
            </tr>
          </g:if>
          <g:else>
            <g:each in="${d.meta}" var="m" status="i">
              <tr>
                <g:if test="${i == 0}">
                  <td rowspan="${d.meta.size()}" style="text-align: center; vertical-align: middle;">
                    ${d.ext}
                  </td>
                </g:if>
                <td>${m.department}</td>
                <td>${m.manager}</td>
                <td>${m.collaborators.join(", ")}</td>
              </tr>
            </g:each>
          </g:else>
        </g:each>
        <tr>
          <td style="text-align: center;">190</td>
          <td colspan="3">Porton principal</td>
        </tr>
        <tr>
          <td style="text-align: center;">188</td>
          <td colspan="3">Porton estacionamiento</td>
        </tr>
      </tbody>
    </table>

    <div style="text-align: center;">
      <span class="glyphicon glyphicon-fire" aria-hidden="true"></span> Bomberos ${emergencyNumbers.firefighters}
      <span class="glyphicon glyphicon-user" aria-hidden="true"></span> Policia ${emergencyNumbers.police}
      <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Cruz Roja ${emergencyNumbers.redCross}
    </div>
    <br>

    <div  style="text-align: center;">
      <g:link action="printExtencionsList" class="btn btn-primary">
        <span class="glyphicon glyphicon-print" aria-hidden="true"></span> Imprimir
      </g:link>
    </div>
  </body>
</html>