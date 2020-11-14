package com.yinkin.yinkinelderservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yinkin.yinkinelderservice.model.ProgrammingSkills;


@Controller
@RequestMapping({ "/service" })
public class ServiceController {


    @GetMapping
    public String main(Model model) {
        model.addAttribute("skills", new ProgrammingSkills());
        return "service";
    }

    @PostMapping
    public String save(ProgrammingSkills skills, Model model) {
        model.addAttribute("skills", skills);
        return "saved";
    }

}