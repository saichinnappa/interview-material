package com.interview.affirm.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/1530392/Affirm-or-Phone-or-find-POPUP
 */

//              ROOT
//          /     |    \
//         /      |     \
//       B       C        D
//    /   |            /  | \  \
//   /    |           /   |  \  \
// F      G      (POPUP)  I  J  (K)
//              /   |   \   / \
//             /    |    \  Z  Y
//            N     O    (P)

class DomNode {
    String id;
    boolean hidden;
    List<DomNode> children;

    public DomNode(String id, boolean hidden, List<DomNode> children) {
        this.hidden = hidden;
        this.id = id;
        this.children = children;
    }
}

public class PopUp {
    public static void main(String[] args) {
        DomNode N = new DomNode("N", false, new ArrayList());
        DomNode O = new DomNode("O", false, new ArrayList());
        DomNode P = new DomNode("P", true, new ArrayList());

        DomNode C = new DomNode("C", false, new ArrayList());

        DomNode Z = new DomNode("Z", false, new ArrayList());
        DomNode Y = new DomNode("Y", false, new ArrayList());


        DomNode POPUP = new DomNode("POPUP", true, Arrays.asList(N, O, P));
        DomNode I = new DomNode("I", false, new ArrayList());
        DomNode J = new DomNode("J", false, Arrays.asList(Z, Y));
        DomNode K = new DomNode("K", true, new ArrayList());

        DomNode D = new DomNode("D", false, Arrays.asList(POPUP, I, J, K));

        DomNode F = new DomNode("F", false, new ArrayList());
        DomNode G = new DomNode("G", false, new ArrayList());

        DomNode B = new DomNode("B", false, Arrays.asList(F, G));

        DomNode ROOT = new DomNode("ROOT", false, Arrays.asList(B, C, D));

        System.out.println(findMainPopUp(ROOT));
        System.out.println(B.hidden);
        System.out.println(C.hidden);
        System.out.println(D.hidden);
        System.out.println(POPUP.hidden);
        System.out.println(I.hidden);
        System.out.println(J.hidden);
        System.out.println(K.hidden);
    }

    private static boolean findMainPopUp(DomNode root) {
        for (DomNode node : root.children) {
            if (findPopUp(node, root))
                return true;
        }
        return false;
    }

    private static boolean findPopUp(DomNode node, DomNode root) {
        System.out.println("Processing: " + node.id);
        for (DomNode x : node.children) {
            if (x.id.equals("POPUP")) {
//                x.hidden = false;
                for (DomNode sibling : root.children) {
//                    System.out.println("Hiding: " + sibling.id);
                    if (!sibling.id.equals(node.id))
                        sibling.hidden = true;
                }
                for (DomNode child : node.children) {
                    System.out.println("Hiding: " + child.id);
                    if (!child.id.equals(x.id))
                        child.hidden = true;
                    else
                        child.hidden = false;
                }
                return true;
            }
        }
        for (DomNode child : node.children) {
            if (findPopUp(child, node))
                return true;
        }
        return false;
    }


}
