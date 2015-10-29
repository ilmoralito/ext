<g:applyLayout name="oneColumn">
  <head>
    <title>Worker</title>
  </head>

  <content tag="main">
    <g:link controller="control" class="btn btn-default">Regresar</g:link>
    <g:link action="create" class="btn btn-primary pull-right">Agregar trabajador</g:link>

    <table class="table table-hover">
      <thead>
        <tr>
          <th></th>
          <th width="1"></th>
        </tr>
      </thead>
      <tbdoy>
        <g:each in="${workers}" var="worker">
          <tr>
            <td>
              <g:link action="edit" params="[id: worker.id]">
                ${worker.fullName}
              </g:link>
            </td>
            <td>
              <g:link action="delete" id="${worker.id}">
                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
              </g:link>
            </td>
          </tr>
        </g:each>
      </tbdoy>
    </table>
  </content>
</g:applyLayout>