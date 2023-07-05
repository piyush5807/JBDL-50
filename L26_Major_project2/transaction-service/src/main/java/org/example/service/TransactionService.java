package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.TransactionCreateRequest;
import org.example.models.Transaction;
import org.example.models.TransactionStatus;
import org.example.repository.TransactionRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();
    private RestTemplate restTemplate = new RestTemplate();

    private static final String TRANSACTION_CREATED_TOPIC = "transaction_created";
    private static final String TRANSACTION_COMPLETED_TOPIC = "transaction_completed";
    private static final String WALLET_UPDATED_TOPIC = "wallet_updated";

    private static final String WALLET_UPDATE_SUCCESS_STATUS = "SUCCESS";
    private static final String WALLET_UPDATE_FAILED_STATUS = "FAILED";


    public String transact(TransactionCreateRequest request, String senderId) throws JsonProcessingException {

        Transaction transaction = Transaction.builder()
                .senderId(senderId)
                .receiverId(request.getReceiver())
                .externalId(UUID.randomUUID().toString())
                .transactionStatus(TransactionStatus.PENDING)
                .reason(request.getReason())
                .amount(request.getAmount())
                .build();

        transactionRepository.save(transaction);

        JSONObject obj = new JSONObject();
        obj.put("senderId", transaction.getSenderId());
        obj.put("receiverId", transaction.getReceiverId());
        obj.put("amount", transaction.getAmount());
        obj.put("transactionId", transaction.getExternalId());


        kafkaTemplate.send(TRANSACTION_CREATED_TOPIC, objectMapper.writeValueAsString(obj));

        return transaction.getExternalId();
    }

//    @KafkaListener(topics = {WALLET_UPDATED_TOPIC}, groupId = "jbdl123")
    public void updateTransaction(String msg) throws ParseException, JsonProcessingException {

        JSONObject obj = (JSONObject) new JSONParser().parse(msg);
        String externalTransactionId = (String) obj.get("transactionId");
        String receiverPhoneNumber = (String) obj.get("receiverWalletId");
        String senderPhoneNumber = (String) obj.get("senderWalletId");
        String walletUpdateStatus = (String) obj.get("status");
        Long amount = (Long) obj.get("amount");

        TransactionStatus transactionStatus;

        if(walletUpdateStatus.equals(WALLET_UPDATE_FAILED_STATUS)){
            transactionStatus = TransactionStatus.FAILED;
            transactionRepository.updateTransaction(externalTransactionId, transactionStatus);
        }else{
            transactionStatus = TransactionStatus.SUCCESSFUL;
            transactionRepository.updateTransaction(externalTransactionId, transactionStatus);
        }

        JSONObject senderObj = this.restTemplate.getForObject("http://localhost:9000/user/username/" + senderPhoneNumber, JSONObject.class);
        JSONObject receiverObj = this.restTemplate.getForObject("http://localhost:9000/user/username/" + receiverPhoneNumber, JSONObject.class);

        String senderEmail = senderObj == null ? null : (String)senderObj.get("email");
        String receiverEmail = receiverObj == null ? null : (String)receiverObj.get("email");

        obj = new JSONObject();
        obj.put("transactionId", externalTransactionId);
        obj.put("transactionStatus", transactionStatus.toString());
        obj.put("amount", amount);
        obj.put("senderEmail", senderEmail);
        obj.put("receiverEmail", receiverEmail);
        obj.put("senderPhone", senderPhoneNumber);
        obj.put("receiverPhone", receiverPhoneNumber);


        kafkaTemplate.send(TRANSACTION_COMPLETED_TOPIC, objectMapper.writeValueAsString(obj));
    }

}
