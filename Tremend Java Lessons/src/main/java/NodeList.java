public class NodeList {

    public Node actualNode;
    public Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            actualNode = head;
            return;
        }
        actualNode = head;
        while (actualNode.nextNode != null)
            actualNode = actualNode.nextNode;
        actualNode.nextNode = new Node(value);
    }

    public int getValue(int pos) {
        int counter = 0;
        actualNode = head;
        while (actualNode.nextNode != null) {
            if (counter == pos)
                break;
            actualNode = actualNode.nextNode;
            counter++;
        }
        return actualNode.value;
    }
}