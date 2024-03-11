package org.example.tp_Mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        // Split the input text into words
        String[] mots = value.toString().split(" ");

        // Iterate through each word
        for (String mot : mots) {
            // Emit each word as key with a count of 1
            context.write(new Text(mot), new IntWritable(1));
        }
        ;
    }
}


