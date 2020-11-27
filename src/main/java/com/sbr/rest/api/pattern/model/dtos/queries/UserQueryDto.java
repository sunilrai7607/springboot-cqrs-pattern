package com.sbr.rest.api.pattern.model.dtos.queries;

import lombok.Data;

@Data
public class UserQueryDto {

    private String userId;

    private String username;

    private boolean enabled;

    private long scheduledPostsCount;
}
