package Control;

import Model.BinaryTree;
import View.DrawingPanel;
import View.TreeView.TreeNode;
import View.TreeView.TreePath;

/**
 * Created by Jean-Pierre on 12.01.2017.
 */
public class MainController {

    private BinaryTree<String> binaryTree;

    public MainController(){
        binaryTree = new BinaryTree<>(""); // Ein Baum ohne Wurzel-Inhalt ist auf dauer ein leerer Baum - es lassen sich laut Dokumentation nichtmal Bäume anhängen. Also wird die Wurzel gefüllt.
        createMorseTree();
    }

    /**
     * Zur Präsentation des Programms wird der Morsecode im Baum dargestellt.
     */
    private void createMorseTree(){
        //TODO 02: Vervollständige des Morsebaum. Such bei google nach "morsecode as tree" als Vorlage. Das hilft, die Übersicht zu wahren.
        BinaryTree<String> left = new BinaryTree<>("E");
        BinaryTree<String> anderesLeft = new BinaryTree<>("T");

        binaryTree.setLeftTree(left);
        binaryTree.setRightTree(anderesLeft);

        left = new BinaryTree<>("I");
        anderesLeft = new BinaryTree<>("A");

        binaryTree.getLeftTree().setLeftTree(left);
        binaryTree.getLeftTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("S");
        anderesLeft = new BinaryTree<>("U");

        binaryTree.getLeftTree().getLeftTree().setLeftTree(left);
        binaryTree.getLeftTree().getLeftTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("H");
        anderesLeft = new BinaryTree<>("V");

        binaryTree.getLeftTree().getLeftTree().getLeftTree().setLeftTree(left);
        binaryTree.getLeftTree().getLeftTree().getLeftTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("F");
        anderesLeft = new BinaryTree<>("Ü");

        binaryTree.getLeftTree().getLeftTree().getRightTree().setLeftTree(left);
        binaryTree.getLeftTree().getLeftTree().getRightTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("R");
        anderesLeft = new BinaryTree<>("W");

        binaryTree.getLeftTree().getRightTree().setLeftTree(left);
        binaryTree.getLeftTree().getRightTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("L");
        anderesLeft = new BinaryTree<>("Ä");

        binaryTree.getLeftTree().getRightTree().getLeftTree().setLeftTree(left);
        binaryTree.getLeftTree().getRightTree().getLeftTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("P");
        anderesLeft = new BinaryTree<>("J");

        binaryTree.getLeftTree().getRightTree().getRightTree().setLeftTree(left);
        binaryTree.getLeftTree().getRightTree().getRightTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("N");
        anderesLeft = new BinaryTree<>("M");

        binaryTree.getRightTree().setLeftTree(left);
        binaryTree.getRightTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("D");
        anderesLeft = new BinaryTree<>("K");

        binaryTree.getRightTree().getLeftTree().setLeftTree(left);
        binaryTree.getRightTree().getLeftTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("B");
        anderesLeft = new BinaryTree<>("X");

        binaryTree.getRightTree().getLeftTree().getLeftTree().setLeftTree(left);
        binaryTree.getRightTree().getLeftTree().getLeftTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("C");
        anderesLeft = new BinaryTree<>("Y");

        binaryTree.getRightTree().getLeftTree().getRightTree().setLeftTree(left);
        binaryTree.getRightTree().getLeftTree().getRightTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("G");
        anderesLeft = new BinaryTree<>("O");

        binaryTree.getRightTree().getRightTree().setLeftTree(left);
        binaryTree.getRightTree().getRightTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("Z");
        anderesLeft = new BinaryTree<>("Q");

        binaryTree.getRightTree().getRightTree().getLeftTree().setLeftTree(left);
        binaryTree.getRightTree().getRightTree().getLeftTree().setRightTree(anderesLeft);

        left = new BinaryTree<>("Ö");
        anderesLeft = new BinaryTree<>("");

        binaryTree.getRightTree().getRightTree().getRightTree().setLeftTree(left);
        binaryTree.getRightTree().getRightTree().getRightTree().setRightTree(anderesLeft);

    }

    /**
     * Der Baum wird im übergebenem Panel dargestellt.
     * Dazu wird zunächst die alte Zeichnung entfernt.
     * Im Anschluss wird eine eine internete Hilfsmethode aufgerufen.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     */
    public void showTree(DrawingPanel panel){
        panel.removeAllObjects();
        //Der Baum wird in der Mitte des Panels beginnend gezeichnet: panel.getWidth()/2
        //Der linke und rechte Knoten in Tiefe 1 sind jeweils ein Viertel der Breite des Panels entfernt.
        showTree(binaryTree, panel, panel.getWidth()/2, 50, panel.getWidth()/4);
    }

    /**
     * Hilfsmethode zum Zeichnen des Baums.
     * Für jeden Knoten wird ein neues TreeNode-Objekt dem panel hinzugefügt.
     * Für jede Kante wird ein neues TreePath-Pbjekt dem panel hinzugefügt.
     * @param tree Der zu zeichnende (Teil)Binärbaum.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     * @param startX x-Koordinate seiner Wurzel
     * @param startY y-Koordinate seiner Wurzel
     * @param spaceToTheSide Gibt an, wie weit horizontal entfernt die folgenden Bäume gezeichnet werden soll.
     */
    private void showTree(BinaryTree tree, DrawingPanel panel, double startX, double startY, double spaceToTheSide) {
        //TODO 03: Vervollständige diese Methode. Aktuell wird nur der Wurzelknoten gezeichnet.
        if (!tree.isEmpty()) {
            int rad = 10;
            TreeNode node = new TreeNode(startX, startY, 10, tree.getContent().toString(), false);
            panel.addObject(node);
            if(!tree.getLeftTree().isEmpty()) {
                int lX = (int) (startX - spaceToTheSide);
                int lY = (int) (startY + panel.getHeight() / 6);

                panel.addObject(new TreePath(startX,startY, lX, lY,rad,false));
                showTree(tree.getLeftTree(), panel, lX, lY, spaceToTheSide / 2);
            }

            if(!tree.getRightTree().isEmpty()) {
                int rX = (int) (startX + spaceToTheSide);
                int rY = (int) (startY + panel.getHeight() / 6);

                panel.addObject(new TreePath(startX,startY, rX, rY,rad,false));
                showTree(tree.getRightTree(),panel,rX,rY,spaceToTheSide/2);
            }
        }
    }

    /**
     * Es wird das Ergebnis einer Traversierung bestimmt.
     * Ruft dazu eine interne Hilfsmethode auf.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    public String traverse(){
        return traverse(binaryTree);
    }

    /**
     * Interne hilfsmethode zur Traversierung.
     * @param tree Der zu traversierende Binärbaum.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    private String traverse(BinaryTree tree){
        //TODO 04: Nachdem wir geklärt haben, was eine Traversierung ist, muss diese Methode noch vervollständigt werden. Sollte ein Kinderspiel sein.
        String output = "";
        if(!tree.getLeftTree().isEmpty()){
            output = traverse(tree.getLeftTree());
        }
        output += tree.getContent().toString();
        if(!tree.getRightTree().isEmpty()){
            output += traverse(tree.getRightTree());
        }

        return output;
    }

    public String transcribe(){
        return null;
    }

    public String transcribe(char ike){
        switch (ike){
            case 'A':
                return ".-";
                break;
            case 'B':
                return "-...";
                break;
            case 'C':
                return "-.-.";
                break;
            case 'D':
                return "-..";
                break;
            case 'E':
                return ".";
                break;
            case 'F':
                return "..-.";
                break;
            case 'G':
                return "--.";
                break;
            case 'H':
                return "....";
                break;
            case 'I':
                return "..";
                break;
            case 'J':
                return ".---";
                break;
            case 'K':
                return "-.-";
                break;
            case 'L':
                return ".-..";
                break;
            case 'M':
                return "--";
                break;
        }
    }
}
