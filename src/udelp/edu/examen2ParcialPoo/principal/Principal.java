package udelp.edu.examen2ParcialPoo.principal;

import java.util.Scanner;

import udelp.edu.examen2ParcialPoo.model.Contacto;
import udelp.edu.examen2ParcialPoo.process.ProcesoAgenda;
import udelp.edu.examen2ParcialPoo.utility.Validaciones;

public class Principal {

	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);
		boolean repetir = false;
		byte opcion;
		String nombre, telefono, respuesta;
		ProcesoAgenda movimientos = new ProcesoAgenda();
		Validaciones valida = new Validaciones();

		do {
			System.out.println("Agenda telefonica \nMenu\n1)Añadir/ Actualizar\n"
					+ "2)Existe el contacto\n3)Lista de contactos\n4)Busca de contactos\n5)Eliminar contactos\n"
					+ "6)Eliminar telefono\n7)Salir");
			opcion = Byte.parseByte(leer.nextLine());
			switch (opcion) {

			case 1:
				System.out.println("Ingresa el nombre del contacto");
				nombre = leer.nextLine();
				Contacto aux = movimientos.existeContacto(nombre);
				if (null == aux) {
					System.out.println("Contacto nuevo \n Ingresa un numero para el contacto");
					telefono = leer.nextLine();
					if (valida.esDeDiez(telefono)) {
						Contacto contacto = new Contacto();
						contacto.setNombre(nombre);
						contacto.setTelefono(telefono);
						movimientos.añadirContacto(contacto);
					}else {
						System.out.println("Numero invalido");
					}
				} else {
					System.out.println("Ingresa otro numero para el contacto");
					telefono = leer.nextLine();
					if (valida.esDeDiez(telefono)) {
						aux.setTelefono(telefono);
					}else {
						System.out.println("Numero invalido");
					}
				}
				repetir = true;
				break;
				
			case 2:
				
				System.out.println("Ingresa el nombre del contacto");
				nombre = leer.nextLine();
				respuesta = null == movimientos.existeContacto(nombre) ? "No existe" : "Existe";
				System.out.println(respuesta);
				repetir = true;
				break;
				
			case 3:
				
				System.out.println(movimientos.mostrar()); 
				repetir = true;
				break;
				
			case 4:
				
				System.out.println("Ingresa el nombre del contacto que se va a buscar");
				nombre=leer.nextLine();
				System.out.println(movimientos.mostrarTelefonos(nombre));;
				repetir = true;
				break;
				
			case 5:
				
				System.out.println("Ingresa el nombre del contacto que se va a eliminar");
				nombre=leer.nextLine();
				respuesta=movimientos.eliminarContacto(nombre)?"Eliminado":"No hay contacto para eliminar";
				System.out.println(respuesta);
				repetir = true;
				break;
				
			case 6:
				
				System.out.println("Ingresa el nombre del contacto");
				nombre=leer.nextLine();
				Contacto aux2=movimientos.existeContacto(nombre);
				if(null!=aux2) {
					System.out.println(movimientos.mostrarTelefonos(aux2.getNombre()));;
					System.out.println("Ingrese el telefono a eliminar");
					telefono=leer.nextLine();
					System.out.println(movimientos.eliminarTelefono(telefono, aux2)?"Telefono eliminado":"No hay coincidencias"); 
				}
				repetir = true;
				break;
				
			case 7:
				
				System.out.println("Adios");
				repetir = false;
				break;
				
			default:
				
				System.out.println("Opcion invalida");
				repetir = true;
				break;
				
			}

		} while (repetir);

	}

}
