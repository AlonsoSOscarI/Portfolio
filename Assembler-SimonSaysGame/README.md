# Simon Says Game in Assembly

## Overview
This project implements the classic "Simon Says" game, developed in assembly language for the ATmega328P microcontroller and simulated in Proteus. The game tests players' memory and attention by challenging them to replicate sequences of flashing lights.

## Objectives
- To create an engaging memory-based game using low-level programming and microcontroller interfacing.
- To demonstrate proficiency in assembly language and understanding of microcontroller-based system design.
- To utilize hardware components like LEDs, buttons, and displays in creating interactive gameplay.

## Game Mechanics
- **Control Buttons**: The game uses a matrix-connected button setup, including specific buttons for starting and resetting the game.
- **Levels and Sequences**: The game features 5 levels, each with sequences involving 4 pseudo-randomly chosen colors (green, yellow, blue, red).
- **Circuit Overview**: The circuit includes:
  - An ATmega328P microcontroller for running the game logic.
  - A display for indicating the current level.
  - 6 buttons, each paired with an LED: 4 for color selection and 1 each for start and reset functions.
  - LEDs provide visual cues for gameplay, with the start button's LED indicating successful level completion and the reset button's LED signaling an incorrect attempt.

## Gameplay
1. **Starting the Game**: Initiating the game by pressing the start button triggers the LEDs to flash, and the display shows pseudo-random numbers before setting on Level 1.
2. **Playing Through Levels**: In each level, one of the four colors is selected pseudo-randomly. The player must press the corresponding button to match the LED's color flash.
3. **Feedback Mechanism**: Correct selections allow the player to progress, signaled by the start button's LED lighting up. Incorrect selections activate the reset function, indicated by the reset button's LED turning red.
4. **Game Completion**: Successfully navigating through all levels results in the start button's LED flashing three times to indicate victory, followed by the execution of the reset function to prepare for a new game.

## Acknowledgments
Special thanks to collaborators and mentors who provided guidance and support throughout the development of this project.

## Outputs


## License
[MIT](./LICENSE)

