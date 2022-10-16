package com.shixun.xj.entity;

import lombok.Data;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @author zhMen
 * @createTime 2022/10/12 16:49
 * @ClassName Learn
 * @Version v1.0
 * @Description
 */
@Data
@Entity
@Validated
@Table(name = "learn")
public class Learn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lid;


    @Column
    private Integer tid;

    @Column
    @NotBlank(message = "标题不能为空")
    private String title;

    @Column
    @NotBlank(message = "内容不能为空")
    private String content;


}
