package snowtoslow.work.workProject.Classes;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import snowtoslow.work.workProject.Helper.Helpers.commonVariables;


@RestController
@RequestMapping("comment")
public class CommentClass implements commonVariables {

    private String blogContent;

    private int postId;

    private String createTime;



    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
