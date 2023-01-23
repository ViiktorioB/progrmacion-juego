# progrmacion-juego
## Objetivos
El ojetivo es crear un juego / juego de mesa con un lenguaje de programcion, como es en este caso Python, el juego a representar en formato texto es el "Buscamnias"

En este ReadMe estara toda la informacion sobre la planificaccion, creacion y implantacion del proyecto.

## Planificación
En este punto se tratarán los aspectos que se han levado a seguir en cada fase del trabajo. Se divide en varias fases.

IDC (Investigación y desarrollo conceptual)

Esta fase es la inicial, ya que es la que nos da la idea de lo que tenemos que generar. Básicamente, es hacer  un estudio de las reglas del Buscaminas para a partir de eso tener la idea y plasmarla en forma de pseudocódigo

TEP (Traslado a entorno de programa)

En esta fase se formará la base del pseudocódigo para a posterior poder implementarlo en formato Python. En este punto se debe expresar de  manera técnica describiendo todas la funciones

CCF (Codificación y creación de funciones)

En esta fase es donde se creará el código del juego, se creará un archivo principal que recogerá todas las funciones relacionadas con el juego y su estructura. Mientras que en otros archivos se irán desarrollando otros menús o subprocesos que se fusionarán en el archivo principal con una adaptación de las variables y valores.

PCE (Pruebas y corrección de errores)

Esta es la última fase y una de gran importancia junto con el CCF, ya que pondremos a prueba nuestro código y veremos los posibles errores con sus correspondientes soluciones. También se deberá hacer una revisión de toda la estructura del código.

# Ejemplo del Docoumento

## Creacion fase IDC

¿¿PRINCIPALMETE COMO SE JUEGA AL BUSCAMINAS??

El juego consiste en despejar todas las casillas de una pantalla que no oculten una mina.

Algunas casillas tienen un número, este número indica las minas que son en todas las casillas circundantes. Así, si una casilla tiene el número 3, significa que de las ocho casillas que hay alrededor (si no es en una esquina o borde) hay 3 con minas y 5 sin minas. Si se descubre una casilla sin número indica que ninguna de las casillas vecinas tiene mina y estas se descubren automáticamente.

Si se descubre una casilla con una mina se pierde la partida.

Se puede poner una marca en las casillas que el jugador piensa que hay minas para ayudar a descubrir la que están cerca.

Ahora lo explicaremos paso a paso.

Primero cabe aclarar que le juego es de una persona contra la máquina.

Paso Por Paso

1. Se genera una tabla de (10x10).

2. Dentro de esta tabla se generan 10,20... minas que son las que tenemos que ubicar para ganar el juego.

3. Una vez se nos ha generado la tabla ya podemos señalar la coordenada que queremos descubrir.

4. Una vez la elegimos pueden suceder dos cosas a) es una mina lo cual perdemos el juego. b) nos descubre un número que hace 5. 5.referencia al número de minas que hay al rededor de esa coordenada en un rango de 1.

5. Una vez pasado esto volveríamos a escoger una coordenada y volveríamos al paso 4.

6. En caso de descubrir en qué coordenadas están todas las minas y tener todo el tablero al descubierto, ganaríamos el juego.


## Creación del documento TEP

1- Importar libreria random.

2- Crear lista tablero minas.

3- Crear lista tablero juego.

4- Crear lista auxiliar tablero explosion.

5- Asignar el valor tablero_minas a tablero_explosion.

6- Crear variable número_de_minas(máxima) y número de minas puestas(actuales).

7- Asignar un valor random en i y en j con rango de 10.

8- Crear función tablero_invisible (la que el usuario no verá pero nuestro código cogerá toda la información).

    - Este tablero es de donde nuestro programa coge toda la información. 
      (0 = No hay mina)
      (1= Hay mina)

9- Crear función tablero_partida (tablero que verá el usuario y con el que jugará la partida).

    - Todas las celdas estarán marcadas con una misma tecla (ya sea # o · por ejemplo).


10- Crear función tablero_derrota (tablero que aparecerá al perder).

### Jugador 

11- Crear función destapar_celda (nº de minas alrededor).

12- Crear funcion jugar, donde para ganar se han de destapar "100 - n_minas" celdas (son 100 ya que el tablero es un 10x10).


## Creación del documento PCE

En esta parte se marcan todos los errores y sus procesos para solucionarlos.

### Fallo 

Teníamos una estructura del tablero que era la que el usuario tenía que ver, pero al numerar las filas y las columnas con el número "10" utilizaba un carácter de más esa fila y desplazaba toda la estructura.

### Solución

Dentro del for hacer un if y cuando el número fuera un "10" elimina los espacios que hacía en las barras "|" que separan las casillas.

### Fallo

El cartel de buscaminas no entraba todo en un print, dando error.

### Solución 

Crear diferentes prints con cada linea.

### Fallo

En el proceso "destapar_celda" utilizamos la "z" como fila y la "b" como en los if, pusimos rango 0-10 lo cual nos limitaba y al querer verificar si en las posiciones de al rededor de la columna 1 había una mina, daba error ya que estaba fuera del rango de la matriz y no se podía seleccionar.

### Solución 

Cambiar el rango del if por uno mayor "-1 and 10".

### Fallo 

Ocurria lo mismo con la columna 10.

### Solución 

Volver a aumentar el rango.

### Fallo 

Al pedir al usuario la fila y la columna ya dentro del juego si el ponía un 1-1 la casilla que se mostraba era la 2-2.

### Solución

Poner un -1 al final de cada input.

### Fallo

No encotramos la manera de mostrar la victoria.

### Solución 

Implementar un contador y cuando el usuario destapé el maximo de celdas "80" mostrar que ha ganado

### Fallo

La estructura del juego no quedaba del todo clara.

### Solución

Dedicarnos a poner todo dentro de funciones y hacer una general que fuese el juego.

### Fallo

Al querer mostrar al usuario el tablero con todas la minas unas vez falla y explota una mina, el tablero que mostraba era el mismo con el que el sistema verificaba las coordenadas.

### Solución

Crear una sublista la cual es la que printeamos de forma bonita.

### Fallo

El import random no seleccionaba la cantidad que queriamos.

### Solución 

Aplicar un contador.
