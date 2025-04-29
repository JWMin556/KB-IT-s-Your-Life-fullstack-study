package ch15.sec02.exam01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Board {
    private String subject;
    private String content;
    private String writer;
}
