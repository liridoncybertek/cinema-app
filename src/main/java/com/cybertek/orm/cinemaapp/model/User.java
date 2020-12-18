package com.cybertek.orm.cinemaapp.model;

import com.cybertek.orm.cinemaapp.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_account")
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class User extends Model<Integer> {

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 6, message = "Password should not be less than 6")
    private String password;

    @NotNull
    private String username;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_details_id", referencedColumnName = "id")
    @JsonIgnore
    private AccountDetails accountDetails;

    public User(String email, String password,String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
