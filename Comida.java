package com.sinensia;

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
    
    

    // Constructor con atributos comunes
    public Comida(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten) {
        this.nombre = nombre;
        this.hidratos = hidratos;
        this.proteina = proteina;
        this.grasas = grasas;
        this.calorias = calcularCalorias(hidratos, proteina, grasas);
        this.tieneGluten = tieneGluten;
    
    }


    public void mostrarInfo() {
        System.out.println("Comida: " + this.nombre +
                            " | Calorías: " + this.calorias +
                            " | Hidratos: " + this.hidratos +
                            " | Proteína: " + this.proteina +
                            " | Grasas: " + this.grasas +
                            " | Tiene Gluten: " + (this.tieneGluten ? "Sí" : "No"));
    }




    public static int calcularCalorias(int hidratos, int proteina, int grasas) {
        return hidratos*4 + proteina*4 + grasas*9;
    }

}



// Subclase Fruta
class Fruta extends Comida implements DatoComida  {
    public Fruta(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten) {
        super(nombre, hidratos, proteina, grasas, tieneGluten);

    }

    @Override
    public String datoComida() {
        return this.nombre + " es fruta. La fruta es muy rica en vitaminas.";
    }
   
}

// Subclase Carne
class Carne extends Comida implements DatoComida {
    
    public Carne(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten) {
        super(nombre, hidratos, proteina, grasas, tieneGluten);
    
    }
    @Override
    public String datoComida() {
        return this.nombre + " es carne. La carne es muy rica en proteína.";
    }
}

// Subclase Pescado
class Pescado extends Comida implements DatoComida {

    public Pescado(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten) {
        super(nombre, hidratos, proteina, grasas, tieneGluten);
        
    }
    @Override
    public String datoComida() {
        return this.nombre + " es pescado. El pescado es muy rico en Omega3.";
    }
}

// Subclase Verdura
class Verdura extends Comida implements DatoComida {
    
    public Verdura(String nombre, int hidratos, int proteina, int grasas, boolean tieneGluten) {
        super(nombre, hidratos, proteina, grasas, tieneGluten);
    
    }
    @Override
    public String datoComida() {
        return this.nombre + " es verdura. La verdura es muy rica en minerales.";
    }
}


class ComidaResultados{
    public static void main(String[] args) {

        // Crear instancias de comida
        Fruta manzana = new Fruta("Manzana", 52, 1, 0, false);
        Pescado salmon = new Pescado("Salmón", 30, 40, 30, false);
        Carne pollo = new Carne("Pollo", 10, 60, 30, false);
        Verdura patata = new Verdura("Patata", 7, 2, 0, false);
        Carne fileteTernera = new Carne("Filete de Ternera", 15, 40, 25, true);

        // Resultados
        manzana.mostrarInfo();
        System.out.println(manzana.datoComida());
        salmon.mostrarInfo();
        System.out.println(pollo.datoComida());
        patata.mostrarInfo();
        fileteTernera.mostrarInfo();



    }
}