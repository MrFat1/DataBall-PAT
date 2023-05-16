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

    urlspringBoot = "/getEquipoSearch/" + selectValue + "/" + inputValue;

    fetch(urlspringBoot, getOptions)
        .then(response =>
            response.json())
        .then(result => {

            console.log(result);

            if (result.length == 0) {
                alert("Ningún resultado coincide con tu búsqueda.");
            } else {
                generarTabla(result);
            }

        })
            
        .catch(error => 
            console.log('error', error));

}

async function generarTabla(result) {

    var table = document.getElementById("tablaEquipos");

    table.innerHTML = ""; //Borramos la tabla actual para actualizarla

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

    h1.innerHTML = "Nombre";
    h2.innerHTML = "Entrenador";
    h3.innerHTML = "Presidente";
    h4.innerHTML = "Estadio";
    h5.innerHTML = "Posicion";
    h6.innerHTML = "Capacidad";
    h7.innerHTML = "Masa Salarial";

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

        cell1.innerHTML = result[i].nombre;
        cell2.innerHTML = result[i].entrenador;
        cell3.innerHTML = result[i].presidente;
        cell4.innerHTML = result[i].estadio;
        cell5.innerHTML = result[i].posicion;
        cell6.innerHTML = result[i].capacidad;
        cell7.innerHTML = result[i].masaSalarial;

        tbody.appendChild(row);

    }

    table.appendChild(tbody);

}