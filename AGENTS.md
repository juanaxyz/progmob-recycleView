# AGENTS.md – Repository Quick‑Start

**Purpose** – Capture the non‑obvious commands and conventions that an OpenCode agent would otherwise miss.

---

## Build & Run
- Always use the Gradle wrapper: `./gradlew` (Unix) or `gradlew.bat` (Windows). Do **not** invoke a globally‑installed Gradle.
- Assemble a debug APK: `./gradlew assembleDebug`
- Install & launch on a connected device or emulator: `./gradlew installDebug`
- Full build (compile, unit tests, instrumented tests, apk): `./gradlew build`
- Clean build directory: `./gradlew clean`

## Testing
- **Unit tests** (run for the `app` module): `./gradlew test`
- **Instrumented (UI) tests** on a device/emulator: `./gradlew connectedAndroidTest`
- Run a **single unit test** (replace the class name):
  ```
  ./gradlew testDebugUnitTest --tests "com.example.recyclerviewapp.ExampleUnitTest"
  ```
- Run a **single instrumented test**:
  ```
  ./gradlew connectedDebugAndroidTest --tests "com.example.recyclerviewapp.ExampleInstrumentedTest"
  ```

## Lint & Static Checks
- Lint task (if enabled by the Android plugin): `./gradlew lint`
- No custom code‑style tools are configured; Kotlin follows the **official** style (`kotlin.code.style=official`).

## Project Layout & Entry Points
- Root project name: **RecyclerViewApp** (defined in `settings.gradle.kts`).
- Single Android module: `:app`
- Application entry point: `app/src/main/java/com/example/recyclerviewapp/MainActivity.kt`
- Layout resource for the activity: `app/src/main/res/layout/activity_main.xml`

## Dependency Management
- Versions are declared in `gradle/libs.versions.toml` and referenced via the **Version Catalog** (`libs.xxx`).
- To add a new library, update the TOML file and sync Gradle; no hard‑coded versions appear elsewhere.

## IDE / SDK Setup
- Android Studio is the expected IDE. After opening the project, click **Sync Project with Gradle Files**.
- The wrapper does **not** include the Android SDK path. Ensure `local.properties` (git‑ignored) contains:
  ```
  sdk.dir=/path/to/Android/sdk
  ```
  (Create the file manually if missing.)

## Gradle Daemon Settings
- JVM args are set in `gradle.properties`:
  ```
  org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
  ```
  Adjust only if builds run out of memory.

## Common Gotchas
- The `.gitignore` excludes `local.properties`; forgetting to create it will cause Gradle sync failures.
- Use the wrapper (`./gradlew`) for **all** Gradle commands; invoking a system‑wide Gradle can lead to version mismatches.
- The project uses the **Kotlin DSL** (`*.kts`). When editing build scripts, keep the syntax consistent.

---

*This file is intentionally concise – it captures only the repository‑specific shortcuts an agent would otherwise have to guess.*