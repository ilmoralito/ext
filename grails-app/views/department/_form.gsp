<div class="row">
  <div class="col-md-4">
    <div class="form-group">
      <g:textField
        name="name"
        value="${department?.name}"
        class="form-control"
        placeholder="Nombre de departamento"
        autofocus="true"/>
    </div>
    
    <div class="form-group">
      <input
        type="number"
        name="extensionNumber"
        id="extensionNumber"
        value= "${department?.extensionNumber}"
        class="form-control"
        placeholder="Numero de extension">
    </div>
  </div>
</div>