package lt.codeacademy.Service;

import lt.codeacademy.Data.Gender;
import lt.codeacademy.Entity.Passport;
import lt.codeacademy.Entity.User;
import lt.codeacademy.Repository.UserRepository;

public class UserService {
    private final UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public void createUser() {
        Passport passport = new Passport(null, "5644465", "LTU", Gender.MALE);
        User user = new User(null, "Aleksandras", "Dudėnas", "aleks.dudenas@gmail.com", passport);
        passport.setUser(user);
        repository.createUser(user);
    }

    public void showAllUsers() {
        repository.getUsers().forEach(System.out::println);
    }

    public void showUsersEmails() {
        repository.getUsersEmails().forEach(System.out::println);
    }

    public void showUsers(Long id){
        System.out.println(repository.getUserById(id));
    }

    public void updateUser(){
        User user = repository.getUserById(3L);

        if(user == null){
            return;
        }

        user.setName("Petras");
        user.setSurname("Petraitis");
        user.setEmail("p.petraitis@gmail.com");

        repository.updateUser(user);
    }

    public void updateUserEmailById(){
        repository.updateEmailById("jonas.jonaitis@gmail.com", 4L);
    }

    public void deleteUser(){
        User user = repository.getUsers().get(0);
        repository.deleteUser(user);
    }

    public void deleteUserById(Long id){
        User user = new User();
        user.setId(id);
        repository.deleteUser(user);
    }

    public void deleteUserByEmail(String email){
        repository.deleteUserByEmail(email);
    }
}
