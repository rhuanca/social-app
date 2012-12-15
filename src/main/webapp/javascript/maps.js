var map;

$(document).ready(function () {
    // set time out functions
    checkConflicts();
    window.setInterval(checkConflicts, 10000);
    retrieveConflictosMap();
    window.setInterval(retrieveConflictosMap, 10000);
    currentDate();
    window.setInterval(currentDate, 1000*60*60);

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

    $('#registerId').click(function () {
        var mail = $('#mailId').val(),
            password = $('#passwordId').val();
        $.ajax({
            type:'POST',
            url:'/rest/user/login',
            data:{
                username:mail,
                password:password
            },
            success:function (data) {
                window.location.reload(true);
            },
            error:function (xhr) {
                alert(xhr.status);
            }
        });
        return false;

    });

    $('#registerUserId').live('click', function () {
        var mail = $('#newUserMailId').val(),
            password = $('#newUserPasswordId').val();

        $.ajax({
            type:'POST',
            url:'/rest/user/create',
            data:{
                username:mail,
                password:password
            },
            success:function (data) {
                window.location.reload(true);
            },
            error:function (xhr) {
                alert(xhr.status);
            }
        });
        return false;

    });

    $('#signUpCloseId').click(function () {
        $("#signUpId").modal();                       // initialized with defaults
        $("#signUpId").modal({ keyboard:false });   // initialized with no keyboard
        $("#signUpId").modal('hide');
        window.location.reload(true);
        return false;
    });

    $('#closeUserId').live('click', function () {
        $("#signUpId").modal();                       // initialized with defaults
        $("#signUpId").modal({ keyboard:false });   // initialized with no keyboard
        $("#signUpId").modal('hide');
        window.location.reload(true);
        return false;
    });

    $('#registerDivId').click(function () {
        $("#signUpId").html($('#newUserDivId').html());
        return false;
    });
});

function checkConflicts() {
    $.ajax({
        type:'POST',
        url:'/rest/conflicts/list',
        contentType:"application/json; charset=utf-8",
        success:function (data) {
            $('#summary').html($('#summaryConflictTemplate').render(data.cities));
        },
        error:function (xhr) {
//            alert(xhr.status);
        }
    });

}

function retrieveConflictosMap() {
    $.ajax({
        type:'POST',
        url:'/rest/conflicts/listConflictosMap',
        contentType:"application/json; charset=utf-8",
        success:function (data) {
            $("#conflictosCountDiv").html(data.length);
            for (i = 0; i < data.length; i++) {
                drawConflictPoint(map, data[i]);
            }
        },
        error:function (xhr) {
            //traceRoute(document.getElementById(divId), [pointVillazon], pointPerez, pointCalle8);
        }
    });
}

var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
function currentDate() {
    var d = new Date();
    var curr_date = d.getDate();
    var curr_month = d.getMonth() + 1; //Months are zero based
    var curr_year = d.getFullYear();
    $('#conflictDate').html(curr_date + " de " + meses[curr_month-1] + " de " + curr_year);
}
