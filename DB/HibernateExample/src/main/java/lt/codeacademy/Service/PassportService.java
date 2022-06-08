package lt.codeacademy.Service;

import lt.codeacademy.Repository.PassportRepository;

public class PassportService {
    private final PassportRepository repository;

    public PassportService() {
        repository = new PassportRepository();
    }

    public void showAllPassports(){
        repository.getPassport().forEach(System.out::println);
    }
}
