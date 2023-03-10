# Tablero
# Este es el primer paso, crear el tablero en el que se distibuiran las minas.
# Debe de tener un tamaño indicado (10x10)ej.

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

# Este será el tablero que de verdad verá el jugador
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

tablero_explosion = []                          # Nos apoyamos en una lista auxiliar a la que le daremos un valor ya existente  
tablero_explosion = tablero_minas               # para cuando el usuario pierda la partida, se le muestre por pantalla el tablero con las minas marcadas.

# Una vez tenemos los tablero pasamos al siguiente paso.

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

# Función que nos permite ver en que posición estan las minas. 
def tablero_invisible():
    for i in range(0,10):
        for j in range(0,10):
            print(tablero_minas[i][j], end=" ")
        print("")



# Funcion que usaremos para la partida
# Este tablero sera el que se vera en la pantalla, principalmente utiliza la lista tablero_juego, para 
# mostrar de forma mas grafica el tablero
def tablero_partida():
    n_fila = 1
    print("     1   2   3   4   5   6   7   8   9   10")     # Este print marca la enumeración de cada columna
    print("    ----------------------------------------")    # Marca la separación y mejora gráficamente las filas del tablero.
    for i in range(0,10):
        if n_fila != 10:                        # Al cambiar el digito a dos ej:10 se deplaza toda la estrucutra
            print(n_fila," | ", end="")         # a la derecha una posicion, para que eso no pase esta este if. El cual los suprime.
            n_fila = n_fila + 1
        else:
            n_fila==10
            print(n_fila,"| ", end="")
        for j in range(0,10):
            if tablero_juego[i][j]=="X":        # 
                print("·", end=" | ")
            else:    
                print(tablero_juego[i][j], end=" | ")
        print("")
        print("    ----------------------------------------")

# Esta función es la que el usuario verá cuando pierda la partida(explote una mina), le mostrará por pantalla la ubicación de todas las minas
# Utiliza como referencia la lista de tablero_minas. 

def tablero_derrota():
    n_fila = 1
    print("     1   2   3   4   5   6   7   8   9   10")     # Este print marca la enumeración de cada columna
    print("    ----------------------------------------")    # Marca la separación y mejora gráficamente las filas del tablero.
    for i in range(0,10):
        if n_fila != 10:                        # Al cambiar el digito a dos ej:10 se deplaza toda la estrucutra
            print(n_fila," | ", end="")         # a la derecha una posicion, para que eso no pase esta este if. El cual los suprime.
            n_fila = n_fila + 1
        else:
            n_fila==10
            print(n_fila,"| ", end="")
        for j in range(0,10):
            if tablero_explosion[i][j]==1:        # Cuando el tablero detecte un 1 (mina) me printeará un asterisco
                print("*", end=" | ")
                continue                            
            elif tablero_explosion[i][j]==0:      # Cuando el tablero detecte un 0 (no mina) me printeará un espacio en blanco (aspecto estético).
                print(" ", end=" | ")

            else:    
                print(tablero_explosion[i][j], end=" | ")
        print("")
        print("    ----------------------------------------")

# Cartel de bievenida.
print("")   
print("██████╗░██╗░░░██╗░██████╗░█████╗░░█████╗░███╗░░░███╗██╗███╗░░██╗░█████╗░░██████╗")
print("██╔══██╗██║░░░██║██╔════╝██╔══██╗██╔══██╗████╗░████║██║████╗░██║██╔══██╗██╔════╝")
print("██████╦╝██║░░░██║╚█████╗░██║░░╚═╝███████║██╔████╔██║██║██╔██╗██║███████║╚█████╗░")  
print("██╔══██╗██║░░░██║░╚═══██╗██║░░██╗██╔══██║██║╚██╔╝██║██║██║╚████║██╔══██║░╚═══██╗")
print("██████╦╝╚██████╔╝██████╔╝╚█████╔╝██║░░██║██║░╚═╝░██║██║██║░╚███║██║░░██║██████╔╝")
print("╚═════╝░░╚═════╝░╚═════╝░░╚════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝░░╚═╝╚═════╝░")
print("")
tablero_partida()
# PASO 3: Eleccion de las cordenadas que quieres destapar.

def destapar_celda(i,j):
    # Creamos un contador de minas que es el que saldra por pantalla en la celda
    minas = 0
    # Usamos una variable local de soporte para calcular los valores que rodean nuestra cordenada ej:
    # si la cordenada es 3-4 debemos buscar la posicion (2-3, 2-4, 2-5, 3-3, 3-5, 4-3, 4-4, 4-5)
    # Si ponemos el mismo ejemplo de 3-4  
    z = i-1                     # z seria 2
    while z <= i+1:             # i+1 sera el rango maximo que podremos obtener en las filas este caso 4 (nos coincide con la linea de arriba)
        if z>=-2 and z<=10:      # sabemos que tenemos 10 filas asi q usaremos el if para pasar a verificar las columnas
            b = j-1             # igual que antes b sera 3
            while b <= j+1:     # el maximo de las columnas sera 5 que tambien coincide
                if b>=-2 and b<=10:
                    minas = minas+tablero_minas[z][b]                   # Este if sera el que verifica si en el tablero que el usuario no ve 
                    b= b+1 # Incrementamos b para verificar la          # y en el que esta las minas si en la cordenada hay un 0 o un 1 y lo 
                           #siguiente coordenada de celda               # incrementa asi sabemos si hay alrededor.
        z = z+1 # Incrementa z para verificar otra coordenada 
                                             
    return minas # Devuelve el valor final de minas 

# Paso 4. Elección de celda.
def jugar():
    
    eleccion_cordenada = 0
    contador_celdas = 0
    
    while eleccion_cordenada < (100 - n_minas):
            print("")
            i=int(input("Señala una fila del (1 al 10('0')): "))-1     # De forma predeterminada empieza a contar a partir del número 0,                                                   
            j=int(input("Señala una columna del (1-10('0')): "))-1     # así que ponemos un -1 para que empiece a contar a partir del número 1.
            print("")

            if tablero_minas[i][j] == 1:                               
                    print("")
                    print("¡¡LA MINA HA EXPLOTADO!! Has Perdido.")
                    print("")
                    tablero_derrota()
                    break
            elif contador_celdas == 80:
                print("ERES EL GANADOR, FELICIDADES!!!")
                break
            else:                                         
                tablero_juego[i][j]= destapar_celda(i,j)  # Paso 5. Destapar celda sera la funcion que nos dara el numero de minas que hay al rededor.
                tablero_partida()
                contador_celdas = contador_celdas+1
            
    
jugar()

