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
        let botonInfo = `<a href="organizaciones.html" class="btn btn-info" onclick="guardarId(${organizacion.id})">Est Ab</a>`;
        let botonNuevoRequerimiento = `<a href="requerimientos.html" class="btn btn-info" STYLE="background: #c92a2a" onclick="guardarId(${organizacion.id})">Nuevo Requerimiento</a>`;

        let org = "<tr><th>"+organizacion.nombre+" " + "</th>" +
            "<th>"+organizacion.efectivoOrganico+"</th>" +
            "<th>"+organizacion.latitud+"</th>" +
            "<th>"+organizacion.longitud+"</th>" +
            "<th>"+botonInfo+ "   "  +botonNuevoRequerimiento +"</th>"

        listadoHtml+= org
    }


    document.querySelector('#organizaciones tbody').outerHTML = listadoHtml;

}


function guardarId(id) {
    localStorage.id = id;
}

