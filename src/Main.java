import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SistemaAsistencia sistema = new SistemaAsistencia();

        // Formato de fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            // Crear estudiantes
            Estudiante est1 = new Estudiante("Luis", "Martínez", "001", "Ingeniería", 2);
            Estudiante est2 = new Estudiante("Ana", "García", "002", "Matemáticas", 3);

            // Agregar estudiantes al sistema
            sistema.agregarEstudiante(est1);
            sistema.agregarEstudiante(est2);

            // Registrar asistencia
            Date fecha1 = sdf.parse("2024-07-01 08:00");
            Date entrada1 = sdf.parse("2024-07-01 08:05");
            Date salida1 = sdf.parse("2024-07-01 16:00");
            sistema.registrarAsistencia(est1, fecha1, entrada1, salida1, "Presente");

            Date fecha2 = sdf.parse("2024-07-02 08:00");
            Date entrada2 = sdf.parse("2024-07-02 08:20");
            Date salida2 = sdf.parse("2024-07-02 16:00");
            sistema.registrarAsistencia(est2, fecha2, entrada2, salida2, "Retardo");

            // Justificar ausencia
            sistema.justificarAusencia(est2, fecha2);

            // Consultar historial de asistencia
            System.out.println("Historial de asistencia de Luis Martínez:");
            sistema.consultarHistorialAsistencia("001").forEach(System.out::println);

            // Generar reportes
            System.out.println("\nReporte de asistencia:");
            sistema.generarReporteAsistencia();

            // Estudiantes con más ausencias
            System.out.println("\nEstudiantes con más ausencias:");
            sistema.estudiantesConMasAusencias(1).forEach(System.out::println);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
