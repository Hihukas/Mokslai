package lt.codeacademy.json.example.SecondTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pagrindinis {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("companies_list.json");
        if(!file.exists()){
            file.createNewFile();
        }

        Pagrindinis pagrindinis = new Pagrindinis();
        //List<Imone> companies = pagrindinis.companiesList();
        mapper.writeValue(file, pagrindinis.companiesList());


    }
    private List<Imone> companiesList(){
        Faker faker = new Faker();
        List<Imone> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Imone(faker.company().name(), faker.code().isbn10(), faker.random().nextInt(1, 100), faker.random().nextDouble()));
        }
        return list;
    }
}

