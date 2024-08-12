package com.vsr.spg.message.email;

import com.vsr.spg.message.base.BaseMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class EmailMessage extends BaseMessage {

    private String template;

    private String subject;

    private String sender;

    private String receiver;

    protected Map<String, String> arguments;

}
