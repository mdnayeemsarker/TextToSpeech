package com.abmn.texttospeech;

public class Base {
    public static float setVoiceSpeed(String speed) {
        return switch (speed.toLowerCase()) {
            case "slower" -> 0.5f;
            case "slow" -> 0.7f;
            case "normal" -> 1.0f;
            case "fast" -> 1.5f;
            case "faster" -> 2.0f;
            default -> Float.parseFloat(speed);
        };
    }
}
