package com.abmn.texttospeech;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class TextToSpeechHelper implements TextToSpeech.OnInitListener {

    private static TextToSpeechHelper instance;
    private final TextToSpeech textToSpeech;
    private boolean isInitialized = false;
    private final List<String> speakQueue = new ArrayList<>(); // Queue for requests during initialization

    // Private constructor
    private TextToSpeechHelper(Context context) {
        textToSpeech = new TextToSpeech(context, this);
    }

    // Singleton instance
    public static synchronized TextToSpeechHelper getInstance(Context context) {
        if (instance == null) {
            instance = new TextToSpeechHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language not supported");
            } else {
                textToSpeech.setSpeechRate(Base.getVoiceSpeed());
                setVoice(Base.getVoiceGender());
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
        instance = null;
    }
    private void setVoice(String gender) {
        if (textToSpeech != null) {
            Set<Voice> voices = textToSpeech.getVoices();
            Voice selectedVoice = null;

            for (Voice voice : voices) {
                String voiceName = voice.getName().toLowerCase();
                if (gender.equalsIgnoreCase("male") && (voiceName.contains("male") || voiceName.contains("man"))) {
                    selectedVoice = voice;
                    break;
                } else if (gender.equalsIgnoreCase("female") && (voiceName.contains("female") || voiceName.contains("woman"))) {
                    selectedVoice = voice;
                    break;
                }
            }

            if (selectedVoice != null) {
                textToSpeech.setVoice(selectedVoice);
                Log.e("TTSG", "Requested voice gender found");
            } else {
                Log.e("TTSG", "Requested voice gender not found, using default." + Base.getVoiceGender());
            }
        }
    }

}
