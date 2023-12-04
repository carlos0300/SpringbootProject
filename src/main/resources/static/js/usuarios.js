//Call the datatable jQuery plugin
$(document).ready(function(){
    cargarUsuarios();
    $('#usuarios').DataTable();
})

async function cargarUsuarios(){
      const request  = await fetch('api/usuarios', {
          method: 'GET',
          headers: getHeaders(),
        });
        const usuarios = await request.json();

        let botonEliminar

        console.log(usuarios);

        let usuarioHTML
        let listadoUsuarios = ''

        usuarios.map((usuario) => {

        botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i> </a>';
        usuarioHTML = '<tr> <td> '+ usuario.id + '</td> <td>'
                    + usuario.nombre + ' ' + usuario.apellido + '</td> <td>'
                    + usuario.email + '</td> <td>' + usuario.telefono
                    + '</td>  <td>' + botonEliminar + ' </td> </tr>';

        listadoUsuarios += usuarioHTML;
        })

        document.querySelector('#usuarios tbody').outerHTML = listadoUsuarios
}

async function eliminarUsuario(id){

    if(confirm("Desea eliminar el usuario:" + id)){
         const request  = await fetch('api/usuario/' + id , {
                      method: 'DELETE',
                      headers: getHeaders(),
                    });
                    location.reload();
    }

}

function getHeaders(){
    return {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': localStorage.token
           }
}