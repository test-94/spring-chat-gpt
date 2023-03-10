package com.synechron.springchatgpt.controller;

import com.synechron.springchatgpt.dto.ResponseModel;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    private ChatgptService chatgptService;

    @GetMapping("/send")
    public ResponseModel send(@RequestParam String message) {
        try {
            String responseMessage = chatgptService.sendMessage(message);
            return ResponseModel.success(responseMessage);
        } catch (Exception e) {
            return new ResponseModel(500, "error", e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseModel home(){
        return new ResponseModel(200, "Success", "Application now is up and running");
    }


}
