
package models;

import java.time.LocalDate;


public class Assignment {
    private String title;
    private String description;
    private LocalDate subDateTime;
    private int totalMark;

    public Assignment() {
    }

    public Assignment(String title, String description, LocalDate subDateTime, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.totalMark = totalMark;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }


    
}
