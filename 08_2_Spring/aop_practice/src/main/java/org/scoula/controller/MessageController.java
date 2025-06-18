package org.scoula.controller;

import org.scoula.dto.MessageDTO;
import org.scoula.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO dto){
        String result = messageService.sendMessage(dto);
        return ResponseEntity.ok(result);
    }
}
