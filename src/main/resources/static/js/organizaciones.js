$(document).ready(function() {
    cargarOrganizaciones();
    $('#organizaciones').DataTable();
});

//llamado al servidor
async function cargarOrganizaciones(){
    const organizacionesReq = await fetch('organizaciones', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const organizaciones = await organizacionesReq.json();
    console.log(organizaciones);
    let listadoHtml = '';
    for (let organizacion of organizaciones) {
        console.log("prueba de organizacion", organizacion)
        let botonInfo = `<a href="organizaciones.html" class="btn btn-info" onclick="guardarId(${organizacion.organizacionId})">Est Ab</a>`;
        let botonNuevoRequerimiento = `<a href="requerimientos.html" class="btn btn-info" STYLE="background: #258391" onclick="guardarId(${organizacion.organizacionId})">Nuevo</a>`;

        let org = "<tr><th>"+organizacion.nombre+" " + "</th>" +
            "<th>"+organizacion.efectivoOrganico+"</th>" +
            "<th>"+organizacion.latitud+"</th>" +
            "<th>"+organizacion.longitud+"</th>" +
            "<th>"+botonNuevoRequerimiento+ " "  +botonInfo +"</th>"

        listadoHtml+= org
    }
    document.querySelector('#organizaciones tbody').outerHTML = listadoHtml;

}

function guardarId(organizacionId) {
    console.log("id de la organi", organizacionId);
    alert("Crear un nuevo Requerimiento");
    localStorage.setItem("organizacionId",String(organizacionId) );
    //guardar un objeto
    //localStorage.setItem("organizacionId",JSON.stringify(OBJETO) );

}

