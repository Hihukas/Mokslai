package lt.codeacademy.json.example;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MainDeserializable {
    public static void main(String[] args) {
        try(ObjectInputStream ob = new ObjectInputStream((new FileInputStream("box.txt")))){
        while(true) {
           if(ob.readObject() instanceof Box box){
               System.out.println(box);
           }

        }
        }catch(EOFException e){
            System.out.println("Failas nuskaitytas");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
