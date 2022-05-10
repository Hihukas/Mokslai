package lt.codeacademy.Windows;

public class RegistrationFrame  {
//
//    public RegistrationFrame(State state) {
//        super(state);
//    }
//
//    public void window() throws Exception {
//        Scanner scanner = new Scanner(System.in);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        File file = new File("lt.codeacademy.Users.json");
//
//        List<User> usersList = objectMapper.readValue(file, new TypeReference<>() {
//        });
//
//        RegistrationFrame registrationFrame = new RegistrationFrame(getState());
//
//        String userName = registrationFrame.usernameCheck(scanner, file, objectMapper, usersList);
//        System.out.println("Sukurkite slaptažodį:");
//        String password = scanner.nextLine();
//        if (!passwordCheck(scanner, password)) {
//            System.out.println("Paskyros sukurti nepavyko.");
//            return;
//        }
//        System.out.println("Įveskite savo vardą:");
//        String name = scanner.nextLine();
//        System.out.println("Įveskite savo pavardę:");
//        String surname = scanner.nextLine();
//
//        usersList.add(new User()
//                .setId(UUID.randomUUID())
//                .setUserType(UserType.STUDENT)
//                .setUsername(userName)
//                .setPassword(password)
//                .setName(name)
//                .setSurname(surname));
//        objectMapper.writeValue(file, usersList);
//
//        switch (UserType.STUDENT) {
//            case STUDENT -> {
//                System.out.println("Sveikiname prisijungus!");
//                StudentFrame frame = new StudentFrame(getState());
//                frame.window();
//            }
//            default -> {
//                System.out.println("Prisiregistruoti nepavyko. Bandykite dar kartą.");
//                RegistrationFrame frame = new RegistrationFrame(getState());
//                frame.window();
//            }
//        }
//    }
//
//    private String usernameCheck(Scanner scanner, File file, ObjectMapper objectMapper, List<User> usersList) throws IOException {
//        while (true) {
//            System.out.println("Sukurkite vartotojo vardą:");
//            String userName = scanner.nextLine();
//
//            boolean userNameAlreadyExists = usersList.stream()
//                    .anyMatch(u -> u.getUsername().equals(userName));
//
//            if (userNameAlreadyExists) {
//                System.out.println("Toks vartotojo vardas jau egzistuoja.");
//                continue;
//            }
//            return userName;
//        }
//    }
//
//    private boolean passwordCheck(Scanner scanner, String password) {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Pakartokite slaptažodžio įvedimą:");
//            String repeatPassword = scanner.nextLine();
//            if (!repeatPassword.equals(password)) {
//                System.out.println("Slaptažodžiai nesutampa.");
//                continue;
//            }
//            return true;
//        }
//        return false;
//    }
}

