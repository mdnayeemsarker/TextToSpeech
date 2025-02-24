# Text To Speech
> This is an Simple and more easy android library where you can you use for click to play english word. 

## Installation TextToSpeech

//Add it in your root build.gradle at the end of repositories:

```bash
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
```

Add Dependency Just go to your build.gradle Module:

//Add the dependency
dependencies {
```bash
	implementation 'com.github.mdnayeemsarker:TextToSpeech:1.0.3'
```
}

How to use:

// before onCreate

```bash

    private TextToSpeechHelper ttsHelper; //before oncreate
    //if you want to change the speed in activity then initialize this befole initialize ttsHelper
    Base.setVoiceSpeed("slow");//you can controll this way to text to speech speed "slower", "slow", "normal", "fast", "faster"
    ttsHelper = new TextToSpeechHelper(this, "slower"); //in oncreate, you can controll this way to text to speech speed "slower", "slow", "normal", "fast", "faster"
    
    ttsHelper.speak("Hello World"); //use look like this
```

## Getting To Know NAYEEM
 * Feel free to [learn more about MD NAYEEM SARKER](https://github.com/mdnayeemsarker).

## License

MIT © [MD NAYEEM SARKER](https://github.com/mdnayeemsarker)
