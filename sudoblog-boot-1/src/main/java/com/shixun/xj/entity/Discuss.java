package com.shixun.xj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhMen
 * @createTime 2022/9/22 9:30
 * @ClassName Discuss
 * @Version v1.0
 * @Description
 */
@Data
@Entity
@Validated
public class Discuss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dsId;


    @Column
    private Integer blogId;

    @Column
    private Integer userId;

    @Column
    @NotBlank(message = "标题不能为空")
    private String title;

    @Column
    @NotBlank(message = "摘要不能为空")
    private String description;

    @Column
    @NotBlank(message = "内容不能为空")
    private String content;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

}
