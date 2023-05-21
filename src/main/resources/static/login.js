document.getElementById('log').onclick = function() {
  const correo = document.getElementById('V').value;
  const password = document.getElementById('password').value;
  fetch('/logg/'+correo+'/'+password,{method:'GET'})
  .then(response => response.json())
  .then(a=>{
    console.log(a);
    url="redirect:/perfil/"+a;
    window.location.href="/perfil.html";
    console.log(url);
});
};