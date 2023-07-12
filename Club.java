package clubDeSocios;

public class Club {
	private String nombre;
	private listaEnlazadaSimpleSocio socios;
	
	public Club(String nombre) {
		this.nombre = nombre;
		this.socios = new listaEnlazadaSimpleSocio();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public listaEnlazadaSimpleSocio getSocios() {
		return socios;
	}

	public void setSocios(listaEnlazadaSimpleSocio socios) {
		this.socios = socios;
	}

	@Override
	public String toString() {
		return "Club [nombre=" + nombre + ", socios=" + socios + "]";
	}
	
	public static listaEnlazadaSimpleSocio union(listaEnlazadaSimpleSocio club1, listaEnlazadaSimpleSocio club2) {
		for (int i = 0; i < club2.getSize(); i++) {
			club1.add(club2.get(i));
		}
		return club1;
	}
	
	/**
	 * pre: --- 
	 * Post: Este método lanza el programa
	 */ 
	public static boolean esta(NodeClub elegido, String socio) {
		for (int i = 0; i < elegido.getContent().getSocios().getSize(); i++) {
			System.out.println(elegido.getContent().getSocios().get(i).getContent().getNombre());
			if (elegido.getContent().getSocios().get(i).getContent().getNombre() == socio) {
				return true;
			}
		}
		return false;
	}
	
}
