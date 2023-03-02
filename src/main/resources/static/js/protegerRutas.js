//comparar todos los roles...

let rol= localStorage.getItem("rol");
let pathname = window.location.pathname;
console.log(window.location)
console.log("Rol con el que se genera el Ingreso",rol)
    if(rol==null){
        console.log("probamos nuevo rol dentro del if",rol)
        alert("")
        window.location.href="index.html";
    }

if(pathname =="/requerimientosOrganizaciones.html" ){
    if(rol=="Usuario" ){
        window.location.href="principal.html";
    }
}
if(pathname =="/efectos.html" ){
    if(rol!="Administrador" ){
        window.location.href="principal.html";
    }
}
