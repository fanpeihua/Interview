package javabasic.collection;

/**
 * Created by perryFan on 2019/2/11.
 */
public class MyLinkedList<E> {

    private int size;

    private Node<E> first;
    private Node<E> last;


    public boolean add(E element) {
        addAtLast(element);
        return true;
    }

    public void addAtLast(E element) {
        Node<E> l = last;
        Node<E> node = new Node<>(element, null, l);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }

    public boolean add(int index, E element) {
        checkRangeForAdd(index);
        if (index == size) {
            addAtLast(element);
        } else {
            Node<E> l = node(index);
            addBeforeNode(element, l);
        }
        return true;
    }

    public void addBeforeNode(E element, Node<E> specifiedNode) {
        Node<E> prevNode = specifiedNode.prev;
        Node<E> newNode = new Node<>(element, specifiedNode, prevNode);
        if (prevNode == null) {
            first = newNode;
        } else {
            prevNode.prev = newNode;
        }
        specifiedNode.prev = newNode;
        size++;
    }

    public void checkRangeForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("指定index超过界限");
        }
    }

    public Node<E> node(int index) {
        if (index < (size << 1)) {
            Node<E> cursor = first;
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
            return cursor;
        } else {
            Node<E> cursor = last;
            for (int i = size - 1; i > 0; i--) {
                cursor = cursor.prev;
            }
            return cursor;
        }
    }

    public E remove(int index) {
        checkRange(index);
        return deleteLink(index);
    }

    public boolean remove(Object object) {
        int index = indexOf(object);
        if (index < 0) {
            return false;
        }
        deleteLink(index);
        return true;
    }

    private E deleteLink(int index) {
        Node<E> l = node(index);
        E item = l.item;
        Node<E> preNode = l.prev;
        Node<E> nextNode = l.next;


        if (preNode == null) {
            first = nextNode;
        } else {
            preNode.next = nextNode;
            l.next = null;
        }

        if (nextNode == null) {
            last = preNode;
        } else {
            nextNode.prev = preNode;
            l.prev = null;
        }

        size--;
        l.item = null;

        return item;
    }


    public E get(int index) {
        checkRange(index);
        return node(index).item;
    }

    private void checkRange(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("指定index超过界限");
        }
    }


    public int indexOf(Object element) {
        Node<E> cursor = first;
        int count = 0;
        while (cursor != null) {
            if (element != null) {
                if (element.equals(cursor.item)) {
                    return count;
                }
            } else {
                if (cursor.item == null) {
                    return count;
                }
            }
            count++;
            cursor = cursor.next;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
