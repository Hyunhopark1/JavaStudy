package com.softagape.mustacheajax.board;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest implements IBoard {
    @Null
    private Long id;

    @NotNull
    @Size(min=2, max=50)
    private String name;

    @NotNull
    @Size(min=2, max=1000)
    private String content;

    @Null
    private Integer viewQty;

    @Null
    private Integer likeQty;

    @Null
    private String createDt;

    @Null
    private String createId;

    @Null
    private String updateDt;

    @Null
    private String updateId;

    @Null
    private String deleteDt;

    @Null
    private String deleteId;

    @Null
    private String delFlag;
}
