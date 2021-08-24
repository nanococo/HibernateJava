package databaseObjects;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

//Esta clase define la estructura en Java para la tabla sd_solutions
@Entity
@Table(name = "sd_solutions", schema = "dbo", catalog = "solutiondesigns")
public class SdSolutionsEntity {
    private int problemid;
    private long designid;
    private String comments;
    private Timestamp posttime;
    private boolean active;
    private long solutionid;
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

    //Este id define la primary key de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //Aquí es donde se define la relacón 1-N por medio de las anotaciones de Java. Se genera una relación
    //con el atributo de sdSolutionsBySolutionid que se encuentra en la clase SdSolutionslogEntity
    @OneToMany(mappedBy = "sdSolutionsBySolutionid", cascade = CascadeType.ALL)
    public Collection<SdSolutionslogEntity> getSdSolutionslogsBySolutionid() {
        return sdSolutionslogsBySolutionid;
    }

    public void setSdSolutionslogsBySolutionid(Collection<SdSolutionslogEntity> sdSolutionslogsBySolutionid) {
        this.sdSolutionslogsBySolutionid = sdSolutionslogsBySolutionid;
    }

    //To string para imprimir los elementos
    @Override
    public String toString() {
        return "SdSolutionsEntity{" +
                "problemid=" + problemid +
                ", designid=" + designid +
                ", comments='" + comments + '\'' +
                ", posttime=" + posttime +
                ", active=" + active +
                ", solutionid=" + solutionid +
                ", sdSolutionslogsBySolutionid=" + sdSolutionslogsBySolutionid +
                '}';
    }
}
