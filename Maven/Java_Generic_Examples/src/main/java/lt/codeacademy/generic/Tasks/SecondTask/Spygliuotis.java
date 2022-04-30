package lt.codeacademy.generic.Tasks.SecondTask;

public class Spygliuotis implements Medis{
    private final TreeType treeType;

    public Spygliuotis(TreeType treeType) {
        this.treeType = treeType;
    }


    @Override
    public void turi() {
        System.out.printf("%s turi spyglius\n", treeType.getName());
    }
}
