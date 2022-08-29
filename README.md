# 🗺 Android Native Clean MVVM Template

This create the boilerplate code for the Android Native application with Clean MVVM architecture. This contains all the recommended components listed below:

- App has been built on MVVM architecture
- All codebase in Kotlin
- Hilt for DI
- Retrofit for Networking
- Coroutines for async operations
- Use Cases for converting responses DTOs into useful models
- BaseUseCase enforces SRP by allowing only 1 input and 1 output in 1 use case class
- Base Test has some utility setup to run unit tests that use coroutines
- All strings are in xml
- No hardcoded dimens
- All dependencies are injected and follow dependency inversion
- Unit tests written for ViewModel and UseCase layers, they contain the main app logic
- NavGraph is used to navigate between home -> details pages, with safe args
- UI specific logic are mostly delegated to custom view binding adapters and used in databinding
