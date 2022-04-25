package lt.codeacademy.json.example.SecondTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Main main = new Main();
        File file = new File("imoniu_sarasas.json");
        if(!file.exists()){
            file.createNewFile();
        }

        List<Company> companies = main.generateCompanies();
        objectMapper.writeValue(file, companies);
    }

    private List<Company> generateCompanies(){
        Faker faker = new Faker();
        List<Company> companies = new ArrayList<>();
        for(int i=0; i<100; i++){
            companies.add(new Company(faker.company().name(), faker.code().isbn10(), faker.number().numberBetween(10, 500), (double)faker.number().numberBetween(1500, 10500)));
        }
    return companies;
    }
}
