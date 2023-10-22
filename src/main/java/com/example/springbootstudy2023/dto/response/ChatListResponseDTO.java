package com.example.springbootstudy2023.dto.response;


import com.example.springbootstudy2023.vo.Chat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatListResponseDTO {

    private Chat chat;

    public static ChatListResponseDTO of(Chat chat) {
        return new ChatListResponseDTO(chat);
    }

}
