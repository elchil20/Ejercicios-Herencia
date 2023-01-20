public class Forma {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Forma(String nombre) {
        this.nombre = nombre;
    }

    public double area() {
        return 0;
    }

    @Override
    public String toString() {
        return "Forma{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public static class Esfera extends Forma {
        private double radio;

        public double getRadio() {
            return radio;
        }

        public void setRadio(double radio) {
            this.radio = radio;
        }

        public Esfera(String nombre, double radio) {
            super(nombre);
            this.radio = radio;
        }

        public double area() {
            return 4 * Math.PI * (Math.pow(radio, 2));
        }

        @Override
        public String toString() {
            return "Esfera: " +
                    "radio=" + radio + " ";
        }
    }

    public static class Rectangulo extends Forma {
        private double altura;
        private double ancho;

        public double getAltura() {
            return altura;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        public double getAncho() {
            return ancho;
        }

        public void setAncho(double ancho) {
            this.ancho = ancho;
        }

        public Rectangulo(String nombre, double altura, double ancho) {
            super(nombre);
            this.altura = altura;
            this.ancho = ancho;
        }

        public double area() {
            return altura * ancho;
        }

        @Override
        public String toString() {
            return "Rectangulo: " +
                    "altura=" + altura +
                    ", ancho=" + ancho + " ";
        }
    }

    public static class Cilindro extends Forma {
        private double radio;
        private double altura;

        public double getRadio() {
            return radio;
        }

        public void setRadio(double radio) {
            this.radio = radio;
        }

        public double getAltura() {
            return altura;
        }

        public void setAltura(double altura) {
            this.altura = altura;
        }

        public Cilindro(String nombre, double radio, double altura) {
            super(nombre);
            this.radio = radio;
            this.altura = altura;
        }

        public double area() {
            return Math.PI * (Math.pow(radio, 2) * altura);
        }

        @Override
        public String toString() {
            return "Cilindro: " +
                    "radio=" + radio +
                    ", altura=" + altura;
        }
    }

    public static class Pintura {
        private double cobertura;

        public Pintura(double cobertura) {
            this.cobertura = cobertura;
        }

        public double cantidadp(Forma forma) {
            return (forma.area() / cobertura);
        }

        @Override
        public String toString() {
            return "Pintura: " +
                    "cobertura=" + cobertura;
        }
    }

    public static class MainPolimorfismo {
        public static void main(String[] args) {
            Pintura pintura = new Pintura(250);
            Rectangulo rectangulo = new Rectangulo("Rectangulo", 20, 35);
            Esfera esfera = new Esfera("Esfera", 15);
            Cilindro cilindro = new Cilindro("Cilindro", 10, 30);
            System.out.println(rectangulo.toString() + "Area: " + rectangulo.area() + " " + pintura.toString() + " " + "Cantidad de Pintura: " + pintura.cantidadp(rectangulo));
            System.out.println(esfera.toString() + "Area: " + esfera.area() + " " + pintura.toString() + " " + "Cantidad de Pintura: " + pintura.cantidadp(esfera));
            System.out.println(cilindro.toString() + "Area: " + cilindro.area() + " " + pintura.toString() + " " + "Cantidad de Pintura: " + pintura.cantidadp(cilindro));

        }
    }
}
