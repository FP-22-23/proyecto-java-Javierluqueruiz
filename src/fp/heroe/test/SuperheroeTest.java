package fp.heroe.test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import fp.common.Creador;
import fp.common.Posicionamiento;

import fp.common.Raza;
import fp.heroe.Superheroe;


public class SuperheroeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Utilizo las tres primeras filas del csv para probar los métodos, ya que todaqvía no puedo leer el csv.
		
		
		List<String> poderes1 = new LinkedList<>();
		poderes1.add("Super Speed");
		poderes1.add("Super Strength");
		Superheroe s1 = new Superheroe("3-D Man", "Delroy Garrett, Jr.", Creador.MARVEL_COMICS, LocalDate.of(1969, 8, 15), poderes1, 85, 30, 60, 60, Posicionamiento.GOOD, Raza.HUMAN, 51.87, 511.68, false, false, true);
	
		
		List<String> poderes2 = new LinkedList<>();
		poderes2.add("Durability");
		poderes2.add("Reflexes");
		poderes2.add("Super Strength");
		Superheroe s2 = new Superheroe("514A (Gotham)", "Bruce Wayne", Creador.DC_COMICS, LocalDate.of(2009, 4, 9), poderes2, 43, 57, 86, 90, Posicionamiento.NEUTRAL, Raza.OTHER, 248.49, 846.64, true, false, true);
		
		List<String> poderes3 = new LinkedList<>();
		Superheroe s3 = new Superheroe("Aa", "Aa", Creador.OTHER, poderes3, Posicionamiento.NEUTRAL, Raza.OTHER, 241.3, 367.51);
		
		
		
		System.out.println("Representación como cadena:");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println("Criterio de igualdad: s1.equals(s2)");
		System.out.println(s1.equals(s2));
		
		System.out.println("Orden natural: s2.compareTo(s3)");
		System.out.println(s2.compareTo(s3));
		
	}

}
