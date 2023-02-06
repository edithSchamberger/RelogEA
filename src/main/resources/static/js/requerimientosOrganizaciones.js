// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarOrganizaciones();
  $('#organizaciones').DataTable();
});
async function cargarOrganizaciones(){

    const request = await fetch('/organizaciones', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });
    const listOrganizaciones = await request.json();
    let listadoHtml = '';

    for (let organizacion of listOrganizaciones) {

        let org = "<tr>" +
            "<th>"+organizacion.organizacionResponseId+"</th>" +
            "<th>"+organizacion.nombre+"</th>" +
            "<th>"+" "+"</th>" +
            "<th>" +
            "<i class=\"fas fa-info-circle\"></i>\n" +
            "<i class=\"fas fa-trash\"></i>" +
            "</th></>";

        listadoHtml+= org
    }

    console.log(listOrganizaciones);

    document.querySelector('#organizaciones tbody').outerHTML = listadoHtml;

}
function guardarId(id) {
    localStorage.id = id;
}
async function eliminarOrganizacion(id) {

    if (!confirm('¿Desea eliminar esta organización?')) {
        return;
    }


    const request = await fetch('/organizaciones/' + id +'?status=false', {

        method: 'PATCH',
            headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

    });
    alert('Organización eliminada');


    location.reload()
}
