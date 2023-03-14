package Mundo;

public class Estudiante {
	
	private int codigo;
	private String nombre;
	
	private Estudiante sgte;
	private Estudiante ant;

	@Override
	public String toString() {
		return "Estudiante{" +
				"codigo=" + codigo +
				", nombre='" + nombre + '\'' +
				", sgte=" + sgte +
				'}';
	}

	/**
	 * @param codigo
	 * @param nombre
	 * sgte = null
	 * ant = null
	 */
	public Estudiante(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		sgte = null;
		ant = null;
	}
	
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the sgte
	 */
	public Estudiante getSgte() {
		return sgte;
	}
	/**
	 * @param sgte the sgte to set
	 */
	public void setSgte(Estudiante sgte) {
		this.sgte = sgte;
	}
	/**
	 * @return the ant
	 */
	public Estudiante getAnt() {
		return ant;
	}
	/**
	 * @param ant the ant to set
	 */
	public void setAnt(Estudiante ant) {
		this.ant = ant;
	}
	
}
