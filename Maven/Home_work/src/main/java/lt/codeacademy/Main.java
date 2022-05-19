package lt.codeacademy;

import lt.codeacademy.Windows.*;

public class Main {
    private final Utility utility;

    public Main(Utility utility) {
        this.utility = utility;
    }

    public static void main(String[] args) throws Exception {
//        FrameFactory frameFactory = new FrameFactory(createTestState());
        //       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();


        MainWindow mainWindow = new MainWindow(new Utility());
        mainWindow.window();

    }
}
