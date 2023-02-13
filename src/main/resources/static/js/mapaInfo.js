let map = L.map('map').setView([-44.1382929,-61.2196494,16.29],5)

//Agregar tilelAyer mapa base desde openstreetmap
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',{
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

async function posicion(){
    let peticionOrganizaciones= await fetch("/organizaciones")
    let organizacionesJson=await peticionOrganizaciones.json()
    for (let organizacion of organizacionesJson){
        var marker = L.marker([organizacion.latitud,organizacion.longitud]).addTo(map);
    }

}

posicion();







/*
function posicionar(){
    let latitud = document.getElementById("txtLatitud").value;
    let longitud = document.getElementById("txtLongitud").value;
    console.log("aca vemos latitud y longitud",latitud,longitud)
    var marker = L.marker([latitud,longitud]).addTo(map);
}*/