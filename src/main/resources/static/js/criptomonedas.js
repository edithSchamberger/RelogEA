// Call the dataTables jQuery plugin
$(document).ready(function() {
    actualizarEmailDelUsuario(localStorage.idUser);
    cargarCriptos(localStorage.idUser);
    $('#criptomonedas').DataTable();

});

function actualizarEmailDelUsuario(idUser) {
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
    //idUser=localStorage.id;
}


async function cargarCriptos(idUser) {
    const request = await fetch('criptomonedas', {
        method: 'GET',
        headers: getHeaders()
    });
    const criptomonedas = await request.json();

    const request2 = await fetch('usuarios/'+localStorage.idUser+'/criptoSeguidas', {
        method: 'GET',
        headers: getHeaders()
    });
    const criptoSeguidas = await request2.json();
    let criptoSeguidasLista=[];
    let usuario = {};
    for (let criptoSeg of criptoSeguidas) {
        criptoSeguidasLista.push(criptoSeg.id_cripto);
        usuario=criptoSeg.usuario;
    }
    let listadoHtml = '';
    for (let criptomoneda of criptomonedas) {;

        if (criptoSeguidasLista.includes(criptomoneda.id_cripto)) {
            let resultado = criptoSeguidas.find( criptoSeguida => criptoSeguida.id_cripto === criptomoneda.id_cripto );
            let botonSeguido = '<a href="#" onclick="dejarDeSeguirCripto('+JSON.stringify(resultado).replace(/\"/g,"&quot;")+')" class="btn btn-success btn-circle btn-sm"><i class="fas fa-check"></i></a>';
            let criptoHtml = '<tr><td>' + criptomoneda.market_cap_rank + '</td><td>' + criptomoneda.symbol + '</td><td>' + criptomoneda.id_cripto + '</td><td>' + criptomoneda.current_price + '</td><td>'
                + criptomoneda.price_change_percentage24h + '</td><td>' + criptomoneda.total_volume
                + '</td><td>' + botonSeguido + '</td></tr>';
            listadoHtml += criptoHtml;
        }else {
            let datos = {};
            datos.id_cripto=criptomoneda.id_cripto;
            datos.usuario=usuario;
            let botonNoSeguido = '<a href="#" onclick="seguirCripto('+JSON.stringify(datos).replace(/\"/g,"&quot;")+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-exclamation-circle"></i></a>';
            let criptoHtml = '<tr><td>' + criptomoneda.market_cap_rank + '</td><td>' + criptomoneda.symbol + '</td><td>' + criptomoneda.id_cripto + '</td><td>' + criptomoneda.current_price + '</td><td>'
                + criptomoneda.price_change_percentage24h + '</td><td>' + criptomoneda.total_volume
                + '</td><td>' + botonNoSeguido + '</td></tr>';
            listadoHtml += criptoHtml;
        }


    }

    document.querySelector('#criptomonedas tbody').outerHTML = listadoHtml;

}

function getHeaders() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}

async function dejarDeSeguirCripto(criptoSegui) {
    const request = await fetch('/criptoSeguidas/' + criptoSegui.id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    console.log("sale del request");
    console.log(request);
    location.reload()
}

async function seguirCripto(datos) {
    const request = await fetch('criptoSeguidas', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    console.log("sale del request");
    console.log(request);
    location.reload()
}