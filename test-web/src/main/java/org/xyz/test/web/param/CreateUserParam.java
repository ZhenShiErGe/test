package org.xyz.test.web.param;

/**
 * Created by yizhenn on 16-12-17.
 */
public class CreateUserParam extends BaseParam{
    private String account;
    private String password;
    private int role;
    private String username;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CreateUserParam{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", username='" + username + '\'' +
                '}';
    }
}
