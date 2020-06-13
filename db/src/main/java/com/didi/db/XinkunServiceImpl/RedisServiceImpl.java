package com.didi.db.XinkunServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @ClassName RedisServiceImpl
 * @Author zhangxinkun
 * @Date 2020/1/28  4:57 PM
 * @Version 1.0
 */
@Service
public class RedisServiceImpl {

    @Autowired
    Jedis jedis;

    public boolean luaScript(){
        String vim = "redis.call(set,key3 ,3)\n" +
                "redis.call(set,key4 ,4)\n" +
                "redis.call(set,key5 ,5)\n" +
                "redis.call(set,key6 ,6)\n" +
                "redis.call(set,key7 ,7)\n" +
                "redis.call(set,key8 ,8)\n" +
                "redis.call(set,key9 ,9)\n" +
                "redis.call(set,key10, 10)\n" +
                "redis.call(set,key11, 11)\n" +
                "redis.call(set,key12, 12)\n" +
                "redis.call(set,key13, 13)\n" +
                "redis.call(set,key14, 14)\n" +
                "redis.call(set,key15, 15)\n" +
                "redis.call(set,key16, 16)\n" +
                "redis.call(set,key17, 17)\n" +
                "redis.call(set,key18, 18)\n" +
                "redis.call(set,key19, 19)\n" +
                "redis.call(set,key20, 20)\n" +
                "redis.call(set,key21, 21)\n" +
                "redis.call(set,key22, 22)\n" +
                "redis.call(set,key23, 23)\n" +
                "redis.call(set,key24, 24)\n" +
                "redis.call(set,key25, 25)\n" +
                "redis.call(set,key26, 26)\n" +
                "redis.call(set,key27, 27)\n" +
                "redis.call(set,key28, 28)\n" +
                "redis.call(set,key29, 29)\n" +
                "redis.call(set,key30, 30)\n" +
                "redis.call(set,key31, 31)\n" +
                "redis.call(set,key32, 32)\n" +
                "redis.call(set,key33, 33)";
        jedis.eval(vim);
        return true;
    }
}
