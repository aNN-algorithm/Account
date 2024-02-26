package com.example.Account_ann.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfo {
    // 클라이언트와 프로그램 사이
    private String accountNumber;
    private Long balance;

}
