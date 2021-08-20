package databaseObjects;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sd_solutionslog", schema = "dbo", catalog = "solutiondesigns")
public class SdSolutionslogEntity {
    private long solutionlogid;
    private Timestamp posttime;
    private Short actiontypeid;
    private Long solutionid;
    private SdActiontypesEntity sdActiontypesByActiontypeid;
    private SdSolutionsEntity sdSolutionsBySolutionid;

    @Id
    @Column(name = "solutionlogid")
    public long getSolutionlogid() {
        return solutionlogid;
    }

    public void setSolutionlogid(long solutionlogid) {
        this.solutionlogid = solutionlogid;
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
    @Column(name = "actiontypeid")
    public Short getActiontypeid() {
        return actiontypeid;
    }

    public void setActiontypeid(Short actiontypeid) {
        this.actiontypeid = actiontypeid;
    }

    @Basic
    @Column(name = "solutionid")
    public Long getSolutionid() {
        return solutionid;
    }

    public void setSolutionid(Long solutionid) {
        this.solutionid = solutionid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdSolutionslogEntity that = (SdSolutionslogEntity) o;
        return solutionlogid == that.solutionlogid && Objects.equals(posttime, that.posttime) && Objects.equals(actiontypeid, that.actiontypeid) && Objects.equals(solutionid, that.solutionid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solutionlogid, posttime, actiontypeid, solutionid);
    }

    @ManyToOne
    @JoinColumn(name = "actiontypeid", referencedColumnName = "actiontypeid")
    public SdActiontypesEntity getSdActiontypesByActiontypeid() {
        return sdActiontypesByActiontypeid;
    }

    public void setSdActiontypesByActiontypeid(SdActiontypesEntity sdActiontypesByActiontypeid) {
        this.sdActiontypesByActiontypeid = sdActiontypesByActiontypeid;
    }

    @ManyToOne
    @JoinColumn(name = "solutionid", referencedColumnName = "solutionid")
    public SdSolutionsEntity getSdSolutionsBySolutionid() {
        return sdSolutionsBySolutionid;
    }

    public void setSdSolutionsBySolutionid(SdSolutionsEntity sdSolutionsBySolutionid) {
        this.sdSolutionsBySolutionid = sdSolutionsBySolutionid;
    }
}
