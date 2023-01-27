$(document).ready(function() {
    cargarSolicitudes();



});

const btnAgregarEfecto= document.querySelector("#ventana-emergente");
const modal = document.querySelector("#modal");
const btnVolver=document.querySelector("#volver")
btnAgregarEfecto.addEventListener("click", ()=>{
    modal.showModal();
})
btnVolver.addEventListener("click", ()=>{
    modal.close();
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
        let elementoEfecto = `<option>${efecto.nombreEfecto}</option>`
        elementosHTML.push(elementoEfecto);
    }
    selectorEfecto.innerHTML= elementosHTML.join();
}

function registrarSolicitudes(){
    let selectorEfecto= document.getElementById("select-efecto").value;
    console.log("imprime 1");
    console.log(selectorEfecto);
    let cant = document.getElementById("cantidadEf").value;
    console.log("imprime 2");
    console.log(cant);
    let efecID = selectorEfecto
    console.log("imprime 3");
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



//http://localhost:8282/clases/2/efectos
//id="select-efecto"