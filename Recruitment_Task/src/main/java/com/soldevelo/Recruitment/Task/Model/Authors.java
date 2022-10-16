package com.soldevelo.Recruitment.Task.Model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Authors {

    private String name;
    private String email;
    private LocalDateTime date;
}
