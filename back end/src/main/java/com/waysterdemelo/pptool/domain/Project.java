package com.waysterdemelo.pptool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank(message = "Project name is required")
    private String projectName;

    @NotBlank(message = "Project identifier name is required")
    @Size(min = 4, max = 5, message = "Please use 4 to 5 characteres")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotBlank(message = "Project description is required")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate start_date;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate end_date;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created_at;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updated_at;

    @PrePersist
    protected void onCreate(){
        this.created_at = LocalDate.now();
    }

    @PostUpdate
    protected void onUpdate(){
        this.updated_at =LocalDate.now();
    }






}
