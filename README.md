# Mobile Application Development - Assignment 5: Working with Multiple Activities

A simple Android application developed in **Android Studio** using **Java**. The main objective of this assignment is to understand the concept of multiple activities, explicit intents, data passing between screens, activity stack management, and gesture-based navigation (*Swipe Gestures*).

## 🚀 Features

The application consists of three main screens (Activities):

1. **MainActivity (Main Screen):**
   * Displays a counter and a `Count` button to increment the value.
   * Includes two navigation buttons to trigger explicit intents toward `HelloActivity` and `ThirdActivity`.
   * Passes the current counter value dynamically to the sub-activities.
   * Updates the counter value when returning from other screens without duplicating instances.

2. **HelloActivity (Second Screen):**
   * Displays the text *Hello!* along with the current counter value transferred from the main activity.
   * Provides a button to navigate back to `MainActivity`.

3. **ThirdActivity (Third Screen):**
   * Displays the text *Activity 3* and the current counter value.
   * **Button Navigation:** Includes buttons to go back to either `MainActivity` or `HelloActivity`.
   * **Gesture Navigation (Swipe):** 
     * Swiping from the center of the screen to the **left** triggers navigation to `MainActivity`.
     * Swiping from the center of the screen to the **right** triggers navigation to `HelloActivity`.

---

## 🛠️ Technical Implementation

### Data Passing & Back Stack Management
* **Data Transfer:** Counter values are bundled into explicit intents using `intent.putExtra("stev", value)` and extracted via `intent.getIntExtra("stev", 0)`.
* **Stack Management:** To prevent multiple instances of the same activity from stacking up (which breaks the hardware back button behavior), navigation calls use specific flags:
  * `Intent.FLAG_ACTIVITY_CLEAR_TOP`
  * `Intent.FLAG_ACTIVITY_SINGLE_TOP`
* **State Updates:** `MainActivity` overrides the `onNewIntent(Intent intent)` lifecycle method to smoothly catch and apply updated counter data upon returning from sub-activities.

### Swipe Gesture Navigation
Gesture navigation on the third screen is handled using the provided custom helper class `OnSwipeTouchListener`. It implements `View.OnTouchListener` and overrides the `onFling` method within a `GestureDetector.SimpleOnGestureListener` by checking the following thresholds:
* `SWIPE_DISTANCE_THRESHOLD = 100` pixels
* `SWIPE_VELOCITY_THRESHOLD = 100` pixels per second

## ScreenShots
<img width="200" height="400" alt="Screenshot_20261109_000615_Activities" src="https://github.com/user-attachments/assets/0aba7bc5-3934-4a8e-bc8d-7326265badc5" />
<img width="200" height="400" alt="Screenshot_20261109_000619_Activities" src="https://github.com/user-attachments/assets/5b596c81-ec8a-4a0a-b58a-3e092a299d26" />
<img width="200" height="400" alt="Screenshot_20261109_000623_Activities" src="https://github.com/user-attachments/assets/b535f5b0-c32a-4401-a31f-72d02f11f56b" />
<img width="200" height="400" alt="Screenshot_20261109_000627_Activities" src="https://github.com/user-attachments/assets/e03f23b2-e7a5-4623-af5f-4d5a838fc044" />



