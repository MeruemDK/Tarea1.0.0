import java.util.*;

public class SistemaAsistencia {
    private Map<String, Estudiante> estudiantes;
    private List<Asistencia> asistencias;

    public SistemaAsistencia() {
        estudiantes = new HashMap<>();
        asistencias = new LinkedList<>();
    }

    // Gestión de Estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getNumeroIdentificacion(), estudiante);
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getNumeroIdentificacion(), estudiante);
    }

    public Estudiante consultarEstudiante(String numeroIdentificacion) {
        return estudiantes.get(numeroIdentificacion);
    }

    // Registro de Asistencia
    public void registrarAsistencia(Estudiante estudiante, Date fecha, Date horaEntrada, Date horaSalida, String estado) {
        Asistencia asistencia = new Asistencia(estudiante, fecha, horaEntrada, horaSalida, estado);
        asistencias.add(asistencia);
    }

    public void justificarAusencia(Estudiante estudiante, Date fecha) {
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getEstudiante().equals(estudiante) && asistencia.getFecha().equals(fecha)) {
                asistencia.setEstado("Justificado");
                return;
            }
        }
    }

    public List<Asistencia> consultarHistorialAsistencia(String numeroIdentificacion) {
        List<Asistencia> historial = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getEstudiante().getNumeroIdentificacion().equals(numeroIdentificacion)) {
                historial.add(asistencia);
            }
        }
        return historial;
    }

    // Generación de Reportes
    public double calcularPorcentajeAsistencia(String numeroIdentificacion) {
        List<Asistencia> historial = consultarHistorialAsistencia(numeroIdentificacion);
        if (historial.isEmpty()) return 0.0;

        int totalClases = historial.size();
        long clasesPresentes = historial.stream().filter(a -> "Presente".equals(a.getEstado())).count();
        return (clasesPresentes * 100.0) / totalClases;
    }

    public List<Estudiante> estudiantesConMasAusencias(int limite) {
        Map<Estudiante, Long> contadorAusencias = new HashMap<>();
        for (Asistencia asistencia : asistencias) {
            if ("Ausente".equals(asistencia.getEstado())) {
                contadorAusencias.put(asistencia.getEstudiante(),
                        contadorAusencias.getOrDefault(asistencia.getEstudiante(), 0L) + 1);
            }
        }
        List<Map.Entry<Estudiante, Long>> listaOrdenada = new ArrayList<>(contadorAusencias.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<Estudiante> resultado = new ArrayList<>();
        for (int i = 0; i < Math.min(limite, listaOrdenada.size()); i++) {
            resultado.add(listaOrdenada.get(i).getKey());
        }
        return resultado;
    }

    public void generarReporteAsistencia() {
        for (Estudiante estudiante : estudiantes.values()) {
            double porcentaje = calcularPorcentajeAsistencia(estudiante.getNumeroIdentificacion());
            System.out.printf("Estudiante: %s, Porcentaje de Asistencia: %.2f%%\n",
                    estudiante.getNombre(), porcentaje);
        }
    }
}
