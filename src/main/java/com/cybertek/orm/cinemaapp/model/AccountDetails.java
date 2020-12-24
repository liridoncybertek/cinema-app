package com.cybertek.orm.cinemaapp.model;

import com.cybertek.orm.cinemaapp.model.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
public class AccountDetails extends Model<Integer> {

    private String name;

    private String address;

    private String country;

    private String state;

    private String city;

    private Integer age;

    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "accountDetails")
    private User user;

    public AccountDetails(String name, String address, String country, String state, String city, Integer age, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                '}';
    }
}
