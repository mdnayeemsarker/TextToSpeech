package com.abmn.texttospeech;

public class Config {

    private static float voiceSpeed = 1.0f;
    private static String voiceGender = "female";

    public static void setVoiceSpeed(String speed) {
        switch (speed.toLowerCase()) {
            case "slower":
                voiceSpeed = 0.5f;
                break;
            case "slow":
                voiceSpeed = 0.7f;
                break;
            case "normal":
                voiceSpeed = 1.0f;
                break;
            case "fast":
                voiceSpeed = 1.5f;
                break;
            case "faster":
                voiceSpeed = 2.0f;
                break;
            default:
                try {
                    voiceSpeed = Float.parseFloat(speed);
                } catch (NumberFormatException e) {
                    voiceSpeed = 1.0f;
                }
                break;
        }
    }

    public static float getVoiceSpeed() {
        return voiceSpeed;
    }

    public static void setVoiceGender(String gender) {
        voiceGender = gender.toLowerCase();
    }

    public static String getVoiceGender() {
        return voiceGender;
    }
}
