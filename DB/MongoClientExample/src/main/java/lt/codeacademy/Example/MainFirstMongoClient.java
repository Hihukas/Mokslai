package lt.codeacademy.Example;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class MainFirstMongoClient {
    public static void main(String[] args) {

        //1. Create MongoDB client
        MongoClient mongoClient = new MongoClient();
        //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));


        //2. Connect/switch to MongoDB
        MongoDatabase mongoDatabase = mongoClient.getDatabase("FirstTaskDB");

        MongoIterable<String> collectionNames = mongoDatabase.listCollectionNames();

        for(String name: collectionNames){
            System.out.println(name);
        }

        System.out.println(mongoDatabase.getName());

       ListCollectionsIterable<Document> collections = mongoDatabase.listCollections();
       for(Document document: collections){
           System.out.println(document);
           System.out.println(document.get("name"));
       }
    }
}
