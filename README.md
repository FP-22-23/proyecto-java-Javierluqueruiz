# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<XX\>/\<YY\>)
Autor/a: Javier Luque Ruiz   
uvus:PGH6213

Aquí debes añadir la descripción del dataset y un enunciado del dominio del proyecto.


## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente
  * **fp.\<heroe\>**: Paquete que contiene los tipos del proyecto.
  * **fp.\<heroe\>.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<superheroe.csv\>**: Archivo csv que contiene los datos de los distintos superhéroes.
 

    
## Estructura del *dataset*

El dataset original Superheroes NLP Dataset se puede obtener de la URL https://www.kaggle.com/datasets/jonathanbesomi/superheroes-nlp-dataset. Originalmente tiene 81 columnas y cada fila contiene datos sobre un superhéroe de la base de datos superherodb. 

El dataset usado en este proyecto tiene 16 columnas, 9 se han tomado del dataset original, y 6 se han modificado añadiendo datos aleatorios y 1 se ha creado desde cero con datos aleatorios. A continuacion se describen las columnas del dataset



* **\<name>**: de tipo cadena, representa el nombre del superhéroe.
* **\<real_name>**: de tipo cadena, representa el nombre real del superhéroe, si es que tiene.
* **\<creator>**: de tipo cadena, indica el creador del superhéroe. Puede tomar los valores: Marvel Comics, DC Comics, Shueisha, Dark Horse Comics, Lego, y Other.
* **\<creation_date>**: de tipo fecha, representa la fecha en la que se creó el superhéroe.
* **\<superpowers>**: de tipo cadena, representa los poderes que tienen los superhéroes. Están separados por comas.
* **\<intelligence_score>**: de tipo entero, representa la puntuación que tiene el superhéroe en inteligencia.
* **\<strength_score>**: de tipo entero, representa la puntuación que tiene el superhéroe en fuerza.
* **\<speed>**: de tipo entero, representa la puntuación que tiene el superhéroe en velocidad.
* **\<durability_score>**: de tipo entero, representa la puntuación que tiene el superhéroe en resistencia.
* **\<alignment>**: de tipo cadena, representa el bando en el que se encuentra el superhéroe. Puede tomar los valores Godd, Bad y Neutral.
* **\<type_race>**: de tipo cadena, representa la raza a la que pertenece el superhéroe. Puede tomar los valores: Human, Mutant, God/Eternal, Metahuman, Alien, y Other.
* **\<height>**: de tipo Double, representa la altura del superhéroe. Se mide en cm.
* **\<weight>**: de tipo Double, representa el peso del superhéroe. Se mide en kg.
* **\<has_telepathy>**: de tipo Doble, representa la capacidad del superhéroe de tener telepatía. El valor 1.0 representa True; mientras que el valor 0.0 representa False.
* **\<has_magic>**: de tipo Doble, representa la capacidad del superhéroe de dominar la magia. El valor 1.0 representa True; mientras que el valor 0.0 representa False.
* **\<has_inmortality>**: de tipo Doble, representa la capacidad del superhéroe de ser inmortal. El valor 1.0 representa True; mientras que el valor 0.0 representa False.


Con motivo de optimizar las clases de Test, he creado un archivo csv más reducido del orgiginal, que cuenta con 190 filas, ya que las funciones que devuelven colecciones eran tan grandes que en la consola de Eclipse no se podían ver las demás funciones. Se ha llamado "dataset_prueba.csv" y se ha utilizado en aquellas funciones que ocupaban demasiado espacio.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Superhéroe
Representa un superhéroe concreto.

**Propiedades**:

- _nombreSuperheroe_, de tipo \<String\>, consultable y modificable. 
- _nombreReal_, de tipo \<String\>, consultable.
- _creador_, de tipo \<Creador\>, consultable. Puede tomar los valores: MARVEL_COMICS, DC_COMICS, SHUEISHA, DARK_HORSE_COMICS, LEGO, OTHER.
- _fechaCreacion_, de tipo \<LocalDate\>, consultable.
- _poderes_, de tipo List[String], consultable y modificable.
- _puntuajeInteligencia_, de tipo \<Integer\>, consultable y modificable.
- _puntuajeFuerza_, de tipo \<Integer\>, consultable y modificable.
- _puntuajeVelocidad_, de tipo \<Integer\>, consultable y modificable.
- _puntuajeResistencia_, de tipo \<Integer\>, consultable y modificable.
- _posicionamiento_, de tipo \<Posicionamiento\>, consultable y modificable. Puede tomar los valores: GOOD, BAD, NEUTRAL.
- _raza_, de tipo \<Raza\>, consultable. Puede tomar los valores: HUMAN, MUTANT, GOD_ETERNAL, METAHUMAN, ALIEN, OTHER
- _altura_, de tipo \<Double\>, consultable.
- _peso_, de tipo \<Double\>, consultable.
- _tieneTelepaia_, de tipo \<Boolean\>, consultable y modificable.
- _tieneMagia_, de tipo \<Boolean\>, consultable y modificable.
- _tieneImortalidad_, de tipo \<Boolean\>, consultable y modificable.
- _puntuajeMedio_, de tipo PuntuajeMedio, consultable. Propiedad derivada que calcula la media de las distintas puntuaciones del superhéroe

**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica.
- C2: Crea un objeto Superheroe a partir de los siguientes parámetros: 
String nombreSuperheroe, String nombreReal, Creador creador,List<String> poderes, Posicionamiento posicionamiento, Raza raza, Double altura, Double peso

**Restricciones**:
 
- R1: Cada puntuación debe estar entre 1 y 100(ambos incluidos).
- R2: El nombre del superhéroe no puede estar vacío.

**Criterio de igualdad**: Según el creador, el nombre de superhéroe, el nombre real, y la raza

**Criterio de ordenación**: Por creador, raza, nombre de superhéroe y nombre real.(En ese orden)

**Otras operaciones**:
 
-	_void añadirPoder(String p)_: En lugar de crear una nueva lista con superpoderes, este método permite añadir superpoderes nuevos a la lista ya existente de un superhéroe.
- ...

#### Tipos auxiliares
 - _Creador:_ enumerado. Puede tomar los valores: MARVEL_COMICS, DC_COMICS, SHUEISHA, DARK_HORSE_COMICS, LEGO, OTHER.
 - _Posicionamiento:_ enumerado. Puede tomar los valores: GOOD, BAD, NEUTRAL.
  - _Raza:_ enumerado. Puede tomar los valores: HUMAN, MUTANT, GOD_ETERNAL, METAHUMAN, ALIEN, OTHER.
 - _PountuajeMedio:_ record. Toma los 4 valores de las diferentes puntuaciones de un objeto de tipo Superheroe y calcula el puntuaje medio.



### Factoría-FactoriaSuperHeroes
Clase de factoría para construir objetos de tipo Partidas. Contiene varios métodos para parsear los diferentes datos del csv, todos tienen estrcuturas similares.

- Superheroes leerSuperheroes(String rutaFichero)_:Crea un objeto de tipo Superheroes a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

- Superheroes leerSuperheroesStream(String rutaFichero)_: Crea un objeto de tipo Superheroes a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro. En este caso, utiliza el constructor a partir de Stream que se describe en el apartado "Constructores".


### Tipo Contenedor - Superheroes

Clase contenedora de los objetos de tipo Superheroe.

**Propiedades**:

- _Superheroes_, de tipo Set\<Superheroe\>, consultable. Lista de superheroes,


**Constructores**: 

- C1: Constructor por defecto.
- C2: Constructor con un parámetro de tipo Collection\<Superheroe\>. Crea un objeto de tipo Superheroes con los superheroes incluidos en la colección dada como parámetro.
- C3: Constructor con un parámtero de tipo Stream\<Superheroe\>. Crea un objeto de tipo Superheroes con los superheroes incluidos en el stream dado como parámetro.

**Criterio de igualdad**: Dos collecciones Superheroes son iguales si lo son sus propiedades Superheroe.


**Otras operaciones**:
 
-	_Integer numeroElementos()_: Devuelve el número de elemntos que hay en la colleción superheroes.
- _void añadirSuperheroe(Superheroe sh)_ : Añade un Superheroe al objeto.
- _void añadirCollecciónSuperheroes(Set\<Superheroe\> sh)_: Añade un conjunto de Superheroes al objeto.
- _void eliminarSuperheroe(Superheroe sh)_: Elimina el Superheroe indicado como parámetro del objeto.

- _Boolean existeSuperheroeRazaTelepatiaInmortal(Raza r)_: Devuelve true si existe un Superheroe tal que su propiedad raza conincidan con la raza dada como parámetro, y además, que sus propiedades tieneTelepatía y tieneInmortalidad sean true. De lo contrario, devuelve false.

- _Double getMediaPuntuajeAño(Integer year):_Devuelve la media del puntuaje medio de los Superhéroes cuyos años de creación coincidan con el año dado como parámetro.

- _Set\<Superheroe\>_ getSuperheroeCercanosAltura(Double altura, Double d):_Devuelve un conjunto de Superheroes cuya altura esté dentro del intervalo (altura-d, altura+d), siendo altura y d los parámetros.

- _Map<Creador, Set\<Superheroe\>> getSuperheroePorCreador():_ Devuelve un Map en el que las claves son los distintos valores del enum Creador, y los valores son conjuntos de los Superheroes cuyo valor de la propiedad Creador conincidan con la clave a la que estén asociados.

- _Map<Integer, Long> getNumeroSuperheroePorAño():_ Devuelve un Map en el que las claves son los distintos años de creación de los Superheroes, y los valores son el número de superhéroes cuya fecha de creación coincida con la clave.

ENTREGA 3(Métodos con Stream)

BLOQUE I
- _Boolean existeSuperheroeRazaTelepatiaInmortalStream(Raza r):_ La misma descripción que el método "existeSuperheroeRazaTelepatiaInmortal", descrita anteriormente, implementado con Stream.

- _Double getMediaPuntuajeAñoStream(Integer year):_ La misma descripción que el método "getMediaPuntuajeAño", descrita anteriormente, solo que se ha implementado con Stream.

- _Set\<Superheroe\> getSuperheroeCercanosAlturaStream(Double altura, Double d):_ La misma descripción que el método "getSuperheroeCercanosAltura", descrita anteriormente, solo que se ha implementado con Stream.

- _Superheroe getSupeheroeMayorPuntuajeMedioPosicionamiento(Posicionamiento p):_ Devuelve el Superheroe que tenga el mayor puntuajeMedio de entre los superheroes cuyo posicionamiento sea igual al dado como parámetro.

- _Set\<Superheroe\> getNSuperheroesMayorPuntuajeMedioCreador(Creador c, Integer n):_ Devuelve un conjunto con los n superhéroes que tengan el mayor puntuaje medio de entre todos los superheroes cuyo Creador coincida con el parámetro.

BLOQUE II
- _Map\<Creador, List\<Superheroe\>\>getSuperheroePorCreadorStream():_ La misma descripción que el método "getSuperheroePorCreador", descrita anteriormente, solo que se ha implementado con Stream.

- _Map\<Creador, Superheroe\> getSuperheroesMayorPuntuajeMedioPosicionamiento():_ Devuelve un Map en el que las claves son los distintos valores del enum Posicionamiento, y los valores son los superhéroes que tienen el mayor puntuajeMedio por cada Creador.

- _Map\<Creador, Superheroe\> getSuperheroesMasAntiguosPorCreador():_ Devuelve un diccionario en el que las claves son los distintos valores del enum Creador, y los valores son los superheroes más antiguos por cada creación.

- _SortedMap\<Raza, List\<Superheroe\>\> obtenerNSuperheroesMayorAlturaPorRaza(Integer n):_ Devuelve un diccionario en el que las claves son los distintos valores del enum Raza, y los valores son los n superhéroes más altos por cada raza.

- _Raza getMaxContadorPesoPorRaza():_ Devuelve la Raza cuyos superhéroes tengan el mayor peso. Para ello, primero clasifica los superhéroes por Raza, luego suma todos los pesos por cada raza y al final elige la Raza que tenga la mayor suma.

