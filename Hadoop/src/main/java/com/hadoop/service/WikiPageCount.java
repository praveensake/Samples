package com.hadoop.service;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by sakez on 7/31/16.
 */
public class WikiPageCount {

    public static class Map extends MapReduceBase implements
            Mapper<LongWritable, Text, Text, IntWritable> {

        @Override
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
                throws IOException {

            System.out.println("@Map input: Key->" + key + " , value->" + value.toString());

            String line = value.toString();
            String [] args = line.split("\\ ");

            if(args[0].equalsIgnoreCase("en")){
                value.set(new Text(args[1]));
                output.collect(value, new IntWritable(Integer.parseInt(args[2])));
                System.out.println("@Map output: Key->" + value + " , value->" + Integer.parseInt(args[2]));
            }

        }
    }

    public static class Reduce extends MapReduceBase implements
            Reducer<Text, IntWritable, Text, IntWritable> {

        @Override
        public void reduce(Text key, Iterator<IntWritable> values,
                           OutputCollector<Text, IntWritable> output, Reporter reporter)
                throws IOException {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next().get();
            }

            output.collect(key, new IntWritable(sum));
            System.out.println("@Reduce output: Key->" + key + " , value->" + sum);

        }
    }

    public static void main(String[] args) throws Exception {

        JobConf conf = new JobConf(WordCount.class);
        conf.setJobName("WikiPageCount");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setReducerClass(Reduce.class);
        conf.setMapperClass(Map.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);

    }
}


