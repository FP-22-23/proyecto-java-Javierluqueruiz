package fp.heroe.test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import fp.heroe.Creador;
import fp.heroe.Posicionamiento;
import fp.heroe.Raza;
import fp.heroe.Superheroe;

public class SuperheroeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Utilizo las tres primeras filas del csv para probar los métodos
		List<String> poderes1 = new LinkedList<>();
		poderes1.add("Super Speed");
		poderes1.add("Super Strength");
		Superheroe s = new Superheroe("3-D Man", "Delroy Garrett, Jr.", Creador.MARVEL_COMICS, LocalDate.of(1969, 8, 15), poderes1, 85, 30, 60, 60, 70, Posicionamiento.GOOD, Raza.HUMAN, 51.87, 511.68, false, false, true);
	
		System.out.println(s);
	}

}
