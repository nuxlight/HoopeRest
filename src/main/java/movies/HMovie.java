package movies;

/**
 * HMovie
 * ======
 * This class describe how to define a movie recovered on Hooper website
 */
public class HMovie {

    private String title;
    private String plateform;
    private String date;
    private String details;
    private String dailyURL;
    private String thumbURL;

    public HMovie(String title, String plateform, String date, String details, String dailyURL, String thumbURL) {
        this.title = title;
        this.plateform = plateform;
        this.date = date;
        this.details = details;
        this.dailyURL = dailyURL;
        this.thumbURL = thumbURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlateform() {
        return plateform;
    }

    public void setPlateform(String plateform) {
        this.plateform = plateform;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDailyURL() {
        return dailyURL;
    }

    public void setDailyURL(String dailyURL) {
        this.dailyURL = dailyURL;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    @Override
    public String toString() {
        return "HMovie{" +
                "title='" + title + '\'' +
                ", plateform='" + plateform + '\'' +
                ", date='" + date + '\'' +
                ", details='" + details + '\'' +
                ", dailyURL='" + dailyURL + '\'' +
                ", thumbURL='" + thumbURL + '\'' +
                '}';
    }
}