package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "https://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancyList = new ArrayList<>();
        int page = 0;
        try {
            while (page < 4) {

                Document doc = getDocument(searchString, page);
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() == 0) break;

                for (Element element : elements) {
                    String title = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text();
                    String salary = "";
                    if (element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").size() > 0)
                        salary = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                    String city = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text();
                    String companyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text();
                    String siteName = "hh.ru";
                    String url = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancyList.add(vacancy);
                }
                page++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) throws IOException {

        Document doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36")
                .referrer("https://hh.ru/")
                .get();

        return doc;
    }
}
