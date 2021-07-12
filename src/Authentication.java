import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Authentication {
    private List<Account> accounts;

    public Authentication(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean signIn(String username, String password) {
        return accounts.stream().anyMatch(account -> {
            return account.getUsername().equals(username) && account.getPassword().equals(password);
        });
    }

    public void signUp(String username, String password) throws Exception {
        validateUsername(username);
        validatePassword(password);
        Date expirationDate;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        expirationDate = cal.getTime();

        accounts.add(new Account(username, password, new Date(), expirationDate));
    }

    private void validateUsername(String username) throws Exception {
        boolean isSuchUsernameExist = accounts.stream().anyMatch(account -> account.getUsername().equals(username));
        if (isSuchUsernameExist) {
            throw new Exception("This username already exists. Please choose a different username");
        }
    }

    private void validatePassword(String password) throws Exception {
        if (password.length() < 6) {
            throw new Exception("Password must have at least 6 characters");
        }
        if (!password.matches("[a-zA-Z]+")) {
            throw new Exception("Password must have at least 1 english letter");
        }
        if (!password.matches("[0-9]+")) {
            throw new Exception("Password must have at least 1 digit");
        }
    }
}
