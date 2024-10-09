var nombre = document.getElementById('nombre');
var email = document.getElementById('email');
var mensaje = document.getElementById('mensaje');
function validarDatos()
{
  

}

function ventanaSecundaria (URL){ 
    window.open(URL,"ventana1","width=620,height=500,scrollbars=NO") 
 } 
const contenedorPrincipal = document.getElementById('contenedor-principal');

//TERCER PASO

const contenedorCarrito = document.getElementById('carrito-contenedor');
//SEXTO PASO
const botonVaciar = document.getElementById('vaciar-carrito');
//SEXTIMO PASO, MODIFICAR LOS CONTADORES
const contadorCarrito = document.getElementById('contadorCarrito');

//OCTAVO PASO
const cantidad = document.getElementById('cantidad');
const precioTotal = document.getElementById('precioTotal');
const cantidadTotal = document.getElementById('cantidadTotal');

let carrito = [];

document.addEventListener('DOMContentLoaded', () => {
    if (localStorage.getItem('carrito')){
        carrito = JSON.parse(localStorage.getItem('carrito'));
        actualizarCarrito();
    }
})

//SEXTO PASO
botonVaciar.addEventListener('click', () => {
    carrito.length = 0;
    actualizarCarrito();
})
cargaInicial();
function cargarFormulario()
{
    contenedorPrincipal.innerHTML="";
    contenedorPrincipal.innerHTML = `       <div class="container">
    <div class="row justify-content-center">
        <div class="col-6 p-5 bg-white shadow-lg rounded">

            <form id="register-form" method="post">
                <h2>Pedir presupuesto</h2>
                <hr>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input name="nombre" id="nombre" type="text" class="form-control" placeholder="Ingrese su nombre">
                </div>
            
                
                <div class="form-group">
                    <label for="tipo_empresa">Tipo de cliente</label>
                    <select class="custom-select"><option value="particular">Particular</option><option value="empresa">Empresa</option></select>
                    </div>
                    <div class="form-group">
                    <label for="exampleInputEmail1">Correo electrónico</label>
                    <input name="email" id="email" type="email" class="form-control" placeholder="Ingrese su mail">
                    <small id="emailHelp" class="form-text text-muted">Nunca compartiremos su correo electrónico con nadie más</small>
                </div>
                <div class="form-group">
                   <label for="mensaje">Mensaje</label>
                  <textarea class="form-control"></textarea>
                </div>
                <input class="btn btn-success btn-block mt-5"type="button" value="Enviar" onclick="registrar()">
            </form>

        </div>
    </div>
</div>`;
    
}
function cargaInicial()
{
    contenedorPrincipal.innerHTML="";
    stockProductos.forEach((producto) => {

        if(producto.tipo!="")
        {
        const div = document.createElement('div');
        div.classList.add('producto');
        div.innerHTML = `
        <div class="contenedorImg"><img class="imagen" src=${producto.img} alt= ""/></div>
        <p class="textoMarca">${producto.marca}</a>
    
        <p class="precioProducto">${producto.precio} $</p>
        <a class="titulo" href="${producto.link}">${producto.titulo}</a>
      
    
        <button id="agregar${producto.id}" class="boton-agregar">Agregar </button>
    
        `;
        contenedorPrincipal.appendChild(div);
    
        //2 - SEGUNDO PASO, LUEGO DE QUE INSERTEMOS EL HTML EN EL DOM:
        const boton = document.getElementById(`agregar${producto.id}`);
        //Por cada elemento de mi array, creo un div, lo cuelgo, le pongo un id particular, una vez colgado
        //le hago un get element by id (el de agregar) Obtengo el elemento y a dicho elemento le agregamos
        //el add event listener
    
        boton.addEventListener('click', () => {
            //esta funcion ejecuta el agregar el carrito con la id del producto
            agregarAlCarrito(producto.id)
            //
        })
    }
    }) 
}
function cargarStock(tipo_producto)
{
    contenedorPrincipal.innerHTML="";
//PRIMER PRIMER PASO, INYECTAR EL HTML
stockProductos.forEach((producto) => {

    if(producto.tipo==tipo_producto)
    {
    const div = document.createElement('div');
    div.classList.add('producto');
    div.innerHTML = `
    <div class="contenedorImg"><img class="imagen" src=${producto.img} alt= "imagen producto ${producto.id}"/></div>
    <p class="textoMarca">${producto.marca}</a>

    <p class="precioProducto">${producto.precio} $</p>
    <a class="titulo" href="${producto.link}">${producto.titulo}</a>
  

    <button id="agregar${producto.id}" class="boton-agregar">Agregar </button>

    `;
    contenedorPrincipal.appendChild(div);

    //2 - SEGUNDO PASO, LUEGO DE QUE INSERTEMOS EL HTML EN EL DOM:
    const boton = document.getElementById(`agregar${producto.id}`);
    //Por cada elemento de mi array, creo un div, lo cuelgo, le pongo un id particular, una vez colgado
    //le hago un get element by id (el de agregar) Obtengo el elemento y a dicho elemento le agregamos
    //el add event listener

    boton.addEventListener('click', () => {
        //esta funcion ejecuta el agregar el carrito con la id del producto
        agregarAlCarrito(producto.id);
        //
    })
}
})
}
// 1- PRIMER PASO

//AGREGAR AL CARRITO
function agregarAlCarrito (prodId) {

    //PARA AUMENTAR LA CANTIDAD Y QUE NO SE REPITA
    const existe = carrito.some (prod => prod.id === prodId) //comprobar si el elemento ya existe en el carro

    if (existe){ //SI YA ESTÁ EN EL CARRITO, ACTUALIZAMOS LA CANTIDAD
        const prod = carrito.map (prod => { //creamos un nuevo arreglo e iteramos sobre cada curso y cuando
            // map encuentre el elemento que es igual al que está agregado, le suma la cantidad
            if (prod.id === prodId){
                prod.cantidad++
            }
        })
    } else { //EN CASO DE QUE NO ESTÉ, AGREGAMOS EL CURSO AL CARRITO
        const item = stockProductos.find((prod) => prod.id === prodId)//Trabajamos con las ID
        //Una vez obtenida la ID, lo que haremos es hacerle un push para agregarlo al carrito
        carrito.push(item)
    }
    //Va a buscar el item, agregarlo al carrito y llama a la funcion actualizarCarrito, que recorre
    //el carrito y se ve.
    actualizarCarrito() //LLAMAMOS A LA FUNCION QUE CREAMOS EN EL TERCER PASO. CADA VEZ Q SE 
    //MODIFICA EL CARRITO
}
//agregarAlCarrito(1) //Le pasamos el ID por parametro. Tenemos que asigarle como evento esta funcion al boton
//con el id de su producto correspondiente

// 5 - QUINTO PASO
const eliminarDelCarrito = (prodId) => {
    const item = carrito.find((prod) => prod.id === prodId)

    const indice = carrito.indexOf(item) //Busca el elemento q yo le pase y nos devuelve su indice.
    //con splice se por parametro el indice y la cantidad de elementos a borrar 
    carrito.splice(indice, 1) 
    actualizarCarrito() //LLAMAMOS A LA FUNCION QUE CREAMOS EN EL TERCER PASO. CADA VEZ Q SE 
    //MODIFICA EL CARRITO
    console.log(carrito)
}
const modificarCantidad = (prodId,cant) => {
    if(cant>0)
    {
    const item = carrito.find((prod) => prod.id === prodId)

    const indice = carrito.indexOf(item); //Busca el elemento q yo le pase y nos devuelve su indice.
    carrito[indice].cantidad=cant;
    actualizarCarrito(); //LLAMAMOS A LA FUNCION QUE CREAMOS EN EL TERCER PASO. CADA VEZ Q SE 
    //MODIFICA EL CARRITO
    console.log(carrito);
    }
    else{
        const item = carrito.find((prod) => prod.id === prodId)
  //Com indexOf obtenemos el indice del elemento que pasamos por parametro.
        const indice = carrito.indexOf(item); 
        carrito[indice].cantidad=1;
        actualizarCarrito(); //LLAMAMOS A LA FUNCION QUE CREAMOS EN EL TERCER PASO. CADA VEZ Q SE 
        //MODIFICA EL CARRITO
        console.log(carrito);
    }
}


const actualizarCarrito = () => {
    //4- CUARTO PASO
    //LOS APPENDS SE VAN ACUMULANDO CON LO QE HABIA ANTES
    contenedorCarrito.innerHTML = "" //Cada vez que yo llame a actualizarCarrito, lo primero q hago
    //es borrar el nodo. Y despues recorro el array lo actualizo de nuevo y lo rellena con la info
    //actualizado
    //3 - TERCER PASO. AGREGAR AL MODAL. Recorremos sobre el array de carrito.

    //Por cada producto creamos un div con esta estructura y le hacemos un append al contenedorCarrito (el modal)
    contenedorCarrito.innerHTML = "<div class='productoEnCarritoTitulo'><span class='cabecera'>Imagen</span><span class='cabecera'>Producto</span><span class='cabecera'>Precio</span><span class='cabecera'>Cantidad</span><span class='cabecera'>Acción</span></div>";
    carrito.forEach((prod) => {
        const div = document.createElement('div');
        //&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
        div.className = ('productoEnCarrito');
        div.innerHTML = `
        <span><img class="imagen" src=${prod.img} alt= "imagen producto ${prod.id}" title="imagen ${prod.id}"/></span>        
        <span>    <a class="titulo" href="${prod.link}">${prod.titulo}</a></span>
        <span>${prod.precio}</span>
        <span><input type="number" onchange="modificarCantidad(${prod.id},this.value) "class="cantProducto" id="cantidad" value="${prod.cantidad}"/></span>
        <span><button onclick="eliminarDelCarrito(${prod.id})" class="boton-eliminar"><img src='img/tachoD.png' alt='boton eliminar' title='Eliminar producto'/></button>
        </span>
        `;
        ///////////////
      /*
            const lista = document.querySelector('#lista-producto');
    
            const fila = document.createElement('tr');
            fila.innerHTML = `
                <td>${producto.titulo}</td>
                <td>${producto.precio}</td>
                <td><input type="number" onchange="modificarCantidad(${prod.id},this.value) "class="cantProducto" id="cantidad" value="${prod.cantidad}" width="5px"/></td>
                <td> <button onclick="eliminarDelCarrito(${prod.id})" class="boton-eliminar">-</button></td>
            `;
           div.innerHTML=fila;      
            lista.appendChild(fila);
    
 */
        //////////////
        contenedorCarrito.appendChild(div)
        
        localStorage.setItem('carrito', JSON.stringify(carrito))

    })
    //SEPTIMO PASO
    contadorCarrito.innerText = carrito.length; // actualizamos con la longitud del carrito.
    //OCTAVO PASO
    console.log(carrito)
    precioTotal.innerText = carrito.reduce((acc, prod) => acc + prod.cantidad * prod.precio, 0)+"$";
    //Por cada producto q recorro en mi carrito, al acumulador le suma la propiedad precio, con el acumulador
    //empezando en 0.

}
