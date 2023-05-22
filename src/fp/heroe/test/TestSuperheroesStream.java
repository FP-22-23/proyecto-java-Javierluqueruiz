package fp.heroe.test;

import fp.common.Creador;
import fp.common.Posicionamiento;
import fp.common.Raza;
import fp.heroe.FactoriaSuperHeroes;
import fp.heroe.Superheroes;

public class TestSuperheroesStream {

	public static void main(String[] args) {
		
		Superheroes superheroes = FactoriaSuperHeroes.leerSuperheroes("data/superheroes.csv");
		Superheroes superheroes_prueba = FactoriaSuperHeroes.leerSuperheroes("data/superheroes_prueba.csv");
		
		
		System.out.println("\nEntrega 3");
		
		System.out.println("\ntestExisteSuperheroeRazaTelepatiaInmortalStream");
		System.out.println("===============================================");
		testExisteSuperheroeRazaTelepatiaInmortalStream(superheroes, Raza.HUMAN);
		testExisteSuperheroeRazaTelepatiaInmortalStream(superheroes, Raza.METAHUMAN);
		testExisteSuperheroeRazaTelepatiaInmortalStream(superheroes, Raza.OTHER);
		
		System.out.println("\ntestGetMediaPuntuajeAñoStream");
		System.out.println("===============================");
		testGetMediaPuntuajeAñoStream(superheroes, 1969);
		testGetMediaPuntuajeAñoStream(superheroes, 1986);
		testGetMediaPuntuajeAñoStream(superheroes, 2010);
		
		System.out.println("\ntestGetSuperheroeCercanosAlturaStream");
		System.out.println("=======================================");
		testGetSuperheroeCercanosAlturaStream(superheroes_prueba, 210.0, 2.0);
		testGetSuperheroeCercanosAlturaStream(superheroes_prueba, 150.0, 5.0);
		
		System.out.println("\ntestGetSupeheroeMayorPuntuajeMedioPosicionamientoStream");
		System.out.println("================================================================");
		testGetSupeheroeMayorPuntuajeMedioPosicionamientoStream(superheroes, Posicionamiento.GOOD);
		testGetSupeheroeMayorPuntuajeMedioPosicionamientoStream(superheroes, Posicionamiento.BAD);
		testGetSupeheroeMayorPuntuajeMedioPosicionamientoStream(superheroes, Posicionamiento.NEUTRAL);
		
		System.out.println("\ntestGetSuperheroesMayorPuntuajeMedioCreador");
		System.out.println("==============================================");
		testGetSuperheroesMayorPuntuajeMedioCreador(superheroes, Creador.MARVEL_COMICS);
		
		System.out.println("\ntestGetSuperheroePorCreadorStream");
		System.out.println("===============================");
		testGetSuperheroePorCreadorStream(superheroes_prueba);
		
		System.out.println("\ntestGetSuperheroesMayorPuntuajeMedioPosicionamiento");
		System.out.println("=============================================");
		testGetSuperheroesMayorPuntuajeMedioPosicionamiento(superheroes_prueba);
		
		System.out.println("\ntestGetSuperheroesMasAntiguosPorCreador");
		System.out.println("=========================================");
		testGetSuperheroesMasAntiguosPorCreador(superheroes_prueba);
		
		System.out.println("\ntestObtenerNSuperheroesMayorAlturaPorRaza");
		System.out.println("=========================================");
		testObtenerNSuperheroesMayorAlturaPorRaza(superheroes, 3);
		testObtenerNSuperheroesMayorAlturaPorRaza(superheroes, 5);
		
		System.out.println("\ntestGetMaxContadorPesoPorRaza");
		System.out.println("========================================");
		testGetMaxContadorPesoPorRaza(superheroes_prueba);

	}


	
	
	
	//Entrega 3
	//Bloque 1
	
	//1
		
		public static void testExisteSuperheroeRazaTelepatiaInmortalStream(Superheroes superheroes, Raza r) {
			
			try {
				String msg = "¿Existe algún superhéroe cuya Raza sea " + r + " y además tenga telepatia e "
						+ "inmortabilidad?: " + superheroes.existeSuperheroeRazaTelepatiaInmortalStream( r);
				System.out.println(msg);
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
			
		}
		
		
	//2
		
		public static void testGetMediaPuntuajeAñoStream(Superheroes superheroes, Integer year) {
			try {
				String msg = "La media del Puntuaje Medio de los superhéroes cuyo año de "
						+ "creación fue " + year + " es: " + superheroes.getMediaPuntuajeAñoStream(year);
				System.out.println(msg);
				
			}catch (Exception e) {
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
		
	//3
		
		public static void testGetSuperheroeCercanosAlturaStream(Superheroes superheroes, Double altura, Double d) {
			try {
				String msg = "Los superhéroes cuya altura se encuentra en el intervalo (" +
			    String.valueOf(altura - d) + ", " +String.valueOf(altura + d) + ") son: " 
				+ superheroes.getSuperheroeCercanosAlturaStream(altura, d);
				System.out.println(msg);
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
		
	//4
		
		public static void testGetSupeheroeMayorPuntuajeMedioPosicionamientoStream(Superheroes superheroes, Posicionamiento p) {
			try {
				String msg = "El/La superhéroe con mayor puntuación de inteligencia cuyo posicionamiento es " + p+ " es: "
			+ superheroes.getSupeheroeMayorPuntuajeMedioPosicionamiento(p);
				System.out.println(msg);
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		
		}
		
	//5
		
		public static void testGetSuperheroesMayorPuntuajeMedioCreador(Superheroes superheroes, Creador c) {
			try {
				String msg = "Los superhéroes ordenados por el puntuaje medio cuyo creador es "
						+ c + " son: " + superheroes.getSuperheroesMayorPuntuajeMedioCreador(c);
				System.out.println(msg);
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	
	//Bloque II
		
	//6
		
		public static void testGetSuperheroePorCreadorStream(Superheroes superheroes) {
			try {
				String msg = "El Map con los superhéroes ordenados por su creador es: " + superheroes.getSuperheroePorCreadorStream();
				System.out.println(msg);
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
		
	//7
		
		public static void testGetSuperheroesMayorPuntuajeMedioPosicionamiento(Superheroes superheroes) {
			try {
				String msg = "El Map con los superhéroes con mayor puntuaje medio ordenados por su posicionamiento es: " + superheroes.getSuperheroesMayorPuntuajeMedioPosicionamiento();
				System.out.println(msg);
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
	
	//8
		public static void testGetSuperheroesMasAntiguosPorCreador(Superheroes superheroes) {
			try {
				String msg = "El Map con los superhéroes más antiguos ordenados por su creador es: " + superheroes.getSuperheroesMasAntiguosPorCreador();
				System.out.println(msg);
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
		
		
	//9
		public static void testObtenerNSuperheroesMayorAlturaPorRaza(Superheroes superheroes, Integer n) {
			try {
				String msg = "El map con los " + n + " superhéroes más altos ordenados por su creador es: " + superheroes.obtenerNSuperheroesMayorAlturaPorRaza(n);
			
			System.out.println(msg);
			
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}
		}
		
		
	//10
		public static void testGetMaxContadorPesoPorRaza(Superheroes superheroes) {
			try {
				String msg = "La raza cuyos superhéroes tienen el mayor peso es: " + superheroes.getMaxContadorPesoPorRaza();
				System.out.println(msg);
			}catch (Exception e){
				System.err.println("Capturada excepción inesperada: " + e.getMessage());
			}	
		}
		
}
		

