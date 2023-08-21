package com.example.img302.common.enums.converter;

import com.example.img302.common.enums.UserType;
import jakarta.persistence.AttributeConverter;

/**
 * @author liushidai
 */
public class UserTypeConverter implements AttributeConverter<UserType, Byte> {


    @Override
    public Byte convertToDatabaseColumn(UserType userType) {
        return userType.getCode();
    }

    @Override
    public UserType convertToEntityAttribute(Byte code) {
        return UserType.fromValue(code);
    }
}
