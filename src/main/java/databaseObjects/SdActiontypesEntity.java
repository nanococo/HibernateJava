package databaseObjects;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sd_actiontypes", schema = "dbo", catalog = "solutiondesigns")
public class SdActiontypesEntity {
    private short actiontypeid;
    private String name;
    private String iconurl;
    private Collection<SdSolutionslogEntity> sdSolutionslogsByActiontypeid;

    @Id
    @Column(name = "actiontypeid")
    public short getActiontypeid() {
        return actiontypeid;
    }

    public void setActiontypeid(short actiontypeid) {
        this.actiontypeid = actiontypeid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "iconurl")
    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdActiontypesEntity that = (SdActiontypesEntity) o;
        return actiontypeid == that.actiontypeid && Objects.equals(name, that.name) && Objects.equals(iconurl, that.iconurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actiontypeid, name, iconurl);
    }

    @OneToMany(mappedBy = "sdActiontypesByActiontypeid")
    public Collection<SdSolutionslogEntity> getSdSolutionslogsByActiontypeid() {
        return sdSolutionslogsByActiontypeid;
    }

    public void setSdSolutionslogsByActiontypeid(Collection<SdSolutionslogEntity> sdSolutionslogsByActiontypeid) {
        this.sdSolutionslogsByActiontypeid = sdSolutionslogsByActiontypeid;
    }
}
