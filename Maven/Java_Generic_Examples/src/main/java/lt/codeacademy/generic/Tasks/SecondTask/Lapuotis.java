package lt.codeacademy.generic.Tasks.SecondTask;

public class Lapuotis implements Medis{

    private final TreeType treeType;

    public Lapuotis(TreeType treeType) {
        this.treeType = treeType;
    }

    @Override
    public void turi() {
        System.out.printf("%s turi lapus.\n", treeType.getName());
    }
}
