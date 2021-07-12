import java.util.Date;

public class Episode {
    private String name;
    private String brief;
    private Date publishedAt;

    public Episode(String name, String brief, Date publishedAt) {
        this.name = name;
        this.brief = brief;
        this.publishedAt = publishedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
}
