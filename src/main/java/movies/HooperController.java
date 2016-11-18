package movies;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by thibaud on 18/11/2016.
 */
@RestController
public class HooperController {

    @RequestMapping("/lives")
    public ArrayList<HMovie> getHMovie() throws IOException {
        ArrayList<HMovie> hMovies = generatingMovieList(2);
        return hMovies;
    }

    private static ArrayList<HMovie> generatingMovieList(int bloc) throws IOException {
        ArrayList<HMovie> hMovieArrayList = new ArrayList<>();
        Document doc = Jsoup.connect("http://www.hooper.fr/").get();
        Elements newMoviesElements = doc.getElementsByClass("view-display-id-block_"+bloc);
        for(Element movies : newMoviesElements){
            Elements image = movies.getElementsByClass("imagecache-video_apercu");
            Elements titles = movies.getElementsByClass("views-field-title");
            Elements plateform = movies.getElementsByClass("views-field-tid-1");
            Elements date = movies.getElementsByClass("views-field-created");
            Elements details = movies.getElementsByClass("views-field-field-video-description-value");
            for (int a=0;a<titles.size();a++){
                String dailyUrl = getMovieURL(titles.select("span").select("a").attr("href"));
                String imgUrl = image.get(a).attr("src");
                HMovie hMovie = new HMovie(
                        titles.get(a).text(),
                        plateform.get(a).text(),
                        date.get(a).text(),
                        details.get(a).text(),
                        dailyUrl,
                        imgUrl
                );
                hMovieArrayList.add(hMovie);
            }
        }
        return hMovieArrayList;
    }

    private static String getMovieURL(String href) throws IOException {
        Document doc = Jsoup.connect("http://www.hooper.fr"+href).get();
        Element iframeDaily = doc.select("iframe").first();
        return "http:"+iframeDaily.attr("src");
    }
}
