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
    * **\<dataset1.csv\>**: Archivo csv que contiene los datos de los distintos superhéroes
 

    
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

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Héroe
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



### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
