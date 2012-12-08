var map;

var routeMarker1;
var routeMarker2;

$(document).ready(function () {
    initView();
	loadPlacesForCreatePath();

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

function initView(){
	routeDirectionRenderer = createDirectionsRenderer(map);
	$('#sourceId').change(function () {
        var newMarker = displaySourcePointInRouteMap('#sourceId', routeMarker1, map);
        if (newMarker == null) {
            routeMarker1 = null;
            routeDirectionRenderer.setDirections({routes:[]});
        }
        else if (routeMarker2 != null) {
            routeMarker1 = newMarker;
            calculateRoute(routeMarker1.getPosition(), routeMarker2.getPosition(), routeDirectionRenderer);
        } else {
            routeMarker1 = newMarker;
        }

    });
    $('#targetId').change(function () {
        var newMarker = displaySourcePointInRouteMap('#targetId', routeMarker2, map);
        if (newMarker == null) {
            routeMarker2 = null;
            routeDirectionRenderer.setDirections({routes:[]});

        } else if (routeMarker1 != null) {
            routeMarker2 = newMarker;
            calculateRoute(routeMarker1.getPosition(), routeMarker2.getPosition(), routeDirectionRenderer);
        } else {
            routeMarker2 = newMarker;
        }

    });
    
    $("#saveRoute").click(function(){
        var alertHito1 = $('#sourceId').val();
        var alertHito2 = $('#targetId').val();
        var googleRoute = routeDirectionRenderer.getDirections().routes[0];

        var w = [], wp;
        var rleg = googleRoute.legs[0];
        var data = {};
        data.start = {'lat':rleg.start_location.lat(), 'lng':rleg.start_location.lng()};
        data.end = {'lat':rleg.end_location.lat(), 'lng':rleg.end_location.lng()};
        var steps = rleg.steps;
        for (var i = 0; i < steps.length - 1; i++)
            w[i] = [steps[i].end_location.lat(), steps[i].end_location.lng()];
        data.points = w;
        $.ajax({
            type:'POST',
            url:'/rest/conflicts/createAlertRoute',
            data:{
                point1:alertHito1,
                point2:alertHito2,
                googleRoute:JSON.stringify(data)
            },
            success:function (data) {
                alert("Alerta creada exitosamente.");
            },
            error:function (xhr) {
                alert(xhr.status);
            }
        });
    });
}

function loadPlacesForCreatePath() {
    $.ajax({
        type:'POST',
        url:'/rest/conflicts/listRutaHitos',
        success:function (data) {
            populateHitoSelectList("#sourceId", data);
            populateHitoSelectList("#targetId", data);
        },
        error:function (xhr) {
            alert(xhr.status);
        }
    });
}