fetch('/Perfi',{method:'GET'})
.then(response => response.json())
.then(json=>{
console.log(json)
if(json==0)
{window.location.href="/login.html";
}
const nombre= document.getElementById("nombre");
nombre.value=json.name;
const apellido= document.getElementById("apellido");
apellido.value=json.surname;
const id= document.getElementById("id");
id.value=json.userid;
const email= document.getElementById("email");
email.value=json.email;

document.getElementById('boton').onclick = function() {
window.location.href="/editarperfil.html";
}
})