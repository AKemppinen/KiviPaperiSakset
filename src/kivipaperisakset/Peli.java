package kivipaperisakset;

/**
 *
 * @author Ira Dook
 */
public class Peli {
    boolean peliLoppui = false;
    int pelatutPelit = 0;           // Pelattujen pelien lkm
    int p1Voitot = 0;       // Pelaaja 1:n voittojen lkm
    int p2Voitot = 0;       // Pelaaja 2:n voittojen lkm
    int tasapelit = 0;              // Tasapelien lkm
    String p1Valinta;
    String p2Valinta;

    public void pelaaErä(Pelaaja p1, Pelaaja p2) {
        System.out.println("Erä: "
                + pelatutPelit + " =====================\n");
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");
        p1Valinta = p1.pelaajanValinta();
        System.out.println("Pelaaja 1: " + p1Valinta
                + "\n\t Pelaaja 1:llä koossa " + p1Voitot + " voittoa.");
        p2Valinta = p2.pelaajanValinta();
        System.out.println("Pelaaja 2: " + p2Valinta
                + "\n\t Pelaaja 2:lla koossa " + p2Voitot + " voittoa.");

        // Allaolevassa pätkässä on yritetty eri tapoja saada
        // lukumäärän laskeminen toimimaan oikein.
        // Ei tää kyllä vieläkään skulaa - KORJAA!

        if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("paperi"))) {
            System.out.println("Pelaaja 2 voittaa");
            p2Voitot++;
            p2.setVoitot(p2Voitot); // Kokeile eri tapoja saada lukumäärän laskenta kuntoon
        } else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("kivi"))) {
            p1Voitot++;
            p1.setVoitot(p1Voitot);
            System.out.println("Pelaaja 1 voittaa");
        } else if ((p1Valinta.equals("kivi")) && (p2Valinta.equals("sakset"))) {
            p1Voitot++;
            p1.setVoitot(p1Voitot);
            System.out.println("Pelaaja 1 voittaa");
        } else if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("kivi"))) {
            p2Voitot++;
            p2.setVoitot(p2Voitot);
            System.out.println("Pelaaja 2 voittaa");
        } else if ((p1Valinta.equals("sakset")) && (p2Valinta.equals("paperi"))) {
            p1Voitot++;
            p1.setVoitot(p1Voitot);
            System.out.println("Pelaaja 1 voittaa");
        } else if ((p1Valinta.equals("paperi")) && (p2Valinta.equals("sakset"))) {
            p2Voitot++;
            p2.setVoitot(p2Voitot);
            System.out.println("Pelaaja 2 voittaa");
        }
        if (p1Valinta == p2Valinta) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
        }
        pelatutPelit++;
        System.out.println();
    }

    public void voitonTarkistus(Pelaaja p1, Pelaaja p2) {
        if (p1.getVoitot() >= 3) {

            peliLoppui = true;
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            System.out.println("PELAAJA 1 VOITTAA TURNAUKSEN");
        } else if (p2.getVoitot() >= 3){

            peliLoppui = true;
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            System.out.println("PELAAJA 2 VOITTAA TURNAUKSEN");
        }
    }

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        Peli peli = new Peli();

        do {
            peli.pelaaErä(p1,p2);
            peli.voitonTarkistus(p1,p2);
        } while (peli.peliLoppui != true);
    }
}
