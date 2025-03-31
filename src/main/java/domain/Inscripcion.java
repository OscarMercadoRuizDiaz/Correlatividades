package domain;

import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materiasACursar;

    public Inscripcion(Alumno alumno, Set<Materia> materiasACursar) {
        this.alumno = alumno;
        this.materiasACursar = materiasACursar;
    }

    public boolean aprobada() {
        Set<Materia> materiasAprobadas = alumno.getMateriasAprobadas();
        return materiasACursar.stream().allMatch(m -> m.cumplenCorrelativas(materiasAprobadas));
    }
}