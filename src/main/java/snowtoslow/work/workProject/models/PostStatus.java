package snowtoslow.work.workProject.models;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public enum PostStatus {
    @Column(name = "status")
    ACTIVE,CURRENT,FINISHED

}
