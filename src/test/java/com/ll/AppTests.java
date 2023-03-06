package com.ll;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTests {
    // TestUtil Test Start
    @Test
    @DisplayName("스캐너에 키보드가 아닌 문자열을 입력으로 설정")
    public void t1() {
        Scanner sc = TestUtil.getScanner("Hello World");

        String cmd = sc.nextLine().trim();
        assertThat(cmd).isEqualTo("Hello World");
    }

    @Test
    @DisplayName("출력을 모니터에 하지 않고 문자열로 얻기")
    public void t2() {
        // System.out 에 대한 화면출력 금지 시작
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        System.out.print("안녕");

        // 그 동안 출력되지 않던 내용들을 문자열로 반환
        String rs = output.toString();

        // System.out 에 대한 화면출력 금지 끝
        TestUtil.clearSetOutToByteArray(output);

        assertThat(rs).isEqualTo("안녕");
    }
    // TestUtil Test End

    // App Test Start
    @Test
    @DisplayName("프로그램 시작 시 타이틀 출력 그리고 종료")
    public void t3() {
        Scanner sc = TestUtil.getScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertThat(rs)
                .contains("== 명언 앱 ==")
                .contains("명령) ");

    }

    @Test
    @DisplayName("잘못된 명령어 입력에 대한 처리")
    public void t4() {
        Scanner sc = TestUtil.getScanner("""
                종료2
                종료
                """.stripIndent().trim());
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertThat(rs)
                .contains("올바르지 않은 명령입니다.");
    }
    // App Test End
}
