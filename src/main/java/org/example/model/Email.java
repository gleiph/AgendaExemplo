package org.example.model;

import org.example.exception.EmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private String email;
    private String login;
    private String dominio;

    private static final String emailRegex =
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern pattern = Pattern.compile(emailRegex);

    public Email(String email) throws EmailException {
        setEmail(email);
    }

    private boolean isValidEmail(String email) {

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailException {
        if(! isValidEmail(email))
            throw new EmailException();

        this.email = email;
        String[] partes = email.split("@");

        this.login = partes[0];
        this.dominio = partes[1];
    }

    public String getLogin() {
        return login;
    }

    public String getDominio() {
        return dominio;
    }

}
