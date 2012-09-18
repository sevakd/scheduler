import java.io.*;

class process {
  public int pid, artime, burst;

  public process(int pids, int artimes, int bursts) {
    pid = pids;
    artime = artimes;
    burst = bursts;
  }
  public void display(){
    System.out.println(pid);
  }
}

class scheduler {
  int timeElapsed;

  void load(){
    String[] pvars;
    int[] pr;
    pr = new int[3];
    process a;

    try {
      BufferedReader in = new BufferedReader(new FileReader("input.txt"));
      String str;
      while ((str = in.readLine()) != null) {
        pvars = str.split(" ");
        for (int i=0; i<3; i++) {
          pr[i] = Integer.parseInt(pvars[i]);
        }
        //System.out.println(pr);
        a = new process(pr[0], pr[1], pr[2]);
        a.display();
      }
      in.close();
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
    one.load();
  }
}
