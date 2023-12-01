package com.ed.kafka.pojo;

import java.time.LocalDateTime;

public record Message(
        String content,
        String from,
        LocalDateTime publishAt
) {
}
