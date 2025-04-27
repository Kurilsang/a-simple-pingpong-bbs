package com.easyjava.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String userId;
    private String nickName;
    private String avatar;
    private String content;
    private String parentCommentId;
    private Date createdAt;
}
