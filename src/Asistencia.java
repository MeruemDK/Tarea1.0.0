import java.util.Date;

public class Asistencia {
    private Estudiante estudiante;
    private Date fecha;
    private Date horaEntrada;
    private Date horaSalida;
    private String estado; // Puede ser "Presente", "Ausente", "Retardo"

    public Asistencia(Estudiante estudiante, Date fecha, Date horaEntrada, Date horaSalida, String estado) {
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.estado = estado;
    }

    // Getters y Setters

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format("Estudiante: [%s], Fecha: %s, Hora Entrada: %s, Hora Salida: %s, Estado: %s",
                estudiante, fecha, horaEntrada, horaSalida, estado);
    }
}
