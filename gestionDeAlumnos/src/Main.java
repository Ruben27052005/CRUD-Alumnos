import java.util.Locale;
import java.util.Scanner;

class MainAlumnos {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerNum = new Scanner(System.in).useLocale(Locale.US);
    static gestorAlumnos ga = new gestorAlumnos();

    public static void main(String[] args) {
        int opcion;
        System.out.println("Crud de notas de alumnos");
        boolean salir = false;
        do {
            menu();
            opcion = scannerNum.nextInt();
            switch (opcion) {
                case 1:
                    ingresarAlumno();
                    break;
                case 2:
                    mostrarAlumnos();
                    break;
                case 3:
                    mocearAlumnos();
                    break;
                case 4:
                    eliminarAlumno();
                    break;
                case 5:
                    modificarAlumno();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (!salir);
        System.out.println("¡Adios!");
    }

    private static void menu() {
        System.out.println("Menú de Opciones");
        System.out.println("================");
        System.out.println("1. Ingresar Nombre Del Alumno");
        System.out.println("2. Listar Nombres De Alumnos");
        System.out.println("3. Mocear Alumnos");
        System.out.println("4. Eliminar Alumno");
        System.out.println("5. Modificar Alumno");
        System.out.println("6. Salir");
        System.out.println("Ingrese Una Opción");
    }

    private static void ingresarAlumno() {
        String apellido1;
        String apellido2;
        String fechaDeNacimiento;
        String correoElectronico;
        String telefono;
        double asistencia;
        double nota1;
        double nota2;
        double nota3;
        double finales;
        System.out.println("Formulario De Ingreso De Alumnos");
        System.out.println("================================");
        System.out.println();
        System.out.println("Nombre: ");
        String nombre = scannerStr.nextLine();
        System.out.println("Primer Apellido: ");
        apellido1 = scannerStr.nextLine();
        System.out.println("Segundo Apellido: ");
        apellido2 = scannerStr.nextLine();
        System.out.println("Fecha De Nacimiento (YYYY-MM-DD): ");
        fechaDeNacimiento = scannerStr.nextLine();
        System.out.println("Correo Electrónico");
        correoElectronico = scannerStr.nextLine();
        System.out.println("Teléfono:");
        telefono = scannerStr.nextLine();
        System.out.println("Nota 1:");
        nota1 = scannerNum.nextDouble();
        System.out.println("Nota 2:");
        nota2 = scannerNum.nextDouble();
        System.out.println("Nota 3:");
        nota3 = scannerNum.nextDouble();
        System.out.println("Asistencia");
        asistencia = scannerNum.nextDouble();
        System.out.println("Nota Finales");
        finales = scannerNum.nextDouble();
        double notaFinal = nota1 * 0.2 + nota2 * 0.2 + nota3 * 0.3 + asistencia * 0.1 + finales * 0.3;
        String notaCualitativa;
        if (notaFinal >= 5.0 && notaFinal < 7.0) {
            notaCualitativa = "Aprobado";
        } else if (notaFinal >= 7.0 && notaFinal < 9.0) {
            notaCualitativa = "Notable";
        } else if (notaFinal >= 9.0 && notaFinal <= 10.0) {
            notaCualitativa = "Sobresaliente";
        } else {
            notaCualitativa = "Suspenso";
        }
        ga.agregarAlumno(new Alumnos(nombre, apellido1, apellido2, fechaDeNacimiento, correoElectronico, telefono, nota1, nota2, nota3, asistencia,finales));
        System.out.println("\nAlumno Agregado Con Éxito");

    }

    private static void mostrarAlumnos() {
        cabeceraListarAlumnos();
        for (Alumnos a : ga.listarAlumnos()) {
            System.out.println(a.toStr());
        }
        pausa();
    }
    private static void cabeceraListarAlumnos() {
        //Salida de datos con variable local
        System.out.println("\n\n      Listado de Alumnos");
        System.out.println("===========================");
        System.out.println("ID    Nombre   Apellido 1   Apellido 2   Fecha de Nacimiento   Correo Electrónico          Teléfono    Nota 1   Nota 2   Nota 3   Finales   Asistencia   Nota Final   Nota Cualitativa");
        System.out.println("======================================================================================================================================================================================");
    }
    private static void pausa() {
        System.out.println();
        System.out.println("Presione ENTER para continuar...");
        scannerStr.nextLine();
    }
    private static void mocearAlumnos() {
        ga.agregarAlumno(new Alumnos("Rubén","Macías", "Guerrero", "27-05-2005", "rubenchomacias@gmail.com", "637571253", 6, 7, 0, 5,5));
        ga.agregarAlumno(new Alumnos("Leyre ","Fernández", "Martín", "14-12-2005",  "leyrefendz@gmail.com","694287543",6, 5,9,4 ,10));
        ga.agregarAlumno(new Alumnos("Victor","Garcia", "Ruiz", "26-05-2005", "victorgapc@gmail.com", "646658490", 6, 5,3, 9,5));
        ga.agregarAlumno(new Alumnos("Santi","Poves", "Escontrela", "12-09-2005","santialr@gmail.com", "659494094", 4, 8,1,3,9));
        ga.agregarAlumno(new Alumnos("Luis","Alonso", "Cruz", "20-03-2005","luisao04@gmail.com" , "645672949", 6, 5,2, 6,7));
        ga.agregarAlumno(new Alumnos("Carlos","Gomez", "Checa", "15-01-2005", "carlosgomz@gmail.com", "649547126", 6,9,5, 7,6));
        ga.agregarAlumno(new Alumnos("Betroy","Lamptey", "Torres", "23-04-2005", "betroyg@gmail.com", "696378032", 5, 7,7, 6,9));

        System.out.println("\n10 Alumnos Agregados Con Éxito");
        pausa();
    }

    private static void listarAlumno(){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.printf("%-5s %-10s %-7s %-7s %-15s %-8s %-8s %-8s %-12s %8s %-8s %s","id", "Nombre","Apellido","Correo_electronico","Teléfono","1ªNota","2ªNota","3ªNota","Asistencia","Nota_final","NotaTotal\n5" ,"nota cualitativa" );
        System.out.println("====================================================================================================================================");
    }
    private static void eliminarAlumno() {
        System.out.println("Ingrese el ID del alumno que desea eliminar:");
        int id = scannerNum.nextInt();
        if (ga.eliminarAlumno(id)) {
            System.out.println("Alumno eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún alumno con el ID especificado.");

        }
    }
    private static void modificarAlumno() {
        System.out.println("Ingrese el ID del alumno que desea modificar:");
        int id = scannerNum.nextInt();
        Alumnos alumno = ga.buscarAlumnoPorId(id);
        if (alumno != null) {
            System.out.println("Ingrese los nuevos datos del alumno:");
            System.out.println("Nuevo Nombre: ");
            alumno.setNombre(scannerStr.nextLine());
            System.out.println("Nuevo Primer Apellido: ");
            alumno.setApellido1(scannerStr.nextLine());
            System.out.println("Nuevo Segundo Apellido: ");
            alumno.setApellido2(scannerStr.nextLine());
            System.out.println("Nueva Fecha De Nacimiento (YYYY-MM-DD): ");
            alumno.setFechaDeNacimiento(scannerStr.nextLine());
            System.out.println("Nuevo Correo Electrónico: ");
            alumno.setCorreoElectronico(scannerStr.nextLine());
            System.out.println("Nuevo Teléfono: ");
            alumno.setTelefono(scannerStr.nextLine());
            System.out.println("Nueva Nota 1: ");
            alumno.setNota1(scannerNum.nextDouble());
            System.out.println("Nueva Nota 2: ");
            alumno.setNota2(scannerNum.nextDouble());
            System.out.println("Nueva Nota 3: ");
            alumno.setNota3(scannerNum.nextDouble());
            System.out.println("Nueva Asistencia: ");
            double nuevaAsistencia = scannerNum.nextDouble();
            alumno.setAsistencia(nuevaAsistencia);
            System.out.println("Nuevos Finales: ");
            double nuevosFinales = scannerNum.nextDouble();
            alumno.setFinales(nuevosFinales);
            double nuevaNotaFinal = alumno.calcularNotaFinal();
            alumno.setNotaFinal(nuevaNotaFinal);

            System.out.println("Datos del alumno modificados correctamente.");
        } else {
            System.out.println("No se encontró ningún alumno con el ID especificado.");
            pausa();
        }
    }
}



