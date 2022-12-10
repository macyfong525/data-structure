public class MyLinkedDequeDemo {

    public static void main(String[] args) throws Exception {
//        try {
            DequeInterface<Integer> testDeque = new MyLinkedDeque<>();
            System.out.println("Add 1,2, remove one by one");
            testDeque.addToBack(1);
            testDeque.addToFront(2);
            testDeque.displayDeque();
            testDeque.removeBack();
            testDeque.removeFront();
            testDeque.displayDeque();
            System.out.println("Check Empty: " + testDeque.isEmpty());
            // create a demo for link chain
            System.out.println("Add 1 to front, 2,3,4 to back, 0 to front, 5 to back");
            testDeque.addToFront(1);
            testDeque.addToBack(2);
            testDeque.addToBack(3);
            testDeque.addToBack(4);
            testDeque.addToFront(0);
            testDeque.addToBack(5);
            testDeque.displayDeque();
            System.out.println("Get the front data:    " + testDeque.getFront());
            System.out.println("Remove the front data: " + testDeque.removeFront());
            System.out.println("Get the last data:     " + testDeque.getBack());
            System.out.println("Remove the last data:  " + testDeque.removeBack());
            testDeque.displayDeque();
            System.out.println("Clear all data");
            testDeque.Clear();
            System.out.println("Check Empty: " + testDeque.isEmpty());
//        }catch (Exception e){
//            System.out.println("ERROR: "+e.getMessage());
//        }
    }
}
