# Tablero
# Este es el primer paso, crear el tablero en el que se distibuiran las minas.
# Debe de tener un tamaño incidado (10x10)ej.

# !!Esta parte se puede hacer de varias maneras la principal seria tener dos listas una de (apoyo) para saber donde estan las 
# mina y otra que es la que el jugador vera por pantalla. Las tablas seras bases con tamaños pre-establecidas y en futuras
# futuras versiones de podrian mejorar para introducir un menu el cual podamos seleccionar la dificultad del juego con tableros
# mas grandes y a la vez con mas minas.

# PASO 1: crearemos la tabla de apoyo, esta tabla no la vera el jugador pero se mostrará en caso de perder
# para que pueda ver el lugar exacto de las minas, ES UN 10X10.
#  0 = Sin Mina
#  * = Con Mina

import random

# Este es el tablero digamos (limpio), tendremos que diseñar una funcion que sobreescriba una mina para poder inicar el juego.
tablero_minas = [
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0,0,0,0] ]

# Este sera el tablero que de verdad verá el jugador
tablero_juego = [
   ["X","X","X","X","X","X","X","X","X","X"],
   ["X","X","X","X","X","X","X","X","X","X"],
   ["X","X","X","X","X","X","X","X","X","X"], 
   ["X","X","X","X","X","X","X","X","X","X"], 
   ["X","X","X","X","X","X","X","X","X","X"], 
   ["X","X","X","X","X","X","X","X","X","X"], 
   ["X","X","X","X","X","X","X","X","X","X"], 
   ["X","X","X","X","X","X","X","X","X","X"], 
   ["X","X","X","X","X","X","X","X","X","X"], 
   ["X","X","X","X","X","X","X","X","X","X"] ]

# Una vez tenemos los tablero pasamos al sgn paso.

# PASO 2: Agregar las minas al tablero para iniciar el juego en el caso de ser un 10X10 habrá 20 minas.
n_minas = 20

# Haremos que sobreescriba los valore que nos ha dado random.
n_minas_puestas = 0
while n_minas_puestas < n_minas:
# Ahora lo que tenemos que conseguir es que nos inserte el numero de minas en lugares aleatorios /usaremos la libreria random/
    i = random.randint(0,9)
    j = random.randint(0,9)

    if tablero_minas[i][j] == 0:
       tablero_minas[i][j] = 1
       n_minas_puestas = n_minas_puestas+1

def tablero_invisible():
    for i in range(0,10):
        for j in range(0,10):
            print(tablero_minas[i][j], end=" ")
        print("")

tablero_invisible()


