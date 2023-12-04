//Call the datatable jQuery plugin
$(document).ready(function(){
    //on ready
})

async function registrarUsuarios(){

    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repetirPassword = document.getElementById('txtRepetirPassword').value;

    if(datos.password != repetirPassword){
        alert("Las Contraseñas No Coinciden");
        return;
    }

      const request  = await fetch('api/usuarios', {
          method: 'POST',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(datos),
        });

    alert("Usuario registrado!")
    window.location.href = "login.html"
}

