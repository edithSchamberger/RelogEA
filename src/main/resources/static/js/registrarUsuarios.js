$(document).ready(function() {
});
async function cargarUsuarios(){
    let selectorNombre = document.getElementById('txtNombre').value;
    let selectorApellido = document.getElementById('txtApellido').value;
    let selectorEmail = document.getElementById('txtEmail').value;
    let selectorPassword = document.getElementById('txtPassword').value;
    let selectorRol = document.getElementById('select-rol').value;
    console.log("esto es el rol", selectorRol);
    let repetirPassword = document.getElementById('txtRepetirPassword').value;
    if (repetirPassword != selectorPassword) {
        alert('La contraseña que escribiste es diferente.');
        return;
    }
    let payload = {nombre : selectorNombre,
        apellido: selectorApellido,
        email: selectorEmail,
        password: selectorPassword,
        rol:selectorRol}
    const request = await fetch('/usuarios', {
        method: 'POST',
        body : JSON.stringify(payload),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }

    });
    console.log(request);
    alert("La cuenta fue creada con exito!");
    window.location.href = 'index.html';

}
