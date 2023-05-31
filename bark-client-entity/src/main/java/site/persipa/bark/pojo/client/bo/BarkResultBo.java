package site.persipa.bark.pojo.client.bo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import site.persipa.bark.converter.TimeStampConverter;

import java.time.LocalDateTime;

/**
 * @author persipa
 */
@Data
public class BarkResultBo {

    private int code;

    private String message;

    @JsonDeserialize(converter = TimeStampConverter.class)
    private LocalDateTime timestamp;
}
