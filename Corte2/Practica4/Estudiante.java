package practicaguijava;
public class Estudiante {
    private String codigo;
    private String nombre;
    private String programa;
    private String jornada;
    private double nota1;
    private double nota2;
    private double nota3;
    
    public Estudiante(String codigo, String nombre, String programa, String jornada, double nota1, double nota2, double nota3){
        this.codigo=codigo;
        this.nombre=nombre;
        this.programa=programa;
        this.jornada=jornada;
        this.nota1=nota1;
        this.nota2=nota2;
        this.nota3=nota3;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public String getJornada() {
        return jornada;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }
    public double calcularDefinitiva(){
        return nota1 * 0.30 + nota2 * 0.30 + nota3 *0.40;
    }
    public String obtenerEstado(){
        if (calcularDefinitiva() >= 3.0){
            return "Aprueba";
        }else{
            return "Reprueba";
        }
    }
}
