package com.soldevelo.Recruitment.Task.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GitController {

    @GetMapping("/")
    public String displayCommits() {
        return "startPage.html";
    }
}
