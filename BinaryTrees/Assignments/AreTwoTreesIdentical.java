public class AreTwoTreesIdentical {
    public static boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {
            return (p.data == q.data)
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        ConstructTree ct = new ConstructTree();
        int pArr1[] = { 1, 2, -1, -1, 3, -1, -1 };
        Node p1 = ct.createTree(pArr1);
        int qArr1[] = { 1, 2, -1, -1, 3, -1, -1 };
        ct.idx = 0;
        Node q1 = ct.createTree(qArr1);
        System.out.println(isSameTree(p1, q1));

        int pArr2[] = { 1, 2, -1, -1, 1, -1, -1 };
        ct.idx = 0;
        Node p2 = ct.createTree(pArr2);
        int qArr2[] = { 1, 1, -1, -1, 2, -1, -1 };
        ct.idx = 0;
        Node q2 = ct.createTree(qArr2);
        System.out.println(isSameTree(p2, q2));
    }
}
