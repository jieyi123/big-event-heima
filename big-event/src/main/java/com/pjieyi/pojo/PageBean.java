package com.pjieyi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author pjieyi
 * @Description  分页对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean <T> {
    private Long total;
    private List<T> items;
}
