package snowtoslow.work.workProject.models;


import javax.persistence.Column;

public enum UserStatus {

    @Column(name = "user_status")
    ONLINE, OFFLINE,ACTIVE,INNACTIVE

}
