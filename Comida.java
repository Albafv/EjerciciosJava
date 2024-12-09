package com.sinensia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

interface DatoComida {
    String datoComida();
}

// Clase abstracta Comida
public abstract class Comida {
    public String nombre;     // Nombre de la comida
    public int hidratos;      // Hidratos en g
    public int proteina;      // Proteína en gramos
    public int grasas;        // Grasas en gramos
    public int calorias;      // Calorías de la comida (por calcular)
    public boolean tieneGluten;  // Indica si la comida tiene gluten
    public LocalDate fechaCaducidad;   // Indica la fecha de caducidad
    

    // Constructor con atributos comunes
    public Comida(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten, LocalDate fechaCaducidad) {
        this.nombre = nombre;

        // Manejo de excepción. Si los parámetros son negativos el programa no se ejecuta
        try {
            if (hidratos < 0 || proteina < 0 || grasas < 0) {
                // Lanza una excepción si los valores son negativos
                throw new IllegalArgumentException("Los valores no pueden ser negativos.");
            }
            // Asignación de valores si son >0
            this.hidratos = hidratos;
            this.proteina = proteina;
            this.grasas = grasas;
            this.calorias = calcularCalorias(hidratos, proteina, grasas);
            this.tieneGluten = tieneGluten;
            this.fechaCaducidad = fechaCaducidad;

        } catch (IllegalArgumentException e) {
            // Si se lanza la excepción, la capturamos aquí 
            System.out.println("Error al crear " + nombre + ": " + e.getMessage());
            
            // Detenemos la ejecución del programa
            System.exit(1); 
        }

    
    }


    public void mostrarInfo() {
        System.out.println("Comida: " + this.nombre +
                            " | Calorías: " + this.calorias +
                            " | Hidratos: " + this.hidratos +
                            " | Proteína: " + this.proteina +
                            " | Grasas: " + this.grasas +
                            " | Tiene Gluten: " + (this.tieneGluten ? "Sí" : "No") +
                            " | Fecha de Caducidad: " + this.fechaCaducidad);
    }




    public static int calcularCalorias(int hidratos, int proteina, int grasas) {
        return hidratos*4 + proteina*4 + grasas*9;
    }

}



// Subclase Fruta
class Fruta extends Comida implements DatoComida  {
    public Fruta(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten, LocalDate fechaCaducidad) {
        super(nombre, hidratos, proteina, grasas, tieneGluten, fechaCaducidad);

    }

    @Override
    public String datoComida() {
        return this.nombre + " es fruta. La fruta es muy rica en vitaminas.";
    }
   
}

// Subclase Carne
class Carne extends Comida implements DatoComida {
    
    public Carne(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten, LocalDate fechaCaducidad) {
        super(nombre, hidratos, proteina, grasas, tieneGluten, fechaCaducidad);
    
    }
    @Override
    public String datoComida() {
        return this.nombre + " es carne. La carne es muy rica en proteína.";
    }
}

// Subclase Pescado
class Pescado extends Comida implements DatoComida {

    public Pescado(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten, LocalDate fechaCaducidad) {
        super(nombre, hidratos, proteina, grasas, tieneGluten, fechaCaducidad);
        
    }
    @Override
    public String datoComida() {
        return this.nombre + " es pescado. El pescado es muy rico en Omega3.";
    }
}

// Subclase Verdura
class Verdura extends Comida implements DatoComida {
    
    public Verdura(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten, LocalDate fechaCaducidad) {
        super(nombre, hidratos, proteina, grasas, tieneGluten, fechaCaducidad);
    
    }
    @Override
    public String datoComida() {
        return this.nombre + " es verdura. La verdura es muy rica en minerales.";
    }
}


class ComidaResultados{
    public static void main(String[] args) {

        // Crear instancias de comida
        Fruta manzana = new Fruta("Manzana", 25, 1, 0, false, LocalDate.of(2025, 05, 01));
        Pescado salmon = new Pescado("Salmón", 0, 20, 13, false, LocalDate.of(2024, 12, 20));
        Carne pollo = new Carne("Pollo", 0, 30, 4, false, LocalDate.of(2025, 02, 01));
        Verdura patata = new Verdura("Patata", 17, 2, 0, false, LocalDate.of(2025, 07, 04));
        Carne fileteTernera = new Carne("Filete de Ternera", 0, 40, 13, true, LocalDate.of(2024, 12, 17));




         // Colecciones: Crear un ArrayList para calorías y otro pa comidas
        //  ArrayList<Integer> listaCalorias = new ArrayList<>();
         ArrayList<Comida> listaComida = new ArrayList<>();
         // Meter las calorías y cada comida a los ArrayList
        //  listaCalorias.add(manzana.calorias);
        //  listaCalorias.add(salmon.calorias);
        //  listaCalorias.add(pollo.calorias);
        //  listaCalorias.add(patata.calorias);
        //  listaCalorias.add(fileteTernera.calorias);
         listaComida.add(manzana);
         listaComida.add(salmon);
         listaComida.add(pollo);
         listaComida.add(patata);
         listaComida.add(fileteTernera);


        // Ordenar los elementos del array de calorías de menor a mayor:
        // Collections.sort(listaCalorias);
        // Qué comida se corresponde con este menor valor de calorías:
        // int menosCalorias = listaCalorias.get(0);
        // for (Comida comida : listaComida) {
            // if (comida.calorias == menosCalorias) {
                // System.out.println("La comida con menos calorías es: " + comida.nombre);    
            // }
        // }



        // Uso de LAMBDA para acortar la selección de comida con menos calorias:
        // Ordenar las comidas por calorías usando lAMBDA
        listaComida.sort(Comparator.comparingInt(c -> c.calorias));
        // Mostrar la comida con menos calorías (la primera después de ordenar)
        System.out.println("La comida con menos calorías es: " + listaComida.get(0).nombre);




        // Agregar un STREAM para filtrar las comidas que tienen menos de 100 calorías
        System.out.println("Comidas con menos de 100 calorías:");
        listaComida.stream()  // Convertimos la lista en un Stream
                   .filter(c -> c.calorias < 150)  // Filtramos las comidas con menos de 100 calorías
                   .forEach(c -> System.out.println(c.nombre));  // Imprimimos los nombres de esas comidas

        // STREAM: Calcular el total de calorías de todas las comidas
        int totalCalorias = listaComida.stream()  // Convertimos la lista en un Stream
                                       .mapToInt(c -> c.calorias)  // Extraemos las calorías de cada comida
                                       .sum();  // Sumamos todas las calorías

        System.out.println("El total de calorías de todas las comidas es: " + totalCalorias);




        // Encontrar la FECHA más cercana y la más lejana
        Comida comidaMasCercana = Collections.min(listaComida, (c1, c2) -> c1.fechaCaducidad.compareTo(c2.fechaCaducidad));
        Comida comidaMasLejana = Collections.max(listaComida, (c1, c2) -> c1.fechaCaducidad.compareTo(c2.fechaCaducidad));
        // Calcular la diferencia entre las fechas
        long diferencia = ChronoUnit.DAYS.between(LocalDate.now(), comidaMasLejana.fechaCaducidad);
        System.out.println("Dispongo de "
                         + diferencia + " días para terminar todos los alimentos antes de que todos caduquen.");



        // Otros resultados:
        manzana.mostrarInfo();
        patata.mostrarInfo();
        fileteTernera.mostrarInfo();
        salmon.mostrarInfo();
        System.out.println(manzana.datoComida());
        System.out.println(pollo.datoComida());


        
        
        // Un ejemplo de resumen da los datos se podría hacer con StringBuilder:
        // Crear resumen usando StringBuilder (método eficiente cuando hay concatenación)
        StringBuilder resumen = new StringBuilder();
        resumen.append("Resumen de Comidas:\n");
        for (Comida comida : listaComida) {
            resumen.append(comida.nombre)
                   .append(" | Calorías: ").append(comida.calorias)
                   .append(" | Fecha de Caducidad: ").append(comida.fechaCaducidad)
                   .append("\n");
        }
 
        // Imprimir resumen
        System.out.println(resumen.toString());
        

    }
}