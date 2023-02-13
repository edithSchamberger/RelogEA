$(document).ready(function() {
  localStorage.clear();
});


function getHeaders() {
  return {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
    'Authorization': localStorage.token
  };
}

async function iniciarSesion() {

  let datos = {};
  datos.id = null;
  datos.nombre = null;
  datos.apellido = null;
  datos.email = document.getElementById('txtEmail').value;
  datos.telefono = null;
  datos.password = document.getElementById('txtPassword').value;
  console.log(datos);

  const request = await fetch('/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(datos)
  });

  const respuesta = await request.text();
  if (request.status == 200) {
    localStorage.token = respuesta;
    const request = await fetch('/usuarios/' + datos.email, {
      method: 'GET',
      headers: getHeaders()

    })

    const usuario = await request.json();
    localStorage.email = datos.email;
    localStorage.idUser = usuario.id;
    localStorage.setItem("rol",usuario.rol);
    window.location.href = 'principal.html'
  } else {
    alert("Las credenciales son incorrectas. Por favor intente nuevamente.");
  }
}

async function cargarUsuario() {
  if(respuesta != 'ERROR'){
    localStorage.tocken = respuesta;
    localStorage.email = datos.email;
    window.location.href = 'Index.html'
  }else {
    alert("Usuario o Contraseña incorrecta");
  }
}

// proteger rutas
async function protegerRutas(){


}

