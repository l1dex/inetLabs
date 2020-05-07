import org.w3c.dom.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.*;

public class Main {

    public static void main(String[] args) throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("./resourses/portfolio.xml");

        NodeList projects = document.getDocumentElement().getChildNodes();//nodelist projects in xml
        List<ProjectXML> projectXMLList = new ArrayList<>();//list of results in Objects
        if(projects.getLength() == 0){
            System.out.println("Zero items");
            return;
        }
        for(int i = 0; i < projects.getLength();i++){//projects loop
            if(projects.item(i).getNodeType() != Node.TEXT_NODE){//exist nullable text nodes
                NamedNodeMap atr = projects.item(i).getAttributes();

                ProjectXML projectXML = new ProjectXML();//create object for list
                projectXML.id = atr.getNamedItem("id").getTextContent();//take attribute id and year
                projectXML.year = atr.getNamedItem("year").getTextContent();

                NodeList project = projects.item(i).getChildNodes();//get spec project
                for(int j = 0; j < project.getLength();j++){
                    if(project.item(j).getNodeType() != Node.TEXT_NODE){
                        String nodeName = project.item(j).getNodeName();
                        if(nodeName.compareTo("title") == 0){
                            projectXML.title = project.item(j).getTextContent();
                        }
                        if(nodeName.compareTo("authors") == 0){
                            projectXML.authors = Arrays.asList(project.item(j).getTextContent().split("\n"));
                        }
                    }
                }
                projectXMLList.add(projectXML);
            }
        }

        htmlCreate(projectXMLList);

    }

    private static void htmlCreate(List<ProjectXML> projectXMLList) throws IOException {
        String path = "./resourses/";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input file name");
        String name = scanner.next();

        File file = new File(path + name + ".html");
        file.createNewFile();

        PrintWriter writer = new PrintWriter(file);
        writer.println(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"ru\">\n" +
                        "<head>\n" +
                        "<meta charset=\"utf-8\" />\n" +
                        "<title>" + name + "</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<br>"
        );

        for(int i = 0; i < projectXMLList.size();i++){
            ProjectXML projectXML = projectXMLList.get(i);
            writer.println("id: " + projectXML.id +
                    " year:" + projectXML.year +
                    " title:" + projectXML.title +
                    " authors: ");

            for(int j = 0; j < projectXML.authors.size() - 1;j++){
                if(projectXML.authors.get(j).length() > 3) {
                    writer.print(projectXML.authors.get(j) + ",");
                }
            }

            writer.println("<br>");
        }

        writer.println(
                "</body>\n" +
                        "</html>"
        );
        writer.close();
    }

    static class ProjectXML{
        private String id;
        private String year;
        private String title;
        private List<String> authors;

        public ProjectXML(){
            id = null;
            year = null;
            title = null;
            authors = new ArrayList<>();
        }

        public ProjectXML(String id, String year, String title, List<String> authors) {
            this.id = id;
            this.year = year;
            this.title = title;
            this.authors = authors;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }
    }
}
