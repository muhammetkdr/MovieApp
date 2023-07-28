<h1 align="center">MovieApp</h1></br>
<p align="center">  
This is a MovieApp that you can see Top Rated Movies and Movie Details with Multi Module and Clean Architecture
</p>

## Prerequisite
- API Key, to run the application, an API key from [The Movie Database](https://www.themoviedb.org/) should be supplied and added following variable to local environment:
`` API_KEY = "Your API Key" ``

## Screenshots Light & Dark Mode
<p align="center">
<img src="https://github.com/mskdr/MovieApp/assets/71526845/a2c78800-f9f3-4e8f-be50-66d9253420d9" width="150">
<img src="https://github.com/mskdr/MovieApp/assets/71526845/0ec481fa-1409-4557-bb7d-aa930e3a311e" width="150">
  
<img src="https://github.com/mskdr/MovieApp/assets/71526845/754c752d-f720-4511-898f-78230d232954" width="150">
<img src="https://github.com/mskdr/MovieApp/assets/71526845/1206f895-989c-4f3f-aef0-170699eafc55" width="150">

## Unit Testing
Unit tests are type of automated test that focuses on testing a small unit of code in isolation. The purpose of a unit test is to verify the correctness of individual units of code, such as functions or methods, by testing them in isolation from the rest of the system.

Unit tests have been added for domain and data module.

## Architecture
This app uses MVVM (Model-View-ViewModel) Clean Architecture

![](https://user-images.githubusercontent.com/71526845/227383042-8799f8bb-3c4e-4756-bca0-c1972f5690fb.png)

## Some of the technologies and libraries which i used in the app 🛠
- Minimum SDK level 24
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) and [Flow](https://developer.android.com/kotlin/flow)
- [Android Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency Injection Library
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- [OkHttp](https://square.github.io/okhttp/) An HTTP client that efficiently make network requests
- <a href="https://github.com/square/moshi">Moshi</a> to serialize and deserialize JSON data when communicating with web services or when storing data locally
- <a href="https://developer.android.com/topic/libraries/architecture/paging/v3-overview?hl=tr">Paging3</a> a library that simplifies efficient pagination in RecyclerViews, enabling smooth scrolling and loading large data sets in a paginated manner. 
- <a href="https://developer.android.com/topic/libraries/architecture/navigation/">Navigation</a> to manage fragments
- <a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a> This is a kind of storage for UI related data which you can save from UI changes(like configuration change)
- <a href="https://developer.android.com/topic/libraries/data-binding">Data Binding</a> to connect views in your layout to data sources in your app's architecture.
- <a href="https://developer.android.com/topic/libraries/view-binding">View Binding</a> a generated binding class is created for each XML layout file in your app
- <a href="https://bumptech.github.io/glide">Glide</a> Popular open-source library for loading and caching images in Android applications.
- Testing
  - [Mockito](https://site.mockito.org/) A mocking framework that tastes really good. It lets you write beautiful tests with a clean & simple API
  - [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) A scriptable web server for testing HTTP clients
  - [Truth](https://truth.dev/) A library for performing assertions in tests
  - [Turbine](https://github.com/cashapp/turbine) A small testing library for kotlinx.coroutines Flow
    
## Contact With Me  
<p align="left">
<a href="https://www.linkedin.com/in/muhammet-k%C3%BCd%C3%BCr/" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="muhammetküdür" height="30" width="40" /></a>
</p>
