package kivipaperisakset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeliTest {

    Peli peli = new Peli();
    Pelaaja p1 = new Pelaaja();
    Pelaaja p2 = new Pelaaja();

    @Test
    @DisplayName("Testaa, että pelaajalla on vaihtoehtoina kivi, paperi tai sakset")
    void testValinnat() {

        for (int i = 0; i < 100; i++) {
            String valinta = p1.pelaajanValinta();
            Assertions.assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
        }
    }
    @Test
    @DisplayName("Testaa loppuuko peli 3 voiton kohdalla")
    void testPeliLoppuuJosOn3Voittoa() {

        p1.setVoitot(3);
        Assertions.assertTrue(peli.peliLoppui);
    }

    @Test
    @DisplayName("p1 voittaa kun hänellä on sakset ja p2 on paperi")
    void testSaksetToPaperi(){

        p1.pelaajanValinta().equals("sakset");
        p2.pelaajanValinta().equals("paperi");

        assertEquals(1, p1.getVoitot());
    }
}