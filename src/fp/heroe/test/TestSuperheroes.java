package fp.heroe.test;

import fp.heroe.FactoriaSuperHeroes;
import fp.heroe.Superheroes;
import fp.common.Posicionamiento;
import fp.common.Raza;

public class TestSuperheroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Superheroes superheroes = FactoriaSuperHeroes.leerSuperheroes("data/superheroes.csv");
		Superheroes superheroes2 = FactoriaSuperHeroes.leerSuperheroes("data/superheroes2.csv");
		
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
		
		System.out.println("\ntestGetSuperheroeCercanosAltura");
		System.out.println("=================================");
		testGetSuperheroeCercanosAltura(superheroes, 200.0, 1.0);
		testGetSuperheroeCercanosAltura(superheroes, 150.0, 5.0);
		
		
		System.out.println("\ntestGetSuperheroePorCreador");
		System.out.println("===============================");
		testGetSuperheroePorCreador(superheroes2);
		
		System.out.println("\ntestGetNumeroSuperheroePorAño");
		System.out.println("===============================");
		testGetNumeroSuperheroePorAño(superheroes2);
		
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
	
	
}
