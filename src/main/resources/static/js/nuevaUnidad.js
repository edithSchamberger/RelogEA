
$(document).ready(function() {

});

//servidor
async function registrarOrganizacion(){
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.efectivoOrganico = document.getElementById('txtEfectivo').value;
    datos.latitud= document.getElementById("txtLatitud").value;
    datos.longitud= document.getElementById("txtLongitud").value;
    const request = await fetch('/organizaciones', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(datos)
    });

    console.log(request);
    alert("Se agregó a la Organizacion con éxito!");
    window.location.href = 'organizaciones.html';

}
