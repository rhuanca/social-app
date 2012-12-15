
/**
 * HardCoders library maps
 * @type {*}
 *
 */
var conflictsMap = null;
var routeMap = null;
var reportMap = null;
var laPaz = new google.maps.LatLng(-16.509174, -68.136864);
var directionsService = new google.maps.DirectionsService();

//json of hitos
var jsonHitos;


//
// Route view global variables
//

/*var routeMarker1;
var routeMarker2;
var pointMarker;*/


var routeDirectionRenderer;

var mapOptions = {
    center:laPaz,
    zoom:12,
    mapTypeId:google.maps.MapTypeId.ROADMAP,
    disableDefaultUI:true,
    panControl:true,
    zoomControl:true,
    scaleControl:true
};

//Main function
$(document).ready(function () {
    initMap();
});

//this function load the map in the map_canvas
function initMap() {
	if(document.getElementById("map_canvas")!=null) {
		map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
	}
    
}

//
// Init and util functions
//

/*function switchFadingViews(id1, id2) {
    $(id1).fadeOut('fast', function () {
        $(id2).fadeIn('fast');
    });
}*/

function initRouteView() {
    $('#pointAlertType').click(function () {
        clearRouteMap();
        switchFadingViews('#routeAlertTypeFields', '#pointAlertTypeFields');
    });

    $('#routeAlertType').click(function () {
        clearRouteMap();
        switchFadingViews('#pointAlertTypeFields', '#routeAlertTypeFields');
    });


    $('#saveAlert').click(function () {
        var alertType = $("input[name=alertType]:checked").val();

        if (alertType == "point") {
            var alertHito = $('#alertPoint').val();
            $.ajax({
                type:'POST',
                url:'/rest/conflicts/createAlertPoint',
                data:{
                    alertHito:alertHito
                },
                success:function (data) {
                    alert("Alert created successfully");
                },
                error:function (xhr) {
                    alert(xhr.status);
                }
            });
            return false;
        } else if (alertType == "path") {
            var alertHito1 = $('#routeStart').val();
            var alertHito2 = $('#routeEnd').val();
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
                    alert("Alert created successfully");
                },
                error:function (xhr) {
                    alert(xhr.status);
                }
            });
        }
        return false;

    });


    $('#alertPoint').change(function () {
        pointMarker = displaySourcePointInRouteMap('#alertPoint', pointMarker, routeMap);

    });

    /*$('#routeStart').change(function () {
        var newMarker = displaySourcePointInRouteMap('#routeStart', routeMarker1, routeMap);
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
    $('#routeEnd').change(function () {
        var newMarker = displaySourcePointInRouteMap('#routeEnd', routeMarker2, routeMap);
        if (newMarker == null) {
            routeMarker2 = null;
            routeDirectionRenderer.setDirections({routes:[]});

        } else if (routeMarker1 != null) {
            routeMarker2 = newMarker;
            calculateRoute(routeMarker1.getPosition(), routeMarker2.getPosition(), routeDirectionRenderer);
        } else {
            routeMarker2 = newMarker;
        }

    });*/
}



//
// display route method
//
function createDirectionsRenderer(map) {
    return new google.maps.DirectionsRenderer({map:map,
        suppressMarkers:true,
        draggable:true});
}

/**
 * this function clear a rout map
 */
function clearRouteMap() {
    if (routeMarker1 != null) {
        routeMarker1.setMap(null);
        routeMarker1 = null;
    }
    if (routeMarker2 != null) {
        routeMarker2.setMap(null);
        routeMarker2 = null;
    }
    if (pointMarker != null) {
        pointMarker.setMap(null);
        pointMarker = null;
    }

    if (routeDirectionRenderer != null) {
        routeDirectionRenderer.setMap(null);
        routeDirectionRenderer = null;
        routeDirectionRenderer = createDirectionsRenderer(routeMap);
    }
}

function displaySourcePointInRouteMap(id, marker, map) {
    var item = $(id).find(":selected").data();

    if (item.id == null) {
        if (marker != null) {
            marker.setMap(null);
        }
        marker = null;
    } else if (marker == null) {
        marker = new google.maps.Marker({
            position:new google.maps.LatLng(item.mapX, item.mapY),
            map:map,
            title:""
        });
    } else {
        marker.setPosition(new google.maps.LatLng(item.mapX, item.mapY));
    }
    return marker;
}

function calculateRoute(start, end, directionRenderer) {
    var request = {
        origin:start,
        destination:end,
        provideRouteAlternatives:true,
        travelMode:google.maps.TravelMode.DRIVING
    };
    directionsService.route(request, function (result, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionRenderer.setDirections(result);
        }
    });
}


//
// conflict map view methods
//

var fillColor = {
    '1':'LightYellow',
    '2':'Gold',
    '3':'LightSalmon',
    '4':'DarkOrange',
    '5':'Red'
};

var strokeColor = {
    '1':'Khaki',
    '2':'GoldenRod',
    '3':'Orange',
    '4':'OrangeRed',
    '5':'DarkRed'
};

function getFillColor(level) {
    return fillColor[level];
}

function getStrokeColor(level) {
    return strokeColor[level];
}

function drawConflictPoint(map, point) {
    var latLng = new google.maps.LatLng(point.latitude, point.longitude);
    var circle = new google.maps.Circle({radius:point.radious, center:latLng, fillColor:getFillColor(point.level), strokeColor:getStrokeColor(point.level)});
    circle.setCenter(latLng);
    circle.setMap(map);
    var marker = new google.maps.Marker({
        position:latLng,
        map:map,
        title:point.name + ': ' + point.description

    });
    google.maps.event.addListener(marker, 'click', function () {
        map.setZoom(16);
        map.setCenter(latLng);
    });
}

//
//Helper functions
//

/*function checkConflicts() {
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

}*/



/**
 * set json object to select
 * @param divId
 * @param data
 */
function populateHitoSelectList(divId, data) {
    var list = $(divId);
    list.empty();
    list.append('<option value="-1">Seleccione un lugar</option>');
    $.each(data, function (i, item) {
        var option = $('<option value="' + item.id + '">' + item.city + ": " + item.zone + ": " + item.name + '</option>').data(item);
        list.append(option);
    });
    list.val(0).attr('selected', true);
}