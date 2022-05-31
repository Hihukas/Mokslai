package lt.codeacademy.Example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lt.codeacademy.Client.MongoClientProvider;
import org.bson.Document;

import java.util.Iterator;

public class MainFirstMongoCollection {
    public static void main(String[] args) {

        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("FirstTaskDB");

        MongoCollection<Document> collection = mongoDatabase.getCollection("Exams");

        FindIterable<Document> exams = collection.find();
//        FindIterable<Document> exams = collection.find(Filters.gte("pazymys", "7"));
        for(Document exam: exams){
            System.out.println(exam);
            System.out.printf("%s %s %s\n", exam.get("name"), exam.get("surname"), exam.get("pazymys"));
        }

//        Iterator<Document> iterator = collection.find().iterator();
//        while (iterator.hasNext()) {
//            Document exam = iterator.next();
//            System.out.println(exam);
//            System.out.printf("%s %s %s\n", exam.get("name"), exam.get("surname"), exam.get("pazymys"));
//        }

    }
}
