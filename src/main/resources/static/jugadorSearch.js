const btnSearch = document.getElementById("buscarJugador");
btnSearch.addEventListener("click", buscarJugador);

function buscarJugador(event) {
    event.preventDefault();

    let inputValue = document.getElementById("search").value;
    let selectValue = document.getElementById("filtro").value;

    var jugadoresOptions = {
        method: 'GET',
    };

    if (inputValue) {

        //Do nothing

    } else {

        inputValue = "all";

    }

    if (selectValue == "filtro") {

        errorMessage("Selecciona un filtro");

    } else {

        urlspringBoot = "/getJugadorSearch/" + selectValue + "/" + inputValue;

        fetch(urlspringBoot, jugadoresOptions)
            .then(response =>
                response.json())
            .then(result => {
                if (result.length == 0) {
                    errorMessage("Ningún resultado coincide con tu búsqueda.");
                } else {
                    generarTabla(result);
                }
            })

            .catch(error =>
                console.log('error', error));

    }
}

function errorMessage(message) {

    var divErrorMsg = document.createElement("div");
    const errorDiv = document.getElementById("error-message");
    errorDiv.innerHTML = "";

    var table = document.getElementById("tablaJugadores");
    table.innerHTML = "";

    divErrorMsg.classList.add("alert");
    divErrorMsg.classList.add("alert-danger");
    divErrorMsg.classList.add("centered");
    divErrorMsg.setAttribute("role", "alert");
    divErrorMsg.innerHTML = message;

    errorDiv.appendChild(divErrorMsg);


}

async function generarTabla(result) {

    var table = document.getElementById("tablaJugadores");
    const errorDiv = document.getElementById("error-message");

    table.innerHTML = "";
    errorDiv.innerHTML = "";

    var thead = document.createElement("thead");
    var tbody = document.createElement("tbody");

    let tr = document.createElement("tr");

    var h1 = tr.insertCell(0);
    var h2 = tr.insertCell(1);
    var h3 = tr.insertCell(2);
    var h4 = tr.insertCell(3);
    var h5 = tr.insertCell(4);
    var h6 = tr.insertCell(5);
    var h7 = tr.insertCell(6);
    var h8 = tr.insertCell(7);

    h1.innerHTML = "Nombre";
    h2.innerHTML = "Posicion";
    h3.innerHTML = "Esquipo";
    h4.innerHTML = "Numero de partidos";
    h5.innerHTML = "Goles";
    h6.innerHTML = "Asistencias";
    h7.innerHTML = "T. Amarillas";
    h8.innerHtML = "T. Rojas";

    thead.appendChild(tr);
    table.appendChild(thead);


    for (let i = 0; i<result.length; i++) {

        let row = document.createElement("tr");

        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);

        cell1.innerHTML = result[i].nombre;
        cell2.innerHTML = result[i].posicion;
        cell3.innerHTML = result[i].equipo;
        cell4.innerHTML = result[i].npartidos;
        cell5.innerHTML = result[i].goles;
        cell6.innerHTML = result[i].asistencias;
        cell7.innerHTML = result[i].amarillas;
        cell8.innerHTML = result[i].rojas;

        tbody.appendChild(row);

    }

    table.appendChild(tbody);

}