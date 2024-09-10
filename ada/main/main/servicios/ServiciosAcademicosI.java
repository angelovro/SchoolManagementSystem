package main.servicios;

import main.exceptions.EstudianteNoInscritoEnCursoException;
import main.exceptions.EstudianteYaInscritoException;
import main.models.Curso;
import main.models.Estudiante;

public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException, EstudianteYaInscritoException;
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException, EstudianteNoInscritoEnCursoException;
}