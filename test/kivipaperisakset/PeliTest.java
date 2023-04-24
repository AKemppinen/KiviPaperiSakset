package kivipaperisakset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeliTest {

    Peli peli = new Peli();

    @Test
    @DisplayName("Testaa, että pelaajalla on vaihtoehtoina kivi, paperi tai sakset")
    void testValinnat() {

        for (int i = 0; i < 100; i++) {
            String valinta = peli.p1.pelaajanValinta();
            Assertions.assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"));
        }
    }
    @Test
    @DisplayName("Testaa voittaako p1, jos hänellä on 3 voittoa")
    void testPeliLoppuuJosOn3Voittoa() {

        peli.p1.setVoitot(3);
        Assertions.assertEquals(3,peli.p1.getVoitot());
    }

    @Test
    @DisplayName("Testaa voittaako p2, jos hänellä on 3 voittoa")
    void testPeliLoppuuJosOn3Voittoap2() {

        peli.p2.setVoitot(3);
        Assertions.assertEquals(3,peli.p2.getVoitot());
    }

    @Test
    @DisplayName("Testaa voitontarkistuksen, jos pelaajalla on 3 voittoa")
    void testVoitontarkistusJosVoittaa() {

        peli.p1.setVoitot(3);
        peli.voitonTarkistus();
        Assertions.assertTrue(peli.peliLoppui);
    }

    @Test
    @DisplayName("Tarkastetaan kaikki mahdolliset tulokset pelistä")
    void testSaksetToPaperi(){

        peli.p1.pelaajanValinta();
        peli.p2.pelaajanValinta();

        if ((peli.p1.pelaajanValinta().equals("kivi")) && (peli.p2.pelaajanValinta().equals("paperi"))) {
            Assertions.assertEquals(1, peli.p2.getVoitot());
        } else if ((peli.p1.pelaajanValinta().equals("paperi")) && (peli.p2.pelaajanValinta().equals("kivi"))) {
            Assertions.assertEquals(1, peli.p1.getVoitot());
        } else if ((peli.p1.pelaajanValinta().equals("kivi")) && (peli.p2.pelaajanValinta().equals("sakset"))) {
            Assertions.assertEquals(1, peli.p1.getVoitot());
        } else if ((peli.p1.pelaajanValinta().equals("sakset")) && (peli.p2.pelaajanValinta().equals("kivi"))) {
            Assertions.assertEquals(1, peli.p2.getVoitot());
        } else if ((peli.p1.pelaajanValinta().equals("sakset")) && (peli.p2.pelaajanValinta().equals("paperi"))) {
            Assertions.assertEquals(1, peli.p1.getVoitot());
        } else if ((peli.p1.pelaajanValinta().equals("paperi")) && (peli.p2.pelaajanValinta().equals("sakset"))) {
            Assertions.assertEquals(1, peli.p2.getVoitot());
        }
        if (peli.p1.pelaajanValinta() == peli.p2.pelaajanValinta()) {
            Assertions.assertEquals(1, peli.tasapelit);
        }

    }
}