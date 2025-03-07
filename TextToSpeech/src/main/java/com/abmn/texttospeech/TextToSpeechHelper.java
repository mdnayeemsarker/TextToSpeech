package com.abmn.texttospeech;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TextToSpeechHelper implements TextToSpeech.OnInitListener {

    private static String voiceSpeed;
    private final TextToSpeech textToSpeech;
    private boolean isInitialized = false;
    private final List<String> speakQueue = new ArrayList<>();

    public TextToSpeechHelper(Context context, String speed)  {
        textToSpeech = new TextToSpeech(context, this);
        voiceSpeed = speed;
    }

    @Override
    public void onInit(int status) {
        textToSpeech.setSpeechRate(Base.setVoiceSpeed(voiceSpeed));
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language not supported");
            } else {
                isInitialized = true;
                processQueue();
            }
        } else {
            Log.e("TTS", "Initialization failed");
        }
    }

    public void speak(String text) {
        if (isInitialized) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            Log.e("TTS", "TextToSpeech not initialized; queuing text");
            speakQueue.add(text);
        }
    }

    private void processQueue() {
        for (String text : speakQueue) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
        speakQueue.clear();
    }

    public void shutdown() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
