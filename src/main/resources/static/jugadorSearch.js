const btnSearch = document.getElementById("buscarJugador");
btnSearch.addEventListener("click", buscarJugador);

function buscarJugador(event) {
    event.preventDefault();

    let inputValue = document.getElementById("search").value;

    let selectValue = document.getElementById("filtro").value;

    const data = {busqueda: inputValue, filtro: selectValue};

    var postOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    urlspringBoot = "/getJugadorSearch";

    fetch(urlspringBoot, postOptions)
        .then(response =>
            response.json())
        .then(result => {

            console.log(result);

            //generarTabla(result);

        })
            
        .catch(error => 
            console.log('error', error));

}