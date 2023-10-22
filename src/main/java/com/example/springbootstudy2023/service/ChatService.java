package com.example.springbootstudy2023.service;

import com.example.springbootstudy2023.dto.request.RegisterChatRequestDTO;
import com.example.springbootstudy2023.dto.response.ChatListResponseDTO;
import com.example.springbootstudy2023.vo.Chat;

import java.util.List;

public interface ChatService {

    Chat registerChat(RegisterChatRequestDTO dto);

    List<ChatListResponseDTO> getChatList(String fromUuid);
}
