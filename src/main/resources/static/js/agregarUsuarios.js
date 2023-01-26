// Call the dataTables jQuery plugin
$(document).ready(function() {

});
async function registrarUsuarios(){
    let datos = {};
    datos.grado = document.getElementById('txtGrado').value;
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.status = document.getElementById('txtStatus').value;
    datos.idOrg = document.getElementById('txtNroOrg').value;
    alert(datos.idOrg);

    const request = await fetch('/personas', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(datos)
    });

    alert("Se agregó a la persona con exito!");
    window.location.href = 'movimientos.html';

}