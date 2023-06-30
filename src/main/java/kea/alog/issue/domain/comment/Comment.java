package kea.alog.issue.domain.comment;
import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import kea.alog.issue.domain.BaseTimeEntity;
import kea.alog.issue.domain.issue.Issue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "comment")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Comment extends BaseTimeEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_pk")
    private Long commentPk;

    @Column(name = "comment_content", length=200)
    private String commentContent;

    @Column(name = "comment_author_nn", length=10)
    private String commentAuthorNn;

    @Column(name = "comment_author_pk")
    private Long commentAuthorPk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue")
    private Issue issue;
    
    @Column(name = "project_pk")
    private Long projectPk;

    @Column (name = "topic_pk")
    private Long topicPk;
    
    @Builder
    public Comment(String commentContent, String commentAuthorNn, Long commentAuthorPk, Issue issue, Long projectPk, Long topicPk){
        this.commentContent = commentContent;
        this.commentAuthorNn = commentAuthorNn;
        this.commentAuthorPk = commentAuthorPk;
        this.issue = issue;
        this.projectPk = projectPk;
        this.topicPk = topicPk;
    }
}
