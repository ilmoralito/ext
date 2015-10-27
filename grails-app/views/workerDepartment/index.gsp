<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="layout" content="public">
    <title>Document</title>
  </head>
  <body>
    ${data}

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
          <tr>
            <td rowspan="${d.meta.size()}">${d.ext}</td>
            <g:if test="${d.meta.size() > 1}">
              <g:each in="${d.meta}" var="m">
                <!--Iteration intance goes here-->
                <td>1</td>
                <td>2</td>
                <td>3</td>
              </g:each>
            </g:if>
            <g:else>
              <td>0</td>
              <td>0</td>
              <td>0</td>
            </g:else>
          </tr>
        </g:each>
      </tbody>
    </table>

    <h2>Demo table</h2>

    <table class="table table-bordered table-hover">
      <colgroup>
        <col style="width: 10%;">
        <col style="width: 20%;">
        <col span="1" style="width: 20%;">
        <col style="width: 50%;">
      </colgroup>
      <thead>
        <tr>
          <td>Column1</td>
          <td>Column2</td>
          <td>Column3</td>
          <td>Column4</td>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Data</td>
          <td>Data</td>
          <td>Data</td>
          <td>Data</td>
        </tr>
        <tr>
          <td rowspan="3">Data</td>
          <td>Data</td>
          <td>Data</td>
          <td>Data</td>
        </tr>
        <tr>
          <td>Data</td>
          <td>Data</td>
          <td>Data</td>
        </tr>
        <tr>
          <td>Data</td>
          <td>Data</td>
          <td>Data</td>
        </tr>
        <tr>
          <td rowspan="2">Data</td>
          <td>Data</td>
          <td>Data</td>
          <td>Data</td>
        </tr>
        <tr>
          <td>Data</td>
          <td>Data</td>
          <td>Data</td>
        </tr>
      </tbody>
    </table>

    <g:link action="printExtencionsList" class="btn btn-primary">
      <span class="glyphicon glyphicon-print" aria-hidden="true"></span> Imprimir
    </g:link>
  </body>
</html>