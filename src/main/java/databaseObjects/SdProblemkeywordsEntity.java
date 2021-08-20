package databaseObjects;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sd_problemkeywords", schema = "dbo", catalog = "solutiondesigns")
public class SdProblemkeywordsEntity {
    private int problemid;
    private int keywordid;
    private boolean deleted;
    private SdProblemsEntity sdProblemsByProblemid;
    private SdKeywordsEntity sdKeywordsByKeywordid;

    @Basic
    @Column(name = "problemid")
    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    @Basic
    @Column(name = "keywordid")
    public int getKeywordid() {
        return keywordid;
    }

    public void setKeywordid(int keywordid) {
        this.keywordid = keywordid;
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
        SdProblemkeywordsEntity that = (SdProblemkeywordsEntity) o;
        return problemid == that.problemid && keywordid == that.keywordid && deleted == that.deleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(problemid, keywordid, deleted);
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
    @JoinColumn(name = "keywordid", referencedColumnName = "keywordid", nullable = false)
    public SdKeywordsEntity getSdKeywordsByKeywordid() {
        return sdKeywordsByKeywordid;
    }

    public void setSdKeywordsByKeywordid(SdKeywordsEntity sdKeywordsByKeywordid) {
        this.sdKeywordsByKeywordid = sdKeywordsByKeywordid;
    }
}
