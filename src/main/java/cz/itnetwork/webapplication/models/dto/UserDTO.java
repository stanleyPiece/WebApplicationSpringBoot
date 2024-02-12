package cz.itnetwork.webapplication.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

    @Email(message = "Vyplňte validní e-mail") //anota @Email označuje formát e-mailu
    @NotBlank(message = "Vyplňte uživatelský e-mail") //nesmí být prázdné
    private String email;

    @NotBlank(message = "Vyplňte uživatelské heslo")
    private String password;

    @NotBlank(message = "Vyplňte uživatelské heslo")
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
