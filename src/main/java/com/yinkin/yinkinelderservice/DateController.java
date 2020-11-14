package com.yinkin.yinkinelderservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yinkin.yinkinelderservice.model.Event;

@Controller
@RequestMapping({ "/datepicker" })
public class DateController {
    @GetMapping
    public String date(Model model) {
        model.addAttribute("event", new Event());
        return "datepicker";
    }

    @PostMapping
    public String save(Event event, Model model) {
        model.addAttribute("event", event);
        return "event_saved";
    }
}
