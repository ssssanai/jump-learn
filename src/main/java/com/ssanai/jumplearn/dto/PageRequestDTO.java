package com.ssanai.jumplearn.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.index.qual.Positive;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import java.net.URLEncoder;

@Log4j2
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageRequestDTO {
    @Builder.Default
    @Positive
    @Min(value=1)
    private int page_no=1;
    @Builder.Default
    @Positive
    @Min(value=1)
    private int page_size=10;
    @Builder.Default
    @PositiveOrZero
    @Min(value=0)
    private int page_skip_count=0;
    @Builder.Default
    @Positive
    @Min(value=1)
    private int page_block_size=10;

    private String search_category;
    private String search_word;
    private String search_date_from;
    private String search_date_to;
    private String linkParams;

    private String sort_order; // 정렬 기준
    private String search_target; // 검색할 게시판

    public int getPage_skip_count() {
        return (this.page_no-1)*this.page_size;
    }

    public String getLinkParams(){
        StringBuffer sb = new StringBuffer();
        //sb.append("page_no="+this.page_no);
        sb.append("page_size="+this.page_size);

        if ( this.search_category != null ){
            sb.append("&search_category="+this.search_category);
        }
        if ( this.search_word != null ){
            try{
                sb.append("&search_word="+ URLEncoder.encode(this.search_word, "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ( this.search_date_from != null ){
            sb.append("&search_date_from="+this.search_date_from);
        }
        if ( this.search_date_to != null ){
            sb.append("&search_date_to="+this.search_date_to);
        }

        return sb.toString();
    }
}