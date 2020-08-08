document.addEventListener("DOMContentLoaded", function (event) {
    const url = "/gethome";
    fetch(url)
        .then(data => {
            return data.json()
        })
        .then(results => {
            const coordinate = results;
            const lat = coordinate.results[0].geometry.location.lat;
            const lng = coordinate.results[0].geometry.location.lng;
            const homeLocation = {lat, lng};
            console.log(lat, "en", lng)

            map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: 52.091090, lng: 5.122374},
                zoom: 8
            });

            const marker = new google.maps.Marker({
                position: homeLocation,
                map: map,
                title: "Meryl's huis"
            });

            var textBox = '<div id="content">" ' +
                '<h3>Wil je in plaats van mailen langskomen?</h3> ' +
                '<p>Mijn adres is Pieter Cheeuwenlaan 52 in Beverwijk.</p> ' +
                '</div>';

            var infowindow = new google.maps.InfoWindow({
                content: textBox
            });

            marker.addListener('click', function() {
                infowindow.open(map, marker);
            });

        })
});