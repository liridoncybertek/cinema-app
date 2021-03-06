package com.cybertek.orm.cinemaapp.model;

import com.cybertek.orm.cinemaapp.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
public class User extends Model<Integer> {

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 6, message = "Password should not be less than 6")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_details_id", referencedColumnName = "id")
    @JsonManagedReference
    private AccountDetails accountDetails;

    public User(String email, String password,String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

}
