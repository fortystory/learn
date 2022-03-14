package tests.linkedlist;

public class Test{

    public static class Node{
        public int e;
        public Node next;

        public Node(int e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(int e){
            this.e = e;
            this.next = null;
        }

    }

    public static void main(String[] args) {
        // Node n1 = new Node(9,null);
        // n1.next = new Node(9,null);
        // n1.next.next = new Node(9,null);
        // n1.next.next.next = new Node(9,null);
        // n1.next.next.next.next = new Node(9,null);
        // n1.next.next.next.next.next = new Node(9,null);
        // n1.next.next.next.next.next.next = new Node(9,null);

        // Node n2 = new Node(9,null);
        // n2.next = new Node(9,null);
        // n2.next.next = new Node(9,null);
        // n2.next.next.next = new Node(9,null);
        Node n1 = new Node(0,null);
        Node n2 = new Node(1,null);
        sum(n1,n2);
    }

    public static Node sum(Node node_1,Node node_2){
        //求和部分
        int j = 1;
        long sum = 0;
        while(node_1 != null || node_2 != null){
            int temp_j1 = 0;
            if(node_1 != null){
                temp_j1 = node_1.e * j;
            }else{
                temp_j1 = 0;
            }

            int temp_j2 = 0;
            if(node_2 != null){
                temp_j2 = node_2.e * j;
            }else{
                temp_j2 = 0;
            }
            //System.out.println(temp_j1+" "+temp_j2);
            //System.out.println(node_1.e+" "+node_2.e);

            sum = sum + temp_j1 + temp_j2;
            node_1 = node_1 == null?null:node_1.next;
            node_2 = node_2 == null?null:node_2.next;
            j = j * 10;
        }
        System.out.println(sum);
        //输出

        long k = 1;
        long v = 10;

        Node node = new Node(-1,null);//虚拟头节点
        Node cur = node;
        if(sum == 0){//处理0
            cur.next = new Node(0,null);
        }else{
            while(sum >= k){
                int n = (int)(sum / k % v);
                
                cur.next = new Node(n,null);

                k = k * 10;
                cur = cur.next;
            }
        }

        System.out.println(print_node(node.next));

        return node.next;
    }

    public static String print_node(Node node){
        StringBuilder res = new StringBuilder();
        Node dummyHead = new Node(-1,node);
        for(Node cura = dummyHead.next; cura != null; cura = cura.next){
            res.append(cura.e + "->");
        }
        res.append("null");
        return res.toString();
    }
}