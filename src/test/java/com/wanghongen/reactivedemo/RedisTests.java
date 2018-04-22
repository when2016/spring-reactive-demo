package com.wanghongen.reactivedemo;

import java.nio.ByteBuffer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.ReactiveRedisConnection;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.wanghongen.reactivedemo.ReactiveDemoApplication.class)
public class RedisTests {
  @Autowired
  private ReactiveRedisConnection connection;
  @Test
  public void testRedis(){
    connection
        .stringCommands().set(ByteBuffer.wrap("h".getBytes()), ByteBuffer.wrap("w".getBytes()))
        .subscribe(System.out::println);
  }
}
