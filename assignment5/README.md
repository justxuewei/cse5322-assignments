# UTA CSE 5322 Assignment 5

Author: Xuewei Niu

Date: Oct 26, 2021

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

## Scenarios

For "Draw a shape on Canvas" use case, non-trivial steps are:

- The system changes the shape corresponding to the botton user clicked;
- The system renders the shape on the specific position.

For "Undo" use case, non-trivial steps are:

- The system remove the last added shape;
- The system renders the graph.

For "Redo" use case, non-trivial steps are:

- The system restore the last removed shape;
- The system renders the graph.

Non-trivial Step: The system changes the shape corresponding to the botton user clicked

| The system changes the shape corresponding to the botton user clicked |
| ------------------------------------------------------------ |
| The shapeGUI emits a clicked event to the pattern controller with action name.. |
| The pattern controller changes the current shape to the specific shape. |

Non-trivial Step: The system renders the shape on the specific position.

| The system renders the shape on the specific position        |
| ------------------------------------------------------------ |
| The shapeGUI emits a pressed event to the pattern controller. |
| The pattern controller pushed the current shape to a stack.  |
| The pattern controller uses a specific type to draw the shape. |
| The type draws the shape on canvas via render engine. (Expert Pattern) |
| The render engine shows the new image on the canvas.         |

Non-trivial Step: The system remove the last added shape

| The system remove the last added shape                       |
| ------------------------------------------------------------ |
| The shapeGUI emits a clicked event to the pattern controller. |
| The pattern controller executes a undo command.(Command Pattern) |
| The undo command pops the last shape from the undo stack.    |
| The undo command push the shape to the redo stack.           |

Non-trivial Step: The system restore the last removed shape

| The system restore the last removed shape                    |
| ------------------------------------------------------------ |
| The shapeGUI emits a clicked event to the pattern controller. |
| The pattern controller executes a redo command.(Command Pattern) |
| The undo command pops the last shape from the redo stack.    |
| The undo command push the shape to the undo stack.           |

Non-trivial Step: The system renders the graph

| The system renders the graph                                 |
| ------------------------------------------------------------ |
| The pattern controller clears the image on the canvas.       |
| The graphic of the canvas updates the image.                 |
| The pattern controller iterators the undo stack.(Iterator Pattern & Composite Pattern) |
| Each shape will be drawed by the specific shape object.      |
| The type draws the shape on canvas via render engine. (Expert Pattern) |
| The render engine shows the new image on the canvas.         |

## Scenario Tables

Non-trivial Step: The system changes the shape corresponding to the botton user clicked

| Subject                | Action                    | Object                 | Other Objects     |
| ---------------------- | ------------------------- | ---------------------- | ----------------- |
| The shapeGUI           | emits a clicked event     | the pattern controller | with action name. |
| The pattern controller | changes the current shape | the specific shape     |                   |

Non-trivial Step: The system renders the shape on the specific position.

| Subject                | Action                   | Object                       | Other Objects     |
| ---------------------- | ------------------------ | ---------------------------- | ----------------- |
| The shapeGUI           | emits a pressed event    | to the pattern controller    | with action name  |
| The pattern controller | pushed the current shape | to a stack                   |                   |
| The pattern controller | uses a specific type     | to draw the shape            |                   |
| The type               | draws the shape          | on canvas                    | via render engine |
| The render engine      | shows                    | the new image on the canvas. |                   |

Non-trivial Step: The system remove the last added shape

| Subject                | Action                | Object                    | Other Objects    |
| ---------------------- | --------------------- | ------------------------- | ---------------- |
| The shapeGUI           | emits a clicked event | to the pattern controller | with action name |
| The pattern controller | executes              | a undo command            |                  |
| The undo command       | pops the last shape   | from the undo stack       |                  |
| The undo command       | push the shape        | to the redo stack         |                  |

Non-trivial Step: The system restore the last removed shape

| Subject                | Action                | Object                    | Other Objects    |
| ---------------------- | --------------------- | ------------------------- | ---------------- |
| The shapeGUI           | emits a clicked event | to the pattern controller | with action name |
| The pattern controller | executes              | a redo command            |                  |
| The undo command       | pops the last shape   | from the redo stack       |                  |
| The undo command       | push the shape        | to the undo stack         |                  |

Non-trivial Step: The system renders the graph

| Subject                   | Action              | Object                       | Other Objects     |
| ------------------------- | ------------------- | ---------------------------- | ----------------- |
| The pattern controller    | clears the image    | on the canvas                |                   |
| The graphic of the canvas | updates             | the image                    |                   |
| The pattern controller    | iterators           | the undo stack               |                   |
| Each shape                | will be drawed      | by the specific shape object |                   |
| The type                  | draws the shape     | on the canvas                | via render engine |
| The render engine         | shows the new image | on the canvas                |                   |

## Informal Sequence Diagram

![assignment5.drawio](https://res.niuxuewei.com/2021-10-26-041020.png)

## Design Sequence Diagram

![assignment5-dsq-ns-1.drawio](https://res.niuxuewei.com/2021-10-26-042508.png)

## Design Class Diagram

![assignment5-dcd.drawio (1)](https://res.niuxuewei.com/2021-10-26-045021.png)

