<g:applyLayout name="oneColumn">
  <head>
    <title>Adding new department</title>
  </head>

  <content tag="main">
    <p><g:link action="index" class="btn btn-default">Regresar</g:link></p>

    <g:form action="create" autocomplete="off">
      <g:render template="form"/>

      <g:hasErrors bean="${department}">
        <g:renderErrors bean="${department}"/>
      </g:hasErrors>

      <g:submitButton name="send" value="Confirmar" class="btn btn-primary"/>
    </g:form>
  </content>
</g:applyLayout>