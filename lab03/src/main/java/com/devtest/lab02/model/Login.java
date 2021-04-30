package com.devtest.lab02.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "login")
public class Login {
    private  @Id String login_windows;
    private  String mp_mobile_app;
    public Login() {
    }
    public Login( String login_windows, 
                 String mp_mobile_app) {
        this.login_windows = login_windows;
        this.mp_mobile_app = mp_mobile_app;
    }
 
    public String getlogin_windows() {
        return login_windows;
    }
    public void setlogin_windows(String login_windows) {
        this.login_windows = login_windows;
    }
    public String getmp_mobile_app() {
        return mp_mobile_app;
    }
    public void setmp_mobile_app(String mp_mobile_app) {
        this.mp_mobile_app = mp_mobile_app;
    }
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Login)) return false;
        Login login = (Login) o;
        return Objects.equals(login_windows, login.login_windows) &&
                Objects.equals(mp_mobile_app, login.mp_mobile_app);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(login_windows, mp_mobile_app);
    }
    
    @Override
    public String toString() {
        return "Login{" +
                ", login_windows='" + login_windows + '\'' +
                ", mp_mobile_app='" + mp_mobile_app + '\'' +
                '}';
    }
}
   
   