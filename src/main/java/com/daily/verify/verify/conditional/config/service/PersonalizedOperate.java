package com.daily.verify.verify.conditional.config.service;



/**
 * 个性化操作，比如存取数据
 */
public interface PersonalizedOperate {
    void putData();

    void getData();

    void delData();

    /**
     * 指定缓存失效时间
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
     boolean expire(String key, long time);

    /**
     * 根据key 获取过期时间
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
     long getExpire(String key);

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
     boolean hasKey(String key);

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String... key);
}
