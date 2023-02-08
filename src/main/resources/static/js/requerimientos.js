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
    cargarRequerimientos();



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

async function cargarSolicitudes(){
    // const efectosReq = await fetch(ruta, objeto de peticion);
    const solicitudesReq = await fetch('/solicitudes');
    const solicitudes = await solicitudesReq.json();
    let elementos =[];
    for (let sol of solicitudes){
        console.log("nuevo ",sol);
        elementos.push(`<tr>
            <td>${sol.efecto.nombreEfecto}</td>
            <td>${sol.efecto.clase.abreviatura}</td>
            <td>${sol.cantidad} </td>
            <td>
                <a class="btn btn-danger"  onclick="eliminarSolicitud(${sol.solicitudId})">
                <i class=\"fas fa-trash\"></i>
                </a> 
            </td>
        </tr>`)
    }
    //me trae el elemento por id
    let tabla=document.getElementById("Solicitudes-tbody");
    tabla.innerHTML = elementos.join("");

}

async function eliminarSolicitud(id) {

    if (!confirm('¿Desea eliminar esta solicitud?')) {
        return;
    }
    await fetch("/solicitudes/" + id, {
        method: 'DELETE',
        headers:{
            'Content-Type': 'application/json'
        }
    });
    alert("Se elimininó  correctamente");
    cargarSolicitudes();

}

//requerimientos


async function generarRequerimiento(){

    let org=localStorage.getItem("organizacionId");
    org =Number(org);
    let fecha = document.getElementById("fecha").value;
    let fehaNueva = new Date(fecha)
    //peticion
    let peticionSolicitudes = await fetch("/solicitudes");
    //solicitudes
    let solicitudes= await peticionSolicitudes.json();
    let arraySol= [];
    for(let sol of solicitudes){
        arraySol.push(sol.solicitudId);
    }
    console.log("vemos la solicitueds de la peticion", arraySol);
    let payload = {"orgId": org, "fechaDeEntregaRequerida": fehaNueva,"idSolicitudes":arraySol}
    fetch("/requerimientos",{
        method: "POST",
        body: JSON.stringify(payload),
        headers: {
            "Content-Type" : "application/json"
        }
    })
    modalFecha.close();
    alert("se creo un nuevo requerimiento")
}

    //"fechaDeEntregaRequerida": "2023-03-05T12:59:11.332",


async function cargarRequerimientos(){
    // const efectosReq = await fetch(ruta, objeto de peticion);
    const requerimientosReq = await fetch('/requerimientos');
    const solicitudes = await solicitudesReq.json();
    let elementos =[];
    for (let sol of solicitudes){
        console.log("nuevo ",sol);
        elementos.push(`<tr>
            <td>${sol.efecto.nombreEfecto}</td>
            <td>${sol.efecto.clase.abreviatura}</td>
            <td>${sol.cantidad} </td>
            <td>
                <a class="btn btn-danger"  onclick="eliminarSolicitud(${sol.solicitudId})">
                <i class=\"fas fa-trash\"></i>
                </a> 
            </td>
        </tr>`)
    }
    //me trae el elemento por id
    let tabla=document.getElementById("Requerimientos-tbody");
    tabla.innerHTML = elementos.join("");

}

