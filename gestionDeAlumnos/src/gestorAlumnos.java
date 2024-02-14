import java.util.ArrayList;

class gestorAlumnos {
    private ArrayList<Alumnos> alumnos = new ArrayList<Alumnos>();
    private int id = 1;

    public void agregarAlumno(Alumnos alumno) {
        alumno.setId(id++);
        alumnos.add(alumno);
    }

    public ArrayList<Alumnos> listarAlumnos() {
        ArrayList<Alumnos> alumnosNoBorrados = new ArrayList<Alumnos>();
        for (Alumnos alumno : alumnos) {
            if (!alumno.isBorrado()) {
                alumnosNoBorrados.add(alumno);
            }
        }
        return alumnosNoBorrados;
    }

    public boolean eliminarAlumno(int id) {
        for (Alumnos alumno : alumnos) {
            if (alumno.getId() == id) {
                alumno.setBorrado(true);
                return true;
            }
        }
        return false;
    }
    public Alumnos buscarAlumnoPorId(int id) {
        for (Alumnos alumno : alumnos) {
            if (alumno.getId() == id && !alumno.isBorrado()) {
                return alumno;
            }
        }
        return null; // Retorna null si no se encuentra ningún alumno con el ID dado
    }
}
