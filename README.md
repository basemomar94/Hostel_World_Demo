### Hostel World Demo app

### Architecture
The app follows the MVVM (Model-View-ViewModel) architecture, ensuring separation of concerns and a maintainable codebase:

* Model: Represents the data models.
* use cases:  Encapsulate the application's business logic and orchestrate data flow from repositories to the ViewModel.
* ViewModel: Manages UI-related data and business logic in a lifecycle-aware manner.
* View (Jetpack Compose): The UI layer is entirely built using Jetpack Compose.
* Repository: Acts as an intermediary between the UseCase and the data source.

### Used Libraries 
* Kotlin
* Jetpack Compose for ui.
* Navigation Component
* Hilt for Dependency Injection
* Retrofit for network communication
* Kotlin Coroutines & Flow
* MockK,JUnit5 for testing
* Glide for loading images.

### Key Implementations
* Error Handling
* State Management: Using StateFlow.
* Dependency Injection: Using Hilt.

### Testing Strategy
* Unit Tests: Test business logic using JUnit and MockK.
* Instrumented Tests: Tests for the Room Database.
* UI Tests: Verify the behavior of the UI using Espresso and Compose Test.
