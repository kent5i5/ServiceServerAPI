package com.yinkin.yinkinelderservice;

import com.yinkin.yinkinelderservice.model.Message;
import com.yinkin.yinkinelderservice.model.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/bubblechat" })
public class bubblechatController {

    @Autowired
    private MessageRepository messageRepository;
    

    @GetMapping
    public String index(Model model) {
        Iterable<Message> message = messageRepository.findAll();
        model.addAttribute("messages", message);
        return "bubblechat";
    }
}
