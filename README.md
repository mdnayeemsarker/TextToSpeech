# Ultimate UltraCalculator
> This is an Simple and more easy android library where you can find many calculation. 

## Installation Ultimate UltraCalculator

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
	implementation 'com.github.mdnayeemsarker:TextToSpeech:1.0.1'
```
}

How to use:

// before onCreate
```bash
    private TextToSpeechHelper ttsHelper; //before oncreate
    
    ttsHelper = TextToSpeechHelper.getInstance(this); //in oncreate
    
    ttsHelper.speak("Hello World"); //use
```

## Getting To Know NAYEEM
 * Feel free to [learn more about MD NAYEEM SARKER](https://github.com/mdnayeemsarker).

## License

MIT © [MD NAYEEM SARKER](https://github.com/mdnayeemsarker)
