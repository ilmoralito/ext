(function() {
  $('.draggable').on('dragstart', function(event) {
    event.originalEvent.dataTransfer.setData('text/plain', event.target.id);
  });

  $('.dropable').on('dragover', function(event) {
    event.preventDefault();
  })

  $('.dropable').on('dragenter', function(event) {
    event.preventDefault();
  })

  $('.dropable').on('drop', function(event) {
    event.preventDefault();

    var origin = event.target;
    var id = event.originalEvent.dataTransfer.getData('text/plain');
    var department = $(this).attr('id');

    console.log(origin);

    /*
    $.ajax({
      url: '/workerDepartment/update',
      data: { id: id, department: department },
      success: function(data) {
        origin.remove();
      }
    })
    */
  })
})();
