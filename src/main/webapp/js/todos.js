/* var serviceUri = "webapi/memtodos";

function doFill() {
    $("#task-list").empty();
    $.ajax({
        url: serviceUri,
        type: 'GET',
        contentType: 'application/json'
    })
     .done(function (data) { $.each(data, function (i, task) { appendElement(task); }); });
}

function doCreate(task) {
    $.ajax({
        url: serviceUri,
        type: 'POST',
        data: JSON.stringify(task),
        contentType: 'application/json'
    })
     .done(function (data, status, xhr) {
         var location = xhr.getResponseHeader('Location');
         $.ajax({
             url: location,
             type: 'GET',
             contentType: 'application/json'
         })
            .done(function (result) { appendElement(result); });
     });
}

function doUpdate(id, task) {
    $.ajax({
        url: serviceUri + "/" + id,
        type: 'PUT',
        data: JSON.stringify(task),
        contentType: 'application/json'
    })
   .done(function () { updateElement(id, task); });
}

function doDelete(id) {
    $.ajax({
        url: serviceUri + "/" + id,
        type: 'DELETE',
        contentType: 'application/json'
    })
     .done(function () { deleteElement(id); });
}

function appendElement(task) {
    $("#task-list")
      .append(
    		  $("<li>")
    		  	.text(task.text)
    		  	.attr("id", task.id));
}

function updateElement(id, task) {
    $("#" + id).text(task.text);
}

function deleteElement(id) {
    $("#" + id).remove();
}


///+++ on load +++

$(function () {

    $("input:radio[name='uriradio']").change(
          function () {
              serviceUri = $("input:radio[name='uriradio']:checked").val();
              doFill();
          });

    $("#create-button").click(
        function () {
            var value = $("#text-input").val();
            var task = { text: value };
            doCreate(task);
        });

    $("#update-button").click(
        function () {
            var value = $("#text-input").val();
            $(".ui-selected").each(
                    function () {
                        var id = $(this).attr("id");
                        var task = { text: value };
                        doUpdate(id, task);
                    });

        });

    $("#delete-button").click(
        function () {
            $(".ui-selected").each(
                    function () {
                        var id = $(this).attr("id");
                        doDelete(id);
                    });

        });


    $("#task-list").selectable();

    doFill();

});
*/