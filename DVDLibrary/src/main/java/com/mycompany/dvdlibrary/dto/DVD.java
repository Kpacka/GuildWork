/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdlibrary.dto;

/**
 *
 * @author jenniferbliss
 */
public class DVD {

    private String Title;

    private String releaseDate;
    private String mpaaRating;
    private String directiorName;
    private String studio;
//User rating or note (allows user to enter additional information, e.g., "Good family movie");
    private String userRating;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return mpaaRating;
    }

    public void setRating(String rating) {
        this.mpaaRating = rating;
    }

    public String getDirectiorName() {
        return directiorName;
    }

    public void setDirectiorName(String directiorName) {
        this.directiorName = directiorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
    
    

}
