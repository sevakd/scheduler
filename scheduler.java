import java.io.*;

class process {
  public int pid, artime, burst;

  public process(int pids, int artimes, int bursts) {
    pid = pids;
    artime = artimes;
    burst = bursts;
  }
  public void display(){
    System.out.println(pid + " " + artime + " " + burst);
  }
}

class scheduler {
  public int timeElapsed;

  void loadIn(){
    String[] pvars;
    int[] pr;
    pr = new int[3];
    process[] worklist;
    worklist = new process[100];
    process a;
    int count = 0;

    try {
      BufferedReader in = new BufferedReader(new FileReader("input.txt"));
      String str;
      while ((str = in.readLine()) != null) {
        pvars = str.split(" ");
        for (int i=0; i<3; i++) {
          pr[i] = Integer.parseInt(pvars[i]);
        }
        //System.out.println(pr);
        worklist[count] = new process(pr[0], pr[1], pr[2]);
        //a.display();
        //worklist[count] = a;
        count++;
      }
      in.close();
      worklist[2].display();
    } catch (IOException e) {
    }
  }

  /*void fcfs(process run) {
    while (burst >= 0){
      burst-= 1;
    }
  }*/  
}

class schedulerDemo {
  public static void main(String[] args) {
    scheduler one = new scheduler();
    one.loadIn();
    //System.out.one.worklist
  }
}
