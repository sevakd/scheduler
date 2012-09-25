import java.io.*;
import java.util.*;

class process { //process object
  public int pid, artime, burst; //id, arrival time, time required to complete

  public process(int pids, int artimes, int bursts) {
    pid = pids;
    artime = artimes;
    burst = bursts;
  }
  public void display(){
    System.out.println(pid + " " + artime + " " + burst);
  }
  int wait(int currentTime){
    int waited = currentTime - artime;
    return waited; 
  }
}

class burstLengthComparator implements Comparator<process> {
  @Override
    public int compare(process x, process y){
      if(x.burst < y.burst) {
        return -1;
      }
      if (x.burst > y.burst){
        return 1;
      }
      return 0;
    }
}

class scheduler {
  public int timeElapsed = 0;
    List<process> worklist = new ArrayList<process
      >();
  void loadIn(){
    String[] processVars;
    int[] pr;
    pr = new int[3];
    process a;
    int count = 0;

    try {
      BufferedReader in = new BufferedReader(new FileReader("input.txt"));
      String str;
      while ((str = in.readLine()) != null) {
        processVars = str.split(" ");
        for (int i=0; i<3; i++) {
          pr[i] = Integer.parseInt(processVars[i]);
        }
        //System.out.println(pr);
        worklist.add(new process(pr[0], pr[1], pr[2]));
        //a.display();
        //worklist[count] = a;
        count++;
      }
      in.close();
    } catch (IOException e) {
    }
  }

  process cp(process orig){
    process c = new process(orig.pid, orig.artime, orig.burst);
    return c;
  }

  void fcfs() {
    float totwait = 0;
    float avgwait = 0;
    int turn = 0;
    float totturn = 0;
    float avgturn = 0;
    for (process current : worklist){
      //current.display();
      current.wait(timeElapsed); //waiting time per process
      turn = current.wait(timeElapsed) + current.burst; //turnaround time per process
      totwait += current.wait(timeElapsed); //total weight time
      totturn += turn; //total turnaroundtime
      while (current.burst > 0){
        current.burst-= 1;
        timeElapsed++;
      }
      //System.out.println(timeElapsed);
    }
    avgturn = totturn/worklist.size(); //avg turn around time
    avgwait = totwait/worklist.size(); //avg wait time
  }

  void sjf(){
    Comparator<process> comparator = new burstLengthComparator();
    PriorityQueue<process> ready = new PriorityQueue<process>(worklist.size(), comparator);
    process current;
    process next;
    int i;
    for (i=0; i<worklist.size(); i++){
      if (ready.isEmpty()){
        current = cp(worklist.get(i));
      } else{
          current = cp(ready.poll());
      }
      if (i<worklist.size()-1){
        next = cp(worklist.get(i+1));
      } else{
          next = new process(0,0,0);
      }
      int k = 1;
      while(current.burst > 0){
        if (timeElapsed == next.artime){
          ready.add(next);
          k++;
          next = cp(worklist.get(i + k));
        }
        current.display();
        current.burst--;
        //System.out.println(timeElapsed);
        timeElapsed++;
      }
      System.out.println(timeElapsed);
      /*for (int j=i; j<ready.size(); j++){
        process n = ready.poll();
        System.out.print("HI");
        n.display();
        worklist.set(j, ready.poll());
      }*/
    }
  }

  void srt(){
  }

  void rr(){
  }
}

class schedulerDemo {
  public static void main(String[] args) {
    scheduler one = new scheduler();
    scheduler two = new scheduler();
    one.loadIn();
    two.loadIn();
    one.fcfs();
    two.sjf();
    //System.out.one.worklist
  }
}
