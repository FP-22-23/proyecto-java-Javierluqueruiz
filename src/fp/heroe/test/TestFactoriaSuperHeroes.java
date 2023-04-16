package fp.heroe.test;

import fp.heroe.Superheroes;

public class TestFactoriaSuperHeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testLeerSuperheroes("data/superheroes.csv");
	}
	
	private static void testLeerSuperheroes(String fichero) {
		System.out.println("\nTestLeerSuperheroes =============");
		Superheroes superheroes = fp.heroe.FactoriaSuperHeroes.leerSuperheroes(fichero);
		System.out.println("Superheroes: " + superheroes);
		
	}

}
