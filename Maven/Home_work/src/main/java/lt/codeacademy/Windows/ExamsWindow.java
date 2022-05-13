package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.Exams.Exam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.codeacademy.Users.User;
import lt.codeacademy.Users.UserType;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExamsWindow extends AbstractWindow {
    private User user;
    private Enum<UserType> userType;

    public ExamsWindow(Enum<UserType> userType, User user) {
        this.userType = userType;
        this.user = user;
    }

    @Override
    public void window() throws Exception {
        Scanner scanner = new Scanner(System.in);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("Exams.json");
        List<Exam> exams = objectMapper.readValue(file, new TypeReference<>() {
        });


        System.out.println("Egzaminų sąrašas:");

        canTakeExam(user, UserType.STUDENT);

        IntStream.range(0, exams.size())
                .mapToObj(i -> {
                    Exam e = exams.get(i);
                    return "[" + (i + 1) + "] Egzamino ID: " + e.getId() +
                            ", Egzamino pavadinimas: " + e.getName() +
                            ", Egzamino tipas: " + e.getExamType();
                })
                .forEach(System.out::println);

        System.out.println("\nPasirinkite egzaminą:");

        try {
            Exam exam = exams.get(scanner.nextInt() - 1);
            if (userType.equals(UserType.STUDENT)) {
                QuestionsWindow questionsWindow = new QuestionsWindow(exam, userType, user);
                questionsWindow.window();
            } else {
                System.out.println("Dėstytojo langas");
            }
        } catch (InputMismatchException e) {
            System.out.println("Galimi tik skaičiai.\n");
            window();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Tokio egzamino nėra! Rinkites dar kartą.\n");
            window();
        }
    }

    //    private boolean canTakeExam(Exam exam) {
//        return !getState().getAnswer().stream()
//                //TODO add check that time has passed 48 hours
//                .anyMatch(examAnswers -> examAnswers.getExam().getId().equals(exam.getId()));
//    }
    private void canTakeExam(User user, UserType userType) throws Exception {
        OneStudentExamsResultsWindow oneStudentExamsResultsWindow = new OneStudentExamsResultsWindow(userType, user);
        List<StudentsAnswers> oneStudentsAnswerList = oneStudentExamsResultsWindow.fillOneStudentsAnswersList();

        List<LocalDateTime> examsTimesLessThan48Hours = oneStudentsAnswerList
                .stream()
                .map(exam -> LocalDateTime.parse(exam.getTime()))
                .filter(examTimes -> {
                    LocalDateTime to = LocalDateTime.now();
                    Duration duration = Duration.between(examTimes, to);
                    String time;
                    if (duration.toHours() < 48) {
                        time = examTimes.toString();
                    } else {
                        time = null;
                    }
                    return time != null;
                }).toList();

//        List<String> newList = oneStudentsAnswerList.stream().map(studentsAnswers -> {
//            StudentsAnswers e = studentsAnswers;
//            return e.getExam().getId() + e.getTime();
//        }).toList();
//
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < newList.size(); i++) {
//            if (newList.stream().map(t -> newList.)
//                    .equals(examsTimesLessThan48Hours.get(i))) {
//                result.add(i);
//            }
//        }
//
//        result.forEach(System.out::println);

//                .stream()
//                .filter(exists -> {
//                    List<UUID> idList = new ArrayList<>();
//                    if(oneStudentsAnswerList.stream().map(h -> LocalDateTime.parse(h.getTime()))
//                            .anyMatch(v -> v.equals(exists))){
//                       idList.add(IntStream.range(0, oneStudentsAnswerList.size())
//                                       .mapToObj(i -> {
//                                           StudentsAnswers e = oneStudentsAnswerList.get(i);
//                                           return e.getExam().getId();
//                                       }).findAny().orElse(null));
////                               oneStudentsAnswerList.stream().map(id -> id.getExam().getId()).findAny().orElse(null));
//                    } else{
//                        idList = null;
//                    }
//                    return idList != null;
//                })
//                .collect(Collectors.toList());
    }
}

