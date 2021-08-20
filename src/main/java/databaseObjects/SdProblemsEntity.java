package databaseObjects;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sd_problems", schema = "dbo", catalog = "solutiondesigns")
public class SdProblemsEntity {
    private int problemid;
    private String title;
    private String description;
    private Timestamp creationdate;
    private boolean active;
    private Long ownerid;
    private Collection<SdProblemkeywordsEntity> sdProblemkeywordsByProblemid;
    private Collection<SdProblemlinksEntity> sdProblemlinksByProblemid;
    private SdOwnersEntity sdOwnersByOwnerid;
    private Collection<SdSolutionsEntity> sdSolutionsByProblemid;

    @Id
    @Column(name = "problemid")
    public int getProblemid() {
        return problemid;
    }

    public void setProblemid(int problemid) {
        this.problemid = problemid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "creationdate")
    public Timestamp getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    @Basic
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "ownerid")
    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdProblemsEntity that = (SdProblemsEntity) o;
        return problemid == that.problemid && active == that.active && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(creationdate, that.creationdate) && Objects.equals(ownerid, that.ownerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problemid, title, description, creationdate, active, ownerid);
    }

    @OneToMany(mappedBy = "sdProblemsByProblemid")
    public Collection<SdProblemkeywordsEntity> getSdProblemkeywordsByProblemid() {
        return sdProblemkeywordsByProblemid;
    }

    public void setSdProblemkeywordsByProblemid(Collection<SdProblemkeywordsEntity> sdProblemkeywordsByProblemid) {
        this.sdProblemkeywordsByProblemid = sdProblemkeywordsByProblemid;
    }

    @OneToMany(mappedBy = "sdProblemsByProblemid")
    public Collection<SdProblemlinksEntity> getSdProblemlinksByProblemid() {
        return sdProblemlinksByProblemid;
    }

    public void setSdProblemlinksByProblemid(Collection<SdProblemlinksEntity> sdProblemlinksByProblemid) {
        this.sdProblemlinksByProblemid = sdProblemlinksByProblemid;
    }

    @ManyToOne
    @JoinColumn(name = "ownerid", referencedColumnName = "ownerid")
    public SdOwnersEntity getSdOwnersByOwnerid() {
        return sdOwnersByOwnerid;
    }

    public void setSdOwnersByOwnerid(SdOwnersEntity sdOwnersByOwnerid) {
        this.sdOwnersByOwnerid = sdOwnersByOwnerid;
    }

    @OneToMany(mappedBy = "sdProblemsByProblemid")
    public Collection<SdSolutionsEntity> getSdSolutionsByProblemid() {
        return sdSolutionsByProblemid;
    }

    public void setSdSolutionsByProblemid(Collection<SdSolutionsEntity> sdSolutionsByProblemid) {
        this.sdSolutionsByProblemid = sdSolutionsByProblemid;
    }
}
