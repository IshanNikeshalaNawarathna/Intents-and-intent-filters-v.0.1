# Android Intents and Intent Filters

## Introduction
Intents and Intent Filters are foundational components in Android development. They enable communication between components within the same app or across different apps.

## Intents
An Intent is an abstract description of an operation to be performed. It allows you to start activities, services, or deliver broadcasts.

### Types of Intents
1. **Explicit Intents**
   - Used to start a specific component (activity, service, etc.).
   - Example:
     ```java
     Intent intent = new Intent(CurrentActivity.this, TargetActivity.class);
     startActivity(intent);
     ```

2. **Implicit Intents**
   - Used when the component is not explicitly specified. The system matches the intent with available components using intent filters.
   - Example:
     ```java
     Intent intent = new Intent(Intent.ACTION_VIEW);
     intent.setData(Uri.parse("https://www.example.com"));
     startActivity(intent);
     ```

### Common Intent Actions
- `Intent.ACTION_VIEW`: Display data to the user (e.g., open a web page).
- `Intent.ACTION_SEND`: Send data to another app (e.g., share text or images).
- `Intent.ACTION_DIAL`: Open the dialer with a phone number.

### Passing Data with Intents
You can pass data between activities using extras:
```java
Intent intent = new Intent(CurrentActivity.this, TargetActivity.class);
intent.putExtra("KEY_NAME", "value");
startActivity(intent);
```
In the target activity, retrieve the data:
```java
String value = getIntent().getStringExtra("KEY_NAME");
```

## Intent Filters
An Intent Filter specifies the types of intents a component can respond to. They are declared in the `AndroidManifest.xml` file.

### Components of an Intent Filter
1. **Action**
   - Defines the action a component can handle (e.g., `ACTION_VIEW`, `ACTION_SEND`).
   - Example:
     ```xml
     <action android:name="android.intent.action.VIEW" />
     ```

2. **Category**
   - Adds additional information about the action.
   - Example:
     ```xml
     <category android:name="android.intent.category.DEFAULT" />
     ```

3. **Data**
   - Specifies the type of data the component can handle.
   - Example:
     ```xml
     <data android:scheme="http" android:host="www.example.com" />
     ```

### Example Intent Filter
```xml
<activity android:name=".TargetActivity">
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data android:scheme="http" android:host="www.example.com" />
    </intent-filter>
</activity>
```


## Using Intent Filters for Implicit Intents
When an app sends an implicit intent, Android checks the intent filters of installed apps to find a match.

### Example
Send an email using an implicit intent:
```java
Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("text/plain");
intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"example@example.com"});
intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
intent.putExtra(Intent.EXTRA_TEXT, "Email body");
startActivity(Intent.createChooser(intent, "Send Email"));
```
Access the Camera
```java
Intent i = new Intent("android.media.action.STILL_IMAGE_CAMERA");
startActivity(i);
```
Access the Google map 
```java
 Intent i = new Intent(Intent.ACTION_VIEW);
 Uri uri = Uri.parse("geo:47.6,-122.3");
 i.setData(uri);
 startActivity(i);
```
Access the Call Dial
```java
Intent i = new Intent(Intent.ACTION_DIAL);
Uri uri = Uri.parse("tel:0767235819");
i.setData(uri);
startActivity(i);
```
Set the permissions
```xml
 <uses-permission android:name="android.permission.CALL_PHONE" />
```

## Conclusion
Understanding Intents and Intent Filters is essential for creating robust and interactive Android applications. They enable seamless interaction between components and apps, enhancing the overall user experience.
