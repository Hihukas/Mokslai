package lt.codeacademy;

import lt.codeacademy.Service.UserService;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserService();
//        userService.createUser();
        userService.showAllUsers();
//        userService.showUsersEmails();
        userService.showUsers(5L);
    }
}
