$(document).ready(function() {
    cargarEfectos();
    $('#efectos').DataTable();
});

//llamado al servidor
async function  cargarEfectos(){
    // const efectosReq = await fetch(ruta, objeto de peticion);
    const efectosReq = await fetch('/efectos');
    const efectos = await efectosReq.json();
    // lo que manda el servidor
    //console.log(efectos);
    // muestra la peticion
    //console.log(efectosReq);
    let elementos =[];
    for (let efecto of efectos){
        console.log(efecto);
        elementos.push(`<tr>
            <td>${efecto.nombreEfecto}</td>
            <td>${efecto.clase.abreviatura}</td>
            <td>${efecto.clase.descripcionTipo} </td>
            <td>${efecto.clase.unidadMedida}</td>
        </tr>`)
    }
    //me trae el elemento por id
    let tabla=document.getElementById("efectos-tbody");
    tabla.innerHTML = elementos.join("");
    //join toma un array y lo convierte en string
}




function guardarId(id) {
    localStorage.id = id;
}

const btnAgregarEfecto= document.querySelector("#ventana-emergente");
const modal = document.querySelector("#modal");
const btnVolver=document.querySelector("#volver")
btnAgregarEfecto.addEventListener("click", ()=>{
    modal.showModal();
})
btnVolver.addEventListener("click", ()=>{
    modal.close();
})


function registrarEfecto(){
    const nombreEf =document.getElementById("txtNombreEf").value; //string
    const idClase= document.getElementById("select-clase").value; //
    let payload = {nombreEfecto: nombreEf};
    //peticion http
    // fetch
    fetch("/efectos/"+idClase,{
        method: "POST",
        body: JSON.stringify(payload),
        headers:{
            "Content-Type": 'application/json'
        }
    })
    modal.close();
    alert("Se creo el efecto correctamente");
    cargarEfectos();

}

