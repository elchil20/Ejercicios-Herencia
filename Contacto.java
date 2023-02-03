import java.util.ArrayList;
import java.util.Scanner;
public class Contacto {
    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public class TelefonoMovil {
        private String myNumber;
        private static ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

        public String getMyNumber() {
            return myNumber;
        }

        public void setMyNumber(String myNumber) {
            this.myNumber = myNumber;
        }

        public ArrayList<Contacto> getMyContacts() {
            return myContacts;
        }

        public void setMyContacts(ArrayList<Contacto> myContacts) {
            this.myContacts = myContacts;
        }
        public TelefonoMovil(String myNumber) {
            this.myNumber = myNumber;
            myContacts.add(new Contacto("name", myNumber));
        }
        public static boolean addNewContact(Contacto contacto) {
            if (findContact(contacto) == -1) {
                System.out.println("Contacto añadido.");
                myContacts.add(contacto);
                return true;
            } else {
                System.out.println("El contacto ya existe.");
                return false;
            }
        }
        private static int findContact(Contacto contacto) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (myContacts.get(i).getName().equals(contacto.name)) {
                    return 0;
                }
            }
            return -1;
        }
        private String findContact(String nombre) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                    return ((i) + "." + " " + myContacts.get(i));
                }
            }
            return null;
        }
        public static boolean updateContact(Contacto contactoexiste, Contacto nuevocontacto) {
            if (findContact(contactoexiste) >=0) {
                myContacts.set(myContacts.indexOf(contactoexiste), nuevocontacto);
                System.out.println("Contacto actualizado.");
                return true;
            }
            else {
                System.out.println("El contacto ya existe.");
                return false;
            }
        }
        public static boolean deleteContact(Contacto contactoexiste2) {
            if (findContact(contactoexiste2) >=0) {
                myContacts.remove(myContacts.indexOf(contactoexiste2));
                System.out.println("Contacto eliminado.");
                return true;
            }
            else {
                System.out.println("El contacto no existe.");
                return false;
            }
        }
        public static Contacto queryContact(String name) {
            for (int i = 0; i < myContacts.size(); i++) {
                if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                    return (myContacts.get(i));
                }
            }
            return null;
        }

        public static void printContacts() {
            for (int i = 0; i < myContacts.size(); i++) {
                System.out.println((i+1) + "." + " " + myContacts.get(i).getName() + " " + myContacts.get(i).getPhoneNumber());
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        String nombre;
        String telefono;
        boolean continuar = true;
        int opcion = 0;
        do {
            try {
                System.out.println("0 - Para salir");
                System.out.println("1 - Para imprimir contactos");
                System.out.println("2 - Para añadir contacto");
                System.out.println("3 - Para modificar un contacto");
                System.out.println("4 - Para eliminar un contacto");
                System.out.println("5 - Para buscar un contacto");
                System.out.println("6 - Imprimir el menu");
                while(continuar) {
                    System.out.println("Elige una opción: ");
                    opcion = sc.nextInt();
                    sc.nextLine();
                    switch (opcion) {
                        case 0:
                            System.out.println("Adios vuelve cuando quieras.");
                            continuar = false;
                            break;
                        case 1:
                            TelefonoMovil.printContacts();
                            break;
                        case 2:
                            System.out.println("Inserta el nuevo contacto: ");
                            System.out.println("Dime su nombre: ");
                            nombre = sc2.nextLine();
                            System.out.println("Dime su numero de telefono: ");
                            telefono = sc3.nextLine();
                            Contacto contacto = new Contacto(nombre, telefono);
                            TelefonoMovil.addNewContact(contacto);
                            break;
                        case 3:
                            Contacto contactoexiste;
                            do {
                                System.out.println("Dime el contacto que quieres modificar: ");
                                String name = sc.nextLine();
                                contactoexiste = TelefonoMovil.queryContact(name);
                                if (contactoexiste == null) {
                                    System.out.println("El contacto no existe");
                                } else {
                                    System.out.println("Dime el nuevo nombre: ");
                                    String nuevonombre = sc.nextLine();
                                    System.out.println("Dime el nuevo numero");
                                    String nuevonumero = sc.nextLine();
                                    Contacto nuevocontacto = new Contacto(nuevonombre, nuevonumero);
                                    TelefonoMovil.updateContact(contactoexiste, nuevocontacto);
                                }
                            } while (contactoexiste == null);
                            break;
                        case 4:
                            Contacto contactoexiste2;
                            do {
                                System.out.println("Dime el contacto que quieres eliminar: ");
                                String name2 = sc.nextLine();
                                contactoexiste2 = TelefonoMovil.queryContact(name2);
                                if (contactoexiste2 == null) {
                                    System.out.println("El contacto no existe");
                                } else {
                                    TelefonoMovil.deleteContact(contactoexiste2);
                                }
                            } while (contactoexiste2 == null);
                            break;
                        case 5:
                            Contacto contactoexiste3;
                            do {
                                System.out.println("Dime el contacto que quieres buscar: ");
                                String name3 = sc.nextLine();
                                contactoexiste3 = TelefonoMovil.queryContact(name3);
                                if (contactoexiste3 == null) {
                                    System.out.println("El contacto no existe");
                                } else {
                                    System.out.println(contactoexiste3.getName() + " " + contactoexiste3.getPhoneNumber());
                                }
                            } while (contactoexiste3 == null);
                            break;
                        case 6:
                            Contacto.main(null);
                    }
                }
            } catch (Exception a) {
                System.out.println("Error has puesto un caracter o varios caracteres, vuelve a elegir una opcion.");
                System.out.println("Vuelve a intentarlo.");
                Contacto.main(null);
            }
        } while (opcion < 0 || opcion > 6);
    }
}
