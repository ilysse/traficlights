# Traffic Light Simulator Android App

A simple yet effective Android application that simulates traffic light behaviors with two distinct scenarios. Built with Kotlin and designed with clean architecture principles.

## Description

The Traffic Light Simulator is an educational Android application that demonstrates state management and timing control through traffic light simulation. The app features a visually appealing interface with three lights (red, yellow, and green) and offers two different operational scenarios:

### Features

1. **Scenario 1 - Sequential Light Change**
   - Demonstrates a complete traffic light cycle
   - Red → Yellow → Green sequence
   - Smooth color transitions
   - Timed intervals between changes

2. **Scenario 2 - Yellow Light Alert**
   - Simulates a warning signal
   - Yellow light blinks at regular intervals
   - Continuous operation until switched off
   - One-second interval between blinks

### Technical Specifications

- **Minimum SDK Version**: 21 (Android 5.0)
- **Target SDK Version**: 34 (Android 14)
- **Language**: Kotlin
- **Architecture**: MVVM
- **Build System**: Gradle

## Installation

1. Clone the repository:


2. Open the project in Android Studio

3. Build and run the application

## Usage

1. Launch the application
2. Choose between two scenarios using the buttons:
   - "Scénario 1" for sequential light changes
   - "Scénario 2" for blinking yellow light

### Scenario 1
- Demonstrates a complete traffic light sequence
- Each light illuminates in sequence with appropriate timing
- Smooth transitions between states

### Scenario 2
- Activates blinking yellow light mode
- Continues until another scenario is selected
- Simulates warning or caution signal

## Technical Features

- Efficient memory management
- Smooth animations using ValueAnimator
- Clean architecture with clear separation of concerns
- Proper resource cleanup
- Color state caching for better performance
- Handler-based timing system
- Choreographer implementation for smooth rendering

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/manager/trafflight/
│   │   │   ├── MainActivity.kt
│   │   │   └── ...
│   │   └── res/
│   │       ├── layout/
│   │       │   └── activity_main.xml
│   │       ├── values/
│   │       │   ├── colors.xml
│   │       │   └── strings.xml
│   │       └── ...
│   └── ...
└── ...
```

## Performance Optimization

- Color resource caching
- Efficient state management
- Optimized animation transitions
- Memory leak prevention
- Proper cleanup in lifecycle methods

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Author

benmi101 - [ilyasbenmimoune@gmail.com](mailto:ilyasbenmimoune@gmail.com)

## Acknowledgments

- Android Development Team for providing excellent documentation
- Contributors and testers who helped improve the application
- Inspiration from real-world traffic light systems
