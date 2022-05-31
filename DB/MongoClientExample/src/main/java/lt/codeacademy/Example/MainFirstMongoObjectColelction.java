package lt.codeacademy.Example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.Client.MongoClientProvider;
import lt.codeacademy.Data.Exams;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MainFirstMongoObjectColelction {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("FirstTaskDB");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Exams");

        List<Exams> examsList = new ArrayList<>();
        FindIterable<Document> documents = collection.find();
        for(Document document: documents) {
            examsList.add(new Exams(document.getObjectId("id").toString(), document.getString("name"), document.getString("surname"), document.getInteger("pazymys")));
        }

        examsList.forEach(System.out::println);
    }

}
