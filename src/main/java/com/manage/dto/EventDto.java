package com.manage.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private String id;

    private String name;
    private String description;
    private String location;

    private Date date;
    private String url;
    private String image;
    private String category;

}
