package fp.heroe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fp.common.Creador;
import fp.common.Posicionamiento;
import fp.common.Raza;
import fp.utiles.Checkers;

public class FactoriaSuperHeroes {
	
	
	public static Superheroes leerSuperheroes(String rutaFichero) {
		Superheroes res = null;
		try{
			Set<Superheroe>  ssuperheroes=Files.lines(Paths.get(rutaFichero))
							.skip(1)
							.map(FactoriaSuperHeroes::parsearSuperheroe)
							.collect(Collectors.toSet());
		res = new Superheroes(ssuperheroes);
		}catch(IOException e){
			System.out.println("No se ha encontrado el fichero" + rutaFichero);
			e.printStackTrace();
		}
		return res;
	}
	
	
	
	
	public static Superheroe parsearSuperheroe(String lineaCSV) {
		
		String[]trozos = lineaCSV.split(";");
		//Checkers.check("La Linea debe contener 16 campos", trozos.length == 16);
		String nombreSuperheroe = trozos[0].trim();
		String nombreReal = trozos[1].trim();
		Creador creador = parseaCreador(trozos[2].trim());
		LocalDate fechaCreacion = parseaFecha(trozos[3].trim());
		List<String> poderes = Arrays.asList(trozos[4].trim().split(","));
		Integer puntuajeInteligencia = Integer.parseInt(trozos[5].trim());
		Integer puntuajeFuerza = Integer.parseInt(trozos[6].trim());
		Integer puntuajeVelocidad = Integer.parseInt(trozos[7].trim());
		Integer puntuajeResistencia = Integer.parseInt(trozos[8].trim());
		Posicionamiento posicionamiento = parseaPosicionamiento(trozos[9].trim());
		Raza raza = parseaRaza(trozos[10].trim().toUpperCase());
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
		if(cadena == "0.0") {
			res = false;
		}else {
			res = true;
		}
		
		return res;
	}
	
	private static Creador parseaCreador(String cadena) {
		Creador res = null;
		if(cadena != "Marvel Comics" && cadena!= "DC Comics" && cadena != "Shueisha" && cadena != "Dark Horse Comics" && cadena != "Lego") {
			res = Creador.OTHER;
		}else {
			res = Creador.valueOf(cadena);
		}
		return res;
	}
	
	private static Raza parseaRaza(String cadena) {
		Raza res = null;
		if(cadena != "Alien" && cadena!= "God / Eternal" && cadena != "Human" && cadena != "Meta Human" && cadena != "Mutant") {
			res = Raza.OTHER;
		}else {
			res = Raza.valueOf(cadena);
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
		}else {
			 d = "20" + String.valueOf(year);
		}
		Integer año = Integer.valueOf(d);
		return LocalDate.of(año, month, day);
	}
	
	private static Posicionamiento parseaPosicionamiento(String cadena) {
		Posicionamiento res = Posicionamiento.NEUTRAL;
		if(cadena =="Good") {
			res = Posicionamiento.GOOD;
		}else if(cadena == "Bad") {
			res = Posicionamiento.BAD;
		}
		return res;
	}
}


