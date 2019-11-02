package snowtoslow.work.workProject.models;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public enum UserStatus {

    @Column(name = "user_status")
    ONLINE, OFFLINE,ACTIVE,INNACTIVE

}
