package com.yinkin.yinkinelderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;

import com.amazonaws.services.sns.AmazonSNS;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sns")
public class SnsSenderController {
    private static Logger LOG = LoggerFactory.getLogger(SnsEndpointController.class);
    private final NotificationMessagingTemplate notificationMessagingTemplate;

    @Autowired
    public SnsSenderController(AmazonSNS amazonSns) {
        this.notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void send(String subject, String message) {
        this.notificationMessagingTemplate.sendNotification("vediogame", message, subject);
    }
}
