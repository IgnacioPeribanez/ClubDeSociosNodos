package clubDeSocios;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

	/**
	 * pre: --- 
	 * Post: Este método crea un club dependiendo de los ficheros encontrados en el directorio indicado
	 */
	private static listaEnlazadaSimpleClub ficheros(listaEnlazadaSimpleClub liga) {
			File directory = new File("C:\\Users\\Salesianos\\Desktop\\1ºGS\\PROGRAMACIÓN\\PRACTICANODO");
			File[] files = directory.listFiles();
			for (int i = 0; i < files.length; i++) {
				int contador = 0;
				File file = new File(files[i].getAbsolutePath());
				try {
					Scanner f = new Scanner(file);
					while (f.hasNextLine()) {
						String linea = f.nextLine();
						if (contador == 0) {
							Club club = new Club(linea);
							NodeClub nc = new NodeClub(club, null);
							liga.add(nc);
							contador++;
						} else {
							String[] lineaSeparada = linea.split(" ");
							Socio socio = new Socio(lineaSeparada[0], lineaSeparada[1], 
									lineaSeparada[2], lineaSeparada[3]);
							NodeSocio nc = new NodeSocio(socio, null);
							liga.get(i).getContent().getSocios().add(nc);
						}
					}
				} catch (FileNotFoundException e) {
					System.out.println(e.toString());
				}
			}
			return liga;
	}

	/**
	 * pre: --- 
	 * Post: Este método escribe el club indicado en un fichero de texto
	 */
	public static void escribir(NodeClub club) {
		try {
			Formatter salida = new Formatter("C:\\Users\\Salesianos\\Desktop\\1ºGS\\PROGRAMACIÓN\\PRACTICANODO\\"
					+ club.getContent().getNombre() + ".txt");
			String linea = club.getContent().getNombre();
			salida.format(linea + "\n");
			for (int j = 0; j < club.getContent().getSocios().getSize(); j++) {
				String socio = club.getContent().getSocios().get(j).getContent().getNombre() + " "
						+ club.getContent().getSocios().get(j).getContent().getPrimerApellido() + " "
						+ club.getContent().getSocios().get(j).getContent().getSegundoApellido() + " "
						+ club.getContent().getSocios().get(j).getContent().getFechaIncorporacion();
				salida.format(socio + "\n");
			}
			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * pre: --- 
	 * Post: Este método lanza el programa
	 */
	public static void main(String[] arg) {
		listaEnlazadaSimpleClub liga = new listaEnlazadaSimpleClub();
		liga = ficheros(liga);
		liga.show();
		Scanner entrada = new Scanner(System.in);
		System.out.println("¡Bienvenido a tu gestor de Clubs!");
		System.out.print(
				"------------------------------------------------------------------------------------------------------");
		while (true) {
			System.out.println("\n0.- Apagar programa");
			System.out.println("1.- Elegir un club");
			System.out.println("2.- Fundar un club");
			System.out.println("3.- Unir dos clubes");
			System.out.print("\n¿Que opción deseas ejecutar?: ");
			int numero = entrada.nextInt();
			System.out.println("");
			if (numero > 3 || numero < 0) {
				System.out.println("Error, elija una de las opciones válidas");
			} else if (numero == 0) {
				System.out.print("Has apagado el programa");
				break;
			} else if (numero == 1) {
				while (true) {
					liga.show();
					System.out.print("\n¿Que club deseas elegir?: ");
					int club = entrada.nextInt();
					NodeClub elegido = liga.get(club);
					System.out.println("");
					if (club > liga.getSize() || club < 0) {
						System.out.println("Error, elija una de las opciones válidas");
					} else {
						while (true) {
							System.out.println("0.- Atras");
							System.out.println("1.- Dar de alta un socio");
							System.out.println("2.- Dar de baja un socio");
							System.out.println("3.- Visualizar socios del club");
							System.out.println("4.- Guardar el club en un fichero de texto");
							System.out.println("5.- Pertenencia de un socio a el club");
							System.out.println("6.- Comprobar si el club esta vacio");
							System.out.println("7.- Número de socios del club");
							System.out.print("\n¿Que opción  deseas ejecutar?: ");
							int opcion = entrada.nextInt();
							System.out.println("");
							if (opcion > 7 || opcion < 0) {
								// Mostramos un error
								System.out.println("Error, elija una de las opciones válidas");
							} else if (opcion == 0) {
								break;
							} else if (opcion == 1) {
								entrada.nextLine();
								System.out.print("¿Que nombre tiene el socio?: ");
								String nombre = entrada.nextLine();
								System.out.print("\n¿Que primer apellido tiene el socio?: ");
								String apellido1 = entrada.nextLine();
								System.out.print("\n¿Que segundo apellido tiene el socio?: ");
								String apellido2 = entrada.nextLine();
								LocalDate fechaD = LocalDate.now();
								String fecha = fechaD.toString();
								Socio alta = new Socio(nombre, apellido1, apellido2, fecha);
								NodeSocio nodeAlta = new NodeSocio(alta, null);
								elegido.getContent().getSocios().add(nodeAlta);
								System.out.println();
							} else if (opcion == 2) {
								elegido.getContent().getSocios().show();
								System.out.print("¿Que socio quieres dar de baja?: ");
								int socio = entrada.nextInt();
								elegido.getContent().getSocios().delete(socio);
								elegido.getContent().getSocios().show();
								System.out.println();
							} else if (opcion == 3) {
								System.out.println();
								elegido.getContent().getSocios().show();
								System.out.println();
							} else if (opcion == 4) {
								escribir(elegido);
							} else if (opcion == 5) {
								entrada.nextLine();
								System.out.print("Dime el nombre del socio que quieres comprobar: ");
								String socio = entrada.nextLine();
								if (Club.esta(elegido, socio) == true) {
									System.out.println("El socio esta en el club");
								} else {
									System.out.println("El socio no se encuentra en el club");
								}
								System.out.println();
							} else if (opcion == 6) {
								if (elegido.getContent().getSocios().getSize() == 0) {
									System.out.println("El club esta vacio");
								} else {
									System.out.println("El club no esta vacio");
								}
								System.out.println();
							} else if (opcion == 7) {
								System.out.println("El club " + elegido.getContent().getNombre() + " tiene "
										+ elegido.getContent().getSocios().getSize() + " socios");
								System.out.println();
							}
						}
					}
				}
			} else if (numero == 2) {
				entrada.nextLine();
				System.out.print("¿Que club quieres introducir?: ");
				String nombre = entrada.nextLine();
				Club nuevo = new Club(nombre);
				NodeClub nc = new NodeClub(nuevo, null);
				liga.add(nc);
			} else if (numero == 3) {
				liga.show();
				System.out.print("\n¿Que club quieres eliminar?: ");
				int eliminado = entrada.nextInt();
				System.out.print("\n¿A que club quieres añadir los socios del club "
						+ liga.get(eliminado).getContent().getNombre() + "?: ");
				int vivo = entrada.nextInt();
				liga.get(vivo).getContent().setSocios(Club.union(liga.get(vivo).getContent().getSocios(),
						liga.get(eliminado).getContent().getSocios()));
				liga.delete(eliminado);
				System.out.println("");
				liga.show();
			}
		}
	}
}
