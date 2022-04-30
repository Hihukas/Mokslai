package lt.codeacademy.generic.Tasks.SecondTask;

import java.util.List;

public class TreeMain {
    public static void main(String[] args) {
        TreeMain main = new TreeMain();
        List<Medis> medis = List.of(new Berzas(), new Pusis());
        List<Lapuotis> lapuociai = List.of(new Berzas(), new Azuolas());
        main.ivairusMiskas(lapuociai);
        main.ivairusMiskas(medis);

        List<Spygliuotis> spygliuociai = List.of(new Pusis(), new Kadagys(), new Egle());
        main.spygliuciuMiskas(spygliuociai);

        List<Berzas> berzai = List.of(new Berzas());
        main.berzuMiskas(berzai);
    }

    private void ivairusMiskas(List<? extends Medis> trees){
        System.out.println("Įvairus miškas.");
        trees.forEach(Medis::turi);
    }

    private <T extends Spygliuotis> void spygliuciuMiskas(List<T> trees){
        System.out.println("Spygliuočių miškas.");
        trees.forEach(Spygliuotis::turi);
    }

    private void berzuMiskas(List<Berzas> trees){
        System.out.println("Beržų miškas.");
        trees.forEach(Berzas::turi);
    }
}
