/*

Proyecto: Juego simon dice
Boton de inicio y reset (Todos los botones conectados de manera matricial)
4 colores (pseudoaleatorios), 5 niveles

Oscar Iván Alonso Simental

*/

.DEF R = r31 //Variable donde se almacena el random
/*Variables para la secuencia de los 5 niveles*/
.DEF l1 = r25 //Nivel 1
.DEF l2 = r26 //Nivel 2
.DEF l3 = r27 //Nivel 3
.DEF l4 = r28 //Nivel 4
.DEF l5 = r29 //Nivel 5
/**/
ldi r16,0b00000011 //PB0-1 Como salida para voltaje a botones
out ddrb,r16

ldi r16,0b0111111 //PC0-5 Como salida para los leds
out ddrc,r16

LDI R,0 //Se inicializa en 0 la variable random
LDI r24,0 //Variable donde se guarda el codigo de color del boton presionado


Inicio:
	ldi r16,0b00000000 //Manda 0 al display
	out portd,r16
    rcall Random //Se llama a la rutina random mientras se espera botón de inicio
    ldi r16,0b00000001 //Se envia voltaje por pinb 0, para verificar primera fila de botones pero solo se detecta boton inicio
	out portb,r16
	sbis pinb,2 ;Si PB2 = 1 brinca una instrucción
	rjmp Inicio //Si no se presionó ningún botón energizado por PB0, regresa a inicio a esperar el botón
	rjmp ledInicio //Si se precionó brinca a etiqueta ledInicio
ledInicio: 
	sbic pinb,2 ;Si PB2 = 0 brinca una instrucción
	rjmp ledInicio //Se cicla hasta que se deje de presionar
	rcall Presentacion //Se llama a la rutina presentación

/*NIVELES 1-5*/
Lvl1: //Nivel 1
	ldi r16,0b00000100 //Manda 1 al display
	out portd,r16
	rcall generadorSecuencia1 //Llama a la rutina que genera secuencia para nivel 1
	rcall boton //Llama a la rutina boton que detectará el boton presionado
	cp l1,r24 //Se compara lo que se generó en secuencia con lo que se presionó
	brne Fallo1 //Si no son iguales, el jugador se equivocó y manda a etiqueta fallo
	rcall cI //Se enciende led inicio indicando que está correcto
	rjmp Lvl2 //Brinca al siguiente nivel

Fallo1: //etiqueta "puente", lleva a fallo2, que es otra etiqueta "puente"
	rjmp Fallo2

Lvl2: //Nivel 2
	ldi r16,0b00001000 //Se envía 2 al display
	out portd,r16
	rcall Sl1 //Para encender el primer led de la secuencia
	rcall generadorSecuencia2 //Genera la secuencia para el nivel 2
	rcall boton //Se manda rutina para detectar cual color se pulsó 
	cp l1,r24 //Se compara el si el el boton presionado es igual al primer color que salió
	brne Fallo2 //Si no es igual brinca a fallo
	rcall boton //Se vuelve a llamar al boton para el segundo led que salió
	cp l2,r24 //Se compara si el segundo led que salió es igual a lo que se presionó
	brne Fallo2 //Si falló brinca a fallo
	rcall cI //Enciende led inicio para indicar que el jugador completó el nivel
	rjmp Lvl3 //Brinca al nivel 3

Fallo2: //Etiqueta puente, brinca a etiqueta fallo, se puso esto porque está muy abajo la etiqueta Fallo y genera el error "Branch out of reach"
	rjmp Fallo

Lvl3:
	ldi r16,0b00001100 //Se envía 3 al display
	out portd,r16
	rcall Sl1 //Se enciende el primer led que salió
	rcall Sl2 //Se enciende el segundo led que salió
	rcall generadorSecuencia3 //Genera nuevo color para el nivel 3
	rcall boton //Se llama a boton para saber que color se presionó
	cp l1,r24 //compara el boton presionado con el primer led de la secuencia
	brne Fallo //si no son iguales brinca a fallo
	rcall boton //Se llama a boton para el segundo color que salió
	cp l2,r24 //Se compara el led con lo que se presionó
	brne Fallo //Si no son iguales brinca a fallo
	rcall boton //Se llama a botón para el tercer color que salió
	cp l3,r24 //Se compara si el led 3 es igual al botón presionado
	brne Fallo //Brinca a fallo si no son iguales
	rcall cI //enciende led inicio indicando que se completó el nivel

Lvl4: //Nivel 4
	ldi r16,0b00010000 //Se manda 4 al display
	out portd,r16
	rcall Sl1 //Se enciende el primer led que salió
	rcall Sl2 //Se enciende el segundo led que salió
	rcall Sl3 //Se enciende el tercer led que salió
	rcall generadorSecuencia4 //Se genera un nuevo color para el nivel 4
	rcall boton //Se llama a boton
	cp l1,r24 //Se compara led 1 con el valor que trajo boton
	brne Fallo //Si no son iguales brinca a fallo
	rcall boton //Se llama a boton
	cp l2,r24 //Se compara led 2 con el valor que trajo boton
	brne Fallo //Si no son iguales brinca a fallo
	rcall boton //Se llama a boton
	cp l3,r24 //Se compara led 3 con el valor que trajo boton
	brne Fallo //Si no son iguales brinca a fallo
	rcall boton //Se llama a boton
	cp l4,r24 //Se compara con led 4 con el valor que trajo boton 
	brne Fallo //Si no son iguales brinca a fallo
	rcall cI //Se enciende el led inicio indicando que se completó nivel

Lvl5:
	ldi r16,0b00010100 //Se envía 5 al display
	out portd,r16
	rcall Sl1 //Se enciende el primer led que salió
	rcall Sl2 //Se enciende el segundo led que salió
	rcall Sl3 //Se enciende el tercer led que salió
	rcall Sl4 //Se enciende el cuarto led que salió
	rcall generadorSecuencia5 //Genera el nuevo led para el nivel 5
	rcall boton //Se llama a boton
	cp l1,r24 //Se compara led 1 con el valor que trajo boton
	brne Fallo //Si no son iguales brinca a fallo
	rcall boton //Se llama a boton
	cp l2,r24 //Se comapra led 2 con lo que trajo boton
	brne Fallo //Si no son iguales brinca a fallo
	rcall boton //Llama a boton
	cp l3,r24 //Se compara led 3 con lo que trajo boton
	brne Fallo //Si no son iguales brinca a fallo
	rcall boton //Llama a boton
	cp l4,r24 //Compara lo que tenga led 4 con lo que trajo boton
	brne Fallo //Brinca a fallo si no son iguales
	rcall boton //Se llama a boton
	cp l5,r24 //Compara led5 con lo que trajo boton
	brne Fallo //Brinca a fallo si no son iguales
	rcall cI //Prende led indicando que se completó nivel
	rjmp Gano //Brinca a etiqueta gano

Fallo: //Si el jugador falla...
	rcall delay250 
	rcall cRe //Se enciende led rojo del reset
	rcall delay250
	rcall cRe //Se enciende led rojo del reset
	rcall delay250
	rcall cRe //Se enciende led rojo del reset
	rjmp Inicio //Brinca a inicio para empezar el juego de nuevo desde 0

Gano: //Si el usuario ganó...
	rcall delay250
	rcall cI //Se enciende el led verde de inicio
	rcall delay250
	rcall cI //Se enciende el led verde de inicio
	rcall delay250
	rcall cI //Se enciende el led verde de inicio
	rjmp Inicio //Brinca a inicio para empezar el juego de nuevo desde 0
/*FIN DE NIVELES*/

/*RUTINAS*/
boton: //Asigna un valor al registro según el botón cliqueado
	/* PRIMERA FILA DE BOTONES */
	vPB0: //Voltaje a PB0
		ldi r16,0b00000001 //Se envia voltaje por pinb 0, para verificar primera fila de botones
		out portb,r16
		rcall Random //Llamada a random
	
	btnVerde:
		sbis pinb,4 ;Si PB4 = 1 brinca una instrucción
		rjmp btnAmarillo //Si PB4 = 0, no se presionó btnVerde, entonces verifica btn Amarillo
		rjmp Verde //Si se presionó el boton verde, brinca a etiqueta Verde

	btnAmarillo:
		sbis pinb,3 ;Si PB3 = 1 brinca una instrucción
		rjmp vPB1 //Si no se presionó ningún botón energizado por PB0, ahora se verifican los de PB1
		rjmp Amarillo //Si se presionó el boton amarillo, brinca a etiqueta Amarillo

	/*FIN PRIMERA FILA DE BOTONES*/

	/*SEGUNDA FILA DE BOTONES*/
	vPB1: //Voltaje a PB1
		ldi r16,0b00000010 //Se envia voltaje por pinb 1, para verificar segunda fila de botones
		out portb,r16
		rcall Random //Llamada a random

	btnAzul:
		sbis pinb,4 ;Si PB4 = 1 brinca una instrucción
		rjmp btnRojo //Si PB4 = 0, no se presionó btnAzul, entonces verifica btnRojo
		rjmp Azul //Si se presionó el boton azul, brinca a etiqueta Azul

	btnRojo:
		sbis pinb,3 ;Si PB3 = 1 brinca una instrucción
		rjmp btnReset //Si PB3 = 0, no se presionó amarillo, entonces verifica reset
		rjmp Rojo //Si se presionó el boton rojo, brinca a etiqueta Rojo

	btnReset:
		sbis pinb,2 ;Si PB2 = 1 brinca una instrucción
		rjmp vPB0 //Si no se presionó ningún botón energizado por PB1, ahora se verifican los de PB0
		rjmp ledReset //Si se presionó boton reset, brinca a etiqueta ledReset

	/*FIN SEGUNDA FILA DE BOTONES*/
	//0 indica que se presionó el boton del verde, 1 el boton del led amarillo, 2 el boton del led azul y 3 el boton del led rojo
	Verde:
		sbic pinb,4 ;Si PB4 = 0 brinca una instrucción
		rjmp Verde //Se cicla hasta que se deje de presionar el boton
		rcall cV //Enciende led verde
		ldi r24,0 //Carga r24 con 0
		ret //Se sale de la rutina

	Amarillo:
		sbic pinb,3 ;Si PB3 = 0 brinca una instrucción
		rjmp Amarillo //Se cicla hasta que se deje de presionar el boton
		rcall cA //Enciende led amarillo
		ldi r24,1 //Carga r24 con 1
		ret //Se sale de la rutina

	Azul: 
		sbic pinb,4 ;Si PB4 = 0 brinca una instrucción
		rjmp Azul //Se cicla hasta que se deje de presionar el boton
		rcall cAz //Se enciende led azul
		ldi r24,2 //Se carga r24 con 2
		ret //Se sale de la rutina

	Rojo: 
		sbic pinb,3 ;Si PB3 = 0 brinca una instrucción
		rjmp Rojo //Se cicla hasta que se deje de presionar el boton
		rcall cR //Se enciende el led rojo
		ldi r24,3 //Carga r24 con 3
		ret //Se sale de la rutina

	ledReset: 
		sbic pinb,2 ;Si PB2 = 0 brinca una instrucción
		rjmp ledReset //Se cicla hasta que se deje de presionar el boton
		rcall cRe //Se enciende el led del de reinicio
		rjmp Inicio //Brinca a inicio a empezar desde 0
ret

generadorSecuencia1: //Se prende un led aleatorio y se asigna un valor a un registro para la secuencia según el nivel
	colorRandom: //Etiqueta compara el valor que esté en R con 0,1,2 o 3 para saber que color debe encender
		rcall delay250
		cpi R,0 //Si es 0
		breq RVerde //Brinca a verde
		cpi R,1 //Si es 1
		breq RAma //Brinca a amarillo
		cpi R,2 //Si es 2
		breq RAzul //Brinca a azul
		cpi R,3 //Si es 3
		breq RRojo //Brinca a rojo

	RVerde:
		ldi l1,0 //Carga el nivel 1 con 0, indicando que el led que salió aleatoriamente fue el verde
		rcall cV //Enciende led verde
		ret //Se sale de la rutina
	RAma:
		ldi l1,1 //Carga el nivel 1 con 1, indicando que el led que salió aleatoriamente fue el amarillo
		rcall cA //Enciende led amarillo
		ret //Se sale de la rutina
	RAzul:  
		ldi l1,2 //Carga el nivel 1 con 2, indicando que el led que salió aleatoriamente fue el azul
		rcall cAz //Enciende led azul
		ret //Se sale de la rutina
	RRojo:
		ldi l1,3 //Carga el nivel 1 con 3, indicando que el led que salió aleatoriamente fue el rojo
		rcall cR //Se enciende led rojo
ret //Se sale de la rutina
generadorSecuencia2: //Se prende un led aleatorio y se asigna un valor a un registro para la secuencia según el nivel
	colorRandom2: //Funciona igual que generadorSecuencia1, pero ahora se carga a l2
		rcall delay250
		cpi R,0
		breq RVerde2
		cpi R,1
		breq RAma2
		cpi R,2
		breq RAzul2
		cpi R,3
		breq RRojo2

	RVerde2:
		ldi l2,0
		rcall cV
		ret
	RAma2:
		ldi l2,1
		rcall cA
		ret
	RAzul2: 
		ldi l2,2
		rcall cAz
		ret
	RRojo2:
		ldi l2,3
		rcall cR
ret
generadorSecuencia3: //Se prende un led aleatorio y se asigna un valor a un registro para la secuencia según el nivel
	colorRandom3: //Funciona igual que generadorSecuencia1, pero ahora se carga a l2
		rcall delay250
		cpi R,0
		breq RVerde3
		cpi R,1
		breq RAma3
		cpi R,2
		breq RAzul3
		cpi R,3
		breq RRojo3

	RVerde3:
		ldi l3,0
		rcall cV
		ret
	RAma3:
		ldi l3,1
		rcall cA
		ret
	RAzul3: 
		ldi l3,2
		rcall cAz
		ret
	RRojo3:
		ldi l3,3
		rcall cR
ret
generadorSecuencia4: //Se prende un led aleatorio y se asigna un valor a un registro para la secuencia según el nivel
	colorRandom4: //Funciona igual que generadorSecuencia1, pero ahora se carga a l2
		rcall delay250
		cpi R,0
		breq RVerde4
		cpi R,1
		breq RAma4
		cpi R,2
		breq RAzul4
		cpi R,3
		breq RRojo4

	RVerde4:
		ldi l4,0
		rcall cV
		ret
	RAma4:
		ldi l4,1
		rcall cA
		ret
	RAzul4: 
		ldi l4,2
		rcall cAz
		ret
	RRojo4:
		ldi l4,3
		rcall cR
ret
generadorSecuencia5: //Se prende un led aleatorio y se asigna un valor a un registro para la secuencia según el nivel
	colorRandom5: //Funciona igual que generadorSecuencia1, pero ahora se carga a l2
		rcall delay250
		cpi R,0
		breq RVerde5
		cpi R,1
		breq RAma5
		cpi R,2
		breq RAzul5
		cpi R,3
		breq RRojo5

	RVerde5:
		ldi l5,0
		rcall cV
		ret
	RAma5:
		ldi l5,1
		rcall cA
		ret
	RAzul5: 
		ldi l5,2
		rcall cAz
		ret
	RRojo5:
		ldi l5,3
		rcall cR
ret

Sl1: //Para seguir la secuencia en los demás niveles
	rcall delay250
	cpi l1,0 //Si l1 tiene 0, entonces el valor que salió para el primer led de la secuencia fue verde
	breq v //Brinca a verde
	cpi l1,1 //Si l1 tiene 1, entonces el valor que salió para el primer led de la secuencia fue amarillo
	breq a //Brinca a amarillo
	cpi l1,2 //Si l1 tiene 2, entonces el valor que salió para el primer led de la secuencia fue azul
	breq az //Brinca a azul
	cpi l1,3 //Si l1 tiene 3, entonces el valor que salió para el primer led de la secuencia fue verde
	breq rr //Brinca a rojo
	v: //Enciende led verde
	rcall cV
	ret //Se sale de la rutina
	a: //Enciende led amarillo
	rcall cA
	ret //Se sale de la rutina
	az: //Enciende led azul
	rcall cAz
	ret //Se sale de la rutina
	rr://Enciende led rojo 
	rcall cR
ret //Se sale de la rutina
Sl2: //Para seguir la secuencia en los demás niveles
	rcall delay250 //Funciona igual que Sl1 pero ahora se compara el valor de l2, para el led que se encendió en el nivel 2
	cpi l2,0
	breq v2
	cpi l2,1
	breq a2
	cpi l2,2
	breq az2
	cpi l2,3
	breq rr2
	v2:
	rcall cV
	ret
	a2:
	rcall cA
	ret
	az2:
	rcall cAz
	ret
	rr2:
	rcall cR
ret
Sl3: //Para seguir la secuencia en los demás niveles
	rcall delay250 //Funciona igual que Sl1 pero ahora se compara el valor de l3, para el led que se encendió en el nivel 3
	cpi l3,0
	breq v3
	cpi l3,1
	breq a3
	cpi l3,2
	breq az3
	cpi l3,3
	breq rr3
	v3:
	rcall cV
	ret
	a3:
	rcall cA
	ret
	az3:
	rcall cAz
	ret
	rr3:
	rcall cR
ret
Sl4: //Para seguir la secuencia en los demás niveles
	rcall delay250//Funciona igual que Sl1 pero ahora se compara el valor de l4, para el led que se encendió en el nivel 4
	cpi l4,0
	breq v4
	cpi l4,1
	breq a4
	cpi l4,2
	breq az4
	cpi l4,3
	breq rr4
	v4:
	rcall cV
	ret
	a4:
	rcall cA
	ret
	az4:
	rcall cAz
	ret
	rr4:
	rcall cR
ret
Sl5: //Para seguir la secuencia en los demás niveles
	rcall delay250 //Funciona igual que Sl1 pero ahora se compara el valor de l5, para el led que se encendió en el nivel 5
	cpi l5,0
	breq v5
	cpi l5,1
	breq a5
	cpi l5,2
	breq az5
	cpi l5,3
	breq rr5
	v5:
	rcall cV
	ret
	a5:
	rcall cA
	ret
	az5:
	rcall cAz
	ret
	rr5:
	rcall cR
ret

delay500: ;Inicio de la subrutina DELAY500ms
	ldi r19,32 ;Carga a R19 con la cantidad de veces que se repetirán los ciclos
	eti1: ldi r20,250 ;Carga a R20 con el valor 250
	eti2: ldi r21,250 ;Carga a R21 con el valor 250
	eti3: nop ;NOP = No Operación (4 uS por iteración)
	dec r21 ;Decrementa en 1 a R21
	brne eti3 ;Mientras ZF=0, brinca a ETI3
	dec r20 ;Decrementa en 1 a R20
	brne eti2 ;Mientras ZF=0, brinca a ETI2
	dec r19 ;Decrementa en 1 a R19
	brne eti1 ;Mientras ZF=0, brinca a ETI1
ret ;Retorna el control

delay250: ;Inicio de la subrutina DELAY250ms
	ldi r19,16 ;Carga a R19 con la cantidad de veces que se repetirán los ciclos
	eti11: ldi r20,250 ;Carga a R20 con el valor 250
	eti22: ldi r21,250 ;Carga a R21 con el valor 250
	eti33: nop ;NOP = No Operación (4 uS por iteración)
	dec r21 ;Decrementa en 1 a R21
	brne eti33 ;Mientras ZF=0, brinca a ETI3
	dec r20 ;Decrementa en 1 a R20
	brne eti22 ;Mientras ZF=0, brinca a ETI2
	dec r19 ;Decrementa en 1 a R19
	brne eti11 ;Mientras ZF=0, brinca a ETI1
ret ;Retorna el control

Presentacion: ;Inicio de la subrutina Presentacion
	//Se prende led 1 por 1 con retraso de 250ms y se envían valores al display
	ldi r16,0b00000001 
	out portd,r16
	out portc,r16
	rcall delay250
	ldi r16,0b00000010 
	out portd,r16
	out portc,r16
	rcall delay250
	ldi r16,0b00000100 
	out portd,r16
	out portc,r16
	rcall delay250
	ldi r16,0b00001000
	out portd,r16
	out portc,r16
	rcall delay250
	ldi r16,0b00010000
	out portd,r16
	out portc,r16
	rcall delay250
	ldi r16,0b00100000 
	out portd,r16
	out portc,r16
	rcall delay250
	//Se apagan los leds y continua el programa
	ldi r16,0b00000000
	out portc,r16
	out portd,r16
ret //Sale de la rutina presentacion

cV: //Rutina color verde
	ldi r16,0b00000001 //Se envia voltaje al led correspondiente (Verde)
	out portc,r16
	rcall delay500 //el color queda encendido por 500ms
	ldi r16,0b00000000 //Se corta voltaje al led correspondiente (Verde)
	out portc,r16
ret
cA: //Rutina color amarillo
	ldi r16,0b00000010 //Se envia voltaje al led correspondiente (Amarillo)
	out portc,r16
	rcall delay500 //el color queda encendido por 500ms
	ldi r16,0b00000000 //Se corta voltaje al led correspondiente (Amarillo)
	out portc,r16
ret
cAz: //Rutina color Azul
	ldi r16,0b00001000 //Se envia voltaje al led correspondiente (Azul)
	out portc,r16
	rcall delay500 //el color queda encendido por 500ms
	ldi r16,0b00000000 //Se corta voltaje al led correspondiente (Azul)
	out portc,r16
ret
cR: //Rutina color Rojo
	ldi r16,0b00010000 //Se envia voltaje al led correspondiente (Rojo)
	out portc,r16
	rcall delay500 //el color queda encendido por 500ms
	ldi r16,0b00000000 //Se corta voltaje al led correspondiente (Rojo)
	out portc,r16
ret
cI: //Rutina para el led inicio
	ldi r16,0b00000100 //Se envia voltaje al led correspondiente (Verde)
	out portc,r16
	rcall delay500 //el color queda encendido por 500ms
	ldi r16,0b00000000 //Se corta voltaje al led correspondiente (Verde)
	out portc,r16
ret
cRe: //Rutina para led reset
	ldi r16,0b00100000 //Se envia voltaje al led correspondiente (Rojo)
	out portc,r16
	rcall delay500 //el color queda encendido por 500ms
	ldi r16,0b00000000 //Se corta voltaje al led correspondiente (Rojo)
	out portc,r16
ret

Random: //Se incrementa el valor en 1 cada que se llama la rutina, debe llamarse muchas veces
	inc R
	cpi R,4
	BREQ reset
	ret
	reset:
		ldi R,0
		ret
