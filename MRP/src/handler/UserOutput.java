package handler;

import model.User;

public class UserOutput {
    public void succesfulRegistration(boolean login) {
        if(login) {
            System.out.println("Registration successful");
        }else{
            System.out.println("Registration failed");
        }
    }

    public void loginCriteria() {
        System.out.println("Your username and password must not be blank!");
    }

    public void output(User user) {
        System.out.println(user.getUsername());
        System.out.println("\n ... und zukünftig andere Infos.");
    }
}
