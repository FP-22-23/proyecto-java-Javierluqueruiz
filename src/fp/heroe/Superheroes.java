package fp.heroe;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Creador;
import fp.common.Posicionamiento;
import fp.common.Raza;

public class Superheroes {

	//Atributos
	private Set<Superheroe> superheroes;
	
	//Constructores
	public Superheroes() {
		this.superheroes = new HashSet<Superheroe>();
	}
	
	public Superheroes(Set<Superheroe> sh) {
		this.superheroes = sh;
	}
	
	public Superheroes(Stream<Superheroe> sh) {
		this.superheroes = sh.collect(Collectors.toSet());
	}

	
	//Criterio de igualdad y ToString
	
	@Override
	public int hashCode() {
		return Objects.hash(superheroes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Superheroes other = (Superheroes) obj;
		return Objects.equals(superheroes, other.superheroes);
	}

	@Override
	public String toString() {
		return "Superheroes [superheroes=" + superheroes + "]";
	}
	
	//Operaciones
	
	public Integer numeroElementos() {
		return superheroes.size();
	}
	
	public void añadirSuperheroe(Superheroe sh) {
		this.superheroes.add(sh);
	}
	
	public void añadirColeccionSuperheroes(Set<Superheroe> sh) {
		superheroes.addAll(sh);
	}
	
	public void eliminarSuperheroe(Superheroe sh) {
		superheroes.remove(sh);
	}
	
	
	//Tratamientos secuenciales
	
	//1.Existe

	public  Boolean existeSuperheroeRazaTelepatiaInmortal(Raza r) {
		Boolean res = false;
		
		for(Superheroe sh:superheroes) {
			if(sh.getRaza().equals(r) && sh.getTieneTelepatia() == true && sh.getTieneInmortabilidad() == true){
				res = true;
				break;
			}
		}
		return res;
	}

	//2.Media
	
	public Double getMediaPuntuajeAño(Integer year) {
		Double suma = 0.0;
		Integer cont = 0;
		for (Superheroe sh: superheroes) {
			if(Integer.valueOf(sh.getFechaCreacion().getYear()).equals(year)) {
				suma += sh.getPuntuajeMedio();
				cont ++;
			}
		}
		
		Double res;
		if(cont!= 0) {
			res = Double.valueOf(suma/cont);
		}else {
			res = null;
		}
		return res;
	}
	
  
	//3. Selección com filtrado
	
		public Set<Superheroe> getSuperheroeCercanosAltura(Double altura, Double d){
			Set<Superheroe> res = new HashSet<>();
			
			for (Superheroe sh: superheroes) {
				Double min = altura - d;
				Double max = altura + d;
				if(sh.getAltura() >= min && sh.getAltura() <= max) {
					
					res.add(sh);
				}	
			}
			return res;
			
		}
		
	//4. Map diccionario de agrupación
		
		public Map<Creador, Set<Superheroe>> getSuperheroePorCreador(){
			
			Map<Creador, Set<Superheroe>> res = new HashMap<Creador, Set<Superheroe>>();
			for(Superheroe sh: superheroes) {
				Creador key = sh.getCreador();
				if(res.containsKey(key)) {
					Set<Superheroe> value = res.get(key);
					value.add(sh);
					res.put(key, value);
				}else {
					Set<Superheroe> value = new HashSet<>();
					value.add(sh);
					res.put(key, value);
				}
			}
			return res;
			
		}
	
		
	//5. Map contador
		
		public Map<Integer, Long> getNumeroSuperheroePorAño(){
			Map<Integer, Long> res = new HashMap<Integer, Long>();
			
			for(Superheroe sh:superheroes) {
				Integer key = sh.getFechaCreacion().getYear();
				if(res.containsKey(key)) {
					Long value = res.get(key);
					value ++;
					res.put(key, value);
				}
				else {
					Long value = Long.valueOf(1);
					res.put(key, value);
				}
			}
			return res;
		}

		
		
		
	//===============Entrega 3=====================0
	//Bloque 1
	
	//1. Existe (Con Stream)
		
		public  Boolean existeSuperheroeRazaTelepatiaInmortalStream(Raza r) {
			return superheroes.stream()
					          .anyMatch(x -> x.getTieneInmortabilidad().equals(true)
					           && x.getRaza().equals(r)
					           && x.getTieneTelepatia().equals(true));
		}
		
		
		
	//2. Media (Con Stream)
		public Double getMediaPuntuajeAñoStream(Integer year) {

			return superheroes.stream().filter(x -> Integer.valueOf(x.getFechaCreacion().getYear()).equals(year))
									   .mapToDouble(x->x.getPuntuajeMedio())
									   .average()
									   .orElse(0);
		}
	
		
	//3. Selección com filtrado (Con Stream)
		
		public Set<Superheroe> getSuperheroeCercanosAlturaStream(Double altura, Double d){
			return superheroes.stream()
							  .filter(x->x.getAltura() >= altura -d && x.getAltura() <= altura +d)
							  .collect(Collectors.toSet());
		}	
		
		
	//4. Máximo con filtrado (Con Stream)
		
		public Superheroe getSupeheroeMayorPuntuajeMedioPosicionamiento(Posicionamiento p) {
			return superheroes.stream()
					          .filter(x->x.getPosicionamiento().equals(p))
					          .max(Comparator.comparing(Superheroe::getPuntuajeMedio))
					          .get();
		}
		
	//5. Selección con filtrado y ordenación (Con Stream)
		
		public Set<Superheroe> getSuperheroesMayorPuntuajeMedioCreador(Creador c) {
			
			
			return superheroes.stream()
					          .filter(x->x.getCreador().equals(c))
					          .sorted(Comparator.comparing(Superheroe::getPuntuajeMedio).reversed())
					          .collect(Collectors.toSet());
		}
		
	//Bloque 2
		
	//6. Map diccionario de agrupación (Con Stream)
		public Map<Creador, List<Superheroe>> getSuperheroePorCreadorStream(){
			
			return superheroes.stream()
					          .collect(Collectors.groupingBy(Superheroe::getCreador));
		}
	
	//7. Método con "collectingAndThen"
		public Map<Posicionamiento, Superheroe> getSuperheroesMayorPuntuajeMedioPosicionamiento(){
			return superheroes.stream()
							  .collect(Collectors.groupingBy(Superheroe::getPosicionamiento, 
							   Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Superheroe::getPuntuajeMedio)), opt -> opt.get())));
							  
		}
		
	//8. Map<Atributo, Máximo/Mínimo>
		public Map<Creador, Superheroe> getSuperheroesMasAntiguosPorCreador(){
			return superheroes.stream()
					          .collect(Collectors.groupingBy(Superheroe::getCreador, 
					           Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Superheroe::getFechaCreacion)), opt->opt.get())));
		}
	
		
	//9. SortedMap<Atributo, nMejores/nPeores>
		public SortedMap<Raza, List<Superheroe>> obtenerNSuperheroesMayorAlturaPorRaza(Integer n){
			return superheroes.stream()
					  	      .sorted(Comparator.comparing(Superheroe::getAltura).reversed())
					  	      .collect(Collectors.groupingBy(Superheroe::getRaza, TreeMap::new, Collectors.collectingAndThen(Collectors.toList(),  x-> x.subList(0, n))));
		}
		
	//10. Clave con valor asociado(Mayor o menor) de un Map
		
		public Raza getMaxContadorPesoPorRaza() {
			Map<Raza, Double> map = superheroes.stream()
										.collect(Collectors.groupingBy(Superheroe::getRaza, Collectors.summingDouble(Superheroe::getPeso)));
			return map.entrySet().stream()
					 	         .max(Comparator.comparing(x->x.getValue()))
					 	         .get().getKey();
				
		}
		
		
		
}
