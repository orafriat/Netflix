import java.util.LinkedList;
import java.util.List;

public class Series {
    private String name;
    private List<Episode> episodes;

    public Series(String name, List<Episode> episodes) {
        this.name = name;
        this.episodes = episodes;
    }

    public Series(String name) {
        this.name = name;
        this.episodes = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public boolean isEpisodeExists(int episodeNumber) {
        for (int i = 0; i < episodes.size(); i++) {
            if (i + 1 == episodeNumber) {
                return true;
            }
        }

        return false;
    }
}
