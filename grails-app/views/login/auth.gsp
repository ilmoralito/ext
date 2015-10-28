<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title></title>
</head>
<body>
  <h1>Identificate</h1>

  <g:if test="${flash.message}">
    <div class="alert alert-info">${flash.message}</div>
  </g:if>

  <form action="${postUrl}" method="POST" autocomplete="off">
    <div class=form-group>
      <input type="text" class="form-control" name="j_username" id="username" placeholder="Correo" autofocus="true"/>
    </div>

    <div class="form-group">
      <input type="password" class="form-control" name="j_password" id="password" placeholder="Clave"/>
    </div>

    <input type="submit" id="submit" value="${message(code: "springSecurity.login.button")}" class="btn btn-primary"/>
  </form>
</body>
</html>