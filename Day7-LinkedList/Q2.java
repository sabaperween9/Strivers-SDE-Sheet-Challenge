/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// ============================== Approach -1 ========================================================================
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Integer, Node> cloneMap = new HashMap<>();
        HashMap<Node, Integer> oldMap = new HashMap<>();
        Node dummy = new Node(-1);
        Node tempN = dummy;
        Node tempO = head;
        int count = 1;
        while(tempO != null) {
            oldMap.put(tempO , count);
            tempN.next = new Node(tempO.val);
            tempN = tempN.next;
            tempO = tempO.next;
            cloneMap.put(count, tempN);
            count++;
        }
        tempO = head;
        tempN = dummy.next;
        while(tempN != null) {
            if(tempO.random == null)
                tempN.random = null;
            else 
                tempN.random = cloneMap.get(oldMap.get(tempO.random));
            tempO = tempO.next;
            tempN = tempN.next;
        }
        return dummy.next;
    }
}


// ================================= Approach - 2 ===========================================================================

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node dummy = new Node(-1);
        Node tempD = dummy;
        Node temp = head;
        HashMap<Node , Node> hm = new HashMap<>();
        while(temp != null) {
            tempD.next = new Node(temp.val);
            hm.put(temp , tempD.next);
            temp = temp.next;
            tempD = tempD.next;        
        }
        tempD = dummy.next;
        temp = head;
        while(temp != null) {
            if(hm.containsKey(temp.random)) {
                tempD.random = hm.get(temp.random);
            }else {
                tempD.random = null;
            }
            tempD = tempD.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}