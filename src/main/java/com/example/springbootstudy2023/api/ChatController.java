package com.example.springbootstudy2023.api;

import com.example.springbootstudy2023.dto.request.RegisterChatRequestDTO;
import com.example.springbootstudy2023.dto.response.ChatListResponseDTO;
import com.example.springbootstudy2023.dto.response.ResultResponseDTO;
import com.example.springbootstudy2023.service.ChatService;
import com.example.springbootstudy2023.vo.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/writeMessage")
    public ResponseEntity<?> sendChat(@RequestBody RegisterChatRequestDTO dto) {

        log.info("/chat/writeMessage : POST!!");

        Chat registeredChat = chatService.registerChat(dto);

        if (registeredChat == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ResultResponseDTO.builder()
                .resultCode("S-1")
                .msg("성공")
                .data(new Object(){
                    private final String uuid = registeredChat.getUuid();

                    public String getUuid() {
                        return uuid;
                    }
                })
                .build()
        );
    }

    @GetMapping("/message")
    public ResponseEntity<?> getChatList(String fromUuid) {

        log.info("/chat/message?fromUuid={} : GET!!", fromUuid);

        return ResponseEntity.ok(ResultResponseDTO.builder()
                .resultCode("S-1")
                .msg("성공")
                .data(new Object(){
                    private final List<ChatListResponseDTO> messages = chatService.getChatList(fromUuid);

                    public List<ChatListResponseDTO> getMessages() {
                        return messages;
                    }
                }).build());
    }

}
