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

  //  cargarEstAb();

});
const btnAgregarEfecto= document.querySelector("#ventana-emergente");
const modal = document.querySelector("#modal");
const btnVolver=document.querySelector("#volver")

btnAgregarEfecto.addEventListener("click", ()=>{
    modal.showModal();
})
const elementoSelector= document.getElementById("select-clase");
console.log("elementoSelector",elementoSelector)
elementoSelector.addEventListener("change", ()=>{
    agregar();
})
btnVolver.addEventListener("click", ()=>{

    modal.close();
})

btnAceptar.addEventListener("click", ()=>{
    modalFecha.showModal();
})



async function agregar(){
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

function registrar(){
    let selectorEfecto= document.getElementById("select-efecto").value;
    let efecID = selectorEfecto
    console.log("valor del id efecto",efecID);
    let cant = document.getElementById("cantidadEf").value;
    let cantDisp = document.getElementById("cantidadEfDisp").value;
    console.log("valor cantidad",cant);
    let orgId = localStorage.getItem("organizacionId");
    console.log(orgId);
    let payload = {cantidadNecesaria: cant  , cantidadDisponible: cantDisp}
    fetch("/estadoAbastecimientos/organizaciones/"+ orgId+"/efectos/"+efecID,{
        method:"POST",
        body: JSON.stringify(payload),
        headers:{
            "Content-Type": 'application/json'
        }
    })
    modal.close();
    alert("Carga Correcta!");
    cargarEstAb();

}

let auxSolicitud=[];



// cargar solicitudes correspondiente según organizacion
async function cargarEstAb(){
    // const efectosReq = await fetch(ruta, objeto de peticion);
    let tabla=document.getElementById("estadoAbastecimiento-tbody");
    tabla.innerHTML="cargando...";
    let id = localStorage.getItem("organizacionId")
    const solicitudesReq = await fetch("/organizaciones/"+id+"/solicitudes");
    let solicitudes = await solicitudesReq.json();
    auxSolicitud=solicitudes.filter(
        function(sol){
        console.log("filter:", sol);
        if(sol.confirmadaSolicitud==false)
            return true;
    })
    let elementos =[];
    for (let sol of auxSolicitud){
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

//REQUERIMIENTOS


//requerimientos filtrados por id de org
async function morstrarRequerimientosOrgId(){
    //traigo la tabla
    let tabla=document.getElementById("Requerimientos-tbody");

    //traigo el id de la Org
    let id = localStorage.getItem("organizacionId")

    // const efectosReq = await fetch(ruta, objeto de peticion);
    const requerimientosReq = await fetch("/organizaciones/"+ id+"/requerimientos");
    let requerimientos = await requerimientosReq.json();
    let elementos =[];
    for (let req of requerimientos){
        console.log("nuevo re ",req);
        elementos.push(`<tr>
            <td>${req.requerimientoId}</td>
            <td>${req.solicitudes}</td>
            <td>${req.confirmado? "Autorizado" :"Pendiente"} </td>
        </tr>`)
    }
    //me trae el elemento por id

    tabla.innerHTML = elementos.join("");

}

// esta bien
async function generarRequerimiento(){
    let org=localStorage.getItem("organizacionId");
    org =Number(org);
    let fecha = document.getElementById("fecha").value;
    let fehaNueva = new Date(fecha)
    //peticion
    let arraySol= [];
    for(let sol of auxSolicitud){
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
    cargarSolicitudes();
    morstrarRequerimientosOrgId();

}



/* setTimeout(function (){
         cargarSolicitudes();
     }, 5000)
*/
    //"fechaDeEntregaRequerida": "2023-03-05T12:59:11.332",

/*


*/