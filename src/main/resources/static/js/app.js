var api = apiclient;
var Module = (function () {

    function _map(list) {
        return mapList = list.map(function (airports) {
            return {airportId: airports.airportId, code: airports.code,name:airports.name,location:airports.location,
                cityId:airports.cityId};
        })
    }



    function _table(airports) {
        airports = _map(airports);
        $("#Tairports > tbody").empty();
        airports.map(function (airport) {
            $("#Tairports > tbody").append(
                "<tr> <td>" +
                airport.airportId +
                "</td>" +
                "<td>" +
                airport.code +
                "</td> " +
                "<td>" +
                airport.name+
                "</td> " +
                "<td>" +
                airport.cityId+"</td>" +
                "</tr>"
            );
        });
    };



    function getAirportsByName(name) {

        apiclient.getAirportsByName(name).then(function (data){
            _table(data);
            plotMarkers(data);
        }).catch(function () {
            alert("Bad request")
            console.log("Bad request");
        });
    }
    function plotMarkers(m)
    {
        init();
        markers = [];
        bounds = new google.maps.LatLngBounds();

        m.forEach(function (marker) {
            var position = new google.maps.LatLng(marker.location.latitude, marker.location.longitude);

            markers.push(
                new google.maps.Marker({
                    position: position,
                    map: map,
                    animation: google.maps.Animation.DROP
                })
            );

            bounds.extend(position);
        });

        map.fitBounds(bounds);
    };

    function init (){
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });

    }


    return {
        getAirportsByName: getAirportsByName,
        init:init,

    };
})();