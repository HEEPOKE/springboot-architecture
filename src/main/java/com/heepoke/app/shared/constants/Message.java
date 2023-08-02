package com.heepoke.app.shared.constants;

import com.heepoke.app.domain.enums.MessageConstants;

public class Message {

    private Message() {
    }
    
    public static final MessageConstants SUCCESS = MessageConstants.SUCCESS;
    public static final MessageConstants FAILED = MessageConstants.FAILED;
    public static final MessageConstants NOT_FOUND = MessageConstants.NOT_FOUND;
    public static final MessageConstants DUPLICATE = MessageConstants.DUPLICATE;
    public static final MessageConstants INVALID = MessageConstants.INVALID;
}