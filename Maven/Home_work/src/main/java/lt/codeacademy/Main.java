package lt.codeacademy;

import lt.codeacademy.Files.ReaderWriter;
import lt.codeacademy.Windows.*;

public class Main {


    public static void main(String[] args) throws Exception {
//        FrameFactory frameFactory = new FrameFactory(createTestState());
        //       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        MainModel mainModel = new MainModel();

        ReaderWriter readerWriter = new ReaderWriter(mainModel);
        readerWriter.fileReader();

        MainWindow mainWindow = new MainWindow(mainModel);
        mainWindow.window();

    }
}
