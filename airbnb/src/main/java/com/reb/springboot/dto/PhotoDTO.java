package com.reb.springboot.dto;

import java.io.Serializable;

import com.reb.springboot.model.Photo;

public class PhotoDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String description;

    public PhotoDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static PhotoDTO builder(Photo p)
    {
        return new PhotoDTO(p.getName(),p.getDescription());

    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    

}