#language: es
## jairo.garcia@sofka.com.co
Característica: Agregar articulos al carrito
  Yo como QA deseo realizar el proceso de automatización de pruebas
  Para el front de agregar articulos al carrito
  Con el fin de presentar un stack de pruebas referenciado a dicha funcionalidad

  Antecedentes:
    Dado Procede a abrir la url

  Escenario: Agregar productos al carrito
    Dado que el usuario procede a loguearse
    Cuando Se procede a organizar los elementos, los agrega al carrito
    E ingresa a la lista de agregados
    Y realiza el checkout
    Entonces valida que la informacion este congruente

