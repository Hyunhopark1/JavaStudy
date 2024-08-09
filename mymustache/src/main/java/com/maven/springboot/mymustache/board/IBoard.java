package com.softagape.mustacheajax.board;

public interface IBoard {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    String getContent();
    void setContent(String content);

    Integer getViewQty();
    void setViewQty(Integer viewQty);

    Integer getLikeQty();
    void setLikeQty(Integer likeQty);

    String getDelFlag();
    void setDelFlag(String delFlag);

    String getCreateDt();
    void setCreateDt(String createDt);

    String getCreateId();
    void setCreateId(String createId);

    String getUpdateDt();
    void setUpdateDt(String updateDt);

    String getUpdateId();
    void setUpdateId(String updateId);

    String getDeleteDt();
    void setDeleteDt(String deleteDt);

    String getDeleteId();
    void setDeleteId(String deleteId);

    default void copyFields(IBoard from) {
        if (from == null) {
            return;
        }
        if (from.getId() != null) {
            this.setId(from.getId());
        }
        if (from.getName() != null && !from.getName().isEmpty()) {
            this.setName(from.getName());
        }
        if (from.getContent() != null && !from.getContent().isEmpty()) {
            this.setContent(from.getContent());
        }
        if (from.getViewQty() != null) {
            this.setViewQty(from.getViewQty());
        }
        if (from.getLikeQty() != null) {
            this.setLikeQty(from.getLikeQty());
        }
        if (from.getDelFlag() != null && !from.getDelFlag().isEmpty()) {
            this.setDelFlag(from.getDelFlag());
        }
        if (from.getCreateDt() != null && !from.getCreateDt().isEmpty()) {
            this.setCreateDt(from.getCreateDt());
        }
        if (from.getCreateId() != null && !from.getCreateId().isEmpty()) {
            this.setCreateId(from.getCreateId());
        }
        if (from.getUpdateDt() != null && !from.getUpdateDt().isEmpty()) {
            this.setUpdateDt(from.getUpdateDt());
        }
        if (from.getUpdateId() != null && !from.getUpdateId().isEmpty()) {
            this.setUpdateId(from.getUpdateId());
        }
        if (from.getDeleteDt() != null && !from.getDeleteDt().isEmpty()) {
            this.setDeleteDt(from.getDeleteDt());
        }
        if (from.getDeleteId() != null && !from.getDeleteId().isEmpty()) {
            this.setDeleteId(from.getDeleteId());
        }
    }
}
