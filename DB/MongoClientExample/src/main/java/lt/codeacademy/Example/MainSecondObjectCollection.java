package lt.codeacademy.Example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.Client.MongoClientProvider;
import lt.codeacademy.Data.Exams;

public class MainSecondObjectCollection {
    public static void main(String[] args) {
        MongoClient objectMongoClient = MongoClientProvider.getObjectMongoClient();
        MongoDatabase mongoDatabase = objectMongoClient.getDatabase("FirstTaskDB");
        MongoCollection<Exams> collection = mongoDatabase.getCollection("Exams", Exams.class);

        FindIterable<Exams> exams = collection.find();
        for(Exams exam: exams){
            System.out.println(exam);
        }
    }
}

