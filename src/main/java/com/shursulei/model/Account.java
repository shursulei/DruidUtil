package com.shursulei.model;

/**
 * @auther shursulei
 * @Email 1368455669@qq.com
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    private Long id;
    private String name;
    private Integer age;
    private String phone;
    private String address;

}