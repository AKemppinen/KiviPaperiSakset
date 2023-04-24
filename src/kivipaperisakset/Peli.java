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

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        Peli peli = new Peli();

        do {
            System.out.println("Erä: "
                    + peli.pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: "
                    + peli.tasapelit + "\n");
            peli.p1Valinta = p1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + peli.p1Valinta
                    + "\n\t Pelaaja 1:llä koossa " + peli.p1Voitot + " voittoa.");
            peli.p2Valinta = p2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + peli.p2Valinta
                    + "\n\t Pelaaja 2:lla koossa " + peli.p2Voitot + " voittoa.");
            
            // Allaolevassa pätkässä on yritetty eri tapoja saada
            // lukumäärän laskeminen toimimaan oikein.
            // Ei tää kyllä vieläkään skulaa - KORJAA!
            
            if ((peli.p1Valinta.equals("kivi")) && (peli.p2Valinta.equals("paperi"))) {
                System.out.println("Pelaaja 2 voittaa");
                peli.p2Voitot++;
                p2.setVoitot(peli.p2Voitot); // Kokeile eri tapoja saada lukumäärän laskenta kuntoon
            } else if ((peli.p1Valinta.equals("paperi")) && (peli.p2Valinta.equals("kivi"))) {
                peli.p1Voitot++;
                p1.setVoitot(peli.p1Voitot);
                System.out.println("Pelaaja 1 voittaa");
            } else if ((peli.p1Valinta.equals("kivi")) && (peli.p2Valinta.equals("sakset"))) {
                peli.p1Voitot++;
                p1.setVoitot(peli.p1Voitot);
                System.out.println("Pelaaja 1 voittaa");
            } else if ((peli.p1Valinta.equals("sakset")) && (peli.p2Valinta.equals("kivi"))) {
                peli.p2Voitot++;
                p2.setVoitot(peli.p2Voitot);
                System.out.println("Pelaaja 2 voittaa");
            } else if ((peli.p1Valinta.equals("sakset")) && (peli.p2Valinta.equals("paperi"))) {
                peli.p1Voitot++;
                p1.setVoitot(peli.p1Voitot);
                System.out.println("Pelaaja 1 voittaa");
            } else if ((peli.p1Valinta.equals("paperi")) && (peli.p2Valinta.equals("sakset"))) {
                peli.p2Voitot++;
                p2.setVoitot(peli.p2Voitot);
                System.out.println("Pelaaja 2 voittaa");
            }
            if (peli.p1Valinta == peli.p2Valinta) {
                peli.tasapelit++;
                System.out.println("\n\t\t\t Tasapeli \n");
            }
            peli.pelatutPelit++;
            if (p1.getVoitot() >= 3) {

                peli.peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
                System.out.println("PELAAJA 1 VOITTAA TURNAUKSEN");
            } else if (p2.getVoitot() >= 3){

                peli.peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
                System.out.println("PELAAJA 2 VOITTAA TURNAUKSEN");
            }
            System.out.println();
        } while (peli.peliLoppui != true);
    }
}
