package snowtoslow.work.workProject.models;


import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "user_status")
public enum UserStatus {

    @Column(name = "status")
    ACTIVE, INACTIVE, BLOCKED

}
