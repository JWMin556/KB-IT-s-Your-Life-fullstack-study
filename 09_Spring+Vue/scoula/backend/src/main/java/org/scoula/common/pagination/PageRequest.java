package org.scoula.common.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageRequest {
    private int page;  // 요청 페이지
    private int amount;  // 한 페이지당 데이터 수

    public PageRequest() {
        page = 1;
        amount = 0;
    }

    public static PageRequest of(int page, int amount) {
        return new PageRequest(page,amount);
    }

    public int getOffset() {
        return (page - 1) * amount;
    }
}
