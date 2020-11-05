package homeWork5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomeWork5 {
    public static List<String> getTextList(List<WebElement> articleList){
        List<String> articleNameList = new ArrayList<>();
        for (int i = 0; i < articleList.size(); i++) {
            articleNameList.add(articleList.get(i).getText());
        }
        return articleNameList;
    }

    public static List<String> getAttributeList(List<WebElement> articleList, String attribute){
        List<String> attributeList = new ArrayList<>();
        for (int i = 0; i < articleList.size(); i++) {
            attributeList.add(articleList.get(i).getAttribute(attribute));
        }
        return attributeList;
    }

    public static void printFullNamesAndUrlsList(List<WebElement> articleList){
        removeSymbolsInSpan(getAttributeList(articleList, "innerHTML")).forEach(System.out::println);
        getAttributeList(articleList, "href").forEach(System.out::println);
    }

    public static List<String> removeSymbolsInSpan(List<String> list){
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String removedSymbols = list.get(i).replaceAll("<span>.*</span>", "");
            newList.add(removedSymbols);
        }
        return newList;
    }

}
