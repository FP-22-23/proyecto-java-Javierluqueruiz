package fp.heroe;

public record PuntuajeMedio(Integer puntuajeInteligencia, Integer puntuajeFuerza, Integer puntuajeVelocidad, Integer puntuajeResistencia) {
	public Double calcularPuntuajeMedio() {
		Double res =  (puntuajeInteligencia + puntuajeFuerza + puntuajeVelocidad + puntuajeResistencia)/4.0;
		return res;
	}

}
