package Queue;

public class cricularQue {
     static class Queuu {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queuu(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1; // in cir
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1; 
        }

        // full
        public static boolean isFull() {
            return (rear + 1) % size == front;      
        }

        // add
        public static void add(int data){
            if(isFull()) {
                System.out.println("queue is full");
                return;
            }

            // if we addeding the first element then we need to update the front also 
            if(front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        //remove
        public static int remove () {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            // int front = arr[0];
            // for(int i = 0; i<rear; i++) {
            //     arr[i] = arr[i+1];
            // }
            // rear = rear -1;
            // return front;

            int result = arr[front];
            

            // is i am removing last el of the array means in the only one ele remains 
            if(rear == front) {
                rear = front = -1; // need to do the -1 to both so we can start from the start if we want to add the ele

            }else {
                front = (front + 1) % size;
            }
            return result;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            // return arr[0]; //here our peek is front 
            return arr[front];
        }
    } 
    public static void main(String[] args) {
        Queuu q = new Queuu(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println(q.remove());
        q.add(6);
        System.out.println(q.remove());
        q.add(7);
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
