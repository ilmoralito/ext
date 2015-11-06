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
          <g:set var="dept" value="${d.name.tokenize(' ').join('_')}"/>

          <tr id="${dept}" class="dropable">
            <td colspan="2">
              <strong>${d.name.toUpperCase()}</strong>
              <a
                href="#"
                class="btn btn-default btn-xs pull-right create-trigger"
                data-department="${dept}"
                >+</a>
            </td>
          </tr>
          <g:each in="${data[d]}" var="v">
            <tr id="${v.id}" class="draggable" draggable="true">
              <td class="${dept}">${v.worker}</td>
              <td>${v.position == "Manager" ? "Director" : "Colaborador"}</td>
            </tr>
          </g:each>
        </g:each>
      </tbody>
    </table>

    <asset:javascript src="application.js"/>
  </content>
</g:applyLayout>
