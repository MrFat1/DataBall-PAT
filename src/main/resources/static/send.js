const form  = document.querySelector('#submit');

form.addEventListener('submit', function (event) {

    event.preventDefault(); //Cancel event

    const correo = form.elements['email'];

    let adress = correo.value;

    if (adress == null || adress == "") {

        confirm("Rellena los campos.");

    } else {

        confirm("Correo registrado correctamente: " + "\nEmail: " + adress);

    }


});