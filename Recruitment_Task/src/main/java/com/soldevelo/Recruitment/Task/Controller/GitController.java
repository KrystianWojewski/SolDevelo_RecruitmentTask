package com.soldevelo.Recruitment.Task.Controller;

import com.soldevelo.Recruitment.Task.Model.GitModel;
import com.soldevelo.Recruitment.Task.Model.UrlModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class GitController {

    String API_URL = "https://api.github.com/repos/";
    WebClient webClient = WebClient.create(API_URL);

    @GetMapping("/")
    public String displayCommitsForm(Model model){
        model.addAttribute("url", new UrlModel());
        return "startPage";
    }

    @PostMapping("/urls")
    public String setParams(@ModelAttribute UrlModel urlModel, RedirectAttributes attributes){
        attributes.addFlashAttribute("url", urlModel);
        return "redirect:/api/commits?owner=" + urlModel.getOwner() + "&repository=" + urlModel.getRepository();
    }

    @GetMapping("/api/commits")
    public String displayCommits(@RequestParam String owner, @RequestParam String repository, Model model) {
        GitModel[] gitModel = webClient.get().uri(owner + "/" + repository + "/commits").retrieve()
                .bodyToMono(GitModel[].class).block();
        List<GitModel> gitModelList = Arrays.asList(gitModel);

        model.addAttribute("gitModel", gitModelList);

        return "commitsPage";
    }
}
