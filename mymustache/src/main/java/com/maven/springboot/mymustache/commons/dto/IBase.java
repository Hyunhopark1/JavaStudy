package com.maven.springboot.mymustache.commons.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface IBase {
    String getCreateDt();
    void setCreateDt(String createDt);

    Long getCreateId();
    void setCreateId(Long createId);

    String getCreateName();
    void setCreateName(String createName);

    String getUpdateDt();
    void setUpdateDt(String updateDt);

    String getUpdateName();
    void setUpdateName(String updateName);

    Long getUpdateId();
    void setUpdateId(Long updateId);

    String getDeleteDt();
    void setDeleteDt(String deleteDt);

    Long getDeleteId();
    void setDeleteId(Long deleteId);

    String getDeleteName();
    void setDeleteName(String deleteName);

    Boolean getDeleteFlag();
    void setDeleteFlag(Boolean deleteFlag);

    default void copyFields(IBase from) {
        if (from == null) {
            return;
        }
        if (from.getCreateDt() != null && !from.getCreateDt().isEmpty()) {
            this.setCreateDt(from.getCreateDt());
        }
        if (from.getCreateId() != null) {
            this.setCreateId(from.getCreateId());
        }
        if (from.getUpdateDt() != null) {
            this.setUpdateDt(from.getUpdateDt());
        }
        if (from.getUpdateId() != null) {
            this.setUpdateId(from.getUpdateId());
        }
        if (from.getDeleteDt() != null ) {
            this.setDeleteDt(from.getDeleteDt());
        }
        if (from.getDeleteId() != null ) {
            this.setDeleteId(from.getDeleteId());
        }
        if (from.getDeleteFlag() != null) {
            this.setDeleteFlag(from.getDeleteFlag());
        }
    }

    default String getSystemDt() {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(today);
    }

    default void setCreateInfo(Long userId) {
        this.setCreateDt(this.getSystemDt());
        this.setCreateId(userId);
    }

    default void setUpdateInfo(Long userId) {
        this.setUpdateDt(this.getSystemDt());
        this.setUpdateId(userId);
    }

    default void setDeleteInfo(Long userId) {
        this.setDeleteDt(this.getSystemDt());
        this.setDeleteId(userId);
    }
}
