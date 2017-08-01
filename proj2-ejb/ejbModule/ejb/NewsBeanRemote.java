package ejb;

import java.util.List;

import javax.ejb.Remote;

import common.NewsJPA;

@Remote
public interface NewsBeanRemote {

    List<NewsJPA> newsForGivenDate(String givenDate);
    List<NewsJPA> checkAuthors(String author);
    List<NewsJPA> getNewsByKeyword(String key);
    List<NewsJPA> getNewsByRegion(String region);

}
