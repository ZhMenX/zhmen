package com.shixun.xj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * @author zhMen
 * @createTime 2022/9/19 9:12
 * @ClassName blog
 * @Version v1.0
 * @Description
 */

@Data
@Entity
@Validated
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
