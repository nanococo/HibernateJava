package databaseObjects;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sd_designs", schema = "dbo", catalog = "solutiondesigns")
public class SdDesignsEntity {
    private long designid;
    private String title;
    private String description;
    private long ownerid;
    private Timestamp creationdate;
    private Timestamp publishdate;
    private boolean active;
    private SdOwnersEntity sdOwnersByOwnerid;
    private Collection<SdSolutionsEntity> sdSolutionsByDesignid;

    @Id
    @Column(name = "designid")
    public long getDesignid() {
        return designid;
    }

    public void setDesignid(long designid) {
        this.designid = designid;
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
    @Column(name = "ownerid")
    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
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
    @Column(name = "publishdate")
    public Timestamp getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Timestamp publishdate) {
        this.publishdate = publishdate;
    }

    @Basic
    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdDesignsEntity that = (SdDesignsEntity) o;
        return designid == that.designid && ownerid == that.ownerid && active == that.active && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(creationdate, that.creationdate) && Objects.equals(publishdate, that.publishdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designid, title, description, ownerid, creationdate, publishdate, active);
    }

    @ManyToOne
    @JoinColumn(name = "ownerid", referencedColumnName = "ownerid", nullable = false)
    public SdOwnersEntity getSdOwnersByOwnerid() {
        return sdOwnersByOwnerid;
    }

    public void setSdOwnersByOwnerid(SdOwnersEntity sdOwnersByOwnerid) {
        this.sdOwnersByOwnerid = sdOwnersByOwnerid;
    }

    @OneToMany(mappedBy = "sdDesignsByDesignid")
    public Collection<SdSolutionsEntity> getSdSolutionsByDesignid() {
        return sdSolutionsByDesignid;
    }

    public void setSdSolutionsByDesignid(Collection<SdSolutionsEntity> sdSolutionsByDesignid) {
        this.sdSolutionsByDesignid = sdSolutionsByDesignid;
    }
}
