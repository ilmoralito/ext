<g:applyLayout name="message">
  <head>
    <title>Confirm!</title>
  </head>

  <content tag="main">
    <h1>Confirmar</h1>
    <p>
      Si elimina el registro de <b>${worker.fullName}</b> no podra deshacer los cambios.
      Desea continuar?
    </p>

    <g:form action="delete" autocomplete="off">
      <g:hiddenField name="id" value="${worker.id}"/>

      <g:link action="index" class="btn btn-default">Regresar</g:link>
      <g:submitButton name="send" value="Confirmar" class="btn btn-warning"/>
    </g:form>
  </content>
</g:applyLayout>