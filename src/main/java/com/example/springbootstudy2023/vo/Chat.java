package com.example.springbootstudy2023.vo;

import com.example.springbootstudy2023.dto.request.RegisterChatRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;
    @CreationTimestamp
    private LocalDateTime createDate;
    private String authorName;
    private String content;

    private Chat(RegisterChatRequestDTO dto) {
        this.authorName = dto.authorName();
        this.content = dto.content();
    }

    public static Chat of(RegisterChatRequestDTO dto) {
        return new Chat(dto);
    }

}
