public class LastViewedSeries {
    private String seriesName;
    private int lastViewedEpisode;
    private int[] viewedEpisodes = new int[]{0,0,0};
    private boolean isSeriesFinishedToBeViewed;

    public LastViewedSeries(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getLastViewedEpisode() {
        return lastViewedEpisode;
    }

    public void setLastViewedEpisode(int lastViewedEpisode) {
        this.lastViewedEpisode = lastViewedEpisode;
    }

    public boolean isSeriesFinishedToBeViewed() {
        return isSeriesFinishedToBeViewed;
    }

    public void setSeriesFinishedToBeViewed(boolean seriesFinishedToBeViewed) {
        isSeriesFinishedToBeViewed = seriesFinishedToBeViewed;
    }

    public void checkEpisode(int episodeNumber) throws Exception {
        if (episodeNumber - 1 < 0 || episodeNumber - 1 > 2) {
            throw new Exception("Invalid episode number");
        }

        viewedEpisodes[episodeNumber - 1] = 1;
    }
}
