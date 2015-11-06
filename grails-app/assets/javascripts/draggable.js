(function() {
  $(document).on('dragstart', '.draggable', function(event) {
    event.originalEvent.dataTransfer.setData('text/plain', event.target.id);
  });

  $(document).on('dragover', '.dropable', function(event) {
    event.preventDefault();
  })

  $(document).on('dragend', '.draggable', function(event) {
    var origin = event.target;

    if (event.originalEvent.dataTransfer.dropEffect != 'none') {
      origin.parentNode.removeChild(origin);
    }
  });

  $(document).on('dragenter', '.dropable', function(event) {
    event.preventDefault();
  })

  $(document).on('drop', '.dropable', function(event) {
    event.preventDefault();

    var id = event.originalEvent.dataTransfer.getData('text/plain');
    var department = $(this).attr('id');
    var target = event.target;
    var parent = document.getElementById(department);

    $.ajax({
      url: '/workerDepartment/update',
      data: { id: id, department: department },
      success: function(data) {
        var tr = document.createElement('tr');
        var tdFullName = document.createElement('td');
        var tdPosition = document.createElement('td');

        tr.setAttribute('id', id);
        tr.setAttribute('class', 'draggable');
        tr.setAttribute('draggable', true);

        tdFullName.setAttribute('class', department);
        tdFullName.innerHTML = data.fullName;

        tdPosition.innerHTML = data.position;

        tr.appendChild(tdFullName);
        tr.appendChild(tdPosition);

        parent.parentNode.insertBefore(tr, parent.nextSibling);
      }
    })
  })
})();
