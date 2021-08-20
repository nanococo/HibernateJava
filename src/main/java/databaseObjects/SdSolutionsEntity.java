package databaseObjects;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sd_solutions", schema = "dbo", catalog = "solutiondesigns")
public class SdSolutionsEntity {
    private int problemid;
    private long designid;
    private String comments;
    private Timestamp posttime;
    private boolean active;
    private long solutionid;
    private SdProblemsEntity sdProblemsByProblemid;
    private SdDesignsEntity sdDesignsByDesignid;
    private Collection<SdSolutionslogEntity> sdSolutionslogsBySolutionid;

    @Basic
    @Column(name = "problemid")
    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    @Basic
    @Column(name = "designid")
    public long getDesignid() {
        return designid;
    }

    public void setDesignid(long designid) {
        this.designid = designid;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "posttime")
    public Timestamp getPosttime() {
        return posttime;
    }

    public void setPosttime(Timestamp posttime) {
        this.posttime = posttime;
    }

    @Basic
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Id
    @Column(name = "solutionid")
    public long getSolutionid() {
        return solutionid;
    }

    public void setSolutionid(long solutionid) {
        this.solutionid = solutionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdSolutionsEntity that = (SdSolutionsEntity) o;
        return problemid == that.problemid && designid == that.designid && active == that.active && solutionid == that.solutionid && Objects.equals(comments, that.comments) && Objects.equals(posttime, that.posttime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problemid, designid, comments, posttime, active, solutionid);
    }

    @ManyToOne
    @JoinColumn(name = "problemid", referencedColumnName = "problemid", nullable = false)
    public SdProblemsEntity getSdProblemsByProblemid() {
        return sdProblemsByProblemid;
    }

    public void setSdProblemsByProblemid(SdProblemsEntity sdProblemsByProblemid) {
        this.sdProblemsByProblemid = sdProblemsByProblemid;
    }

    @ManyToOne
    @JoinColumn(name = "designid", referencedColumnName = "designid", nullable = false)
    public SdDesignsEntity getSdDesignsByDesignid() {
        return sdDesignsByDesignid;
    }

    public void setSdDesignsByDesignid(SdDesignsEntity sdDesignsByDesignid) {
        this.sdDesignsByDesignid = sdDesignsByDesignid;
    }

    @OneToMany(mappedBy = "sdSolutionsBySolutionid")
    public Collection<SdSolutionslogEntity> getSdSolutionslogsBySolutionid() {
        return sdSolutionslogsBySolutionid;
    }

    public void setSdSolutionslogsBySolutionid(Collection<SdSolutionslogEntity> sdSolutionslogsBySolutionid) {
        this.sdSolutionslogsBySolutionid = sdSolutionslogsBySolutionid;
    }
}
