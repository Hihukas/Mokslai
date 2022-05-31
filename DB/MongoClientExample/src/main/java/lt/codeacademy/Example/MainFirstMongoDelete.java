package lt.codeacademy.Example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lt.codeacademy.Client.MongoClientProvider;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MainFirstMongoDelete {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("FirstTaskDB");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Exams");

        // Delete by id
//        collection.deleteOne(new Document("_id", new ObjectId("629640dd1b44073bbfb5891d")));

        collection.deleteOne(Filters.and(Filters.eq("name", "Aleksandras"), Filters.eq("surname", "Dudenas")));
        FindIterable<Document> documents = collection.find();

        for(Document exam: documents){
            System.out.println(exam);
        }
    }
}
