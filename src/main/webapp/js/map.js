//
// Start function
// 

$(document).ready(function () {
//    initialize("map_canvas");
//    initialize("mapReportConflict");

    getRutaHitos('select2');
    getRutaHitos('selectReportSource');
    getRutaHitos('selectReportDestiny');

    $("#conflictReportId").datepicker();

    $('.close').click(function () {
        $("#signup-modal").hide();
        return false;
    });
    $('#signupButton').click(function () {
        $("#signup-modal").show();
//        $(".news").show();
//        $('#').css('display:block');
        return false;
    });

    checkConflicts();
    window.setInterval(checkConflicts, 4000);

    window.setInterval(currentDate, 1000);

    $('#saveReportConflict').click(function () {
        var point = $('input[name=conflictPoint]:checked').val(),
            traditionalPoint = $('#select2').val(),
            detail = $('#detailConflict').val();

        $.ajax({
            type:'POST',
            url:'/rest/conflicts/createConflict',
            data:{
                type:point,
                rutaHitoId:traditionalPoint,
                detail:detail
            },
            // contentType:"application/json; charset=utf-8",
            success:function (data) {
                alert("success");
            },
            error:function (xhr) {
                alert(xhr.status);
            }
        });
        return false;
    });

    $('#conflictPath').click(function () {
        $('#detectPoint').fadeOut('fast', function () {
            $('#detectPath').fadeIn('fast');
        });
    });

    $('#conflictPoint').click(function () {
        $('#detectPath').fadeOut('fast', function () {
            $('#detectPoint').fadeIn('fast');
        });
    });

    $('.chooseManualSelection').live('change', function () {
        if ($(this).val() == -100) {
            $('#').show('slow');
        }
    });
});


//
// Helper functions
//

function checkConflicts() {
    $.ajax({
        type:'POST',
        url:'/rest/conflicts/list',
        //dataType: "json",
        contentType:"application/json; charset=utf-8",
        success:function (data) {
            $('#tree').html($('#treeTempl').render(data.cities));
        },
        error:function (xhr) {
            alert(xhr.status);
        }
    });

}

function getRutaHitos(rutas) {
    $.ajax({
        type:'POST',
        url:'/rest/conflicts/listRutaHitos',

        //dataType: "json",
        contentType:"application/json; charset=utf-8",
        success:function (data) {
            var sel = $("#" + rutas);
            sel.empty();
            sel.append('<option value="-100">[Usar Mapa]</option>').css({'background-color':'yellow', 'font-weight':'bolder'});
            $.each(data, function (i, item) {
                sel.append('<option value="' + item.id + '">' + item.name + '</option>');
            });
            sel.val(1).attr('selected', true);
        },
        error:function (xhr) {
            alert(xhr.status);
        }
    });
}

function currentDate() {
    var d = new Date();
    var curr_date = d.getDate();
    var curr_month = d.getMonth() + 1; //Months are zero based
    var curr_year = d.getFullYear();
    var curr_time = d.get;
    var curr_hour = d.getHours();
    var curr_minutes = d.getMinutes();
    var curr_seconds = d.getSeconds();
    $('#conflictDate').html(curr_date + "-" + curr_month + "-" + curr_year + " - " + curr_hour + ":" + curr_minutes + ":" + curr_seconds);
}

