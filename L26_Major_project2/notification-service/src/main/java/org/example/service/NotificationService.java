package org.example.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final String TRANSACTION_COMPLETED_TOPIC = "transaction_completed";

    @Autowired
    SimpleMailMessage simpleMailMessage;

    @Autowired
    JavaMailSender javaMailSender;

    @KafkaListener(topics = {TRANSACTION_COMPLETED_TOPIC}, groupId = "jbdl123")
    public void notify(String msg) throws ParseException {
        JSONObject obj = (JSONObject) new JSONParser().parse(msg);
        String transactionStatus = (String) obj.get("transactionStatus");
        String transactionId = (String) obj.get("transactionId");
        Long amount = (Long) obj.get("amount") / 100;
        String senderEmail = (String) obj.get("senderEmail");
        String receiverEmail = (String) obj.get("receiverEmail");

        String senderMsg = getSenderMessage(transactionStatus, amount, transactionId);
        String receiverMsg = getReceiverMessage(transactionStatus, amount, senderEmail);

        if(senderMsg != null && senderMsg.length() > 0){
            simpleMailMessage.setTo(senderEmail);
            simpleMailMessage.setSubject("E-Wallet Transaction Updates");
            simpleMailMessage.setFrom("ewallet.jbdl50@gmail.com");
            simpleMailMessage.setText(senderMsg);
            javaMailSender.send(simpleMailMessage);
        }

        if(receiverMsg != null && receiverMsg.length() > 0){
            simpleMailMessage.setTo(receiverEmail);
            simpleMailMessage.setSubject("E-Wallet Transaction Updates");
            simpleMailMessage.setFrom("ewallet.jbdl50@gmail.com");
            simpleMailMessage.setText(receiverMsg);
            javaMailSender.send(simpleMailMessage);
        }
    }

    private String getSenderMessage(String transactionStatus, Long amount, String transactionId){
        String msg = "";
        if(transactionStatus.equals("FAILED")){
            msg = "Hi!! Your transaction of amount " + amount + " , transaction id = " + transactionId + " has failed";
        }else{
            msg = "Hi!! Your account has been debited with amount " + amount + " , transaction id = " + transactionId;
        }

        return msg;
    }

    private String getReceiverMessage(String transactionStatus, Long amount, String senderEmail){
        String msg = "";
        if(transactionStatus.equals("SUCCESSFUL")){
            msg = "Hi!! Your account has been credit with amount " + amount + " for the transaction done by user " + senderEmail;
        }

        return msg;
    }

}
