# Serenity BDD project using Cucumber and Screenplay 

Es un proyecto tanto de back como de front, para validar los conceptos tecnicos y las buenas practicas de programación

### Prerequisites
* Java 17 installed
* Gradle  (Suggested version 7.5.1)
* IDE installed (Suggested IntelliJ IDEA 2022.2)
* Sourcetree
* Google Chrome installed

### Como instalarlo
* Instrucciones de instalacion
Realizar la clonacion del proyecto
Abrir intellijIDEA y seleccionar el proyecto

### Ejecución de pruebas

To run a specific Tag<br>
`gradle clean test -Dcucumber.filter.tags=@SISTEMA` <br>
`gradle clean test -Dcucumber.filter.tags=@BACKEND`

### Descripcion de las pruebas automatizadas

Los escenarios de back son los de crear booking, obtener booking y actualizar booking, cada uno de los escenarios tiene el happy paths como el Unhappy paths. tambien tiene una data variable que es generada con data faker.

Los escenarios de front son los de realizar compras en linea, algunos de los datos son generados aleatoriamente, adicionalmente cuanta con un ordenamiento tanto descendentemente como ascendentemente y se escribe cada ejecucion el ordenamiento de los datos sin borrar los anteriores dandole persistencia a los datos. Si el archivo no esta creado se creara en tiempo de ejecucion

### Estructura del Proyecto:

[src/main/java/co/com/sura/acelerador/interactions]() - Tanto back como front <br>
[src/main/java/co/com/sura/acelerador/questions]() - Aserciones de las pruebas. <br>
[src/main/java/co/com/sura/acelerador/task]() - que ejecutan las tareas de las pruebas. <br>
[src/main/java/co/com/sura/acelerador/userinterfaces]() - Donde se mapean cada uno de los elementos de la automatización por funcionalidad <br>
[src/main/java/co/com/sura/acelerador/util]() - Clase de utilidades genericas del proyecto <br>

[src/test/java/co/com/sura/acelerador/runners]() - Clases para ejecutar los test <br>
[src/test/java/co/com/sura/acelerador/stepdefinitions]() - Son la traducción de los features a código <br>
[src/test/resources/features]() - Historias de usuario que se llevarán a cabo en las pruebas <br>
[src/test/resources/booking/dato.txt]() - Donde es escribe el id booking cada ejecucion <br>
[src/test/resources/datos/datos.txt]() - Donde se escriben los ordenamientos de los precios tanto descendentemente como ascendentemente <br>

### Generación de Reportes:

target/site/serenity/index.html - este es el archivo que se debe abrir para revisar los reportes de ejecucion


### Pruebas en CI/CD: <br>


### Contribución y Contacto:

[jairo.garcia@sofka.com.co](mailto:jairo.garcia@sofka.com.co)

