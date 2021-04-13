package com.pollra.pudding.common.engine.exception;

public enum ExceptionCode {

    /**
     * 샘플
     */
    SAMPLE_01 // 샘플 exception

    /**
     * 공통
     */
    ,E00010001  // 유효성 검사에 실패하였습니다
    ,E00010002  // 해당 정보를 찾을 수 없습니다

    /**
     * JWT
     */
    ,E00020001  // Token 조작을 감지하였습니다
    ,E00020002  // 인증에 실패하였습니다
    ,E00020003  // 지원하지 않는 인코딩 입니다

    /**
     * AUTH
     */
    ,E00030001  // 검증에 실패하였습니다
    ,E00030002  // 권한이 부족합니다
    ,E00030003  // 해당 권한을 찾을 수 없습니다
}
