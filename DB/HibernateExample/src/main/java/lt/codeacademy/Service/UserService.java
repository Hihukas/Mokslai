package lt.codeacademy.Service;

import lt.codeacademy.Entity.User;
import lt.codeacademy.Repository.UserRepository;

public class UserService {
    private final UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public void createUser() {
        User user = new User(null, "Aleksandras", "Dudėnas", "aleks.dudenas@gmail.com");
        repository.createUser(user);
    }

    public void showAllUsers(){
        repository.getUsers().forEach(System.out::println);
    }
}
