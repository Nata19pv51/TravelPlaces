package org.mycompany.myname.model.entity;

import javax.jws.soap.SOAPBinding;

public class User {
    final public static String USER_TABLE = "user";
    final public static String ID_USER = "id_user";
    final public static String LOGIN = "login";
    final public static String PASSWORD = "password";
    final public static String EMAIL = "email";
    final public static String COUNTRY = "country";

    private int idUser;
    private String login;
    private String password;
    private String email;
    private String country;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Login: " + login + "\n" + "E-mail: " + email + "\n" +
                "Country: " + country;
    }

    public static final class UserBuilder implements IBuilder<User> {
        private int idUser;
        private String login;
        private String password;
        private String email;
        private String country;

        public UserBuilder setIdUser(int idUser){
            this.idUser = idUser;
            return this;
        }

        public UserBuilder setLogin(String login){
            this.login = login;
            return this;
        }

        public UserBuilder setPassword(String password){
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public UserBuilder setCountry(String country){
            this.country = country;
            return this;
        }

        @Override
        public User build() {
            User user = new User();
            user.setIdUser(idUser);
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setCountry(country);
            return user;
        }
    }
}
