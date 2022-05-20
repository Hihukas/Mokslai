package lt.codeacademy.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Utility;

import java.io.File;


public class ReaderWriter {
    private final Utility utility;
    private final File studentsAnswersFile = new File("src/main/java/lt/codeacademy/Files/StudentsAnswers/StudentsAnswers.json");
    private final File usersListFile = new File("src/main/java/lt/codeacademy/Files/Users/Users.json");
    private final File examsFile = new File("src/main/java/lt/codeacademy/Files/Exams/Exams.json");


    public ReaderWriter(Utility utility) {
        this.utility = utility;
    }

    public void fileReader() {
        utility.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            utility.setStudentsAnswersList(utility.getObjectMapper().readValue(studentsAnswersFile, new TypeReference<>() {
            }));

            utility.setUsersList(utility.getObjectMapper().readValue(usersListFile, new TypeReference<>() {
            }));

            utility.setExamsList(utility.getObjectMapper().readValue(examsFile, new TypeReference<>() {
            }));
        } catch (Exception e) {
        }
    }

    public void fileWriter() {
        utility.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            utility.getObjectMapper().writeValue(studentsAnswersFile, utility.getStudentsAnswersList());

            utility.getObjectMapper().writeValue(usersListFile, utility.getUsersList());

            utility.getObjectMapper().writeValue(examsFile, utility.getExamsList());
        } catch (Exception e) {
        }
    }
}
