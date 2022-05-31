package lt.codeacademy.Example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lt.codeacademy.Client.MongoClientProvider;
import org.bson.Document;

import java.util.List;

public class MainFirstMongoInsert {
    public static void main(String[] args) {
        MongoClient client = MongoClientProvider.getMongoClient();
        MongoDatabase mongoDatabase = client.getDatabase("FirstTaskDB");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Exams");


        Document document = new Document("name", "TestUser")
                .append("surname", "SimpleUser")
                .append("pazymys", "10");

        collection.insertOne(document); //insert only one
//        collection.insertMany(List.of(new Document(), new Document())); insert collection of documents
    }
}
