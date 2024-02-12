package cz.itnetwork.webapplication.controllers;

import cz.itnetwork.webapplication.models.dto.TitleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String renderHomePage(@ModelAttribute TitleDTO titleDTO) {
        titleDTO.setTitle("Hlavní strana");
        return "pages/home/HomePage";
    }

    @GetMapping("about")
    public String renderAbout(@ModelAttribute TitleDTO titleDTO) {
        titleDTO.setTitle("O Eshopu");
        return "pages/home/about";
    }
}
