#language: es
## jairo.garcia@sofka.com.co
Característica: Agregar articulos al carrito
  Yo como QA deseo realizar el proceso de automatización de pruebas
  Para el front de agregar articulos al carrito
  Con el fin de presentar un stack de pruebas referenciado a dicha funcionalidad

  Antecedentes:
    Dado Procede a abrir la url

  Escenario: Login exitoso
    Cuando que el usuario procede a loguearse
    Entonces Valida que se logue de forma exitosa

  Esquema del escenario: Login exitoso
    Cuando que el usuario procede a con otros datos
      | user   | clave   |
      | <user> | <clave> |
    Entonces Valida que salga un error en el sistema

    Ejemplos:
      | user          | clave |
      | standard_user | 12344 |