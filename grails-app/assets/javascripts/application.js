//= require /jquery/dist/jquery.min.js
//= require_tree .
//= require_self

(function() {
  $('a.create-trigger').on('click', function(e) {
    e.preventDefault();

    var department = $(this).data().department;

    $.ajax({
      url: '/workerDepartment/getWorkersWithNotWorkerDepartment',
      dataType: 'json',
      success: function(data) {
        if (data.workersInstances.length) {
          var div = $('<div>', { class: 'col-md-4' });
          var select = $('<select>', { class: 'form-control workers' });
          var tr = $('<tr>');
          var td1 = $('<td>');
          var td2 = $('<td>');
          var confirmButton = $('<a>', { text: 'Confirmar', class: 'btn btn-primary btn-sm confirmButton', 'data-department': department, style: 'margin-right: 5px;' });
          var cancelButton = $('<a>', { text: 'Cancel', class: 'btn btn-default btn-sm cancelButton' });

          data.workersInstances.forEach(function(w) {
            var option = $('<option>', { text: w.fullName, value: w.id });

            select.append(option);
          });

          div.append(select);
          td1.append(div);
          tr.append(td1);
          td2.append(confirmButton);
          td2.append(cancelButton);
          tr.append(td2);

          $('#' + department).after(tr)
        }
      },
      error: function(xhr, ajaxOptions, thrownError) {
        console.log(xhr.status, ajaxOptions, thrownError);
      }
    });
  });

  $(document).on('click', '.confirmButton', function(e) {
    var _self = $(this);
    var target = _self.parent().parent().children();
    var worker = target.first().find('select option:selected').attr("value");
    var department = _self.data().department;

    $.ajax({
      url: "/workerDepartment/create",
      data: { worker: worker, department: department },
      success: function(data) {
        if (data) {
          //update selects > removing worker
          $('.workers option').each(function() {
            var _this = $(this);
            
            if (_this.html() === data.fullName) {
              _this.remove();
            }
          });

          //print data in td target
          target.first().html(data.fullName);
          target.last().html(data.position == 'Manager' ? 'Director' : 'Colaborador');

          //remove all .workers if there are no more workers
          $.getJSON('/workerDepartment/getWorkersWithNotWorkerDepartment', function(data) {
            if (!data.workersInstances.length) {
              $('.workers').parent().parent().parent().remove()
            };
          });
        }
      },
      error: function(xhr, ajaxOptions, thrownError) {
        console.log(xhr.status, ajaxOptions, thrownError);
      }
    });
  });

  $(document).on('click', '.cancelButton', function(e) {
    $(this).parent().parent().remove()
  });
})();
