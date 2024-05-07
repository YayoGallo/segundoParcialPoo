package udelp.edu.examen2ParcialPoo.process;

import java.util.ArrayList;
import java.util.List;

import udelp.edu.examen2ParcialPoo.model.Contacto;


public class ProcesoAgenda {

	List<Contacto> contactos;

	public Contacto existeContacto(String nombre) {
		if (null != contactos) {
			for (int i = 0; i < contactos.size(); i++) {
				if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {

					return contactos.get(i);
				}
			}
		}
		return null;
	}

	public void añadirContacto(Contacto contacto) {
		if (null != contactos) {
			contactos.add(contacto);
		} else {
			contactos = new ArrayList<Contacto>();
			contactos.add(contacto);
		}
	}

	public String mostrar() {
		String respuesta="";
		if(null!=contactos) {
			for (int i = 0; i < contactos.size(); i++) {
				respuesta+=contactos.get(i).getNombre()+" Telefonos:\n";
				for (int j = 0; j < contactos.get(i).getTelefonos().size(); j++) {
					respuesta+=contactos.get(i).getTelefonos().get(j)+"\n";
				}
			}
		}
		return respuesta;
	}
	
	public String mostrarTelefonos(String nombre) {
		
		String respuesta="No existe el contacto o no hay telefonos";
		Contacto aux=existeContacto(nombre);
		if(null!=aux && !aux.getTelefonos().isEmpty()) {
			respuesta="Telefonos:\n";
			for (int i = 0; i < aux.getTelefonos().size(); i++) {
				respuesta+=aux.getTelefonos().get(i)+"\n";
			}
		}
		return respuesta;
		
	}
	
	public boolean eliminarContacto(String nombre) {
		if (null != contactos) {
			for (int i = 0; i < contactos.size(); i++) {
				if (contactos.get(i).getNombre().equalsIgnoreCase(nombre)) {
					contactos.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean eliminarTelefono(String telefono, Contacto contacto) {
		
		if (!contacto.getTelefonos().isEmpty()) {
			for (int i = 0; i < contacto.getTelefonos().size(); i++) {
				if (contacto.getTelefonos().get(i).equals(telefono)) {
					contacto.getTelefonos().remove(i);
					return true;
				}
			}
		}
		return false;
		
	}
	
}
