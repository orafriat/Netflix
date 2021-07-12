import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello welcome to netflix menu");
        System.out.println("To signup press 1");
        System.out.println("To login press 2");
        int option = scanner.nextInt();
        if (option == 1) {
            System.out.println("Enter a username\n at least 6 letters");
            String username = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Enter a password\n at least 1 english letter and 1 digit");
            String password = scanner.nextLine();
            scanner.nextLine();
            Account account = new Account(username, password,new Date(),new Date());
            List<Account> accounts = new LinkedList<>();
            accounts.add(account);
            Authentication authentication = new Authentication(accounts);
            try {
                authentication.signUp(scanner.nextLine(),scanner.nextLine());
            } catch (Exception e) {
                System.out.println("plz try again");
            }








        }




    }

    public void firstMenu () {
        int option = 0;
        switch (option) {
            case 1:
                System.out.println("Sing up for new account");

                break;
            case 2:
                System.out.println("Enter a username");

                System.out.println("Enter a password");

        }

    }

}
