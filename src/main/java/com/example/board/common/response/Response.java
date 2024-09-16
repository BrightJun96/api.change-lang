package com.example.board.common.response;

/**
 * 응답 객체
 */
public record Response<T>(
    boolean isSuccess,
    T data,
    String message
) {


    // 성공 시 메시지 없이 응답
    public static <T> Response<T> ok(T data) {
        return new Response<>(
                true,
                data,
                null // 메시지 없음
        );
    }

    // 성공 시 메시지를 포함한 응답
    public static <T> Response<T> ok(T data, String message) {
        return new Response<>(
                true,
                data,
                message // 메시지 포함
        );
    }

    // 실패 시 메시지만 포함한 응답
    public static <T> Response<T> fail(String message) {
        return new Response<>(
                false,
                null, // 실패 시 데이터는 없을 수 있음
                message // 실패 메시지
        );
    }
}
