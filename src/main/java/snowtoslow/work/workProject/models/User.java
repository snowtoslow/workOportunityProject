package snowtoslow.work.workProject.models;


import snowtoslow.work.workProject.utils.Regex;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;


@Entity
@Table(name = "user", schema = "public")
public class User extends Regex {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username")
    @NotEmpty(message = "Username Is Required !!")
    private String userName;

    @Column(name = "password")
    @NotEmpty(message = "User Password Can NOT Be Empty !!")
    @Pattern(regexp = userPasswordRegex)
    private String userPassword;

    @Column(name = "last_name")
    @NotEmpty(message = "Last Name of User Can NOT be empty !!")
    @Pattern(regexp = userInfoRegex)
    private String userLastName;

    @Column(name = "first_name")
    @NotEmpty(message = "First Name Of User Can NOT be empty !!")
    @Pattern(regexp = userInfoRegex)
    private String userFirstName;

    @Column(name = "user_email")
    @NotEmpty(message = "User Email Can NOT be empty !!")
    @Email(regexp = userEmailRegex)
    private String userEmail;

    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany(mappedBy="postId")
    private Set<Post> posts;

    @OneToMany(mappedBy = "commentId")
    private Set<Comment> comments;







    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
