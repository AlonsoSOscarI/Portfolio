# 8 Puzzle Solver with AI Techniques

## Overview
This Python-based solver tackles the classic 8 puzzle game employing artificial intelligence methods. By utilizing the Manhattan distance heuristic and a node-based search strategy, the solver efficiently navigates from an initial state to the solution. The entire process unfolds in the console, offering a step-by-step display of the puzzle's resolution, including the movements of the blank space (underscore _) and the required steps to achieve the goal state. [8 Puzzle Solver](https://github.com/AlonsoSOscarI/Portfolio/tree/main/Python-8puzzleSolver/8Puzzle)

## Features

- **Heuristic-Based Search**: The Manhattan distance heuristic guides the search, estimating the cost to reach the goal by calculating the total distance each tile is from its target position.
- **Node-Based Exploration**: The search space is explored through nodes representing potential moves, with a focus on moves that lead closer to the goal state based on heuristic values.
- **Console Visualization**: Each state transition is visualized in the console, showing how tiles are repositioned and tracking the blank space's movements. ![Console Visualization](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Python-8puzzleSolver/Python-Output/3.%20Console%20Visualization.JPG)
- **Solvability Check**: The solver assesses if the initial state can lead to a solution, advising termination of the execution if the puzzle is deemed unsolvable.
- **Movement Counter**: Upon solving the puzzle, the total number of moves made is displayed, providing insight into the search algorithm's efficiency.
- - ![Movement Counter](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Python-8puzzleSolver/Python-Output/2.%20Movement%20Counter.JPG)

### Usage
Define the initial puzzle state in a 3x3 matrix within the Python script, using an underscore (_) to represent the blank tile. The script outputs each action taken to solve the puzzle and concludes with the solved state and move count. ![Initial State](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Python-8puzzleSolver/Python-Output/1.%20Initial%20State.JPG)

