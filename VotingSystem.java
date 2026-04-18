import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class DuplicateUserException extends Exception {
    public DuplicateUserException(String message) {
        super(message);
    }
}

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class User {
    private String name;
    private String password;
    private String phone;
    private String branch;

    public User(String name, String password, String phone, String branch) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getBranch() {
        return branch;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', phone='" + phone + "', branch='" + branch + "'}";
    }
}

public class VotingSystem {
    private Set<User> users = new HashSet<>();
    private Set<String> passwords = new HashSet<>();

    public void addUser(User user) throws DuplicateUserException {
        if (users.contains(user)) {
            throw new DuplicateUserException("User data cannot be the same. User '" + user.getName() + "' already exists.");
        }
        if (passwords.contains(user.getPassword())) {
            throw new DuplicateUserException("Password already taken. Please choose a different password.");
        }
        users.add(user);
        passwords.add(user.getPassword());
        System.out.println("User '" + user.getName() + "' added successfully.");
    }

    public void validatePhoneNumber(String phone) throws InvalidPhoneNumberException {
        if (phone.length() > 10) {
            throw new InvalidPhoneNumberException("Phone number cannot be more than 10 digits. Entered: " + phone.length() + " digits.");
        }
        System.out.println("Phone number '" + phone + "' is valid.");
    }

    public void processVoting() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of users (minimum 2): ");
            int numUsers = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (numUsers < 2) {
                System.out.println("Minimum 2 users required.");
                return;
            }

            for (int i = 0; i < numUsers; i++) {
                System.out.println("Enter details for user " + (i + 1) + ":");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                System.out.print("Phone number: ");
                String phone = scanner.nextLine();
                validatePhoneNumber(phone);
                System.out.print("Branch: ");
                String branch = scanner.nextLine();

                User user = new User(name, password, phone, branch);
                addUser(user);
            }

        } catch (DuplicateUserException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Voting process completed. Total users: " + users.size());
        }

        // Display all user data
        System.out.println("\nUser Details:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.processVoting();
    }
}