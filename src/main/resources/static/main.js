$(document).ready(function () {



    $("#add-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();

        var name = $("#username").val();
        var surname = $("#surname").val();
        //search["email"] = $("#email").val();

        $("#btn-search").prop("disabled", true);

        var parameter = {
            name: name,
            surname : surname
        };


        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/add",
            data: JSON.stringify(parameter),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                location.reload();
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);

            }
        });

    });


    $(".delete").click(function (event) {
        var id = $("#id").text();
        //stop submit the form, we will post it manually.
        event.preventDefault();
        $("#btn-search").prop("disabled", true);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/delete",
            data: JSON.stringify({ id: id}),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                location.reload();
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);

            }
        });

    });



});
