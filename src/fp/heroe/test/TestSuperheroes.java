package fp.heroe.test;

import fp.heroe.FactoriaSuperHeroes;
import fp.heroe.Superheroes;
import fp.common.Creador;
import fp.common.Posicionamiento;
import fp.common.Raza;

public class TestSuperheroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Superheroes superheroes = FactoriaSuperHeroes.leerSuperheroes("data/superheroes.csv");
		//Superheroes superheroes2 = FactoriaSuperHeroes.leerSuperheroes("data/superheroes2.csv");
		
		System.out.println("\ntestExisteSuperheroePosicionamientoRaza");
		System.out.println("=========================================");
		testExisteSuperheroePosicionamientoRaza(superheroes, Posicionamiento.GOOD, Raza.ALIEN);
		testExisteSuperheroePosicionamientoRaza(superheroes, Posicionamiento.BAD, Raza.METAHUMAN);
		testExisteSuperheroePosicionamientoRaza(superheroes, Posicionamiento.NEUTRAL, Raza.OTHER);
		
		
		System.out.println("\ntestGetMediaPuntuajeAño");
		System.out.println("=========================");
		testGetMediaPuntuajeAño(superheroes, 1969);
		testGetMediaPuntuajeAño(superheroes, 1986);
		testGetMediaPuntuajeAño(superheroes, 2010);
		
		/*System.out.println("\ntestGetSuperheroeCercanosAltura");
		System.out.println("=================================");
		testGetSuperheroeCercanosAltura(superheroes2, 210.0, 2.0);
		testGetSuperheroeCercanosAltura(superheroes2, 150.0, 5.0);
		
		
		System.out.println("\ntestGetSuperheroePorCreador");
		System.out.println("===============================");
		testGetSuperheroePorCreador(superheroes2);
		
		System.out.println("\ntestGetNumeroSuperheroePorAño");
		System.out.println("===============================");
		testGetNumeroSuperheroePorAño(superheroes2);
		*/
		
		System.out.println("\nEntrega 3");
		
		
		System.out.println("\ntestGetMediaPuntuajeAñoStream");
		System.out.println("===============================");
		testGetMediaPuntuajeAñoStream(superheroes, 1969);
		testGetMediaPuntuajeAñoStream(superheroes, 1986);
		testGetMediaPuntuajeAñoStream(superheroes, 2010);
		
		System.out.println("\ntestExisteSuperheroePosicionamientoRazaStream");
		System.out.println("===============================================");
		testExisteSuperheroePosicionamientoRazaStream(superheroes, Posicionamiento.GOOD, Raza.ALIEN);
		testExisteSuperheroePosicionamientoRazaStream(superheroes, Posicionamiento.BAD, Raza.METAHUMAN);
		testExisteSuperheroePosicionamientoRazaStream(superheroes, Posicionamiento.NEUTRAL, Raza.OTHER);
		
		/*System.out.println("\ntestGetSuperheroeCercanosAlturaStream");
		System.out.println("=======================================");
		testGetSuperheroeCercanosAlturaStream(superheroes2, 210.0, 2.0);
		testGetSuperheroeCercanosAlturaStream(superheroes2, 150.0, 5.0);*/
		
		System.out.println("\ntestGetSupeheroeMayorPuntuajeMedioPosicionamientoStream");
		System.out.println("================================================================");
		testGetSupeheroeMayorPuntuajeMedioPosicionamientoStream(superheroes, Posicionamiento.GOOD);
		testGetSupeheroeMayorPuntuajeMedioPosicionamientoStream(superheroes, Posicionamiento.BAD);
		testGetSupeheroeMayorPuntuajeMedioPosicionamientoStream(superheroes, Posicionamiento.NEUTRAL);
		
		System.out.println("\ntestGetNSuperheroesMayorPuntuajeMedioCreador");
		System.out.println("==============================================");
		testGetNSuperheroesMayorPuntuajeMedioCreador(superheroes, Creador.MARVEL_COMICS, 3);
		
	}

	
	public static void testExisteSuperheroePosicionamientoRaza(Superheroes superheroes, Posicionamiento p, Raza r) {
		
		try {
			String msg = "¿Existe algún superhéroe cuyo Posicionamiento sea " + p + " y su "
					+ "Raza sea " + r + "?: " + superheroes.existeSuperheroePosicionamientoRaza(p, r);
			System.out.println(msg);
		}catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
		
	}
	
	public static void testGetMediaPuntuajeAño(Superheroes superheroes, Integer year) {
		try {
			String msg = "La media del Puntuaje Medio de los superhéroes cuyo año de "
					+ "creación fue " + year + " es: " + superheroes.getMediaPuntuajeAño(year);
			System.out.println(msg);
		}catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testGetSuperheroeCercanosAltura(Superheroes superheroes, Double altura, Double d) {
		try {
			String msg = "Los superhéroes cuya altura se encuentra en el intervalo (" +
		    String.valueOf(altura - d) + ", " +String.valueOf(altura + d) + ") son: " 
			+ superheroes.getSuperheroeCercanosAltura(altura, d);
			System.out.println(msg);
		}catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	public static void testGetSuperheroePorCreador(Superheroes superheroes) {
		try {
			String msg = "El Map con los superhéroes ordenados por su creador es: " + superheroes.getSuperheroePorCreador();
			System.out.println(msg);
		}catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
		
	}
	
	public static void testGetNumeroSuperheroePorAño(Superheroes superheroes) {
		try {
			String msg = "El Map con el número de superhéroes ordenador por su fecha de creación es: " + superheroes.getNumeroSuperheroePorAño();
			System.out.println(msg);
		}catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	
	//Entrega 3
	//Test del Bloque I
	
	public static void testExisteSuperheroePosicionamientoRazaStream(Superheroes superheroes, Posicionamiento p, Raza r) {
		
		try {
			String msg = "¿Existe algún superhéroe cuyo Posicionamiento sea " + p + " y su "
					+ "Raza sea " + r + "?: " + superheroes.existeSuperheroePosicionamientoRazaStream(p, r);
			System.out.println(msg);
		}catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
		
	}
	
	
	
	public static void testGetMediaPuntuajeAñoStream(Superheroes superheroes, Integer year) {
		try {
			String msg = "La media del Puntuaje Medio de los superhéroes cuyo año de "
					+ "creación fue " + year + " es: " + superheroes.getMediaPuntuajeAñoStream(year);
			System.out.println(msg);
			
		}catch (Exception e) {
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
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
	
	public static void testGetSupeheroeMayorPuntuajeMedioPosicionamientoStream(Superheroes superheroes, Posicionamiento p) {
		try {
			String msg = "El/La superhéroe con mayor puntuación de inteligencia cuyo posicionamiento es " + p+ " es: "
		+ superheroes.getSupeheroeMayorPuntuajeMedioPosicionamiento(p);
			System.out.println(msg);
		}catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	
	}
	
	public static void testGetNSuperheroesMayorPuntuajeMedioCreador(Superheroes superheroes, Creador c, Integer n) {
		try {
			String msg = "Los " + n + " superhéroes con mayor puntuaje medio cuyo creador es "
					+ c + " son: " + superheroes.getNSuperheroesMayorPuntuajeMedioCreador(c, n);
			System.out.println(msg);
		}catch (Exception e){
			System.err.println("Capturada excepción inesperada: " + e.getMessage());
		}
	}
	
	
}
