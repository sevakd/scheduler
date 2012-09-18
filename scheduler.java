import java.io.*;

class process {
  int pid, artime, burst;
}

class scheduler {
  int timeElapsed;

  void load(){
    try {
      BufferedReader in = new BufferedReader(new FileReader("input.txt"));
      String str;
      while ((str = in.readLine()) != null) {
        System.out.println(str);
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
