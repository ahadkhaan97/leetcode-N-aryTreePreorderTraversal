import java.util.*


fun main() {

    val root = Node(1)
    root.children.add(Node(2))
    root.children.add(Node(3))
    root.children.add(Node(4))

    root.children.get(0)?.children?.add(Node(5))
    root.children.get(0)?.children?.get(0)?.children?.add(
        Node(10)
    )
    root.children.get(0)?.children?.add(Node(6))
    root.children.get(0)?.children?.get(1)?.children?.add(
        Node(11)
    )
    root.children.get(0)?.children?.get(1)?.children?.add(
        Node(12)
    )
    root.children.get(0)?.children?.get(1)?.children?.add(
        Node(13)
    )
    root.children.get(2)?.children?.add(Node(7))
    root.children.get(2)?.children?.add(Node(8))
    root.children.get(2)?.children?.add(Node(9))

    dfs(root)
}

fun dfs(root: Node?): ArrayList<Int> {
    if (root == null)
        return arrayListOf()
    val stack = Stack<Node>()

    val preorder = ArrayList<Int>()

    stack.push(root)

    while (!stack.isEmpty()) {
        val temp = stack.peek()
        stack.pop()
        // store the key in preorder vector(visited
        // list)
        preorder.add(temp.`val`)
        for (i in temp.children.size - 1 downTo 0) {
            stack.push(temp.children[i])
        }
    }
    for (i in preorder) {
        print("$i,")
    }
    return preorder
}

class Node(var `val`: Int) {
    var children: ArrayList<Node?> = ArrayList()
}