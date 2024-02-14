public class Alumnos {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaDeNacimiento;
    private String correoElectronico;
    private double nota1;
    private double nota2;
    private double nota3;
    private double finales;
    private double asistencia;
    private double notaFinal;
    private boolean borrado;
    private String telefono;
    private String calcularNotaCualitativa;

    public Alumnos(String nombre, String apellido1, String apellido2, String fechaDeNacimiento, String correoElectronico, String telefono, double nota1, double nota2, double nota3, double asistencia, double finales) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.finales = finales;
        this.asistencia = asistencia;
        this.notaFinal = calcularNotaFinal();
        this.borrado = false;
        this.calcularNotaCualitativa = calcularNotaCualitativa();

    }

    public String toStr(){
        return String.format("%-5s %-8s %-12s %-18s %-15s %-27s %-12s %-8s %-8s %-8s %-12s %-9s %.2f          %-15s" ,id , nombre,apellido1,apellido2,fechaDeNacimiento,correoElectronico,telefono,nota1,nota2,nota3,asistencia,finales,notaFinal,calcularNotaCualitativa);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;

    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }


    public void setFinales(double finales) {
        this.finales = finales;
    }
    public double getFinales() {
        return finales;
    }


    public double getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(double asistencia) {
        this.asistencia = asistencia;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
        this.calcularNotaCualitativa = calcularNotaCualitativa();
    }

    public String getCalcularNotaCualitativa() {
        return calcularNotaCualitativa;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public double calcularNotaFinal() {
        return nota1 * 0.2 + nota2 * 0.2 + nota3 * 0.3 + asistencia * 0.1 + finales * 0.3;
    }

    private String calcularNotaCualitativa() {
        if (this.notaFinal >= 5.0 && this.notaFinal < 7.0) {
            return "Aprobado";
        } else if (this.notaFinal >= 7.0 && this.notaFinal < 9.0) {
            return "Notable";
        } else if (this.notaFinal >= 9.0) {
            return "Sobresaliente";
        } else {
            return "Suspenso";
        }
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
}
