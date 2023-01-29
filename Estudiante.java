import java.util.Arrays;

public class Estudiante implements Comparable <Estudiante> {
    private String nombre;
    private int altura;
    private int edad;

    @Override
    public String toString() {
        return "Estudiante: " +
                "nombre='" + nombre + '\'' +
                ", altura=" + altura +
                ", edad=" + edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Estudiante(String nombre, int altura, int edad) {
        this.nombre = nombre;
        this.altura = altura;
        this.edad = edad;
    }

    @Override
    public int compareTo(Estudiante est) {
        int resultado;
        if (this.altura>est.altura) {
            resultado = -1;
        }
        else if (this.altura<est.altura) {
            resultado = 1;
        }
            else {
                resultado = 0;
            }
        return resultado;
    }
    public static void main(String arg[]) {
        Estudiante est1 = new Estudiante("Patri", 170,12);
        Estudiante est2 = new Estudiante("Manuel", 173, 43);
        Estudiante est3 = new Estudiante("Javier", 189, 72);
        Estudiante est4 = new Estudiante("Alicia",168,52);
        Estudiante est5 = new Estudiante("Alberto",189,35);
        System.out.println("Estudiantes Sin ordenar:");
        Estudiante[] estudiante= {est1,est2,est3,est4,est5};
        for (int i = 0; i < estudiante.length; i++)
        {
            System.out.println(estudiante[i]);
        }
        System.out.println('\n');
        System.out.println("Estudiantes ordenados:");
        Arrays.sort(estudiante);

        for (int i = 0; i < estudiante.length; i++)
        {
            System.out.println(estudiante[i]);
        }
    }
}