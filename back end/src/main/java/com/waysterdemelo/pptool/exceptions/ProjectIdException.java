package com.waysterdemelo.pptool.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Data
public class ProjectIdException extends RuntimeException{

    public ProjectIdException(String msg){
        super(msg);
    }

}
