//
// Start function
// 

$(document).ready(function () {
    checkConflicts();
    window.setInterval(checkConflicts, 4000);
    window.setInterval(currentDate, 1000);
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

