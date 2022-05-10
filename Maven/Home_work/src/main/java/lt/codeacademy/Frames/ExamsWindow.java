package lt.codeacademy.Frames;

import lt.codeacademy.Exams.Exam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ExamsWindow extends AbstractWindow {



    @Override
    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("lt.codeacademy.Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });


        System.out.println("Pasirinkite egzaminą:");

//        IntStream.range(0, exams.size())
//                .mapToObj(i -> {
//                    Exam e = exams.get(i);
//                    return (i + 1) + ". Egzamino ID: " + e.getId() +
//                            ", Egzamino pavadinimas: " + e.getName() +
//                            ", Egzamino tipas: " + e.getExamType() +
//                            ", ar galima laikyti: " + canTakeExam(e);
//                })
//                .forEach(System.out::println);

        //       try {
        Exam exam = exams.get(scanner.nextInt() - 1);
//        } catch (InputMismatchException e) {
//            System.out.println("Tokio veiksmo nėra. Pasirinkite iš naujo.");
//            ExamsFrame examsFrame = new ExamsFrame(getState());
//            examsFrame.print();
//        }

//        QuestionsFrame frame = new QuestionsFrame(getState(), exam);
//        frame.window();

    }

//    private boolean canTakeExam(Exam exam) {
////        return !getState().getAnswer().stream()
////                //TODO add check that time has passed 48 hours
////                .anyMatch(examAnswers -> examAnswers.getExam().getId().equals(exam.getId()));
//    }
}

