
Aydo Libreria Exension Analisis - Gabriel Quiroz
=======

IntegacionTest.class
--------------------
Se encontraron clases instanciadas dos veces.

		Producto producto1 = new Producto("El Hobbit");
		producto1 = new Libro("El Hobbit", 50);
		
(Ej línea 15 y 16)
Varios assert en un mismo test (En casoSuscripcionPeriodicoFebreroVerPrecioEnOtrosMes)
Convenciones de Nombres de test java no respetados
Y nombres de test feos (Ej caso uno en línea 283)
Refactorizo

Periodico.class
--------------------
Boolean en el constructor redundante. 
Corrijo el boolean tanto para inicializar la clase (En los test) como la funcionalidad del mismo.

		if (ejemplarSuelto == true || suscripcion == true){		
			if (ejemplarSuelto == true){
				super.setValor(monto);
			}
			else if(suscripcion == true){
				double descuento = monto*0.2;
				super.setValor((monto - descuento)*30);
				super.setTipo("Periodico");	
			}
Y me llama la atencion que siempre que esta suscripto hace un descuento.

Producto.class
--------------------
En clase Producto Instancia la clase con una variable “Nombre” que luego no guarda.
Incluso tiene un setter sin funcionalidad. (Linea 18) 

	public void setNombreProducto(String nombre){
	}
	
Elimino el setter y guardo la variable en un private.
Me llama la atención que la clase Producto se guarde un String con “tipo”
En las clases que heredan de producto en el constructor se guarda un String con el “Tipo” (Ej La clase revista guarda siempre un string = “Revista”). 

Procedo investigar para que se usa el Tipo

Get tipo encontrado en método compra de la clase Cliente
Lógica: ¿Si es un producto del tipo revista o Periodico agrega los productos comprados en los sucesivos meses?

Cliente.class
--------------------
Usa el atributo tipo para preguntar si la clase es de ese tipo (Un instanceOf 'casero') (Linea 35)
El cliente guarda una lista de los productos por mes
Me pincha que guarde siempre una suscripción en todos los meses

¿Solución hardcodeada?  Si


Solucion hardcodeada
--------------------
Vuelvo a la clase test, y en ningun momento indica en las suscripciones el tiempo de las mismas.
Los descuentos estan hardcodeados
La clase Revista hace un descuento dependiendo de la periodicidad  (linea 14)

		}else if (frecuenciaMensual > 0 && frecuenciaMensual < 5){
			
			super.setTipo("Revista");
			double descuento = monto*0.2;
			super.setValor((monto - descuento)*frecuenciaMensual);
			
		}
Para que cierre el test casoDos (Linea 308 de la clase IntegracionTest)

	Producto producto1 = new Producto("Barcelona");
	producto1 = new Revista("Barcelona", 20, 2);
Clase Kiosko.class
----------------------
Corrijo redundancia de returns en linea 37-50
Y varios usos de un booleano dentro de un if (linea 37)

	if (encontrado != false){
	
Implementacion de funcionalidad suscripcion
--------------------------
Refactorizo al mismo tiempo que implemento la verdadera solucion de suscripcion.

Creo interfaz ActivosKiosko con metodo getValor()
Producto implementa ActivosKiosko
Cambio en la clase Cliente la lista de Productos Por una lista de ActivosKiosko para luego poder agregar Suscribible

Creo interfaz Suscribible implementa ActivosKiosko 
Suscribible tiene un metodo setSuscripcionMensual

Eliminada clase periódico ya que tiene la misma funcionalidad que una revista. Cambiado nombre de clase revista a PublicacionPeriodica
PublicacionPeriodica extends Producto implementa Suscribible


Creo metodo en clase Cliente para suscribirse que recibe un suscribible
Elimino funcionalidad de el metodo comprar de un cliente, ya que no necesita preguntar de que tipo es la compra.

Cuando un cliente se suscribe a un producto suscribible, este producto cambia su estado y auto calcula su valor dependiendo de la periodicidad mensual (y agrega los meses de suscripcion mas descuento si es necesario).

La clase Kiosko calcula el monto a cobrar segun la lista de ActivosKiosko del mes indicado por parametro del cliente y funciona sin tener que modificar funcionalidad.

Implementacion de funcionalidad alquilar
------------------------------------------------------------
Agrego intefaz alquilable al diseño, que implementa ActivosKiosko
Libro implementa alquilable

Agrego metodos a cliente para alquilarEnDias, alquilarEnMeses y alquilarEnCuatrimestres (recien como parametro un alquilable, un mes, y la cantidad de dias/meses/cuatrimestres segun su metodo)
La clase cliente solo se encarga de agregar sus alquilables a los meses correspondientes y decirle al alquilable que va a ser alquilado.

El alquilable (en este caso el libro) se calcula su precio antes de ser guardado.
Las Exception las maneja la clase que es alquilable segun restricciones de negocio.

