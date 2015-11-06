(function() {
  $('.draggable').on('dragstart', function(event) {
    event.originalEvent.dataTransfer.setData('text/plain', event.target.id);
  });

  $('.dropable').on('dragover', function(event) {
    event.preventDefault();
  })

  $('.draggable').on('dragend', function(event) {
    var origin = event.target;

    if (event.originalEvent.dataTransfer.dropEffect != 'none') {
      origin.parentNode.removeChild(origin);
    }
  });

  $('.dropable').on('dragenter', function(event) {
    event.preventDefault();
  })

  $('.dropable').on('drop', function(event) {
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

        console.log(data)

        parent.parentNode.insertBefore(tr, parent.nextSibling);
      }
    })
  })
})();
