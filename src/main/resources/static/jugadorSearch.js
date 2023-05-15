const btnSearch = document.getElementById("buscarJugador");
btnSearch.addEventListener("click", buscarJugador);

function buscarJugador(event) {
    event.preventDefault();

    let inputValue = document.getElementById("search").value;

    let selectValue = document.getElementById("filtro").value;


    var jugadoresOptions = {
        method: 'GET',
    };

    urlspringBoot = "/getJugadorSearch/" + selectValue + "/" + inputValue;

    fetch(urlspringBoot, jugadoresOptions)
        .then(response =>
            response.json())
        .then(result => {

            console.log(result);

            //generarTabla(result);

        })
            
        .catch(error => 
            console.log('error', error));

}