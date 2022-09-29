package com.example.demo.entities;
import javax.persistence.*;

@Entity
@Table(name = "UserEntity") //supabase lo crea como user_entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column (name="email", unique = true)
    private String email;

    @Column (name="image")
    private String image;

    @Column (name="Auth0_Id", unique = true)
    private String Auth0_id;

    public UserEntity() {
    }

    public UserEntity(String email, String image, String auth0_id) {
        this.Auth0_id = auth0_id;
        this.email = email;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuth0_id() {
        return Auth0_id;
    }

    public void setAuth0_id(String auth0_id) {
        Auth0_id = auth0_id;
    }

}
