$(document).ready(function() {
});
async function cargarUsuarios(){
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if (repetirPassword != datos.password) {
        alert('La contraseña que escribiste es diferente.');
        return;
    }
    const request = await fetch('/usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(datos)
    });
    console.log(request);
    alert("La cuenta fue creada con exito!");
    window.location.href = 'index.html';

}
