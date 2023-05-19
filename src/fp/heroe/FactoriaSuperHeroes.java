package fp.heroe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Creador;
import fp.common.Posicionamiento;
import fp.common.Raza;
import fp.utiles.Checkers;

public class FactoriaSuperHeroes {
	
	
	public static Superheroes leerSuperheroes(String rutaFichero) {
		Superheroes res = null;
		try{
			Set<Superheroe>  superheroes=Files.lines(Paths.get(rutaFichero))
							.skip(1)
							.map(FactoriaSuperHeroes::parsearSuperheroe)
							.collect(Collectors.toSet());
		res = new Superheroes(superheroes);
		}catch(IOException e){
			System.out.println("No se ha encontrado el fichero" + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	public static Superheroes leerSuperheroesStream(String rutaFichero) {
		Stream<Superheroe> res = null;
		try {
			res = Files.lines(Paths.get(rutaFichero)).skip(1).map(FactoriaSuperHeroes::parsearSuperheroe);
		}catch (IOException e){
			System.out.println("No se ha encontrado el fichero" + rutaFichero);
			e.printStackTrace();
		}
		return new Superheroes(res);
	}
	
	
	public static Superheroe parsearSuperheroe(String lineaCSV) {
		
		String[]trozos = lineaCSV.split(";");
		Checkers.check("La Linea debe contener 16 campos", trozos.length == 16);
		String nombreSuperheroe = trozos[0].trim();
		String nombreReal = trozos[1].trim();
		Creador creador = Creador.valueOf(trozos[2].trim().toUpperCase());
		LocalDate fechaCreacion = parseaFecha(trozos[3].trim());
		List<String> poderes = Arrays.asList(trozos[4].trim().split(","));
		Integer puntuajeInteligencia = Integer.parseInt(trozos[5].trim());
		Integer puntuajeFuerza = Integer.parseInt(trozos[6].trim());
		Integer puntuajeVelocidad = Integer.parseInt(trozos[7].trim());
		Integer puntuajeResistencia = Integer.parseInt(trozos[8].trim());
		Posicionamiento posicionamiento = parseaPosicionamiento(trozos[9].trim());
		Raza raza = Raza.valueOf(trozos[10].trim().toUpperCase());
		Double altura = Double.parseDouble(trozos[11].trim());
		Double peso = Double.parseDouble(trozos[12].trim());
		Boolean tieneTelepatia = parseaBooleano(trozos[13].trim());
		Boolean tieneMagia = parseaBooleano(trozos[14].trim());
		Boolean tieneInmortabilidad = parseaBooleano(trozos[15].trim());
		
		return new Superheroe(nombreSuperheroe, nombreReal, creador, fechaCreacion, poderes, puntuajeInteligencia, puntuajeFuerza, 
				puntuajeVelocidad, puntuajeResistencia, posicionamiento, raza, altura, peso, tieneTelepatia, 
				tieneMagia, tieneInmortabilidad);
			
	}


	
	private static Boolean parseaBooleano(String cadena) {
		Boolean res = null;
		if(cadena.equals("0.0")) {
			res = false;
		}else if (cadena.equals("1.0")){
			res = true;
		}
		
		return res;
	}

	
	private static LocalDate parseaFecha(String cadena) {
		String d = null;
		String[] trozos = cadena.split("/");
		Integer year = Integer.valueOf(trozos[2].trim());
		Integer month = Integer.valueOf(trozos[1].trim());
		Integer day = Integer.valueOf(trozos[0].trim());
		if(year>=30) {
			 d = "19" + String.valueOf(year);
		}else if(year >= 10){
			 d = "20" + String.valueOf(year);
		}else {
			d = "200" + String.valueOf(year);
			
		}
		Integer año = Integer.valueOf(d);
		return LocalDate.of(año, month, day);
	}
	
	private static Posicionamiento parseaPosicionamiento(String cadena) {
		Posicionamiento res = null;
		if(cadena == "") {
			res = Posicionamiento.NEUTRAL;
		}else {
			res = Posicionamiento.valueOf(cadena.toUpperCase());
		}

		return res;
	}
}


