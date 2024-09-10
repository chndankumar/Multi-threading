package Mutithreading.Lock;

public class DeadLockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(new Task1(pen, paper));
        Thread t2 = new Thread(new Task2(pen, paper));

        t1.start();
        t2.start();
    }
}

class Pen {

    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + "and trying to use paper");
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finish using pen " + this);
    }
}

class Paper {
    public synchronized void writeWithPenAndPaper(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + "and trying to use pen");
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finish using paper " + this);
    }

}

class Task1 implements Runnable {
    Pen pen;
    Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);// thread1 locked pen and trying to lock paper
    }
}

class Task2 implements Runnable {
    Pen pen;
    Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (pen) {
            paper.writeWithPenAndPaper(pen);// thread1 locked paper and trying to lock pen
        }
    }
}
