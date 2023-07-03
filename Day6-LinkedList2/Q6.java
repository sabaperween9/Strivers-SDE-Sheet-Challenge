class GfG
{
    Node flatten(Node root)
    {
        if(root ==  null || root.next == null)
            return root;
        
        Node dummy = new Node(-1);
        dummy.next = root;
        Node temp = dummy.next;
        Node curr = root.next;
        
        while(curr != null) {
            Node currBottom = curr;
            Node prev = temp.bottom;
            
            while(currBottom != null && prev != null) {
                if(currBottom.data <= prev.data) {
                    temp.bottom = currBottom;
                    currBottom = currBottom.bottom;
                }else{
                    temp.bottom = prev;
                    prev = prev.bottom;
                }
                temp = temp.bottom;
            }
            
            if(currBottom != null) {
                temp.bottom = currBottom;
            }
            
            if(prev != null) {
                temp.bottom = prev;
            }
            
            curr = curr.next;
            temp = dummy.next;
            
        }
        
        return dummy.next;
    }
}