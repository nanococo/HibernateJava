package databaseObjects;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sd_owners", schema = "dbo", catalog = "solutiondesigns")
public class SdOwnersEntity {
    private long ownerid;
    private String firstname;
    private String lastname;
    private String email;
    private byte[] password;
    private boolean enabled;
    private Timestamp creationdate;
    private Collection<SdDesignsEntity> sdDesignsByOwnerid;
    private Collection<SdProblemsEntity> sdProblemsByOwnerid;

    @Id
    @Column(name = "ownerid")
    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Basic
    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "creationdate")
    public Timestamp getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdOwnersEntity that = (SdOwnersEntity) o;
        return ownerid == that.ownerid && enabled == that.enabled && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(email, that.email) && Arrays.equals(password, that.password) && Objects.equals(creationdate, that.creationdate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ownerid, firstname, lastname, email, enabled, creationdate);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @OneToMany(mappedBy = "sdOwnersByOwnerid")
    public Collection<SdDesignsEntity> getSdDesignsByOwnerid() {
        return sdDesignsByOwnerid;
    }

    public void setSdDesignsByOwnerid(Collection<SdDesignsEntity> sdDesignsByOwnerid) {
        this.sdDesignsByOwnerid = sdDesignsByOwnerid;
    }

    @OneToMany(mappedBy = "sdOwnersByOwnerid")
    public Collection<SdProblemsEntity> getSdProblemsByOwnerid() {
        return sdProblemsByOwnerid;
    }

    public void setSdProblemsByOwnerid(Collection<SdProblemsEntity> sdProblemsByOwnerid) {
        this.sdProblemsByOwnerid = sdProblemsByOwnerid;
    }
}
