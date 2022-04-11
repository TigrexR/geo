package com.tigrex.geo.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.jupiter.api.Test;

public class NIOtest {

    @Test
    public void pipeTest(){

        System.out.println("oh shit!");

        //分配缓冲区
//        ByteBuffer.allocate(1024);

        //分配直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        System.out.println(byteBuffer.isDirect());

    }


    /**
     *
     */
    @Test
    public void channelTest() throws IOException {

        System.out.println("channel is running");

        FileInputStream fileInputStream = new FileInputStream("1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");

        FileChannel inFileChannel = fileInputStream.getChannel();
        FileChannel outFileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (inFileChannel.read(byteBuffer) != -1){

            byteBuffer.flip();

        }

        fileInputStream.close();
        fileOutputStream.close();
        inFileChannel.close();
        outFileChannel.close();

    }

    @Test
    public void byteMapper() throws IOException {

        FileChannel inFileChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
        FileChannel outFileChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        MappedByteBuffer inMappedByteBuffer = inFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inFileChannel.size());
        MappedByteBuffer outMappedByteBuffer = outFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, inFileChannel.size());

        byte[] dst = new byte[inMappedByteBuffer.limit()];

        inMappedByteBuffer.get(dst);
        outMappedByteBuffer.put(dst);

        inMappedByteBuffer.clear();
        outMappedByteBuffer.clear();
        inFileChannel.close();
        outFileChannel.close();

    }

}
