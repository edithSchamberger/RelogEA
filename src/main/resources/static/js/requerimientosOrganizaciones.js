// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarAllRequerimientos();
    $('#allRequerimientos').DataTable();
});


async function cargarAllRequerimientos(){
    // const efectosReq = await fetch(ruta, objeto de peticion);
    const requerimientoReq = await fetch('/requerimientos');
    const requerimientos = await requerimientoReq.json();
    let elementos =[];
    for (let req of requerimientos){
        console.log("nuevo ",req);
        elementos.push(`<tr>
            <td>${req.fechaDeEntregaRequerida}</td>
            <td>${req.organizacion.nombre}</td>
            <!-- condicion ? si true : si false-->
            <td>${req.confirmado? "Autorizado" :"Pendiente"} </td>
            <td>
                <a class="btn btn-info"  onclick="autorizarReq(${req.requerimientoId})">
                    <i >Autorizar</i>
                </a> 
                <a class="btn btn-success" onclick="guardarId(${req.requerimientoId})">
                    <i class="fas fa-info-circle"></i>
                </a>
            </td>            
        </tr>`)
        console.log("IDreque ",req.requerimientoId);
    }
    //me trae el elemento por id
    let tabla=document.getElementById("allRequerimientos-tbody");
    tabla.innerHTML = elementos.join("");
}

async function autorizarReq(id) {
    if (!confirm('¿Desea confirmar este Requerimiento?')) {
        return;
    }
    console.log("autorizando", id)
    await fetch("/requerimientos/" + id, {
        method: 'PATCH',
        headers:{
            'Content-Type': 'application/json'
        }
    });
    alert("Se autorizo  correctamente");
    cargarAllRequerimientos();

}
