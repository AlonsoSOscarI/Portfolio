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

Below are key outputs and screenshots demonstrating the functionality and features of the Simon Says game project.

1. **Circuit Schematic**: This schematic outlines the project's design, including the ATmega328P microcontroller, the display, buttons, and LEDs. All components are interconnected using air connections in Proteus, hence the absence of visible wires. ![Circuit Schematic](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Assembler-SimonSaysGame/Outputs-Assembler/1.%20Circuit%20Schematic.JPG)
   
2. **Circuit Turned On**: Here, the circuit is powered on within Proteus, showing the initial animation. Capturing the turn-on animation is challenging due to its transient nature. ![Circuit Turned On](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Assembler-SimonSaysGame/Outputs-Assembler/2.%20Circuit%20Turned%20on.JPG)
   
3. **Game Started, First Level**: The display indicates Level 1, and the blue LED flashes as part of the pseudo-random sequence generation, marking the beginning of the game. ![Game Started, First Level](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Assembler-SimonSaysGame/Outputs-Assembler/3.%20Game%20Started%2C%20First%20Level.JPG)
   
4. **Lost Game**: This image captures the moment when the player loses the game by pressing an incorrect button. The reset LED flashes red, and the reset function is triggered. ![Lost Game](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Assembler-SimonSaysGame/Outputs-Assembler/4.%20Lost%20game.JPG)
   
5. **Fifth Level, Game Won**: The player successfully completes the sequence, illustrated by the start LED flashing green. Subsequently, the reset function is executed, preparing the game for a new round. ![Fifth Level, Game Won](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Assembler-SimonSaysGame/Outputs-Assembler/5.%20Fifth%20Level%2C%20Game%20won.JPG)


## License
[MIT](./LICENSE)

