import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class Mascotas {
    // Atributos
	
	public	int codigo;
   public String nombre;
   public String especie;
   public int edad;
   public String edadString;
    
    ArrayList<String> informacionMascota;

    //Constructor sin parametros
    public Mascotas() {
    	  nombre = "Firu";
          especie = "Default";
          edad = 0;
          
          informacionMascota = new ArrayList<>();
    }
    
    //Metodo que permite ingresar los datos de las macotas con un ciclo
    
    public void ingresar() {
    	String val;
    	
    	do {
    	nombre = JOptionPane.showInputDialog("Ingrese nombre");
        especie = JOptionPane.showInputDialog("ingrese la especie de " + nombre);
        edad = Integer.parseInt(JOptionPane.showInputDialog("edad de la mascota " + nombre));
        
        informacionMascota.add(nombre);
        informacionMascota.add(especie);
        edadString = Integer.toString(edad);
        informacionMascota.add(edadString);
        
        val = JOptionPane.showInputDialog("¿desea ingresar otra?");
    	}while(val.equalsIgnoreCase("SI"));
    }

    
    // Constructor con parametros
    public Mascotas(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    
    // MÃ©todo para mostrar informaciÃ³n de la mascota
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad + " años");
    }
    
    //Metodo para mostrar la informacion de cada mascota

    public void mostrarInformacionGeneral(){
    	for (int i = 0; i < informacionMascota.size(); i++) {
    		
    		System.out.println(informacionMascota.get(i));
    	}
        
    }
    
    //Metodo para hacer una consulta indivual a la vez se puede modificar los datos
    
    public void consultaIndividual() {
        if (informacionMascota.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        String nombreBuscado = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a consultar");
        boolean encontrada = false;

        for (int i = 0; i < informacionMascota.size(); i += 3) {
            String nombre = informacionMascota.get(i);

            if (nombre.equalsIgnoreCase(nombreBuscado)) {
                String especie = informacionMascota.get(i + 1);
                String edadString = informacionMascota.get(i + 2);
                int edad = Integer.parseInt(edadString);

                Mascotas mascotaConsultada = new Mascotas(nombre, especie, edad);
                mascotaConsultada.mostrarInformacion();
                encontrada = true;

                // Modificar la mascota consultada
                String opcionModificacion = JOptionPane.showInputDialog("¿Qué desea modificar? (nombre/especie/edad)");
                opcionModificacion = opcionModificacion.toLowerCase();

                switch (opcionModificacion) {
                    case "nombre":
                        nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
                        informacionMascota.set(i, nombre);
                        mascotaConsultada.nombre = nombre;
                        break;
                    case "especie":
                        especie = JOptionPane.showInputDialog("Ingrese la nueva especie");
                        informacionMascota.set(i + 1, especie);
                        mascotaConsultada.especie = especie;
                        break;
                    case "edad":
                        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad"));
                        informacionMascota.set(i + 2, Integer.toString(edad));
                        mascotaConsultada.edad = edad;
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }

                System.out.println("Mascota modificada:");
                mascotaConsultada.mostrarInformacion();
                break;
            }
        }

        if (!encontrada) {
            System.out.println("La mascota no se encontró en la lista.");
        }
    }
     
    //Metodo para que dice si el perro esta jugando
    public void jugar () {
    	if (especie.equalsIgnoreCase("perro")) {
			System.out.println("Vaya por la pelota");
		} else {
			System.out.println("No esta jugando la mascota");
		}
    }
    
    
    // Metodo para hacer que la mascota realice un sonido
    public void hacerSonido() {
        if (especie.equalsIgnoreCase("perro")) {
            System.out.println("Â¡Guau guau!");
        } else if (especie.equalsIgnoreCase("gato")) {
            System.out.println("Â¡Miau miau!");
        } else {
            System.out.println("La mascota no hace sonidos conocidos.");
        }
    }
    
}




