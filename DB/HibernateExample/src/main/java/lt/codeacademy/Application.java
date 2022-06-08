package lt.codeacademy;

import lt.codeacademy.Service.PassportService;
import lt.codeacademy.Service.UserService;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserService();
        PassportService passportService = new PassportService();
        userService.createUser();

        passportService.showAllPassports();
//        userService.showAllUsers();
////        userService.showUsersEmails();
////        userService.showUsers(5L);
////        userService.updateUser();
////        userService.updateUserEmailById();
////        userService.deleteUser();
////        userService.deleteUserById(4L);
//        userService.deleteUserByEmail("p.petraitis@gmail.com");
    }
}
