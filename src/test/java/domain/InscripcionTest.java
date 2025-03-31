package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

class InscripcionTest {
    Materia algoritmos = new Materia("Algoritmos y estructura de datos");
    Materia paradigmas = new Materia("Paradigma de programación");
    Materia discreta = new Materia("Lógica y Estructuras Discretas");
    Materia inglesUno = new Materia("Inglés I");
    Materia inglesDos = new Materia("Inglés II");
    Alumno juan = new Alumno("Juan");

    @Test
    @DisplayName("Se aprueba la inscripción al pasar materias que cumplen las correlativas")
    public void seApruebaInscripcion() {
        juan.agregarMateriasAprobadas(discreta, algoritmos, inglesUno);
        Inscripcion inscripcion = new Inscripcion(juan, Set.of(inglesDos, paradigmas));

        paradigmas.agregarCorrelativas(algoritmos, discreta);
        inglesDos.agregarCorrelativas(inglesUno);

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("NO se aprueba la inscripción porque no se cumplen las correlativas de una sola materia")
    public void noSeApruebaInscripcion() {
        juan.agregarMateriasAprobadas(discreta, inglesUno);
        Inscripcion inscripcion = new Inscripcion(juan, Set.of(inglesDos, paradigmas));

        paradigmas.agregarCorrelativas(algoritmos, discreta);
        inglesDos.agregarCorrelativas(inglesUno);

        Assertions.assertFalse(inscripcion.aprobada());
    }

}