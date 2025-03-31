package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

class MateriaTest {
    Materia algoritmos = new Materia("Algoritmos y estructura de datos");
    Materia paradigmas = new Materia("Paradigma de programación");
    Materia discreta = new Materia("Lógica y Estructuras Discretas");
    Materia inglesUno = new Materia("Inglés I");

    @Test
    @DisplayName("Se cumplen las correlativas cuando se añaden materias que sí la cumplen")
    public void correlativasCorrectas() {
        paradigmas.agregarCorrelativas(algoritmos, discreta);

        Assertions.assertTrue(paradigmas.cumplenCorrelativas(Set.of(algoritmos, discreta, inglesUno)));
    }

    @Test
    @DisplayName("No se cumplen las correlativas cuando no le pasan todas sus correlativas")
    public void correlativasIncorrectas() {
        paradigmas.agregarCorrelativas(algoritmos, discreta);

        Assertions.assertFalse(paradigmas.cumplenCorrelativas(Set.of(discreta, inglesUno)));
    }

}