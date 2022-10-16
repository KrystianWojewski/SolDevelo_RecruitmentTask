package com.soldevelo.Recruitment.Task.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GitModel {

    private String sha;
    private Commits commit;
}
