package databaseObjects;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sd_links", schema = "dbo", catalog = "solutiondesigns")
public class SdLinksEntity {
    private int linkid;
    private String url;
    private Collection<SdProblemlinksEntity> sdProblemlinksByLinkid;

    @Id
    @Column(name = "linkid")
    public int getLinkid() {
        return linkid;
    }

    public void setLinkid(int linkid) {
        this.linkid = linkid;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdLinksEntity that = (SdLinksEntity) o;
        return linkid == that.linkid && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkid, url);
    }

    @OneToMany(mappedBy = "sdLinksByLinkid")
    public Collection<SdProblemlinksEntity> getSdProblemlinksByLinkid() {
        return sdProblemlinksByLinkid;
    }

    public void setSdProblemlinksByLinkid(Collection<SdProblemlinksEntity> sdProblemlinksByLinkid) {
        this.sdProblemlinksByLinkid = sdProblemlinksByLinkid;
    }
}
