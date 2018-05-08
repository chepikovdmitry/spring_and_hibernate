package byy.entity;

import javax.persistence.*;

@Table(name = "users")
@Entity
public class User extends BaseEntity{

    String name;
    String pas;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "pas")
    public String getPas() {
        return pas;
    }

    public User() {
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public User(String name, String pas) {
        this.name = name;
        this.pas = pas;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pas='" + pas + '\'' +
                ", id=" + id +
                '}';
    }
}
