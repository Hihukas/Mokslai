package lt.codeacademy.Client;

import com.mongodb.MongoClient;

public class MongoClientProvider {
    public static MongoClient getMongoClient(){
        return new MongoClient();
    }
}
