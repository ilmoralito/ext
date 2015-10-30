<g:applyLayout name="oneColumn">
  <head>
    <title>WorkerDepartment</title>
  </head>

  <content tag="main">
    <g:link controller="control" class="btn btn-default">Regresar</g:link>

    <table class="table table-hover">
      <thead>
        <tr>
          <th></th>
          <th></th>
          <th width="1"></th>
        </tr>
      </thead>
      <tbody>
        <g:each in="${departments}" var="d">
          <tr>
            <td colspan="2">
              <b>${d}</b>
              <a href="#" class="btn btn-default btn-xs pull-right">+</a>
            </td>
          </tr>
          <g:each in="${data[d]}" var="v">
            <tr>
              <td>${v.worker}</td>
              <td>${v.position == "Manager" ? "Director" : "Colaborador"}</td>
            </tr>
          </g:each>
        </g:each>
      </tbody>
    </table>
  </content>
</g:applyLayout>
