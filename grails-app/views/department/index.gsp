<g:applyLayout name="oneColumn">
  <head>
    <title>Department</title>
  </head>
  <content tag="main">
    <g:link controller="control" class="btn btn-default">Regresar</g:link>
    <g:link action="create" class="btn btn-primary pull-right">Agregar departamento</g:link>

    <table class="table table-hover">
      <colgroup>
        <col style="width: 1%">
        <col style="width: 88%">
        <col style="width: 1%">
      </colgroup>
      <thead>
        <tr>
          <th>Ext.</th>
          <th>Nombre</th>
          <th></th>
        </tr>
      </thead>
      <tbdoy>
        <g:each in="${departmentList}" var="department">
          <tr>
            <td>${department.extensionNumber}</td>
            <td>
              <g:link action="edit" params="[id: department.id]">
                ${department.name}
              </g:link>
            </td>
            <td>
              <g:link action="delete" id="${department.id}">
                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
              </g:link>
            </td>
          </tr>
        </g:each>
      </tbdoy>
    </table>
  </content>
</g:applyLayout>