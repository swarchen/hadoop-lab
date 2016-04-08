package wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text,IntWritable,???,???> {
	
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		int count = 0;
		// agrregate the amount of same starting character
		for (IntWritable val: values) {
			// count += ...
            count += val;
		}
		
		// write the result
		// context.write(K,V);
        context.write (key, new Text(""+count));
		
	}
}
