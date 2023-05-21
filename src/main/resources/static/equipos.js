const btnSearch = document.getElementById("buscarEquipo");
btnSearch.addEventListener("click", buscarEquipo);

function buscarEquipo(event) {
    event.preventDefault();

    let inputValue = document.getElementById("search").value;
    let selectValue = document.getElementById("filtro").value;

    var getOptions = {
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

        urlspringBoot = "/getEquipoSearch/" + selectValue + "/" + inputValue;

        fetch(urlspringBoot, getOptions)
            .then(response =>
                response.json())
            .then(result => {

                console.log(result);

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

    var table = document.getElementById("tablaEquipos");
    table.innerHTML = "";

    divErrorMsg.classList.add("alert");
    divErrorMsg.classList.add("alert-danger");
    divErrorMsg.classList.add("centered");
    divErrorMsg.setAttribute("role", "alert");
    divErrorMsg.innerHTML = message;

    errorDiv.appendChild(divErrorMsg);
}

async function generarTabla(result) {

    var table = document.getElementById("tablaEquipos");
    const errorDiv = document.getElementById("error-message");

    table.innerHTML = ""; //Borramos la tabla actual para actualizarla
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

    h1.innerHTML = "Nombre";
    h2.innerHTML = "Entrenador";
    h3.innerHTML = "Presidente";
    h4.innerHTML = "Estadio";
    h5.innerHTML = "Posicion";
    h6.innerHTML = "Capacidad";

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

        cell1.innerHTML = result[i].nombre;
        cell2.innerHTML = result[i].entrenador;
        cell3.innerHTML = result[i].presidente;
        cell4.innerHTML = result[i].estadio;
        cell5.innerHTML = result[i].posicion;
        cell6.innerHTML = result[i].capacidad;

        tbody.appendChild(row);

    }

    table.appendChild(tbody);

}