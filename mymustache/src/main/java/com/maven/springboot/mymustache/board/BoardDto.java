package com.softagape.mustacheajax.board;

import com.softagape.mustacheajax.commons.dto.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto extends BaseDto implements IBoard {
    private Long id;
    private String name;
    private String content;
    private Integer viewQty;
    private Integer likeQty;
    private String delFlag;
}
