<div class="row">
  <div class="col-md-4">
    <div class="form-group">
      <g:textField
        name="fullName"
        value="${worker?.fullName}"
        class="form-control"
        placeholder="Nombres y apellidos"
        autofocus="true"/>
    </div>
    
    <div class="form-group">
      <input
        type="email"
        name="email"
        id="email"
        value= "${worker?.email}"
        class="form-control"
        placeholder="Correo institucional">
    </div>
  </div>
</div>