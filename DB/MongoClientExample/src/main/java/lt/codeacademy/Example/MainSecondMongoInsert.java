package lt.codeacademy.Example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.Client.MongoClientProvider;
import lt.codeacademy.Data.Exams;

import java.util.List;

public class MainSecondMongoInsert {
    public static void main(String[] args) {

        MongoClient objectMongoClient = MongoClientProvider.getObjectMongoClient();
        MongoDatabase secondDB = objectMongoClient.getDatabase("SecondDB");

        MongoCollection<Exams> collection = secondDB.getCollection("exams", Exams.class);

        collection.insertMany(List.of(new Exams(null, "Aleksandras", "Dudenas"),
                (new Exams(null, "Aleksandras", "Dudenas")),
        (new Exams(null, "Alek","Dunas")),
        (new Exams(null, "Aleksadas", "Dudns")),
        (new Exams(null, "Alesandrs", "Dudeas"))));

        FindIterable<Exams> exams = collection.find();

        for(Exams exam: exams){
            System.out.println(exam);
        }

    }
}

