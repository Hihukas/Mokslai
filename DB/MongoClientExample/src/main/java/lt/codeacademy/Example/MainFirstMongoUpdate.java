package lt.codeacademy.Example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lt.codeacademy.Client.MongoClientProvider;
import org.bson.Document;

public class MainFirstMongoUpdate {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("FirstTaskDB");
        MongoCollection<Document> collection = mongoDatabase.getCollection("Exams");

        MainFirstMongoUpdate mainFirstMongoUpdate = new MainFirstMongoUpdate();
        mainFirstMongoUpdate.printCollection(collection);

//        collection.updateOne(Filters.eq("name", "TestUser"), Updates.set("name", "vardenis6"));
//        collection.updateOne(Filters.and(Filters.eq("name", "vardenis6"), Filters.eq("surname", "SimpleUser")),
//                Updates.set("surname", "pavardenis6"));
        collection.updateOne(Filters.and(Filters.eq("name", "vardenis6"), Filters.eq("surname", "pavardenis6")),
                Updates.combine(Updates.set("name", "Aleksandras"), Updates.set("surname", "Dudenas")));
        mainFirstMongoUpdate.printCollection(collection);

    }

    private void printCollection(MongoCollection<Document> collection) {
        FindIterable<Document> documents = collection.find();
        for(Document exam: documents){
            System.out.println(exam);
        }
    }
}
