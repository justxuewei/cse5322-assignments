# UTA CSE 5322 Assignment 5

## Expanded Use Case

Use Case: Draw a shape on Canvas

| Actor: User                                            | System: Drawing Application                                  |
| ------------------------------------------------------ | ------------------------------------------------------------ |
| 1. TUCBW user clicks a specific shape button           | 2. The system changes the shape corresponding to the botton user clicked. |
| 3. The user draws the shape by clicking on the Canvas. | 4. The system renders the shape on the specific position.    |
| 5. TUCEW The user sees the shape.                      |                                                              |

Use Case: Undo

| Actor: User                                                 | System: Drawing Application                |
| ----------------------------------------------------------- | ------------------------------------------ |
| 1. TUCBW user clicks "undo" button.                         | 2. The system remove the last added shape. |
|                                                             | 3. The system renders the graph.           |
| 4. TUCEW The user sees the last added shape is disappeared. |                                            |

Use Case: Redo

| Actor: User                                   | System: Drawing Application                   |
| --------------------------------------------- | --------------------------------------------- |
| 1. TUCBW user clicks "redo" button.           | 2. The system restore the last removed shape. |
|                                               | 3. The system renders the graph.              |
| 4. TUCEW The user sees the shape is appeared. |                                               |

## Non-trivial Steps

For "Draw a shape on Canvas" use case, non-trivial steps are:

- The system changes the shape corresponding to the botton user clicked;
- The system renders the shape on the specific position.

For "Undo" use case, non-trivial steps are:

- The system remove the last added shape;
- The system renders the graph.

For "Redo" use case, non-trivial steps are:

- The system restore the last removed shape;
- The system renders the graph.

Non-trivial Steps: The system changes the shape corresponding to the botton user clicked

| The system changes the shape corresponding to the botton user clicked |
| ------------------------------------------------------------ |
| The shapeGUI emits a clicked event to the pattern controller. |
| The pattern controller changes the current shape to the specific shape. |

Non-trivial Steps: The system renders the shape on the specific position.

| The system renders the shape on the specific position        |
| ------------------------------------------------------------ |
| The shapeGUI emits a pressed event to the pattern controller. |
| The pattern controller pushed the current shape to a stack.  |
| The pattern controller                                       |

