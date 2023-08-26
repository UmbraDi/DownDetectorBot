package tutorial;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class checkSite {
    public static String check(String str) {
        try {
            if (InetAddress.getByName(str).isReachable(5000)) {
                System.out.println("Сайт доступен!");
                return "Сайт доступен!";
            } else {
                System.out.println("Сайт недоступен!");
                return "Сайт недоступен!";
            }
        } catch (UnknownHostException e) {
            System.out.println("Сайт не найден!");
            return "Сайт не найден!";
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
