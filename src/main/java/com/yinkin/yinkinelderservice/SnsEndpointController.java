package com.yinkin.yinkinelderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationUnsubscribeConfirmationMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;
@RestController
@RequestMapping("/sns/receive")
public class SnsEndpointController {

    private static Logger LOG = LoggerFactory.getLogger(SnsEndpointController.class);
    //private final SendingTextWebSocketHandler snsSendingTextWebSocketHandler;
   
    
    @Value( "${cloud.aws.credentials.accessKey}" )
    private String access_key_id;
    @Value( "${cloud.aws.credentials.secretKey}" )
    private String secret_key_id;
    //@Value( "${sns.topic.arn}" )
    private String topicarn = "arn:aws:sns:us-west-2:168180329753:vediogame";
    // @Autowired
    // public SnsEndpointController(@Qualifier("snsWebSocketHandler") SendingTextWebSocketHandler snsSendingTextWebSocketHandler) {
    //     this.snsSendingTextWebSocketHandler = snsSendingTextWebSocketHandler;
    // }
    @GetMapping("/subscribe/{email}")
    public String subscribtoSNS(@PathVariable("email") String email){
        System.out.println(" ok"+ access_key_id +" "+ secret_key_id +" "+ topicarn);

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(access_key_id, secret_key_id);
        AmazonSNSClient amazonSNSClient = new AmazonSNSClient(awsCreds).withRegion(Regions.US_WEST_2);
        SubscribeRequest subscribeRequest = new SubscribeRequest(topicarn, "email", email);
        amazonSNSClient.subscribe(subscribeRequest);
        return "Check your email box";
    }
    @NotificationMessageMapping
    public void receiveNotification(@NotificationMessage String message, @NotificationSubject String subject) {
        LOG.debug("Received SNS message {} with subject {}", message, subject);

    }

    @NotificationSubscriptionMapping
    public void confirmSubscription(NotificationStatus notificationStatus) {
        notificationStatus.confirmSubscription();
    }
    @NotificationUnsubscribeConfirmationMapping
    public void handleUnsubscribeMessage(NotificationStatus status) {
        //e.g. the client has been unsubscribed and we want to "re-subscribe"
        status.confirmSubscription();
    }
    
}