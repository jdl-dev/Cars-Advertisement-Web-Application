package com.app.myapp.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;



// Włączenie mechanizmu cache
//Po dodaniu @EnableCaching Spring zaczyna skanować komponenty w poszukiwaniu adnotacji związanych z cachem, takich jak:
//@Cacheable - Zapisuje wynik metody w pamięci podręcznej.
//@CachePut - Aktualizuje wartość w cache.
//@CacheEvict - Usuwa dane z pamięci podręcznej.
@Configuration
public class RedisCacheConfig {


    @Bean
    public RedisCacheConfiguration defaultCacheConfig() {
        ObjectMapper mapper = new ObjectMapper()
                .findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(mapper)));
    }

//    @Bean
//    public <T> RedisTemplate<String, T> redisTemplate(@Autowired LettuceConnectionFactory lettuceConnectionFactory) {
//        RedisTemplate<String, T> template = new RedisTemplate<>();
//        template.setConnectionFactory(lettuceConnectionFactory);
//
//        StringRedisSerializer keySerializer = new StringRedisSerializer();
//        RedisSerializer<Object> valueSerializer = RedisSerializer.json();
//
//        template.setKeySerializer(keySerializer);
//        template.setValueSerializer(valueSerializer);
//
//        template.setHashKeySerializer(keySerializer);
//        template.setHashValueSerializer(valueSerializer);
//
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    @Bean
//    public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {
//
//        return RedisCacheManager.builder(factory)
//                .cacheDefaults(config)
//                .build();
//    }
//

    //CACHING Z IMPLEMENTACJA  REDIS !!!

    //TO USE REDIS AS CACHE ABSTRACTION IMPLEMENTATION IN SPRING DO THIS:
//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        System.out.println(connectionFactory.toString());
//        return RedisCacheManager.create(connectionFactory);
//    }

    //RedisCacheManager behavior can be configured with RedisCacheManager.RedisCacheManagerBuilder,
    // letting you set the default RedisCacheManager, transaction behavior, and predefined caches.

//    @Bean
//    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
////        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
////                .entryTtl(Duration.ofMinutes(10)) //key expiration times, Ttl (time-to-live)
////                .disableCachingNullValues();
//
////        RedisCacheManager redisCach1 = RedisCacheManager.builder(connectionFactory).cacheDefaults(config).build();
//
//        RedisCacheManager redisCache2 = RedisCacheManager.builder(connectionFactory)
//                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())))
//                .transactionAware() //Enable RedisCaches to synchronize cache put/ evict (put/delete) operations with ongoing Spring-managed transactions.
//                .withInitialCacheConfigurations(Collections.singletonMap("predefined", RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues()))
//                .enableStatistics() //collect local hits and misses through
//                .build();
//
//        return redisCache2;
//    }


    //Jedis, needed extra dependency
//    @Bean
//    public RedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory(new RedisStandaloneConfiguration());
//    }

    //default in SPRING is LETTUCE driver


    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    // !!!! TWORZENIE POŁĄCZEN I PRACA Z BAZĄ DANYCH REDIS !!!!


    // konfigruacja driverow do połączenia z bazą danych Redis
    //Są 2 drivery ktore mozna wykorzystac: Lettuce i Jedis

    //RedisStandaloneConfiguration
    //Configuration class used to set up a RedisConnection with RedisConnectionFactory for connecting to a single node Redis   instance.

    //--------------------------------------------------------------------------------------------------------------------------------------------------------
    //Lettuce
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("server", 6379)); //mozna to ustawic w application.properties (hostName, port)
//    }
//


    //--------------------------------------------------------------------------------------------------------------------------------------------------------

//    // CONFIGURING TEMPLATE API AND DRIVER
//    @Bean
//    LettuceConnectionFactory connectionFactory() {
//        return new LettuceConnectionFactory();
//    }
//
//    @Bean
//    RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
//
//        // For String intensive operations consider the dedicated StringRedisTemplate.
//        RedisTemplate<String, String> template = new RedisTemplate<>();
//
//        template.setConnectionFactory(connectionFactory);
//        return template;
//    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------

    //Redis Sentinel - High Availability (HA) z wykorzystaniem Redis Sentinel oznacza stworzenie systemu Redis,
    // który jest odporny na awarie i zapewnia ciągłą dostępność danych oraz usług Redis, nawet w przypadku awarii głównego serwera (Master).

    //Łatwym językiem - jest kilka instancji bazy danych i gdy padnie główna (master) przełącza na inną awaryjną wersje,
    //tak a by zachowac ciaglosc pracy

    //Mozna to ustawic rowniez  w pliku application.property

//    @Bean
//    public RedisConnectionFactory lettuceConnectionFactory() {
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//                .master("mymaster")
//                .sentinel("127.0.0.1", 26379)
//                .sentinel("127.0.0.1", 26380);
//        return new LettuceConnectionFactory(sentinelConfig);
//    }

//    @Bean
//    public RedisConnectionFactory jedisConnectionFactory() {
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
//                .master("mymaster")
//                .sentinel("127.0.0.1", 26379)
//                .sentinel("127.0.0.1", 26380);
//        return new JedisConnectionFactory(sentinelConfig);


    //ustawienie String'a jak typy ktore ma obslugiwac Redis

//--------------------------------------------------------------------------------------------------------------------------------------------------------

    //ustawienie Driver'a
//    @Bean
//    LettuceConnectionFactory redisConnectionFactory1() {
//        return new LettuceConnectionFactory();
//    }
//
//    //String-focused extension of RedisTemplate. Since most operations against Redis are String based,
//    // this class provides a dedicated class that minimizes configuration of its more generic template especially in terms of serializers.
//    @Bean
//    StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory1) {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(redisConnectionFactory1);
//        return stringRedisTemplate;
//    }

}
