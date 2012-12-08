
var map;
var conflictMarker;

$(document).ready(function () {
    initReportConflictView();
    initActions();
    $.ajax({
        type:'GET',
        url:'/rest/user/logged',
        success:function (data) {
            $.each(data, function (i, item) {
                $('#labelSignIn').html(data.email);
            });

        },
        error:function (xhr) {
//            alert(xhr.status);
        }
    });


});

function initReportConflictView() {
    $('#saveReportConflict').click(function () {
        var point = $('input[name=conflictPoint]:checked').val(),
            traditionalPoint = $('#conflictPoint').val(),
            detail = $('#detailConflict').val();

        $.ajax({
            type:'POST',
            url:'/rest/conflicts/createConflict',
            data:{
                rutaHitoId:traditionalPoint,
                detail:detail
            },
            success:function (data) {
                alert("Conflicto creado!");
            },
            error:function (xhr) {
                //alert(xhr.status);
            }
        });
        return false;
    });
    
    $.ajax({
        type:'POST',
        url:'/rest/conflicts/listRutaHitos',

        //dataType: "json",
        contentType:"application/json; charset=utf-8",
        success:function (data) {
            jsonHitos = data;
            populateHitoSelectList("#inputPlace", data);
        },
        error:function (xhr) {
            alert(xhr.status);
        }
    });

}


function initActions() {
    //Save Hito
    $('#conflictReport').click(function () {
        var traditionalPoint = $('#inputPlace').val();
        var detail = $('#inputPassword').val();

        $.ajax({
            type:'POST',
            url:'/rest/conflicts/createConflict',
            data:{
                rutaHitoId:traditionalPoint,
                detail:detail
            },
            success:function (data) {
                alert("Conflicto guardado exitosamente.");
            },
            error:function (xhr) {
                alert(xhr.status);
            }
        });
        return false;
    });
    
    $('#inputPlace').change(function () {
    	conflictMarker = displaySourcePointInRouteMap('#inputPlace', conflictMarker, map);

    });
}

