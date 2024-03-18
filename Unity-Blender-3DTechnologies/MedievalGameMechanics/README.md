# Medieval Adventure Game Prototype

## Overview
This prototype is a fantasy-themed game inspired by the expansive worlds found in titles like Skyrim. Developed entirely in Unity and Blender, it showcases a range of functionalities set within a medieval environment. While the graphical fidelity and complexity are intentionally kept simple, all models, animations, and textures were created from scratch, emphasizing functionality over visual detail.
You can download the project folder here: [Medieval Unity Project](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalMechanicProject.rar)

## Game Features
- **Inventory System**: A core feature allowing players to manage collected items, equipping or storing them as needed for progression.
- **Pick Up Mechanics**: Objects can be interacted with directly using 'F' to "hold" them or 'E' to add them to the inventory, facilitated by an invisible InteractionZone object that discerns interactable items.
- **Equipping Mechanism**: Players can equip and unequip items from their inventory, changing their capabilities and appearance.
- **Combat and Health**: The game includes a basic combat system where the player can attack with equipped weapons and defend using shields. A health system tracks the player's vitality during encounters.
- **Enemy AI**: Features a rudimentary AI enemy represented by a 3D rectangle that detects the player, initiates pursuit, and engages in combat.
- **Medieval Ambiance**: The environment includes medieval-themed elements like trees and an altar, enhancing the game's setting and atmosphere.
- **Equipment Modifiers**: Armor and weapons affect gameplay through modifiers that alter the player's damage output and resistance, adding depth to the combat and inventory systems.

## Development Process
The development journey for this prototype involved:
- **Modeling and Animation in Blender**: Every asset, including characters, equipment, and environmental elements, was personally crafted to support the game's mechanics and setting.
- **Unity Programming**: All game functionalities, from inventory management to enemy AI, were programmed in Unity, ensuring a cohesive gameplay experience.

## Acknowledgments
This game prototype stands as a personal exploration into the realms of game design and development, combining a passion for medieval fantasy with the technical challenges of creating interactive experiences.

## Outputs
1. **General Project Setup**: This image displays the Unity editor's layout for the project, showcasing the SampleScene in the hierarchy with essential game elements like the GameManager, player, and enemy. The project's assets are organized and accessible in the bottom pane. ![General Project Setup](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/1.%20General%20Project%20Setup.JPG)
2. **Player Setup**: Here, we observe the player character setup, highlighting the components that enable interaction with the game world, alongside the mouse-controlled camera setup. ![Player Setup](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/2.%20Player%20interactions%2C%20colliders%20and%20camera.JPG)
3. **Enemy Detection Zone**: This screenshot reveals the enemy's detection mechanics, showcasing the radius within which the enemy can detect the player and initiate pursuit, as indicated by the script visible in the inspector. ![Enemy Detection Zone](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/3.%20Enemy%2C%20Zone%20Detection.JPG)
4. **Equipment Object Example**: An example of an equipment object, specifically Chest Armor, showing how it influences the player's Armor Modifier in the inspector. The array illustrates the mesh regions covered by the armor, such as the Arms and Torso. ![Equipment Object Example](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/4.%20Equipment%20Objet%20Example.JPG)
5. **Player Idle Animation**: Captures the player character in an idle state, where subtle animations, like chest movements, simulate breathing, adding a layer of realism. ![Player Idle Animation](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/5.%20Player%20Idle.JPG)
6. **Interacting with Items**: This scene shows the player interacting with a shield on the ground, highlighting the game's interaction mechanics. The shield enters the player's Interaction Zone, allowing the player to pick it up with a key press. ![Interacting with Items](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/6.%20Player%20picking%20up%20shield.JPG)
7. **Inventory Interface**: The player's inventory interface is revealed upon pressing a designated key, showcasing the UI design and functionality. ![Inventory Interface](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/7.%20Inventory%20Interface.JPG)
8. **Inventory Management**: Demonstrates the inventory after the player has stored items, showcasing how items are added to the inventory and managed within the game. ![Inventory Management](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/8.%20Inventory%20after%20saving%20items.JPG)
9. **Equipped Items**: Displays the player character wearing selected items from the inventory, such as a helmet and chest armor, illustrating the game's equipment system. ![Equipped Items](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/9.%20Some%20items%20equipped.JPG)
10. **Walking Animation**: A view of the player character's walking animation, showcasing the fluidity and realism of movement. ![Walking Animation](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/10.%20Walk%20Animation.JPG)
11. **Running Animation**: Highlights the player character's running animation, emphasizing the dynamic change in movement. ![Running Animation](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/11.%20Run%20Animation.JPG)
12. **Combat Stance**: Showcases the player in a combat-ready stance, fully equipped with armor, shield, and sword, prepared for battle. ![Combat Stance](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/12.%20Combat%20Animation.JPG)
13. **Attack Animation**: Captures a moment of the player executing an attack, demonstrating the combat mechanics and animation quality. ![Attack Animation](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/13.%20Atack%20Animation.JPG)
14. **Approaching Enemy's Detection Zone**: Illustrates the player nearing the enemy's detection zone, setting the stage for an impending confrontation. ![Approaching Enemy's Detection Zone](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/14.%20Player%20approaching%20to%20enemy_s%20detection%20zone.JPG)
15. **Chase Sequence**: Depicts the intense moment of the player being pursued by the enemy after being detected, highlighting the AI behavior. ![Chase Sequence](https://github.com/AlonsoSOscarI/Portfolio/blob/main/Unity-Blender-3DTechnologies/MedievalGameMechanics/MedievalOutputs/15.%20Player%20getting%20chased%20by%20enemy.JPG)

## License
[MIT](../LICENSE)
