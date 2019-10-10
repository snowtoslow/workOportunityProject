package snowtoslow.work.workProject.Helper;

import java.util.Date;
import java.util.UUID;

public class Helpers {
    public static String timeHelper() {
        Date date = new Date();
        return date.toString();
    }
    public static String idHelper() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public interface commonVariables{
        String principalId = idHelper();//universal ID and principal in comment

        String userId = idHelper();//for post



    }
}
