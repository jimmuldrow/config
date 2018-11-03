package publishSubscribe;

import com.workQueue.NewTask;

public class Test {
	public static void main(String[] args){
		for(int i = 0; i < 5; i++){
			ReceiveLogs.main();
		}				

		String[] s = {"Here", "is", "a", "message"};
		EmitLog.main(s);
	}
}
