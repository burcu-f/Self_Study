package part1;

public class WelcomeMessage2 {
    public static void main(String[] args) {
        String[] messages = {
                "Welcome to Java",
                "Welcome to Computer Science",
                "Programming is fun"
        };

        /*for (String message : messages) {
            System.out.println(message);
        }*/

        for (int i = 0; i < messages.length; i++) {
            System.out.println(messages[i]);
        }

    }
}
