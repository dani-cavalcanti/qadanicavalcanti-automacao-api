package domain;

public class LoginAuth {

    private Object username;
    private Object password;

    public LoginAuth(Object username, Object password) {
        this.username = username;
        this.password = password;
    }

    public LoginAuth(){
        username = "";
        password = "";
    }

    public Object getUsername() {
        return username;
    }

    public void setUsername(Object username) {
        this.username = username;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

}
