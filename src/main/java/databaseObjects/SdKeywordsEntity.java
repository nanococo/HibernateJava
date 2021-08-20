package databaseObjects;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "sd_keywords", schema = "dbo", catalog = "solutiondesigns")
public class SdKeywordsEntity {
    private int keywordid;
    private String word;
    private Collection<SdProblemkeywordsEntity> sdProblemkeywordsByKeywordid;

    @Id
    @Column(name = "keywordid")
    public int getKeywordid() {
        return keywordid;
    }

    public void setKeywordid(int keywordid) {
        this.keywordid = keywordid;
    }

    @Basic
    @Column(name = "word")
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdKeywordsEntity that = (SdKeywordsEntity) o;
        return keywordid == that.keywordid && Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keywordid, word);
    }

    @OneToMany(mappedBy = "sdKeywordsByKeywordid")
    public Collection<SdProblemkeywordsEntity> getSdProblemkeywordsByKeywordid() {
        return sdProblemkeywordsByKeywordid;
    }

    public void setSdProblemkeywordsByKeywordid(Collection<SdProblemkeywordsEntity> sdProblemkeywordsByKeywordid) {
        this.sdProblemkeywordsByKeywordid = sdProblemkeywordsByKeywordid;
    }
}
