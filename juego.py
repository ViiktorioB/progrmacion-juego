# Tablero
# Este es el primer paso, crear el tablero en el que se distibuiran las minas.
# Debe de tener un tamaño incidado (10x10)ej.

# !!Esta parte se puede hacer de varias maneras la principal seria tener dos listas una de (apoyo) para saber donde estan las 
# mina y otra que es la que el jugador vera por pantalla. Las tablas seras bases con tamaños pre-establecidas y en futuras
# futuras versiones de podrian mejorar para introducir un menu el cual podamos seleccionar la dificultad del juego con tableros
# mas grandes y a la vez con mas minas.

# Primero crearemos la tabla de apoyo, esta tabla no la vera el jugador pero se mostrará en caso de perder
# para que pueda ver el lugar exacto de las minas, ES UN 10X10.
#  0 = Sin Mina
#  * = Con Mina

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

print(tablero_minas)

