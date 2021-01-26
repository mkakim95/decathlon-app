package kz.nursultan.output;

import kz.nursultan.model.Athlete;
import kz.nursultan.model.DisciplinePoint;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XmlCreator {
    public static void create(List<Athlete> athletes) {
        try {
            var dbFactory = DocumentBuilderFactory.newInstance();
            var dBuilder = dbFactory.newDocumentBuilder();
            var doc = dBuilder.newDocument();
            // root element
            var rootElement = doc.createElement("athletes");
            doc.appendChild(rootElement);

            for (Athlete athlete : athletes) {
                // athlete element
                var athleteElem = doc.createElement("athlete");

                // place attr
                var placeAttr = doc.createAttribute("place");
                placeAttr.setValue(athlete.getPlace());
                athleteElem.setAttributeNode(placeAttr);

                // total point attr
                var totalPointAttr = doc.createAttribute("totalPoint");
                totalPointAttr.setValue(String.valueOf(athlete.getTotalPoint()));
                athleteElem.setAttributeNode(totalPointAttr);

                // name attr
                var nameAttr = doc.createAttribute("name");
                nameAttr.setValue(String.valueOf(athlete.getName()));
                athleteElem.setAttributeNode(nameAttr);

                // discipline point element
                for (DisciplinePoint disciplinePoint : athlete.getDisciplinePoints()) {
                    Element disciplinePointElem = doc.createElement("disciplinePoint");
                    Attr pointAttr = doc.createAttribute("point");
                    pointAttr.setValue(String.valueOf(disciplinePoint.getPoint()));
                    disciplinePointElem.setAttributeNode(pointAttr);
                    disciplinePointElem.appendChild(doc.createTextNode(disciplinePoint.getDisciplineType().getName()));
                    athleteElem.appendChild(disciplinePointElem);
                }

                rootElement.appendChild(athleteElem);
            }

            // write the content into xml file
            var transformerFactory = TransformerFactory.newInstance();
            var transformer = transformerFactory.newTransformer();
            var source = new DOMSource(doc);
            var result = new StreamResult(new File("athletes.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            var consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
