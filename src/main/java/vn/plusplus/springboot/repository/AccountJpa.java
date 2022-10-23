package vn.plusplus.springboot.repository;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone")
    private String phoneJpa;

    @Column(name = "email")
    private String emailJpa;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private Integer balance;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneJpa() {
        return phoneJpa;
    }

    public void setPhoneJpa(String phoneJpa) {
        this.phoneJpa = phoneJpa;
    }

    public String getEmailJpa() {
        return emailJpa;
    }

    public void setEmailJpa(String emailJpa) {
        this.emailJpa = emailJpa;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
