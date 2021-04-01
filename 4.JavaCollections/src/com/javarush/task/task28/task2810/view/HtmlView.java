package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace(".","/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        String fileContent = getUpdatedFileContent(vacancies);
        updateFile(fileContent);

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Moscow");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){

        try {
            Document document = getDocument();


            Element templateElement = document.getElementsByClass("template").first().clone();
            templateElement.removeAttr("style");
            templateElement.removeClass("template");

            Elements elementsToDel = document.getElementsByAttributeValue("class", "vacancy").remove();

            Elements newElements = new Elements();


           for (Vacancy vacancy : vacancies){
               Element template = templateElement.clone();
               template.getElementsByAttributeValue("class","city").html(vacancy.getCity());
               template.getElementsByAttributeValue("class","companyName").html(vacancy.getCompanyName());
               template.getElementsByAttributeValue("class","Salary").html(vacancy.getSalary());
               template.getElementsByTag("a").html(vacancy.getTitle());
               template.getElementsByTag("a").attr("href", vacancy.getUrl());
               newElements.add(template);

           }

            document.getElementsByAttributeValueContaining("class", "template").before(newElements.outerHtml());

           return document.html();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "Some exception occurred";
    }

    private void updateFile(String fileContent){
        try (FileWriter fileWriter = new FileWriter(new File(filePath))){

            fileWriter.write(fileContent);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected Document getDocument() throws IOException{
        Document doc = Jsoup.parse(new File(filePath), "UTF-8");

        return doc;
    }
}
