//= require /jquery/dist/jquery.min.js
//= require_tree .
//= require_self

$(function() {
  $('a.create-trigger').on('click', function(e) {
    e.preventDefault();
    
    var dataset = $(this).data();
    var department = dataset.department;
    var currentMembers = getCurrentMembersInDepartment(department);

    $.ajax({
      url: '/worker/index.json',
      success: function(data) {
        if (data) {
          var div = $('<div>', { class: 'col-md-4' });
          var select = $('<select>', { id: 'workers', class: 'form-control' });
          var tr = $('<tr>');
          var td1 = $('<td>');
          var td2 = $('<td>');
          var confirmButton = $('<a>', { text: 'Confirm', class: 'btn btn-primary btn-sm', id: 'confirmButton', style: 'margin-right: 5px;' });
          var cancelButton = $('<a>', { text: 'Cancel', class: 'btn btn-default btn-sm', id: 'cancelButton' });
          var filteredMembers = filterMembers(data, currentMembers);

          filteredMembers.forEach(function(w) {
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

          confirmButton.on('click', function(e) {
            
          })

          cancelButton.on('click', function(e) {
            $(this).parent().parent().remove()
          });
        }
      },
      error: function(xhr, ajaxOptions, thrownError) {
        console.log(xhr.status, ajaxOptions, thrownError);
      }
    });
  });

  var getCurrentMembersInDepartment = function(department) {
    var members = [];

    $('.' + department).each(function(index) {
      members.push($(this).text());
    });

    return members;
  };

  var filterMembers = function(workers, currentMembers) {
    var validMembers = [];

    workers.forEach(function(worker) {
      if (currentMembers.indexOf(worker.fullName) == -1) {
        validMembers.push(worker);
      }
    });

    return validMembers;
  };
})();
