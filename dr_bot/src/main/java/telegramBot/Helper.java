package telegramBot;

public class Helper {
    // Verification
    public synchronized Boolean verify(String name) {
        return (name.equalsIgnoreCase("фамилия имя") ||
                name.equalsIgnoreCase("имя фамилия") ||
                name.equalsIgnoreCase("last-name first-name") ||
                name.equalsIgnoreCase("first-name last-name"));
    }
}
