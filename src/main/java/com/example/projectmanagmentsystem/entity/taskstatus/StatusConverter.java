package com.example.projectmanagmentsystem.entity.taskstatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status,Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return status == null ? null: status.getStatusId();
    }

    @Override
    public Status convertToEntityAttribute(Integer integer) {
        return integer == null ? null : Status.findByStatusId(integer);
    }
}
