package com.ruifu.pls.rediscache;


import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {
    public static final String KEY="ITEM";
    private RedisTemplate<String,Item> redisTemplate;
    private HashOperations hashOperations;

    public ItemRepository(RedisTemplate<String,Item> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public Item getItem(int itemId){
        return (Item)hashOperations.get(KEY, itemId);
    }

    public void addItem(Item item){
        hashOperations.put(KEY, item.getId(),item);
    }

    public void deleteItem(int id){
        hashOperations.delete(KEY,id);
    }

    public void updateItem(Item item){
        addItem(item);
    }
}
