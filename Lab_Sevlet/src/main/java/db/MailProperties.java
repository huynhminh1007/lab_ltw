package db;

import java.io.IOException;
import java.util.Properties;

public class MailProperties {

    public static Properties prop;

    public static String host;
    public static String port;
    public static boolean auth;
    public static boolean ssl;
    public static String username;
    public static String password;

    static {
        prop = new Properties();
        try {
            prop.load(MailProperties.class.getClassLoader().getResourceAsStream("mail.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        host = prop.getProperty("mail.smtp.host");
        port = prop.getProperty("mail.smtp.port");
        auth = "true".equals(prop.getProperty("mail.smtp.auth"));
        ssl = "true".equals(prop.getProperty("mail.smtp.starttls.enable"));
        username = prop.getProperty("mail.user");
        password = prop.getProperty("mail.pass");
    }
}
