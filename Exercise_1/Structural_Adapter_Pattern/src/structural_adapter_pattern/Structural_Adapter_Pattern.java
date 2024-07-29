/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package structural_adapter_pattern;

/**
 *
 * @author JITHIN V J
 */
// Adapter Pattern

interface Data {
    String getData();
}

class XMLData {
    private String xml;

    public XMLData(String xml) {
        this.xml = xml;
    }

    public String getXML() {
        return "XML Data: " + xml;
    }
}

class JSONData {
    private String json;

    public JSONData(String json) {
        this.json = json;
    }

    public String getJSON() {
        return "JSON Data: " + json;
    }
}

class XMLAdapter implements Data {
    private XMLData xmlData;

    public XMLAdapter(XMLData xmlData) {
        this.xmlData = xmlData;
    }

    @Override
    public String getData() {
        return xmlData.getXML();
    }
}

class JSONAdapter implements Data {
    private JSONData jsonData;

    public JSONAdapter(JSONData jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String getData() {
        return jsonData.getJSON();
    }
}

// Usage
public class Structural_Adapter_Pattern {
    public static void main(String[] args) {
        XMLData xmlData = new XMLData("<data>Hello XML</data>");
        JSONData jsonData = new JSONData("{\"data\": \"Hello JSON\"}");

        Data xmlAdapter = new XMLAdapter(xmlData);
        Data jsonAdapter = new JSONAdapter(jsonData);

        System.out.println(xmlAdapter.getData());
        System.out.println(jsonAdapter.getData());
    }
}

