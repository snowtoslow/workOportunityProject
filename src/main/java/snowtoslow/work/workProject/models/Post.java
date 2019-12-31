package snowtoslow.work.workProject.models;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "post", schema = "public")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int postId;

    @Column(name = "post_title")
    @NotEmpty(message = "This Field Must Contain Information !!")
    private String postTitle;

    @Column(name = "post_content")
    @NotEmpty(message = "This Field Must Contain Information !!")
    private String postContent;

    @Column(name = "create_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date create_time;

    @Column(name = "update_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @UpdateTimestamp
    private Date update_time;

    @Column(name = "post_status")
    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=true, updatable = false)
    //@MapsId("user_id")
    //@Embedded
    private User userId;




    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
