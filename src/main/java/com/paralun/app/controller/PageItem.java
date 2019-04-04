package com.paralun.app.controller;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageItem {
    private int number;
    private boolean current;
}
