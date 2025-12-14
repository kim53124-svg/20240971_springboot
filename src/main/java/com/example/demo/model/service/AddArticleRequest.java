package com.example.demo.model.service; // 이 파일의 패키지 경로

import com.example.demo.model.domain.Board; // Board 패키지 경로에 맞게 수정
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class AddArticleRequest {

    private String title;
    private String content;
    private String user;
    private String newdate;
    private String count;
    private String likec;

    // DTO를 Board 엔티티로 변환하는 메서드
    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .user(user)
                .newdate(newdate)
                .count(count)
                .likec(likec)
                .build();
    }
}