package fp.heroe;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.common.Creador;
import fp.common.Posicionamiento;
import fp.common.PuntuajeMedio;
import fp.common.Raza;
import fp.utiles.Checkers;
public class Superheroe implements Comparable<Superheroe> {
	
	private String nombreSuperheroe;
	private String nombreReal;
	private Creador creador;
	private LocalDate fechaCreacion;
	private List<String> poderes;
	private Integer puntuajeInteligencia;
	private Integer puntuajeFuerza;
	private Integer puntuajeVelocidad;
	private Integer puntuajeResistencia;
	private Posicionamiento posicionamiento;
	private Raza raza;
	private Double altura;
	private Double peso;
	private Boolean tieneTelepatia;
	private Boolean tieneMagia;
	private Boolean tieneInmortabilidad;
	private PuntuajeMedio puntuajeMedio;



	public Superheroe(String nombreSuperheroe, String nombreReal, Creador creador, LocalDate fechaCreacion,
			List<String> poderes, Integer puntuajeInteligencia, Integer puntuajeFuerza, Integer puntuajeVelocidad,
			Integer puntuajeResistencia, Posicionamiento posicionamiento, Raza raza,
			Double altura, Double peso, Boolean tieneTelepatia, Boolean tieneMagia, Boolean tieneInmortabilidad) {
		//Restricciones
		Checkers.check("El nombre no puede estar vacío", nombreSuperheroe.replaceAll(" ", "") != "");
		Checkers.check("El puntuaje debe ser mayor o igual que 0 y menor o igual que 100", puntuajeInteligencia >= 0 && puntuajeInteligencia <= 100);
		Checkers.check("El puntuaje debe ser mayor o igual que 0 y menor o igual que 100", puntuajeFuerza >= 0 && puntuajeFuerza <= 100);
		Checkers.check("El puntuaje debe ser mayor o igual que 0 y menor o igual que 100", puntuajeVelocidad >= 0 && puntuajeVelocidad <= 100);
		Checkers.check("El puntuaje debe ser mayor o igual que 0 y menor o igual que 100", puntuajeResistencia >= 0 && puntuajeResistencia <= 100);

		//Asignaciones
		this.nombreSuperheroe = nombreSuperheroe;
		this.nombreReal = nombreReal;
		this.creador = creador;
		this.fechaCreacion = fechaCreacion;
		this.poderes = new ArrayList<String>(poderes);
		this.puntuajeInteligencia = puntuajeInteligencia;
		this.puntuajeFuerza = puntuajeFuerza;
		this.puntuajeVelocidad = puntuajeVelocidad;
		this.puntuajeResistencia = puntuajeResistencia;
		this.posicionamiento = posicionamiento;
		this.raza = raza;
		this.altura = altura;
		this.peso = peso;
		this.tieneTelepatia = tieneTelepatia;
		this.tieneMagia = tieneMagia;
		this.tieneInmortabilidad = tieneInmortabilidad; 
		this.puntuajeMedio = new PuntuajeMedio(puntuajeInteligencia, puntuajeFuerza, puntuajeVelocidad, puntuajeResistencia);
	}


	public Superheroe(String nombreSuperheroe, String nombreReal, Creador creador,
			List<String> poderes, Posicionamiento posicionamiento, Raza raza, Double altura, Double peso) {
		
		//Restricciones
		Checkers.check("El nombre no puede estar vacío", nombreSuperheroe.replaceAll(" ", "") != "");
		
		//Asignacionezs
		this.nombreSuperheroe = nombreSuperheroe;
		this.nombreReal = nombreReal;
		this.creador = creador;
		this.fechaCreacion =LocalDate.now();
		this.poderes = poderes;
		this.puntuajeInteligencia =null;
		this.puntuajeFuerza = null;
		this.puntuajeVelocidad = null;
		this.puntuajeResistencia = null;
		this.posicionamiento = posicionamiento;
		this.raza = raza;
		this.altura = altura;
		this.peso = peso;
		this.tieneTelepatia = null;
		this.tieneMagia = null;
		this.tieneInmortabilidad = null;
		this.puntuajeMedio = null;
		
	}






	//Getters and Setter2s

	public String getNombreSuperheroe() {
		return nombreSuperheroe;
	}
	
	public void setNombreSuperheroe(String s) {
		Checkers.check("El nombre no puede estar vacío", s != "");
		this.nombreSuperheroe = s;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public Creador getCreador() {
		return creador;
	}
	
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	
	public List<String> getPoderes() {
		return poderes;
	}

	public void setPoderes(List<String> poderes) {
		this.poderes = poderes;
	}
	
	public void anadiPoder(String p) {
		this.poderes.add(p);
	}

	public Integer getPuntuajeInteligencia() {
		return puntuajeInteligencia;
	}

	public void setPuntuajeInteligencia(Integer puntuajeInteligencia) {
		Checkers.check("El puntuaje debe ser mayor o igual que 0 y menor o igual que 100", puntuajeInteligencia >= 0 && puntuajeInteligencia <= 100);
		this.puntuajeInteligencia = puntuajeInteligencia;
	}

	public Integer getPuntuajeFuerza() {
		return puntuajeFuerza;
	}

	public void setPuntuajeFuerza(Integer puntuajeFuerza) {
		Checkers.check("El puntuaje debe ser mayor o igual que 0 y menor o igual que 100", puntuajeFuerza >= 0 && puntuajeFuerza <= 100);
		this.puntuajeFuerza = puntuajeFuerza;
	}

	public Integer getPuntuajeVelocidad() {
		return puntuajeVelocidad;
	}

	public void setPuntuajeVelocidad(Integer puntuajeVelocidad) {
		Checkers.check("El puntuaje debe ser mayor o igual que 0 y menor o igual que 100", puntuajeVelocidad >= 0 && puntuajeVelocidad <= 100);
		this.puntuajeVelocidad = puntuajeVelocidad;
	}

	public Integer getPuntuajeResistencia() {
		return puntuajeResistencia;
	}

	public void setPuntuajeResistencia(Integer puntuajeResistencia) {
		Checkers.check("El puntuaje debe ser mayor o igual que 0 y menor o igual que 100", puntuajeResistencia >= 0 && puntuajeResistencia <= 100);

		this.puntuajeResistencia = puntuajeResistencia;
	}

	public Double getPuntuajeMedio() {
		return puntuajeMedio.calcularPuntuajeMedio();
	} 
	
	
	public Posicionamiento getPosicionamiento() {
		return posicionamiento;
	}

	public void setPosicionamiento(Posicionamiento posicionamiento) {
		this.posicionamiento = posicionamiento;
	}

	public Raza getRaza() {
		return raza;
	}

	public Double getAltura() {
		return altura;
	}

	public Double getPeso() {
		return peso;
	}
	
	public Boolean getTieneTelepatia() {
		return tieneTelepatia;
	}

	public void setTieneTelepatia(Boolean tieneTelepatia) {
		this.tieneTelepatia = tieneTelepatia;
	}

	public Boolean getTieneMagia() {
		return tieneMagia;
	}

	public void setTieneMagia(Boolean tieneMagia) {
		this.tieneMagia = tieneMagia;
	}

	public Boolean getTieneInmortabilidad() {
		return tieneInmortabilidad;
	}

	public void setTieneInmortabilidad(Boolean tieneInmortabilidad) {
		this.tieneInmortabilidad = tieneInmortabilidad;
	}

	

	//Representación como cadena
	@Override
	public String toString() {
		return "Superheroe [nombreSuperheroe=" + nombreSuperheroe + ", nombreReal=" + nombreReal + ", creador="
				+ creador + ", fechaCreacion=" + fechaCreacion + ", poderes=" + poderes + ", puntuajeInteligencia="
				+ puntuajeInteligencia + ", puntuajeFuerza=" + puntuajeFuerza + ", puntuajeVelocidad="
				+ puntuajeVelocidad + ", puntuajeResistencia=" + puntuajeResistencia  + ", puntuajeMedio=" + puntuajeMedio + ", posicionamiento=" + posicionamiento + ", raza=" + raza + ", altura=" + altura
				+ ", peso=" + peso + ", tieneTelepatia=" + tieneTelepatia + ", tieneMagia=" + tieneMagia
				+ ", tieneInmortabilidad=" + tieneInmortabilidad + "]";
	}

    //Criterio de igualdad
	@Override
	public int hashCode() {
		return Objects.hash(creador, nombreReal, nombreSuperheroe, poderes, raza);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Superheroe other = (Superheroe) obj;
		return creador == other.creador && Objects.equals(nombreReal, other.nombreReal)
				&& Objects.equals(nombreSuperheroe, other.nombreSuperheroe) && raza == other.raza;
	}

	
	//Orden natural
	
	public int compareTo(Superheroe o) {
		int r = this.getCreador().compareTo(o.getCreador());
		if ( r== 0) {
			r = this.getRaza().compareTo(o.getRaza());
			if (r == 0) {
				r = this.getNombreSuperheroe().compareTo(o.getNombreSuperheroe());
				if (r == 0) {
					r = this.getNombreReal().compareTo(o.getNombreReal());
				}
			}
		} 
		return r;
	}
	

	
}



	

