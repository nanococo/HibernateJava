package databaseObjects;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

//Esta clase define la estructura en Java para la tabla sd_solutionslog
@Entity
@Table(name = "sd_solutionslog", schema = "dbo", catalog = "solutiondesigns")
public class SdSolutionslogEntity {
    private long solutionlogid;
    private Timestamp posttime;
    private Short actiontypeid;
    private Long solutionid;
    private SdSolutionsEntity sdSolutionsBySolutionid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //Aquí se define la otra dirección de la relación. Una relación de tipo N-1
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "solutionid", referencedColumnName = "solutionid")
    public SdSolutionsEntity getSdSolutionsBySolutionid() {
        return sdSolutionsBySolutionid;
    }

    public void setSdSolutionsBySolutionid(SdSolutionsEntity sdSolutionsBySolutionid) {
        this.sdSolutionsBySolutionid = sdSolutionsBySolutionid;
    }

    //El to string solo devuelve el solution id por motivos de prueba
    @Override
    public String toString() {
        return String.valueOf(solutionlogid);
    }
}
