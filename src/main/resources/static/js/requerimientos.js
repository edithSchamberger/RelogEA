$(document).ready(function() {
   // $('#modalFecha').attr('min', new Date().toISOString().split('T')[0])
    //let modalFecha = document.querySelector("#modalFecha input")
    //new Date(new Date().getFullYear(),new Date().getMonth(),new Date().getDate()+1)
    // ver tema de minimo
    //modalFecha.min = `${new Date().getFullYear()}-${new Date().getMonth()+1}-${new Date().getDate()}`
    //console.log(modalFecha);
    //const fecha = new Date();
    //const añoActual = fecha.getFullYear();
    //const mesActual = fecha.getMonth() + 1;
    //const diaActual = fecha.getDate() + 1;

    cargarSolicitudes();



});
const btnAgregarEfecto= document.querySelector("#ventana-emergente");
const modal = document.querySelector("#modal");
const btnVolver=document.querySelector("#volver")
const btnAceptar=document.querySelector("#aceptar")
const modalFecha = document.querySelector("#modalFecha");
const btnVolverFecha=document.querySelector("#volverFecha")

btnAgregarEfecto.addEventListener("click", ()=>{
    modal.showModal();
})
btnVolver.addEventListener("click", ()=>{
    modal.close();
})

btnAceptar.addEventListener("click", ()=>{
    modalFecha.showModal();
})
btnVolverFecha.addEventListener("click", ()=>{
    modalFecha.close();
})

const elementoSelector= document.getElementById("select-clase");
elementoSelector.addEventListener("change", ()=>{
    agregarSolicitudes();
})

async function agregarSolicitudes(){
    let selectorEfecto= document.getElementById("select-efecto");
    //valores por defecto del fetch el metodo ya es GET
    //en este caso no mando body
    let idClase= elementoSelector.value;
    let peticion = await fetch("/clases/"+idClase+"/efectos");
    let efectosJson = await peticion.json();
    console.log(efectosJson);
    let elementosHTML= [];
    for (let efecto of efectosJson){
        console.log("efecto");
        console.log(efecto);
        let elementoEfecto = `<option value=${efecto.efectoId}>${efecto.nombreEfecto}</option>`
        elementosHTML.push(elementoEfecto);
    }
    selectorEfecto.innerHTML= elementosHTML.join();
}

function registrarSolicitudes(){
    let selectorEfecto= document.getElementById("select-efecto").value;
    let efecID = selectorEfecto
    console.log("valor del id efecto",efecID);

    let cant = document.getElementById("cantidadEf").value;
    console.log("valor cantidad",cant);
    let orgId = localStorage.getItem("organizacionId");
    console.log(orgId);
    let payload = {cantidad: cant  , efectoId: efecID , organizacionId :orgId}
    console.log(payload);
    fetch("/solicitudes",{
        method:"POST",
        body: JSON.stringify(payload),
        headers:{
            "Content-Type": 'application/json'
        }
    })
    modal.close();
    alert("Se creo la Solicitud del EFECTO");
    cargarSolicitudes();
}

async function  cargarSolicitudes(){
    // const efectosReq = await fetch(ruta, objeto de peticion);
    const solicitudesReq = await fetch('/solicitudes');
    const solicitudes = await solicitudesReq.json();
    // lo que manda el servidor
    //console.log(efectos);
    // muestra la peticion
    //console.log(efectosReq);
    let botonEliminar = `<a class="btn btn-danger"  onclick="eliminarSolicitud(${solicitudes.idSolicitudes})"><i class=\"fas fa-trash\"></i></a>`;
    let elementos =[];
    for (let sol of solicitudes){
        elementos.push(`<tr>
            <td>${sol.efecto.nombreEfecto}</td>
            <td>${sol.efecto.clase.abreviatura}</td>
            <td>${sol.cantidad} </td>
            <td>${botonEliminar} </td>
        </tr>`)
    }
    //me trae el elemento por id
    let tabla=document.getElementById("Solicitudes-tbody");
    tabla.innerHTML = elementos.join("");

}

async function generarRequerimiento(){
    let org=localStorage.getItem("organizacionId");
    org =Number(org);
    let fecha = document.getElementById("fecha").value;
    let fehaNueva = new Date(fecha)

    let payload = {"orgId": org, "fechaDeEntregaRequerida": fehaNueva,"idSolicitudes":[1,2,3]}
    fetch("/requerimientos",{
        method: "POST",
        body: JSON.stringify(payload),
        headers: {
            "Content-Type" : "application/json"
        }

    })
}


async function eliminarSolicitud(id) {

    if (!confirm('¿Desea eliminar esta solicitud?')) {
        return;
    }

    const request = await fetch('/Solicitudes/' + id+'?status=false', {
        method: 'DELETE',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    location.reload()
}

