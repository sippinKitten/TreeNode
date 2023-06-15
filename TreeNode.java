//Выполнил студент группы 2А Иванов Данил

// Класс, представляющий узел бинарного дерева
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

// Класс, представляющий бинарное дерево
class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // Метод для добавления значения в бинарное дерево
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Рекурсивный метод для добавления значения в бинарное дерево
    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    // Метод для поиска значения в бинарном дереве
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    // Рекурсивный метод для поиска значения в бинарном дереве
    private boolean searchRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        if (value < current.value) {
            return searchRecursive(current.left, value);
        } else {
            return searchRecursive(current.right, value);
        }
    }

    // Метод для удаления значения из бинарного дерева
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    // Рекурсивный метод для удаления значения из бинарного дерева
    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Узел не имеет потомков
            if (current.left == null && current.right == null) {
                return null;
            }

            // Узел имеет только одного потомка
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Узел имеет двух потомков
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    // Метод для поиска наименьшего значения в поддереве
    private int findSmallestValue(TreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
}

// Пример использования бинарного дерева
public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);
        binaryTree.insert(6);
        binaryTree.insert(9);

        System.out.println(binaryTree.search(4)); // Вывод: true
        System.out.println(binaryTree.search(8)); // Вывод: false

        binaryTree.delete(3);
        System.out.println(binaryTree.search(3)); // Вывод: false
    }
}
