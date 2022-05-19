package lt.codeacademy.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Utility;

import java.io.File;


public class ReaderWriter {
    private final Utility utility;

    public ReaderWriter(Utility utility) {
        this.utility = utility;
    }

    public void fileReader() throws Exception {
        utility.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        File studentsAnswersFile = new File("StudentsAnswers.json");
        utility.setStudentsAnswersList(utility.getObjectMapper().readValue(studentsAnswersFile, new TypeReference<>() {
        }));

        File usersListFile = new File("Users.json");
        utility.setUsersList(utility.getObjectMapper().readValue(usersListFile, new TypeReference<>() {}));

        File examsFile = new File("Exams.json");
        utility.setExamsList(utility.getObjectMapper().readValue(examsFile, new TypeReference<>() {}));



    }
    public void fileWriter () throws Exception {
        utility.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        File studentsAnswersFile = new File("StudentsAnswers.json");
        utility.getObjectMapper().writeValue(studentsAnswersFile, utility.getStudentsAnswersList());

        File usersListFile = new File("Users.json");
        utility.getObjectMapper().writeValue(usersListFile, utility.getUsersList());

        File examsFile = new File("Exams.json");
        utility.getObjectMapper().writeValue(examsFile, utility.getExamsList());


    }
}
