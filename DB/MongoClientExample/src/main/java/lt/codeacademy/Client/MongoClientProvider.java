package lt.codeacademy.Client;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class MongoClientProvider {
    public static MongoClient getMongoClient(){
        return new MongoClient();
    }

    public static com.mongodb.client.MongoClient getObjectMongoClient(){
        //1. uzregistruoti provider codec
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());

        // 2. uzregistruoti pojo provaideri i registries
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        //3. codec regusttry idedame i settings
        MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(codecRegistry).build();

        return MongoClients.create(settings);
    }
}
