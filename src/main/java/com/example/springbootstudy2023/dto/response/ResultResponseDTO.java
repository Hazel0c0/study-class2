package com.example.springbootstudy2023.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultResponseDTO {

    private String resultCode;
    private String msg;
    private Object data;

}
