$(document).ready(function() {
    $('#moda').attr('min', new Date().toISOString().split('T')[0])
    //const modalFecha = document.querySelector("#modalFecha input")
    //modalFecha.min = "2022-01-31"
    // ver tema de minimo
    //modalFecha.min = `${new Date().getFullYear()}-${new Date().getMonth()+1}-${new Date().getDate()}`
    console.log(modalFecha);
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
    console.log(selectorEfecto);
    let cant = document.getElementById("cantidadEf").value;
    console.log(cant);
    let efecID = selectorEfecto
    console.log(efecID);
    let payload = {cantidad: cant  , efectoId: efecID }
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
    let elementos =[];
    for (let sol of solicitudes){
        elementos.push(`<tr>
            <td>${sol.efecto.nombreEfecto}</td>
            <td>${sol.efecto.clase.abreviatura}</td>
            <td>${sol.cantidad} </td>
        </tr>`)
    }
    //me trae el elemento por id
    let tabla=document.getElementById("Solicitudes-tbody");
    tabla.innerHTML = elementos.join("");

}




async function generarRequerimiento(){
    const requerimientosReq = await fetch('/requerimientos');
    const requerimientos = await requerimientosReq.json();
    console.log(requerimientosReq);
    console.log(requerimientos);
    let elementos =[];
    for (let req of requerimientos){
        elementos.push(`<tr>
            <td>${req.organizacion.organizacionId}</td>
            <td>${req.fechaDeEntregaRequerida}</td>
            <td>${req.solicitudes.solicitudId} </td>
        </tr>`)
    }
    //let tabla=document.getElementById("Solicitudes-tbody");
    //tabla.innerHTML = elementos.join("");

    //{
      //  "orgId": 1,
        //"fechaDeEntregaRequerida": "2023-03-05T12:59:11.332",
        //"idSolicitudes":[1,2]
    //}
}





//http://localhost:8282/clases/2/efectos
//id="select-efecto"