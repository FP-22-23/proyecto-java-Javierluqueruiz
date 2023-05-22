package fp.heroe.test;

import fp.heroe.FactoriaSuperHeroes;
import fp.heroe.Superheroes;

import fp.common.Raza;

public class TestSuperheroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Superheroes superheroes = FactoriaSuperHeroes.leerSuperheroes("data/superheroes.csv");
		Superheroes superheroes_prueba = FactoriaSuperHeroes.leerSuperheroes("data/superheroes_prueba.csv");
		
		System.out.println("\ntestExisteSuperheroePosicionamientoRaza");
		System.out.println("=========================================");
		testExisteSuperheroeRazaTelepatiaInmortal(superheroes, Raza.HUMAN);
		testExisteSuperheroeRazaTelepatiaInmortal(superheroes, Raza.METAHUMAN);
		testExisteSuperheroeRazaTelepatiaInmortal(superheroes, Raza.OTHER);
		
		
		System.out.println("\ntestGetMediaPuntuajeAño");
		System.out.println("=========================");
		testGetMediaPuntuajeAño(superheroes, 1969);
		testGetMediaPuntuajeAño(superheroes, 1986);
		testGetMediaPuntuajeAño(superheroes, 2010);
		
		System.out.println("\ntestGetSuperheroeCercanosAltura");
		System.out.println("=================================");
		testGetSuperheroeCercanosAltura(superheroes_prueba, 210.0, 2.0);
		testGetSuperheroeCercanosAltura(superheroes_prueba, 150.0, 5.0);
		
		
		System.out.println("\ntestGetSuperheroePorCreador");
		System.out.println("===============================");
		testGetSuperheroePorCreador(superheroes_prueba);
		
		System.out.println("\ntestGetNumeroSuperheroePorAño");
		System.out.println("===============================");
		testGetNumeroSuperheroePorAño(superheroes_prueba);	
	}

	
	public static void testExisteSuperheroeRazaTelepatiaInmortal(Superheroes superheroes, Raza r) {
		
		try {
			String msg = "¿Existe algún superhéroe cuya Raza sea " + r + " y además tenga telepatia e "
					+ "inmortabilidad?: " + superheroes.existeSuperheroeRazaTelepatiaInmortal(r);
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
