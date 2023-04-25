package kivipaperisakset;

/**
 *
 * @author Antti Kemppinen
 * Määritellään pelille instannsimuuttujat.
 */
public class Peli {

    //Lisää 2 pelaajaa
    Pelaaja p1 = new Pelaaja();
    Pelaaja p2 = new Pelaaja();
    boolean peliLoppui = false; // Onko peli loppunut vai ei
    int pelatutPelit = 0;// Pelattujen pelien lkm
    int p1Voitot = 0;// Pelaaja 1:n voittojen lkm
    int p2Voitot = 0;// Pelaaja 2:n voittojen lkm
    int tasapelit = 0;// Tasapelien lkm
    String p1Valinta; // Pelaajan 1 valinta
    String p2Valinta; // Pelaajan 2 valinta

    /**
     * @author Antti Kemppinen
     * Pelaa yhden erän kivi sakset paperi peliä.
     * Ensin molemmat pelaajat valitsevat satunnaisesti joko arvot kivi, sakset tai paperi.
     * Tämän jälkeen tarkistetaan mitä kumpikin sai ja verrataan niitä toisiinsa.
     * Tämän jälkeen pelaajien pisteitä lisätään sitä mukaan kumpi voitti.
     * Lopuksi lisätään pelien määrää yhdellä.
     */
    public void pelaaErä() {
        //Printtaa erän
        System.out.println("Erä: "
                + pelatutPelit + " =====================\n");
        //Printtaa tasapelien määrän
        System.out.println("Tasapelien lukumäärä: "
                + tasapelit + "\n");
        //p1 ja p2 valitsevat kivi, paperi tai sakset
        p1Valinta = p1.pelaajanValinta();
        System.out.println("Pelaaja 1: " + p1Valinta
                + "\n\t Pelaaja 1:llä koossa " + p1Voitot + " voittoa.");
        p2Valinta = p2.pelaajanValinta();
        System.out.println("Pelaaja 2: " + p2Valinta
                + "\n\t Pelaaja 2:lla koossa " + p2Voitot + " voittoa.");

        //Tarkistaa erikseen jokaisen mahdollisen tuloksen
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
        //Lisää pelattuihin peleihin yhden pelin
        pelatutPelit++;
        System.out.println();
    }

    /**
     * @author Antti Kemppinen
     * Tarkastaa voiton. Jos jommalla kummalla pelaajalla on 3 tai enemmän voittoja
     * muuttuu peliLoppui muuttuja arvoon true, joka lopettaa pelin
     */
    public void voitonTarkistus() {
        //Tarkistaa jos jommallakummalla on 3 voittoa
        if (p1.getVoitot() >= 3) {

            peliLoppui = true;
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            System.out.println("PELAAJA 1 VOITTAA TURNAUKSEN");
        } else if (p2.getVoitot() >= 3){

            peliLoppui = true;
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            System.out.println("PELAAJA 2 VOITTAA TURNAUKSEN");
            System.out.println(peliLoppui);
        }
    }

    /**
     *
     * @param args
     * @author Antti Kemppinen
     * Tarkistaa aluksi onko jompikumpi pelaajista jo voittanut, jonka jälkeen pelaa yhden erän.
     * Tämän jälkeen pelataan niin monta erää kunnes jompikumpi saa 3 voittoa, joka johtaa
     * peliLoppui muuttujan arvon vaihtumiseen arvoon true. Kun arvo on true while loop loppuu.
     */
    public static void main(String args[]) {
        Peli peli = new Peli();
        //Pelaa yhden erän
        peli.voitonTarkistus();
        peli.pelaaErä();

        //Pelaa peliä kunnes peliLoppui muuttuu, eli jompikumpi pelaaja on voittanut 3 kertaa
        while (peli.peliLoppui != true) {
            peli.voitonTarkistus();
            if(peli.peliLoppui != true) {
                peli.pelaaErä();
            }

        }
    }
}
