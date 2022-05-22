package lt.codeacademy.Windows;

import lt.codeacademy.Answers.StudentsAnswers;
import lt.codeacademy.MainModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith({MockitoExtension.class})
class OneStudentExamsResultsWindowTest {

    @InjectMocks
    private  OneStudentExamsResultsWindow oneStudentExamsResultsWindow;

    @Mock
    private MainModel mainModel;

    @Test
    void testFillOneStudentsAnswersListWhenStudentsAnswersListIsEmpty() {
        List<StudentsAnswers> filledOneStudentsAnswersList = new ArrayList<>();

        for (StudentsAnswers a : mainModel.getStudentsAnswersList()) {
            if (a.getUser().getId().equals(mainModel.getUser().getId())) {
                filledOneStudentsAnswersList.add(a);
            }
        }

        Assertions.assertEquals(0, filledOneStudentsAnswersList.size());
    }

//    @Test
//    void testFillOneStudentsAnswersListWhenStudentsAnswersListHasOtherStudentsAnswers() {
//        List<StudentsAnswers> filledOneStudentsAnswersList = new ArrayList<>();
//        Mockito.when(mainModel.getStudentsAnswersList().size()).thenReturn(1);
//        Assertions.assertEquals(1, filledOneStudentsAnswersList.size());
//    }
}
