# Simple Quiz App - Android

A straightforward and interactive Android quiz application built with Kotlin. Users can enter their name, answer a series of multiple-choice questions, track their progress, and view their final score on a dedicated results screen. The app demonstrates fundamental Android development concepts including Activity lifecycle management, UI creation with XML, Intent-based navigation, and basic state management.

## Table of Contents
* [Features](#features)
* [App Flow](#app-flow)
* [Screenshots](#screenshots)
* [Technologies Used](#technologies-used)
* [Setup & Installation](#setup--installation)
* [How to Use](#how-to-use)
* [Code Structure](#code-structure)
* [License](#license)

## Features
*   **User Name Input:** Personalizes the quiz experience by asking for the user's name.
*   **Multiple-Choice Questions:** Presents questions with distinct answer options.
*   **Sequential Question Navigation:** Users progress through questions one by one.
*   **Interactive Answer Selection:** Options change appearance when selected.
*   **Immediate Feedback:** After checking an answer, visual cues indicate if it was correct or incorrect.
*   **Progress Tracking:** A `ProgressBar` and text display the current question number out of the total.
*   **Score Calculation:** Points are tallied for correct answers.
*   **Dedicated Results Screen:** Clearly shows the user's name and their final score.
*   **Navigation:** Smooth transitions between welcome, quiz, and result screens.
*   **Input Validation:** Ensures a name is entered before starting the quiz.

## App Flow
1.  **Main Activity (`MainActivity.kt`):**
    *   User enters their name in an `EditText`.
    *   User clicks the "Start" button.
    *   If the name is not empty, it navigates to `QuestionActivity`, passing the user's name.
2.  **Question Activity (`QuestionActivity.kt`):**
    *   Displays questions one by one from a predefined list (`Constants.getQuestions()`).
    *   User selects an option.
    *   User clicks "CHECK" to validate the answer. Correct/incorrect feedback is shown.
    *   User clicks "NEXT" (or "FINISH" on the last question) to proceed.
    *   Score is updated.
    *   Once all questions are answered, it navigates to `ResultActivity`, passing the user's name, score, and total questions.
3.  **Result Activity (`ResultActivity.kt`):**
    *   Displays the user's name and their score.
    *   Provides a "FINISH" button to navigate back to `MainActivity`, allowing for a new quiz attempt.

## Screenshots
*(It's highly recommended to add screenshots of each main activity: MainActivity, QuestionActivity (during quiz), and ResultActivity. Replace paths below.)*

![Welcome/Main Screen](path/to/your/screenshot_main.png)
*Caption: User name input screen.*

![Question Screen](path/to/your/screenshot_question.png)
*Caption: Active quiz question with options and progress bar.*

![Results Screen](path/to/your/screenshot_results.png)
*Caption: Final score display.*

## Technologies Used
*   **Language:** Kotlin
*   **Platform:** Android SDK (e.g., Min API 24, Target API 33 - *Adjust as needed*)
*   **UI/UX:**
    *   XML for layouts (`activity_main.xml`, `activity_question.xml`, `activity_result.xml`)
    *   Material Design Components: `Button`, `TextView`, `EditText`, `ProgressBar`.
    *   `ContextCompat` for accessing resources (colors, drawables).
    *   Custom Drawable Resources for styling option states (e.g., `option_border_bg.xml`, `selected_option_border_bg.xml`, etc.).
    *   Dynamic UI updates (changing text, backgrounds, `ProgressBar` progress).
    *   `Typeface` for text styling.
    *   Basic input validation with `Toast` messages.
*   **Android Core Components:**
    *   `AppCompatActivity` as the base for screens.
    *   Explicit `Intent` for navigation between Activities.
    *   Passing data between Activities using `Intent.putExtra()` (user name, score, total questions).
    *   `View.OnClickListener` interface for handling button and option clicks.
    *   Managing Activity lifecycle (e.g., calling `finish()` to remove Activities from the back stack).
*   **Data Handling:**
    *   Static `Constants.kt` object to provide quiz questions (demonstrates separation of data).
    *   `Questions.kt` data class to model individual quiz questions.
    *   Local variable state management within Activities (e.g., `currentPosition`, `score`, `answered`).
*   **Build Tool:** Gradle
*   **IDE:** Android Studio

## Setup & Installation

To get a local copy up and running, follow these simple steps:

1.  **Clone the repository:**
    
