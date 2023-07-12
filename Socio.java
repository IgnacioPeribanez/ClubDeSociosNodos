package clubDeSocios;

public class Socio {
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String fechaIncorporacion;
	
	public Socio(String nombre, String primerApellido, String segundoApellido, String fechaIncorporacion) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(String fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido
				+ ", fechaIncorporacion=" + fechaIncorporacion + "]";
	}

}
