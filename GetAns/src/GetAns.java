import java.util.Scanner;
//存各部分的和
class A {

    long value = 0;

    A(long value){
        this.value = value;
    }

}
public class GetAns implements Runnable{
    private A sum;
    private int front;
    private int last;
    private int threadId;
    private int x;

    public GetAns(A sum,int front, int last, int threadId,int x) {
        this.sum=sum;
        this.front = front;
        this.last = last;
        this.threadId = threadId;
        this.x=x;

    }

    @Override
    public void run() {
        for(int i=front;i<=last;i++){
            if (contain(i, x)) {
                this.sum.value += i;
            }
        }
    }
    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }

    public static void main(String[] args) {
        int maxn=999999999;
        long ans=0;
        int threadNum=8;// 线程数
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        A[] perAns=new A[threadNum];
        for (int i = 0; i < threadNum; i++) {
            perAns[i]=new A(0);
        }
        //开始时间
        long current = System.currentTimeMillis();
        // 每个线程计算一段连续的加和，并将加和结果保存
        for(int i=0;i<threadNum;i++){
            int front= (int) (maxn*(1.0*i/threadNum)+1);
            int last= (int) (maxn*(1.0*(i+1)/threadNum));
            new Thread(new GetAns(perAns[i],front,last,i,x)).start();
        }
        while(Thread.activeCount()!=2){

        }
        //结束时间
        current=System.currentTimeMillis()-current;
        //异步求和
        for (int i = 0; i < threadNum; i++) {
            ans+=perAns[i].value;
        }
        System.out.println(ans);
        System.out.println("用时：" + current);
    }
}

