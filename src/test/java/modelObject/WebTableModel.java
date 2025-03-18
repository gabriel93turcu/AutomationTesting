package modelObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WebTableModel {

    private String firstnameValue;
    private String lastNameValue;
    private String userEmailValue;
    private String ageValue;
    private String salaryValue;
    private String departmentValue;
    private String editSalaryValue;
    private String editDepartmentValue;
    private String editAgeValue;
    private int newTableSize;
    private int actualTableSize;

    // Constructor care încarcă JSON fără mapare manuală
    public WebTableModel(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(jsonFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file: " + jsonFilePath, e);
        }
    }

    // Getteri (fără modificări)
    public String getFirstnameValue() { return firstnameValue; }
    public String getLastNameValue() { return lastNameValue; }
    public String getUserEmailValue() { return userEmailValue; }
    public String getAgeValue() { return ageValue; }
    public String getSalaryValue() { return salaryValue; }
    public String getDepartmentValue() { return departmentValue; }
    public String getEditSalaryValue() { return editSalaryValue; }
    public String getEditDepartmentValue() { return editDepartmentValue; }
    public String getEditAgeValue() { return editAgeValue; }
    public int getNewTableSize() { return newTableSize; }
    public int getActualTableSize() { return actualTableSize; }
}