package main.gestor;

import java.util.ArrayList;
import java.util.HashMap;
import main.exceptions.EstudianteNoInscritoEnCursoException;
import main.exceptions.EstudianteYaInscritoException;
import main.models.Curso;
import main.models.Estudiante;
import main.servicios.ServiciosAcademicosI;


public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException {
        if (estudiantes.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está matriculado.");
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = cursos.stream().filter(c -> c.getId() == idCurso).findFirst().orElse(null);
        if (curso == null) {
            throw new IllegalArgumentException("Curso no encontrado");
        }
        if (inscripciones.containsKey(curso) && inscripciones.get(curso).contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }
        inscripciones.computeIfAbsent(curso, k -> new ArrayList<>()).add(estudiante);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = cursos.stream().filter(c -> c.getId() == idCurso).findFirst().orElse(null);
        if (curso == null) {
            throw new IllegalArgumentException("Curso no encontrado");
        }
        Estudiante estudiante = estudiantes.stream().filter(e -> e.getId() == idEstudiante).findFirst().orElse(null);
        if (estudiante == null || !inscripciones.get(curso).contains(estudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en el curso.");
        }
        inscripciones.get(curso).remove(estudiante);
    }
}
