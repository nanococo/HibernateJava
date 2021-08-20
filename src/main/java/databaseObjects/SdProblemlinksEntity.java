package databaseObjects;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sd_problemlinks", schema = "dbo", catalog = "solutiondesigns")
public class SdProblemlinksEntity {
    private int problemid;
    private int linkid;
    private boolean deleted;
    private SdProblemsEntity sdProblemsByProblemid;
    private SdLinksEntity sdLinksByLinkid;

    @Basic
    @Column(name = "problemid")
    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    @Basic
    @Column(name = "linkid")
    public int getLinkid() {
        return linkid;
    }

    public void setLinkid(int linkid) {
        this.linkid = linkid;
    }

    @Basic
    @Column(name = "deleted")
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdProblemlinksEntity that = (SdProblemlinksEntity) o;
        return problemid == that.problemid && linkid == that.linkid && deleted == that.deleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(problemid, linkid, deleted);
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
    @JoinColumn(name = "linkid", referencedColumnName = "linkid", nullable = false)
    public SdLinksEntity getSdLinksByLinkid() {
        return sdLinksByLinkid;
    }

    public void setSdLinksByLinkid(SdLinksEntity sdLinksByLinkid) {
        this.sdLinksByLinkid = sdLinksByLinkid;
    }
}
