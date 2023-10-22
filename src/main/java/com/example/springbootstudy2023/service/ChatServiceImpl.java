package com.example.springbootstudy2023.service;

import com.example.springbootstudy2023.dto.request.RegisterChatRequestDTO;
import com.example.springbootstudy2023.dto.response.ChatListResponseDTO;
import com.example.springbootstudy2023.repository.ChatRepository;
import com.example.springbootstudy2023.vo.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public Chat registerChat(RegisterChatRequestDTO dto) {
        return chatRepository.save(Chat.of(dto));
    }

    @Override
    public List<ChatListResponseDTO> getChatList(String uuid) {
        if (uuid == null) {
            return chatRepository.findAll()
                    .stream()
                    .map(ChatListResponseDTO::of)
                    .toList();
        }

        return chatRepository.findAllByAfterUuidCreateDate(uuid)
                .stream()
                .map(ChatListResponseDTO::of)
                .toList();
    }
}
