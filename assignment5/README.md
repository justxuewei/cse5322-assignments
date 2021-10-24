# UTA CSE 5322 Assignment 5

## Expanded Use Case

Use Case: Draw a shape on Canvas

| Actor: User                                            | System: Drawing Application                                  |
| ------------------------------------------------------ | ------------------------------------------------------------ |
| 1. TUCBW user clicks a specific shape button           | 2. The system changes the shape corresponding to the botton user clicked. |
| 3. The user draws the shape by clicking on the Canvas. | 4. The system pushs this shape into undo stack.              |
|                                                        | 5. The system enables undo button.                           |
|                                                        | 6. The system removes all shapes from redo stack.            |
|                                                        | 7. The system disables redo button                           |
|                                                        | 8. TUCEW The system displays the shape on the specific position. |

Use Case: Undo

| Actor: User                         | System: Drawing Application                                  |
| ----------------------------------- | ------------------------------------------------------------ |
| 1. TUCBW user clicks "undo" button. | 2. The system pops a shape from undo stack.                  |
|                                     | 3. The system disables undo button if the length of undo stack is 0. |
|                                     | 4. The system pushs the shape into redo stack.               |
|                                     | 5. The system disables undo button.                          |
|                                     | 6. TUCEW The system                                          |
|                                     |                                                              |

