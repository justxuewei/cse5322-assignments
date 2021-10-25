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
|                                                        | 8. The system renders the shape on the specific position.    |
| 9. TUCEW The user sees the shape.                      |                                                              |

Use Case: Undo

| Actor: User                                                 | System: Drawing Application                                  |
| ----------------------------------------------------------- | ------------------------------------------------------------ |
| 1. TUCBW user clicks "undo" button.                         | 2. The system pops a shape from undo stack.                  |
|                                                             | 3. The system disables undo button if the length of undo stack is 0. |
|                                                             | 4. The system pushs the shape into redo stack.               |
|                                                             | 5. The system disables undo button.                          |
|                                                             | 6. The system rerender the picture.                          |
| 7. TUCEW The user sees the last added shape is disappeared. |                                                              |

Use Case: Redo

| Actor: User                                   | System: Drawing Application                    |
| --------------------------------------------- | ---------------------------------------------- |
| 1. TUCBW user clicks "redo" button.           | 2. The system pops a shape from redo stack.    |
|                                               | 3. The system pushs the shape into undo stack. |
|                                               | 4. The system rerender the picture.            |
| 5. TUCEW The user sees the shape is appeared. |                                                |

