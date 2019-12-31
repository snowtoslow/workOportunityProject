package snowtoslow.work.workProject.utils;

public abstract class Regex {


    protected final String userPasswordRegex = "^(?=.*[0-9])(?=.*[a-z]).{5,}";

    protected final String userEmailRegex = "^(?=.*[a-z])(.+)@(.+)$";

    protected final String userInfoRegex = "^(?!^.*[A-Z]{2,}.*$)^[A-Za-z]*$";


}
