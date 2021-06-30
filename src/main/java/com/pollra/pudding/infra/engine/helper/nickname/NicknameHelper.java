package com.pollra.pudding.infra.engine.helper.nickname;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author pollra
 * @description NicknameHelper
 * @since 2021.03.02
 **********************************************************************************************************************/
public class NicknameHelper {
    private static String[] PREFIX_NAMES = {
            "치킨먹는", "꿀잠자는", "똘똘한", "강인한", "신중한"
            , "건강한", "혼돈의", "넘어진", "수수한", "어둠의"
            , "내이름은", "날아다니는", "유혹하는", "사랑에빠진", "아무래도"
            , "내가봐도 난", "걸어다니는", "천상계의", "히히히", "날씬한"
            , "통통한", "사랑스러운", "노래하는", "코딩하는", "사냥꾼에게쫒기는"
            , "커다란", "험상궂은", "섹시한", "뇌절하는", "군대면제받은"
    };
    private static String[] SUFFIX_NAMES = {
            "독수리", "강아지", "고양이", "딱정벌레", "여우"
            , "사마귀", "갈구리무늬꽃수레밤나비", "나비", "민달팽이", "둘리"
            , "비둘기", "매미", "돌고래", "상어", "김밥"
            , "타란튤라", "굳건이", "호돌이", "호랑이", "사자"
            , "오믈렛", "족제비", "바다사자", "피자", "싱하형"
            , "피아노", "고릴라", "유니콘", "키메라", "혼밥족"
    };

    public static String createNickname() {
        int prefixIndex = RandomUtils.nextInt(0, PREFIX_NAMES.length);
        int suffixIndex = RandomUtils.nextInt(0, SUFFIX_NAMES.length);
        return PREFIX_NAMES[prefixIndex] + " "+ SUFFIX_NAMES[suffixIndex];
    }
}
