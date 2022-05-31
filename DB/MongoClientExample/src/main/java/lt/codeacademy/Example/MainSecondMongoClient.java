package lt.codeacademy.Example;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lt.codeacademy.Client.MongoClientProvider;
import lt.codeacademy.Data.Exams;

public class MainSecondMongoClient {
    public static void main(String[] args) {
        MongoClient objectMongoClient = MongoClientProvider.getObjectMongoClient();
        MongoDatabase secondDB = objectMongoClient.getDatabase("SecondDB");
        MongoCollection<Exams> collection = secondDB.getCollection("exams", Exams.class);

        MainSecondMongoClient mainSecondMongoClient = new MainSecondMongoClient();
        FindIterable<Exams> exams = collection.find();

        mainSecondMongoClient.printExams(exams);

        exams = collection.find(Filters.eq("name", "Aleksandras"));

        mainSecondMongoClient.printExams(exams);

        exams = collection.find().sort(new BasicDBObject("name", 1));

        mainSecondMongoClient.printExams(exams);

        exams = collection.find(Filters.not(Filters.eq("name", "Aleksandras")));

        mainSecondMongoClient.printExams(exams);


    }

    private void printExams(FindIterable<Exams> exams){
        for(Exams exam: exams){
            System.out.println(exam);
        }

        System.out.println("------------------------------------------------");
    }
}
