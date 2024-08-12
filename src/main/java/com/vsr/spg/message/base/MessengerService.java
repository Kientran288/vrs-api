package com.vsr.spg.message.base;

import com.vsr.spg.config.AsyncTaskConfig;
import org.springframework.scheduling.annotation.Async;

import java.util.Locale;

/**
 * This interface provide the functions the to send the message to users
 */
public interface MessengerService<T extends BaseMessage> {

    /**
     * Send message to users asynchronously
     *
     * @param message
     */
    @Async(AsyncTaskConfig.BEAN_ASYNC_EXECUTOR)
    void sendMessageInAsync(T message);

    @Async(AsyncTaskConfig.BEAN_ASYNC_EXECUTOR)
    void sendMessageInAsync(T message, Locale locale);
}

