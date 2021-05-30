package state.abuse;

public class StopWatch {

    private boolean isRunning;
    public void click(){
        if(isRunning){
            System.out.println("Stopped");
            isRunning = false;
        }else{
            isRunning = true;
            System.out.println("Start");
        }
    }
}
