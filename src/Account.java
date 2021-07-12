import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private String username;
    private String password;
    private Date createdDate;
    private Date subscriptionEndDate;

    private List<LastViewedSeries> lastViewedSeriesList;

    public Account(String username, String password, Date createdDate, Date subscriptionEndDate) {
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.subscriptionEndDate = subscriptionEndDate;

        lastViewedSeriesList = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSubscriptionEndDate() {
        return subscriptionEndDate;
    }

    public void setSubscriptionEndDate(Date subscriptionEndDate) {
        this.subscriptionEndDate = subscriptionEndDate;
    }

    public List<LastViewedSeries> getLastViewedSeriesList() {
        return lastViewedSeriesList;
    }

    public void setLastViewedSeriesList(List<LastViewedSeries> lastViewedSeriesList) {
        this.lastViewedSeriesList = lastViewedSeriesList;
    }

    public int totalViewedSeries() {
        return (int) lastViewedSeriesList.stream().filter(series -> series.getLastViewedEpisode() > 0).count();
    }

    public int totalViewFinishedSeries() {
        return (int) lastViewedSeriesList.stream().filter(LastViewedSeries::isSeriesFinishedToBeViewed).count();
    }

    public int totalViewedEpisodes() {
        int total = 0;
        for (LastViewedSeries series : lastViewedSeriesList) {
            total += series.getLastViewedEpisode();
        }

        return total;
    }

    public void addSeriesToLibrary(Series series) {
        lastViewedSeriesList.add(new LastViewedSeries(series.getName()));
    }

    public void checkEpisode(String seriesName, int episodeNumber) throws Exception {
        for (LastViewedSeries series : lastViewedSeriesList) {
            if (series.getSeriesName().equals(seriesName)) {
                series.checkEpisode(episodeNumber);
                return;
            }
        }

        throw new Exception("Series not found");
    }
}
