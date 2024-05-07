package udelp.edu.examen2ParcialPoo.model;

import java.util.ArrayList;
import java.util.List;

public class Contacto {

	private String nombre;
	
	private List<String> telefonos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefono(String telefono) {
		if (null != telefonos) {
			this.telefonos.add(telefono);
		} else {
			this.telefonos = new ArrayList<String>();
			this.telefonos.add(telefono);
		}
		
	}
	
}
