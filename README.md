# 📱 SwiftJoT: Open-Source Note-Taking App for Android

SwiftJoT is an open-source note-taking application specifically designed and **optimized for older Android devices**. It aims to provide a lightweight, simple, and intuitive interface while incorporating advanced functionalities to enhance productivity and accessibility.

---

## ✨ Key Features

SwiftJoT integrates intelligent and versatile features to enrich the note-taking experience:

* **Optimized Performance:** Tailored for older Android devices to ensure compatibility and performance optimization.
* **Intuitive UI/UX:** Built using **Material Design principles** to provide a visually appealing and easy-to-use interface.
* **Note Management System:** Robust functionality to easily create, edit, save, and delete notes, with storage utilizing unique identifiers for data integrity.
* **Text-to-Speech (TTS):** Integrated button functionality allows users to convert note content into speech, enhancing accessibility for users with visual impairments or those preferring auditory input.
* **PDF Upload Feature:** Enables users to seamlessly integrate external PDF documents directly into their notes, expanding the app's versatility and utility.
* **Sketch Mode:** Users can enter a dedicated sketch mode to incorporate drawings, annotations, or illustrations directly within the notes area.
* **To-Do Lists:** Includes functionality for managing to-do lists to improve efficiency.

---

## ⚙️ Development Methodology

The development of the SwiftJoT app strictly followed an **Agile methodology**. This approach ensured iterative development, frequent feedback loops, and flexibility in adapting to requirements.

The application is structured around a clear High-Level Design (HLD) and Low-Level Design (LLD) encompassing modular components:

* **User Interface Module:** Specifies the layout and functionality for viewing, editing, and creating notes.
* **Note Management Module:** Defines algorithms and data structures for storing and retrieving notes.
* **Text-to-Speech Module:** Implements the TTS feature for listening to note contents.
* **Sketch Mode Module:** Defines functionality for sketching and handling tools within the app.
* **PDF Upload Module:** Manages the upload, integration, and rendering of PDF files.

---

## 🚀 Getting Started

Follow these steps to clone and run the SwiftJoT application on your development machine using **Android Studio**.

### Prerequisites

* **Android Studio:** The latest stable version installed.
* **Git:** Installed on your system.
* An **Android Device or Emulator** to run the application.

### Setup Instructions

1.  **Clone the Repository**
    Open your terminal or command prompt and clone the project files:
    ```bash
    git clone [https://github.com/the-rajanand/SwiftJoT-NotesApp.git](https://github.com/the-rajanand/SwiftJoT-NotesApp.git)
    cd SwiftJoT-NotesApp
    ```

2.  **Open in Android Studio**
    * Launch **Android Studio**.
    * Select **"Open an existing Android Studio project"** (or use `File > Open...`).
    * Navigate to the directory where you cloned the repository (`SwiftJoT-NotesApp`) and select the project folder.

3.  **Sync Gradle**
    * Android Studio will automatically detect the Gradle files and prompt you to **sync the project**. Allow the sync to complete to download all necessary dependencies.
    * *(Note: If the sync fails, check the Android SDK version settings in your `build.gradle` file against your installed SDKs.)*

4.  **Run the Application**
    * Select your target device from the dropdown menu (either a physical device connected via USB or an AVD emulator).
    * Click the **"Run"** button (green play icon) in the toolbar.
    * Android Studio will build and install the SwiftJoT app on your selected device/emulator.

---

## 🔬 Future Scope

Future developments planned for SwiftJoT include:

* Notes synchronization across devices.
* Development of a web interface for note management.
* Evaluation of potential integration with Google Now for voice command functionality.

---

## 👤 Author

* **Raj Anand**
