package ejb;

import javax.ejb.Remote;

@Remote
public interface UserBeanRemote {

    boolean login(String username, String password);
    boolean logout();
    String getName();
    String getEmail();
    boolean register(String username, String password, String email, String name, String phone);


}
