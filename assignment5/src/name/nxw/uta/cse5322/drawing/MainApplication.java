package name.nxw.uta.cse5322.drawing;

import name.nxw.uta.cse5322.drawing.controller.PatternController;

public class MainApplication {
     public static void main(String[] args) {
          PatternController p = new PatternController();
          p.listenEvents();
     }
}
