package snowtoslow.work.workProject.models;


import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "post_status")
public enum PostStatus {
    @Column(name = "status")
    DRAFT,PUBLISHED

}
