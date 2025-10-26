#  JavaFX Icon Menu Editor

##  Overview

**JavaFX Icon Menu Editor** is an interactive desktop application component that allows users to dynamically create, add, and remove icons from a list.  
Each icon represents a functional element (Home, Folder, Disk, User, etc.) and can be displayed or deleted through a simple and intuitive graphical interface.

The layout is divided into three columns:
1. **Left column** — List of available icon types  
2. **Middle column** — Buttons to add or remove icons  
3. **Right column** — A `FlowPane` that dynamically displays the selected icons

This project demonstrates how to use **JavaFX** to manage GUI layouts, handle events, and create dynamic components programmatically.

---

## ⚙️ Features

- Multi-selection of icons to add  
- Dynamic add/remove of elements in a `FlowPane`  
- Layout using `GridPane`, `VBox`, and `FlowPane`  
- Custom icon components with text and image  
- Mouse click interaction (`setOnMouseClicked`)  
- Automatically returns removed icons to the left-side list  
- Modular architecture (`Main` and `Icone` classes)  

---