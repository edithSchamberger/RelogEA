
let map = L.map('map').setView([-34.5768061,-58.4392418,16.29],5)

//Agregar tilelAyer mapa base desde openstreetmap
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',{
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);


function posicionar(){
    let latitud = document.getElementById("txtLatitud").value;
    let longitud = document.getElementById("txtLongitud").value;
    console.log("aca vemos latitud y longitud",latitud,longitud)
    var marker = L.marker([latitud,longitud]).addTo(map);
}
/*
id="txtLatitud"
id="txtLongitud"
var marker = L.marker([-34.5768061,-58.4392418,16.29]).addTo(map);
var circle = L.circle([-34.5768061,-58.4392418,16.29], {
    color: 'red',
    fillColor: '#f03',
    fillOpacity: 0.5,
    radius: 200
}).addTo(map);


document.getElementById('select-location').addEventListener('change', function(e){
    let coords = e.target.value.split(",");
    map.flyTo(coords,13);
})
*/