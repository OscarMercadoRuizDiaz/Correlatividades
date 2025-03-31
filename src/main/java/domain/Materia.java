package domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public void agregarCorrelativas(Materia ... materias) {
        Collections.addAll(this.correlativas, materias);
    }

    public boolean cumplenCorrelativas(Set<Materia> unasMaterias) {
        return unasMaterias.containsAll(correlativas);
    }
}