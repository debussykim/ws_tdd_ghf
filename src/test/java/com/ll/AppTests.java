package com.ll;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTests {
    @Test
    @DisplayName("스캐너에 키보드가 아닌 문자열을 입력으로 설정")
    public void t1() {
        Scanner sc = TestUtill.getScanner("Hello World");

        String cmd = sc.nextLine().trim();
        assertThat(cmd).isEqualTo("Hello World");
    }
}
