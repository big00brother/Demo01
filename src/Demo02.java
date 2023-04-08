

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Demo02 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        ListNode[] curNodes = new ListNode[lists.length];
        for(int i = 0; i< lists.length; i++) {
            curNodes[i] = lists[i];
        }
        ListNode headNode = null;
        ListNode minNode = findMinNode(curNodes);
        while(minNode != null) {
            if(headNode == null) {
                headNode = minNode;
            }

        }
        return null;

    }

    public ListNode findMinNode(ListNode[] curNodes) {
        ListNode minNode = null;
        for(int i = 0; i < curNodes.length; i++) {
            ListNode curNode = curNodes[i];
            if(curNode != null) {
                if(minNode == null) {
                    minNode = curNode;
                } else {
                    if(curNode.val < minNode.val) {
                        minNode = curNode;
                    }
                }
            }
        }
        return minNode;
    }
}




