
import main.gestor.GestorAcademico;
import main.models.Curso;
import main.models.Estudiante;




public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "2000-01-01", Estudiante.Estado.MATRICULADO);
        Estudiante estudiante2 = new Estudiante(2, "Ana", "López", "1999-05-15", Estudiante.Estado.MATRICULADO);

        Curso curso1 = new Curso(1, "Matemáticas", "Curso básico de matemáticas", 3, "1.0");
        Curso curso2 = new Curso(2, "Historia", "Historia Universal", 4, "1.0");

        try {
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);

            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);

            gestor.inscribirEstudianteCurso(estudiante1, 1);
            gestor.inscribirEstudianteCurso(estudiante2, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
