public class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        if (radio < 0) {
            radio = 0;
        }
        return radio;
    }

    public double getArea() {
        return Math.PI * (Math.pow(radio, 2));
    }

    public static class Cilindro extends Circulo {
        private double altura;

        public Cilindro(double radio, double altura) {
            super(radio);
            this.altura = altura;
        }
        public double getAltura() {
            if (altura < 0) {
                altura = 0;
            }
            return altura;
        }
        public void setAltura(double altura) {

            this.altura = altura;

        }
        public double getVolumen() {

            return getArea() * altura;
        }
    }
        public static void main(String[] args) {
            Circulo circulo = new Circulo(4);
            Cilindro cilindro = new Cilindro (3, 5);
            System.out.println("Este es el radio de tu circulo: " + circulo.getRadio());
            System.out.println("El area de tu circulo es: " + circulo.getArea());
            System.out.println("La altura de tu cilindro es: " + cilindro.getAltura());
            System.out.println("El volumen de tu cilindro es: " + cilindro.getVolumen());
        }
    }
